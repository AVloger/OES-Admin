<template>
	<v-app>
		<div class="ma-2">
			<h1 class="grey--text display-1">计算机详情</h1>
		</div>

		<v-row class="mt-10">
			<v-col cols="12">

				<!-- 详情展示 -->
				<v-data-table :headers="headers" :items="items" item-key="id"  class="elevation-1"
					hide-default-footer>
				</v-data-table>
			</v-col>
		</v-row>
	</v-app>
</template>

<script>
	export default {
		data: function() {
			return {
				items: [{
						id: 1,
						time: '2021-03-05T21:18:18.21439',
						type: '安装',
						name: '电脑1的安装',
						plugins: '无',
						status: '正在进行'
					},
					{
						id: 2,
						time: '2021-03-05T21:18:18.21439',
						type: '取证',
						name: '电脑2的取证',
						plugins: '微信 QQ',
						status: '已经完成'
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
						text: '操作时间',
						value: 'time'
					},
					{
						text: '操作类型',
						value: 'type'
					},
					{
						text: '案件名称',
						value: 'name'
					},
					{
						text: '插件',
						value: 'plugins'
					},
					{
						text: '状态',
						value: 'status'
					},
				],
			}
		}
	}
</script>

<style>
</style>
