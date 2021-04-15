<template>
	<router-view></router-view>
</template>

<script>
	export default {
		name: 'App',
		components: {

		},

		data: () => ({

		}),


		// 打开新页面 自动回滚到顶部 在数据更新前调用
		updated() {
			window.scroll(0, 0);
		},
	}
</script>
