<template>
	<v-app>
		<div class="ma-2">
			<h1 class="grey--text display-1">
				案件详情
			</h1>
		</div>
		
		<div class="ma-2"> 
			<v-btn color="primary">
				添加取证任务
			</v-btn>
		</div>

		<div>
			<v-row class=" d-flex align-center">
				<v-col cols="2">
					已完成的审查计算机数目: 12
				</v-col>
				<v-col cols="2">
					正在取证的计算机数据: 10
				</v-col>
				<v-col cols="5">
					未取证的审查计算机数目: 9
				</v-col>

				<v-col cols="2">
					<v-text-field v-model="search" append-icon="mdi-magnify" label="搜索案件" single-line hide-details>
					</v-text-field>
				</v-col>


				<v-col cols="12">
					<v-data-table multi-sort v-model="selected" :headers="headers" :items="desserts"
						:single-select="singleSelect" item-key="name" class="elevation-1" :search="search">

						<template v-slot:item.actions="{ item }">
							<v-icon small class="mr-2" @click="toTask(item)">
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
		</div>


	</v-app>
</template>

<script>
	export default {
		data() {
			return {
				caseDialog: false,
				search: '',
				singleSelect: false,
				selected: [],
				headers: [{
						text: '取证任务名称',
						align: 'start',
						sortable: false,
						value: 'name',
					},
					{
						text: '状态',
						value: 'status'
					},
					{
						text: '历时',
						value: 'total_time'
					}, {
						text: '创建时间',
						value: 'create_time'
					},
					{
						text: '发起人',
						value: 'user'
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
					status: Random.randomType(['取证中', '完成', '停止']),
					create_time: Random.randomTime(),
					type: Random.randomType(['舞弊', '泄密', '诈骗']),
					total_time: Random.randomNum(0, 10) + "h " + Random.randomNum(0, 60) + "m " + Random.randomNum(0,
						60) + "s ",
					user: Random.randomString(5),
					// 			progress: Random.randomNum(0, 100) + "%"



				};
				_this.desserts.push(data);
			}
		},
	}
</script>

<style>
</style>
