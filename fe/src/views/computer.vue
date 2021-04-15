<template>
	<v-app>
		<div class="ma-2">
			<h1 class="grey--text display-1">计算机管理</h1>
		</div>

		<v-dialog v-model="pcDialog" persistent max-width="400">
			<v-card>
				<v-card-title>
					计算机表单
				</v-card-title>
				<v-card-text>
					<v-row class="d-flex align-center">
						
						<v-col cols="12">
							<v-select label="目标机IP" :items="targetIpList" item-text="value" item-value="key"></v-select>
						</v-col>
						
						<v-col cols="12">
							<v-text-field label="请输入远程计算机账号"></v-text-field>
						</v-col>
						
						<v-col cols="12">
							<v-text-field label="请输入远程计算机密码"></v-text-field>
						</v-col>
						
						<v-col cols="12">
							<v-select label="选择分组" :items="groups" item-text="value" item-value="key"></v-select>
						</v-col>
						
						<v-col cols="12">
							是否安装审查客户端
							<v-radio-group v-model="radioGroup">
								<v-radio v-for="radio in radioList" :key="radio.id" :label="`${radio.value}`" :value="radio.value"></v-radio>
							</v-radio-group>
						</v-col>
						
					</v-row>
				</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="primary">
						保存
					</v-btn>

					<v-btn color="info" @click="pcDialog=false">
						取消
					</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>

		<div class="ma-3">
			<v-row class="d-flex align-center">
				<v-col cols="2">
					<v-btn class="mr-2" color="primary" @click="addPc">
						新增计算机
					</v-btn>
					<v-btn color="info">
						刷新
					</v-btn>
				</v-col>

				<v-col cols="2">
					<v-text-field label="搜索计算机"></v-text-field>
				</v-col>

				<v-col cols="2">
					<v-btn color="info">
						搜索
					</v-btn>
				</v-col>

				<v-col cols="5">
					<v-btn class="teal white--text mr-2">
						安装审查客户端
					</v-btn>
					<v-btn class="cyan white--text mr-2">
						卸载审查客户端
					</v-btn>
				</v-col>
			</v-row>
		</div>


		<v-row>
			<v-col cols="12">
				<v-data-table v-model="selected" :headers="headers" :items="pcs" :single-select="singleSelect"
					item-key="id" show-select class="elevation-1" hide-default-footer>
					<template v-slot:top>
						<v-switch v-model="singleSelect" label="单选" class="pa-3"></v-switch>
					</template>

					<template v-slot:item.actions="{ item }">
						<v-icon small class="mr-2" @click="toPcDetail(item)">
							mdi-redo
						</v-icon>
						<v-icon small class="mr-2" @click="editItem(item)">
							mdi-pencil
						</v-icon>
						<v-icon small @click="deleteItem(item)">
							mdi-delete
						</v-icon>
	
					</template>
					<template v-slot:no-data>
						<v-btn color="primary" @click="initialize">
							Reset
						</v-btn>
					</template>

				</v-data-table>
			</v-col>
		</v-row>

	</v-app>
</template>

<script>
	export default {
		data: function() {
			return {
				radioGroup: 1,
				pcDialog: false,
				targetIpList: [
					{
						key: 1,
						value: '1.1.1.1'
					},
					{
						key: 2,
						value: '12.2.2.2'
					},
					{
						key: 3,
						value: '11.1.1.1-11.2.2.2'
					}
				], 
				groups: [
					{
						key: 1,
						value: '组1'
					},
					{
						key: 2,
						value: '组2'
					}
				],
				radioList:[
					{
						id:1,
						value: '是'
					},
					{
						id:2,
						value: '否'
					}
				],
				pcs: [{
						id: 1,
						name: '联想拯救者R7000',
						remarks: '电脑1',
						ip: '1.1.1.2',
						group: 1,
						status: '在线'
					},
					{
						id: 2,
						name: '联想拯救者R7000P',
						remarks: '电脑2',
						ip: '1.1.1.3',
						group: 1,
						status: '离线'
					},

					{
						id: 3,
						name: '联想拯救者Y9000',
						remarks: '电脑3',
						ip: '1.1.1.5',
						group: 1,
						status: '等待卸载'
					},
					{
						id: 4,
						name: '外星人',
						remarks: '电脑4',
						ip: '1.1.1.4',
						group: 1,
						status: '正在卸载'
					},


				],

				singleSelect: false,
				selected: [],
				headers: [{
						text: '序号',
						align: 'start',
						sortable: false,
						value: 'id',
					},
					{
						text: '原始计算机名',
						value: 'name'
					},
					{
						text: '备注',
						value: 'remarks'
					},
					{
						text: 'ip',
						value: 'ip'
					},
					{
						text: '组别',
						value: 'group'
					},
					{
						text: '状态',
						value: 'status'
					},
					{
						text: '操作',
						value: 'actions'
					}
				],

			}
		},


		methods: {
			/**
			 * 编辑计算机
			 */
			editItem(item) {
				let _this = this;
				_this.pcDialog = true;
			},

			/**
			 * 增加计算机
			 */
			addPc() {
				let _this = this;
				_this.pcDialog = true;
			},
			/**
			 * 删除计算机
			 */
			deleteItem(item) {
				let _this = this;
				Confirm.show("确定要删除该台计算机吗？");
			},

			/**
			 * 查看详情
			 */
			toPcDetail(item) {
				let _this = this;
				_this.$router.push('/system/pcdetail');
			}
		},

		watch: {
			selected: {
				// deep: true,
				handler() {
					console.log(this.selected);
				}
			}
		}

	}
</script>

<style>
</style>
