<template>
	<v-app>
		<Nav />
		<v-main color="#FAF9FE">
			<router-view></router-view>
		</v-main>
	</v-app>
</template>

<script>
	import Nav from '@/components/Nar.vue'
	export default {
		name: 'Admin',
		components: {
			Nav
		}
	}
</script>

<style>
</style>
