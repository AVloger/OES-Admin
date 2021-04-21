<template>
	<v-app>
		<div class="ma-2">
			<h1 class="grey--text display-1">案件管理</h1>
		</div>

		<!-- 案件表单 -->
		<v-dialog v-model="caseDialog" max-width="400" persistent="">
			<v-card>
				<v-card-title>
					案件表单
				</v-card-title>
				<v-card-text>

				</v-card-text>

				<v-card-actions>
					<v-spacer></v-spacer>
					<v-btn color="primary">保存</v-btn>
					<v-btn @click="caseDialog=false">取消</v-btn>
				</v-card-actions>
			</v-card>
		</v-dialog>

		<div class="ma-2">
			<v-row class="d-flex align-center">
				<v-col cols="10">
					<v-btn color="primary" class="mr-2" @click="addCase">创建案件</v-btn>
					<v-btn color="error">批量删除</v-btn>
				</v-col>
				<v-col cols="2">
					<v-text-field v-model="search" append-icon="mdi-magnify" label="搜索案件" single-line hide-details>
					</v-text-field>
				</v-col>
			</v-row>
		</div>

		<v-row class="mt-10">
			<v-col cols="12">
				<v-data-table multi-sort v-model="selected" :headers="headers" :items="desserts"
					:single-select="singleSelect" item-key="name" show-select class="elevation-1" :search="search"
					:footer-props="{itemsPerPageText: '每页 '}">
					<template v-slot:footer.page-text="props">
						Custom page-text
					</template>
					<template v-slot:item.actions="{ item }">
						<v-icon small class="mr-2" @click="toCase(item)">
							mdi-redo
						</v-icon>
						<v-icon small class="mr-2" @click="editCase(item)">
							mdi-pencil
						</v-icon>
						<v-icon small @click="deleteCase(item)">
							mdi-delete
						</v-icon>

						<v-icon small @click="controllCaseProgress(item)">
							mdi-chevron-right
						</v-icon>

						<v-icon small @click="exportFile(item)">
							mdi-file
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
		data() {
			return {
				footer: {
					showFirstLastPage: true,
					firstIcon: 'mdi-arrow-collapse-left',
					lastIcon: 'mdi-arrow-collapse-right',
					prevIcon: 'mdi-minus',
					nextIcon: 'mdi-plus',
					'items-per-page-text': 'products per page'
				},
				caseDialog: false,
				search: '',
				singleSelect: false,
				selected: [],
				headers: [{
						text: '案件名称',
						align: 'start',
						sortable: false,
						value: 'name',
					},
					{
						text: '案件状态',
						value: 'status'
					},
					{
						text: '案件创建时间',
						value: 'create_time'
					},
					{
						text: '案件类型',
						value: 'type'
					},
					{
						text: '案件历时',
						value: 'total_tiem'
					},
					{
						text: '案件创建者',
						value: 'user'
					},
					{
						text: '运行进度条',
						value: 'progress'
					},
					{
						text: '操作',
						value: 'actions'
					}

				],
				desserts: [

				],
			}
		},

		created() {
			let _this = this;

			for (let i = 0; i < 100; ++i) {
				let data = {
					name: Random.randomString(10),
					status: Random.randomType(['运行中', '完成', '停止']),
					create_time: Random.randomTime(),
					type: Random.randomType(['舞弊', '泄密', '诈骗']),
					total_tiem: Random.randomNum(0, 10) + "h " + Random.randomNum(0, 60) + "m " + Random.randomNum(0,
						60) + "s ",
					user: Random.randomString(5),
					progress: Random.randomNum(0, 100) + "%"



				};
				_this.desserts.push(data);
			}
		},

		methods: {
			/**
			 * 创建案件
			 */
			addCase() {
				let _this = this;
				_this.caseDialog = true;
			},

			/**
			 * 编辑案件
			 */
			editCase(item) {

			},
			/**
			 * 打开案件
			 */
			toCase(item) {
				let _this = this;
				_this.$router.push('/system/casedetail')
			}
		}


	}
</script>

<style>
</style>
