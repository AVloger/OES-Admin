<!-- https://stackoverflow.com/questions/62259868/vuetify-change-text-rows-per-page-text-in-v-data-tables-footer -->
<template>
	<v-app class="ma-2">
		<div class="display-1 grey--text">用户管理</div>
		<!-- 修改用户表单 -->
		<v-dialog v-model="userDialog" persistent max-width="300">
			<v-card>
				<v-card-title>
					用户表单
				</v-card-title>
				<v-card-text>
					<v-text-field label="用户名" required></v-text-field>
					<!-- 如果没有user.id就说明是新增的 -->
					<!-- 如果有user.id就说明是编辑，只能改姓名不能改密码 -->
					<!-- 				<v-text-field v-if="!user.id"  v-model="user.password" prepend-icon="lock" label="password"></v-text-field>
					<v-text-field v-model="user.nickname" prepend-icon="person" label="nickname"></v-text-field> -->
					<v-text-field label="密码"></v-text-field>
					<v-select :items="items" label="角色"></v-select>
					<v-text-field label="联系电话"></v-text-field>
					<v-text-field label="备注"></v-text-field>
				</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="primary" @click="save(user)">
						保存
					</v-btn>

					<v-btn @click="userDialog = false" color="warning">取消</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>


		<!-- 修改密码 -->
		<v-dialog v-model="psdDialog" persistent max-width="300">
			<v-card>
				<v-card-title>
					修改密码
				</v-card-title>
				<v-card-text>
					<v-text-field label="用户名" required></v-text-field>
					<v-text-field label="密码"></v-text-field>
				</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="primary" @click="save(user)">
						保存
					</v-btn>

					<v-btn @click="psdDialog = false" color="warning">取消</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>


		<!-- 按钮 -->
		<div class="mt-5 mb-5">


			<v-row class="d-flex align-center">
				<v-col cols="2">
					<v-btn class="mr-5" color="primary" @click="addUser()">
						<!-- <v-icon left small>add</v-icon> -->
						新增用户
					</v-btn>
					<v-btn color="warning" @click="listUsers">
						<!-- <v-icon left small>refresh</v-icon> -->
						刷新
					</v-btn>
				</v-col>

				<v-col cols="2">
					<v-text-field label="搜索用户"></v-text-field>
				</v-col>

				<v-col cols="1">
					<v-btn color="success" @click="listUsers">
						<!-- <v-icon left small></v-icon> -->
						搜索
					</v-btn>
				</v-col>

				<v-col cols="2">
					在线人数：1
				</v-col>
			</v-row>

		</div>


		<!-- 列表展示 -->
		<v-container>
			<v-card>
				<v-card-title>
					<!-- 用户列表 -->
					<v-spacer></v-spacer>
	<!-- 				<v-text-field v-model="search" append-icon="mdi-magnify" label="Search" single-line hide-details>
					</v-text-field> -->
				</v-card-title>
				<v-data-table 
				:headers="headers" 
				:items="users" 
				:options.sync="options"
				:server-items-length="totalUsers"
				:loading="loading"
				
        >
					
<!-- 					<template v-slot:footer.page-text="items"> {{ items.pageStart }} - {{ items.pageStop }} 总共
						{{ items.itemsLength }} 条数据 </template> -->

					<template v-slot:item.actions="{item}">
						<div class="d-flex justify-space-around">
							<v-icon small @click="test(item)">
								mdi-pencil
							</v-icon>
							<v-icon small>
								mdi-delete
							</v-icon>
						</div>

					</template>
				</v-data-table>
			</v-card>
		</v-container>
	</v-app>
</template>

<script>
	import axios from 'axios'
	export default {
		name: 'User',
		data: function() {
			return {
				totalUsers: 0,
				loading: true,
				options: {},
				user: {

				},
				items: ['案件管理员', '调查员', '审阅员'],
				search: '',
				headers: [{
						text: 'id',
						align: 'left',
						// sortable: false,
						value: 'id',
					},
					{
						text: '姓名',
						value: 'name'
					}, {
						text: '密码',
						value: 'password'
					}, {
						text: '昵称',
						value: 'nickname',
					},
					{
						text: '操作',
						align: 'center',
						value: 'actions'
					}
				],

				users: [],
				userDialog: false,
				psdDialog: false,
			}
		},
		created() {
			let _this = this;
			_this.listUsers();
		},

		methods: {
			test(item) {
				alert(item.id);
			},
			/**
			 * 查询所有用户
			 */
			listUsers() {
				let _this = this;
				_this.$ajax.get(process.env.VUE_APP_SERVER + '/admin/user/list').then(res => {
					_this.users = res.data.content;
				})

			},
			/**
			 * 编辑用户
			 */
			editUser(user) {
				let _this = this;
				_this.user = $.extend({}, user);
				_this.userDialog = true;
			},
			/**
			 * 新增user
			 */
			addUser() {
				let _this = this;
				_this.user = {};
				_this.userDialog = true;
			},

			/**
			 * 根据id删除用户
			 */
			deleteUser(id) {
				let _this = this;
				Confirm.show("用户删除之后不可恢复，确定吗？", function() {

				});
			},

			/**
			 * 保存
			 */
			save(user) {
				let _this = this;
			},

			/**
			 * 修改密码
			 */
			editPassword(id) {
				let _this = this;
				_this.psdDialog = true;
			}

		}
	}
</script>

<style>
</style>
