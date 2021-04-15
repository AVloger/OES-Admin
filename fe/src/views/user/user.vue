<template>
	<v-app>
		<div class="ma-2">
			<h1 class="grey--text display-1">用户管理</h1>
		</div>
		
		<div class="ma-2">
			<v-btn class="mr-2 info" @click="add">新增用户</v-btn>
			<v-btn @click="getDataFromApi()" class="success">刷新</v-btn>
			
		</div>


		<!-- 删除确认框 -->
		<v-dialog v-model="confirmDialog" max-width="200">
			<v-card>
				<v-card-title>
					{{ confirmTitle }}
				</v-card-title>
				<v-card-text>
					{{ confirmText }}
				</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="green draken-1" text @click="del()">
						确认
					</v-btn>
					<v-btn color="green darken-1" text @click="confirmDialog=false">
						取消
					</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>

<!-- 用户新增编辑 -->
		<v-dialog v-model="userDialog" max-width="300">
			<v-card>
				<v-card-title>
					用户表单
				</v-card-title>
				<v-card-text>
					<v-text-field label="姓名" v-model="user.name"></v-text-field>
					<v-text-field label="密码" v-model="user.password"></v-text-field>
					<v-text-field label="联系方式" v-model="user.phone"></v-text-field>
					<v-text-field label="备注" v-model="user.remark"></v-text-field>
				</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn @click="save" class="primary">保存</v-btn>
					<v-btn @click="userDialog=!userDialog" class="warning">取消</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>

		<v-snackbar centered height="80" v-model="snackbar" :timeout="timeout">{{snackbarText}}</v-snackbar>

		<v-data-table :headers="headers" :items="desserts" :options.sync="options" :server-items-length="totalDesserts"
			:loading="loading" :footer-props="{itemsPerPageText:'每页条数'}" class="elevation-1">

			<template v-slot:footer.page-text="items"> {{ items.pageStart }} - {{ items.pageStop }} 总共
				{{ items.itemsLength }} 条数据 </template>

			<template v-slot:item.actions="{ item }">
				<v-btn x-small class="mr-2 primary">角色分配</v-btn>
				<v-btn x-small  class="mr-2 info" @click="editUser(item)">编辑</v-btn>
				<v-btn x-small class="mr-2 error" @click="deleteUser(item.ids)">删除</v-btn>
<!-- 				<
				<v-icon small class="mr-2" @click="editUser(item)">
					mdi-pencil
				</v-icon>
				<v-icon small @click="deleteUser(item.id)">
					mdi-delete
				</v-icon> -->
			</template>
		</v-data-table>
	</v-app>
</template>
<script>
	export default {
		data() {
			return {
				// 确认框
				confirmDialog: false,
				confirmTitle: '确定删除?',
				confirmText: '删除之后不可恢复',
				deleteUserId: 0,

				// 提示框
				snackbar: false,
				snackbarText: '',
				timeout: 1000,
				// 单个用户
				user: {},
				// 用户表单
				userDialog: false,
				// 总条目
				totalDesserts: 0,
				flag: false,
				desserts: [],
				// 当获取到数据之前loading = true, 获取到数据之后 loading = false
				loading: true,
				// 获取分页参数
				options: {},
				// 定义table 表头
				headers: [{
						text: 'id',
						align: 'start',
						sortable: false,
						value: 'id',
					},
					{
						text: '姓名',
						value: 'name',
						sortable: false,
					},
					// {
					// 	text: '密码',
					// 	value: 'password',
					// 	sortable: false,
					// },
					{
						text: '联系方式',
						value: 'phone',
						sortable: false,
					},
					{
						text: '备注',
						value: 'remark',
						sortable: false,
					},
					{
						text: '操作',
						value: 'actions',
						sortable: false,
					}

				],
			}
		},
		
		watch: {
			options: {
				handler() {
					this.getDataFromApi()
				},
				deep: true,
			},
		},
		
		// 初始化页面完成后，在对DOM节点进行相关操作
		mounted() {
			this.getDataFromApi()
		},
		methods: {
			getDataFromApi() {
				let _this = this;
				_this.loading = true
				const {
					sortBy,
					sortDesc,
					page,
					itemsPerPage
				} = _this.options

				// console.log('每页大小:', itemsPerPage);
				// console.log('当前页码:', page);

				_this.$ajax.post(process.env.VUE_APP_SERVER + '/admin/user/pageUser/', {
					page: page,
					size: itemsPerPage
				}).then(res => {
					_this.desserts = res.data.content.list;
					_this.totalDesserts = res.data.content.total;
					_this.loading = false;
				});
			},
			
			
			/**
			 * 新增用户
			 */
			add() {
				let _this = this;
				_this.user = {};
				_this.userDialog = true;
			},
			
			// addUser()  {
			// 	_this.$ajax.post(process.env.VUE_APP_SERVER + '/admin/user/add', _this.user).then(res => {
			// 		if(res.data.code == '200') {
			// 			_this.userDialog = false;
			// 			_this.getDataFromApi();
			// 		}
			// 	})
			// },


			/**
			 * 编辑用户
			 */
			editUser(user) {
				let _this = this;
				_this.user = $.extend({}, user);
				_this.userDialog = true;
			},

			/**
			 * 删除用户
			 */
			deleteUser(id) {
				let _this = this;
				_this.confirmDialog = true;
				_this.deleteUserId = id;
			},
			del() {
				let _this = this;
				Loading.show();
				_this.$ajax.delete(process.env.VUE_APP_SERVER + '/admin/user/delete/' + _this.deleteUserId).then(res => {
					Loading.hide(function() {
						_this.confirmDialog = false;
						if (res.data.code == '200') {
							_this.snackbarText = '删除成功';
								_this.snackbar = true;
							_this.getDataFromApi();
						}
					})
				})
			},


			/**
			 * 保存
			 */
			save() {
				let _this = this;
				Loading.show();
				_this.$ajax.post(process.env.VUE_APP_SERVER + '/admin/user/save', _this.user).then(res => {
					Loading.hide(function() {
						if (res.data.code == '200') {
							_this.userDialog = false;
							_this.snackbarText = '保存成功'
							_this.snackbar = true;
							_this.getDataFromApi();
						}
						// 出现异常 。。。
					});

				});
			},
		},
	}
</script>
