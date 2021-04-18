<template>
	<v-app>
		<div class="ma-2">
			<h1 class="blue--text display-1">分组管理</h1>
			
			<v-snackbar centered height="80" v-model="snackbar" timeout="1000">{{snackbarText}}</v-snackbar>
			
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
						<v-btn color="green darken-1" text @click="del">确认</v-btn>
						<v-btn color="green darken-1" text @click="confirmDialog=!confirmDialog">取消</v-btn>
					</v-card-actions>
				</v-card>
			</v-dialog>
			<v-dialog v-model="groupDialog" max-width="200" persistent>
				<v-card>
					<v-card-title>
						计算机组别表单
					</v-card-title>
					<v-card-text>
						<v-text-field label="组名" v-model="group.name"></v-text-field>
					</v-card-text>
					<v-card-actions>
						<v-spacer></v-spacer>
						<v-btn color="primary" @click="save">
							保存
						</v-btn>
						
						<v-btn color="info" @click="groupDialog = false">
							取消
						</v-btn>
					</v-card-actions>
				</v-card>
			</v-dialog>
			<div class="ma-5">
				<v-row class="d-flex align-center">
					<v-col cols="4">
						<v-btn color="info" class="mr-5" @click="addGroup">
							新增分组
						</v-btn>
						<v-btn color="success">
							刷新
						</v-btn>
					</v-col>
					
			<!-- 		<v-col cols="2">
						<v-text-field label="搜索计算机所在组"></v-text-field>
					</v-col>
					
					<v-col cols="2" >
						<v-btn class="info">
							搜索
						</v-btn>
					</v-col> -->
				</v-row>
			</div>
			<v-row>
				<v-col cols="12">
					<v-simple-table>
						<thead>
							<tr>
								<th class="text-center">序号</th>
								<th class="text-center">组名</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<tr v-for="group in groups">
								<td class="text-center">{{group.id}}</td>
								<!-- <td class="text-center">{{user.status}}</td> -->
								<td class="text-center">
									{{ group.name }}
								</td>

								<td>
									<v-row class="justify-space-around">
										<v-btn small color="info" @click="toComputer(group)">
											<v-icon>redo</v-icon>
										</v-btn>
										<v-btn small color="primary" @click="editGroup(group)">
											<v-icon>edit</v-icon>
										</v-btn>
		<!-- 								<v-btn small color="error" @click="deleteGroup(group.id)">
											<v-icon>delete</v-icon>
										</v-btn> -->
									</v-row>
								</td>
							</tr>
						</tbody>
					</v-simple-table>
				</v-col>
			</v-row>
		</div>
	</v-app>
</template>

<script>
	export default{
		name: 'Group',
		data: function() {
			return {
				groupDialog: false,
				groups: [],
				group: {},
				snackbar: false,
				snackbarText: '',
				deleteGroupId: 0,
				confirmDialog: false,
				confirmTitle: '',
				confirmText: '',
			}
		},
		
		created() {
			// 获取所有计算机组别
			let _this = this;
			_this.getGroups();
		},
		
		methods: {
			/**
			 * 获取所有分组
			 */
			getGroups() {
				let _this = this;
				_this.$api.group.getGroups().then(res => {
					if(res.data.code == '200') {
						_this.groups = res.data.content;
					}
				})
			},
			/**
			 * 新增分组
			 */
			addGroup() {
				let _this = this;
				_this.group = {};
				_this.groupDialog = true;
			},
      /**
			 * 编辑分组
			 */			
			editGroup(group) {
				let _this = this;
				_this.group = $.extend({}, group);
				_this.groupDialog = true;
			},
			/**
			 * 保存
			 */
			save() {
				let _this = this;
				if(Tool.isEmpty(_this.group.name)) {
					_this.snackbar = true;
					_this.snackbarText = '组名不能为空';
					return ;
				}
				Loading.show();
				_this.$api.group.save(_this.group).then(res => {
					Loading.hide(function() {
						if(res.data.code == '200') {
							_this.groupDialog = false,
							_this.getGroups();
						}
					});
				})
			},
			
			/**
			 * 删除分组
			 */
			deleteGroup(id) {
				let _this = this;
				
			},
			del() {},
			/**
			 * 跳转到计算机页面
			 */
			toComputer(group) {
				let _this = this;
				SessionStorage.set(SESSION_KEY_GROUP, group);
				_this.$router.push('/system/pc');
			}
		}
	}
</script>

<style>
</style>
