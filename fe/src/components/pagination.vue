<template>
	<v-container>
		<v-row>
			<v-col cols="8">
				<v-btn small v-bind:disabled="page===1" @click="selectPage(page-1)" class="ma-1">
					上一页
				</v-btn>

				<v-btn small v-for="(p, i) in pages" @click="selectPage(p)" class="ma-1">
					{{ p }}
				</v-btn>

				<v-btn small v-bind:disabled="page===pageTotal" @click="selectPage(page+1)" class="ma-1">
					下一页
				</v-btn>
			</v-col>

			<v-col cols="4">
				<v-select v-model="size" :items="items" no-data-text="5"></v-select>
			</v-col>
		</v-row>
	</v-container>
</template>

<script>
	export default {
		name: 'Pagination', // 分页组件

		// 传过来的值 定义类型
		props: {
			list: {
				type: Function,
				default: null
			},
			itemCount: Number //显示的页码数，比如总共有100页，只显示10页
		},

		data: function() {
			return {
				items: [1, 5, 10, 20, 50, 100], // 每页显示的条数
				total: 0, // 总条数
				size: 1, // 每页条数
				page: 0, // 当前页码
				pageTotal: 0, // 总页数
				pages: [], // 显示的页码数组
			}
		},

		methods: {
			/**
			 * 分页渲染组件
			 */
			render(page, total) {
				let _this = this;
				_this.page = page; // 当前页码
				_this.total = total; // 总条数
				_this.pageTotal = Math.ceil(total / _this.size); //总页数
				_this.pages = _this.getPagetItems(_this.pageTotal, page, _this.itemCount || 5);
			},

			/**
			 * 查询某一页
			 * @param page
			 */
			selectPage(page) {
				let _this = this;
				if (page < 1) {
					page = 1;
				}
				if (page > _this.pageTotal) {
					page = _this.pageTotal;
				}
				if (this.page !== page) {
					_this.page = page;
					if (_this.list) {
						_this.list(page);
					}
				}
			},

			/**
			 * 当前要显示在页面上的页码
			 * @param total
			 * @param current
			 * @param length
			 * @returns {Array}
			 */
			getPageItems(total, current, length) {
				let items = [];
				if (length >= total) {
					for (let i = 1; i <= total; i++) {
						items.push(i);
					}
				} else {
					let base = 0;
					// 前移
					if (current - 0 > Math.floor((length - 1) / 2)) {
						// 后移
						base = Math.min(total, current - 0 + Math.ceil((length - 1) / 2)) - length;
					}
					for (let i = 1; i <= length; i++) {
						items.push(base + i);
					}
				}
				return items;
			}
		}
	}
</script>

<style>
</style>
