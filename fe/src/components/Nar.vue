<template>
	<!-- https://material-ui.com/zh/components/material-icons/ -->
	<nav>
		<v-app-bar app color="#6777EF">
			<v-app-bar-nav-icon @click="drawer = !drawer">

			</v-app-bar-nav-icon>

			<v-toolbar-title>
				<span class=" font-weight-bold">取证系统</span>
			</v-toolbar-title>
			<v-spacer></v-spacer>
			<v-menu offset-y>
				<template v-slot:activator="{ on, attrs }">
					<v-btn v-bind="attrs" v-on="on" text>
						菜单
					</v-btn>
				</template>
				<v-list>
					<v-list-item v-for="(item, index) in items" :key="index">
						<v-list-item-title>{{ item.title }}</v-list-item-title>
					</v-list-item>
				</v-list>
			</v-menu>
			<v-btn text>
				<span>退出</span>
				<v-icon>exit_to_app</v-icon>
			</v-btn>
		</v-app-bar>
		<v-navigation-drawer color="#f8f8f8" app v-model="drawer">
			<v-card-text class="text-center title">
				取证系统
			</v-card-text>

			<v-list>
				<v-list-group prepend-icon="settings" no-action>
					<template v-slot:activator>
						<v-list-item-title>用户权限管理</v-list-item-title>
					</template>


					<v-list-item to="/system/user">
						<v-list-item-content>
							用户管理
						</v-list-item-content>
					</v-list-item>

					<v-list-item to="/system/role">
						<v-list-item-content>
							角色管理
						</v-list-item-content>
					</v-list-item>

					<v-list-item to="/system/menu">
						<v-list-item-content>
							资源管理
						</v-list-item-content>
					</v-list-item>


				</v-list-group>

				<v-list-group prepend-icon="folder" no-action>
					<template v-slot:activator>
						<v-list-item-title>案件管理</v-list-item-title>
					</template>
					<v-list-item to='/system/case'>
						<v-list-item-content>
							案件管理
						</v-list-item-content>
					</v-list-item>
				</v-list-group>

				<v-list-group prepend-icon="computer" no-action>
					<template v-slot:activator>
						<v-list-item-title>计算机管理</v-list-item-title>
					</template>
					<v-list-item to='/system/group'>
						<v-list-item-content>
							分组管理
						</v-list-item-content>
					</v-list-item>
				</v-list-group>

				<v-list-group prepend-icon="build" no-action>
					<template v-slot:activator>
						<v-list-item-title>工具类</v-list-item-title>
					</template>
					<v-list-item to="/tools/swagger">
						<v-list-item-content>
							API文档
						</v-list-item-content>
					</v-list-item>
					
					<v-list-item to="/test/test">
						<v-list-item-content>
							管理端测试
						</v-list-item-content>
					</v-list-item>
					
					<v-list-item to="/test/test2">
						<v-list-item-content>
							客户端测试
						</v-list-item-content>
					</v-list-item>
				</v-list-group>
			</v-list>
		</v-navigation-drawer>
	</nav>
</template>

<script>
	export default {
		name: 'Nav',
		data: function() {
			return {
				drawer: true,
				items: [{
						title: '点击1',
					},
					{
						title: '点击2',
					},
					{
						title: '点击3'
					}
				]
			}
		}
	}
</script>

<style>
</style>
