<template>
	<v-app>
		<div class="ma-2">
			<h1 class="blue--text display-1">计算机管理</h1>
		</div>

		<v-snackbar v-model="snackbarFlag" timeout="2000" centered height="80">{{ snackbarText }}</v-snackbar>

		<v-dialog v-model="pcDialog" persistent max-width="400">
			<v-card>
				<v-card-title>
					计算机表单
				</v-card-title>
				<v-card-text>
					<v-row class="d-flex align-center">

						<v-col cols="12">
							<!-- <v-select label="IP" :items="targetIpList" item-text="value" item-value="key"></v-select> -->
							<v-text-field label="请输入远程电脑的ip" v-model="pc.ip"></v-text-field>
						</v-col>

						<v-col cols="12">
							<v-text-field label="请输入远程计算机账号" v-model="pc.accountName"></v-text-field>
						</v-col>

						<v-col cols="12">
							<v-text-field label="请输入远程计算机密码" v-model="pc.accountPassword"></v-text-field>
						</v-col>

						<v-col cols="12">
							<v-select label="选择分组" v-model="pc.groupId" :items="groups" item-text="name"
								item-value="id"></v-select>
						</v-col>

						<v-col cols="12">
							是否安装审查客户端
							<v-radio-group v-model="pc.clientFlag">
								<v-radio v-for="radio in radioList" :key="radio.id" :label="`${radio.value}`"
									:value="radio.id"></v-radio>
							</v-radio-group>
						</v-col>

					</v-row>
				</v-card-text>
				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="primary" @click="save">
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
				<v-col cols="4">
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

				<v-col cols="4">
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
						<!-- 						<v-icon small class="mr-2" @click="toPcDetail(item)">
							mdi-redo
						</v-icon>
						<v-icon small class="mr-2" @click="editItem(item)">
							mdi-pencil
						</v-icon>
						<v-icon small @click="deleteItem(item)">
							mdi-delete
						</v-icon> -->

						<v-btn x-small class="mr-2 primary" @click="editItem(item)">编辑</v-btn>

					</template>
					<!-- 					<template v-slot:no-data>
						<v-btn color="primary" @click="initialize">
							Reset
						</v-btn>
					</template> -->

				</v-data-table>
			</v-col>
		</v-row>

	</v-app>
</template>

<script>
	export default {
		data: function() {
			return {
				snackbarFlag: false,
				snackbarText: '',
				radioGroup: 1,
				pcDialog: false,
				pcGroup: 0,
				pc: {},
				targetIpList: [{
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
				groups: [],

				radioList: [{
						id: 1,
						value: '是'
					},
					{
						id: 0,
						value: '否'
					}
				],
				pcs: [

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
						text: 'ip',
						value: 'ip'
					},
					{
						text: '组别',
						value: 'groupId'
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

		created() {
			// 从session-storage中获取组别
			let _this = this;
			let data = SessionStorage.get(SESSION_KEY_GROUP) || {};
			if (Tool.isEmpty(data)) {
				_this.$router.push('/welcome');
			}
			_this.pcGroup = data;
			_this.getComputers();
			_this.groups = _this.getGroups();
		},


		methods: {
			/**
			 * 获取组别
			 */
			getGroups() {
				let _this = this;
				_this.$ajax.get(process.env.VUE_APP_SERVER + '/admin/group/list').then(res => {
					if (res.data.code == '200') {
						_this.groups = res.data.content;
					}
				})
			},
			/**
			 * 编辑计算机
			 */
			editItem(item) {
				let _this = this;
				_this.pc = $.extend({}, item);
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

			save() {
				let _this = this;
				console.log(_this.pc);
				Loading.show();
				_this.$ajax.post(process.env.VUE_APP_SERVER + '/admin/pc/save', _this.pc).then(res => {
					Loading.hide(function() {

						_this.pcDialog = false;
						_this.getComputers();
					});
					setTimeout(function() {
						_this.snackbarFlag = true;
						_this.snackbarText = '保存成功';
					}, 500);
				})
			},

			/**
			 * 查看详情
			 */
			toPcDetail(item) {
				let _this = this;
				_this.$router.push('/system/pcdetail');
			},

			/**
			 * 获取计算机列表
			 */
			getComputers() {
				let _this = this;
				Loading.show();
				_this.$ajax.get(process.env.VUE_APP_SERVER + '/admin/pc/list/' + _this.pcGroup.id).then(res => {
					Loading.hide(function() {
						if (res.data.code == '200') {
							_this.pcs = res.data.content;
						}
					});
				})
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
