<template>
	<v-app>
		<div class="ma-2">
			<h1 class="grey--text display-1">分组管理</h1>
			
			<v-dialog v-model="groupDialog" max-width="200" persistent>
				<v-card>
					<v-card-title>
						计算机组别表单
					</v-card-title>
					<v-card-text>
						<v-text-field label="组名"></v-text-field>
					</v-card-text>
					<v-card-actions>
						<v-spacer></v-spacer>
						<v-btn color="primary">
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
					<v-col cols="2">
						<v-btn color="primary" class="mr-5" @click="addGroup">
							新增分组
						</v-btn>
						<v-btn color="info">
							刷新
						</v-btn>
					</v-col>
					
					<v-col cols="2">
						<v-text-field label="搜索计算机所在组"></v-text-field>
					</v-col>
					
					<v-col cols="2" >
						<v-btn class="info">
							搜索
						</v-btn>
					</v-col>
				</v-row>
			</div>
			<v-row>
				<v-col cols="12">
					<v-simple-table>
						<thead>
							<tr>
								<th class="text-center">序号</th>
								<th class="text-center">用户名</th>
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
										<v-btn small color="error" @click="deleteGroup(group.id)">
											<v-icon>delete</v-icon>
										</v-btn>
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
				groups: [
					{
						id: 1,
						name: '计算机分组1'
					},
					{
						id: 2,
						name: '计算机分组2'
					},{
						id: 3,
						name: '计算机分组3'
					}
				]
			}
		},
		
		methods: {
			/**
			 * 新增分组
			 */
			addGroup() {
				let _this = this;
				_this.groupDialog = true;
			},
      /**
			 * 编辑分组
			 */			
			editGroup(group) {
				let _this = this;
				_this.groupDialog = true;
			},
			
			/**
			 * 删除分组
			 */
			deleteGroup(id) {
				let _this = this;
				Confirm.show("是否删除该组别，一旦删除，所有隶属于该组别的计算机都将被删除");
			},
			/**
			 * 跳转到计算机页面
			 */
			toComputer(group) {
				let _this = this;
				_this.$router.push('/system/pc');
			}
		}
	}
</script>

<style>
</style>
