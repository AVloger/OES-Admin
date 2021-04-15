# 前端开发手册

# 技术架构

- vue
- vuetify



# 构建项目

```
vue create vuetify-fe
```



手动选择功能

选上router



**hash模式和history模式的不同**

最直观的区别就是**在url中 hash 带了一个很丑的 #   而history是没有#的

```
vue add vuetify 
```

如果没装cnpm

```
npm install --registry=https://registry.npm.taobao.org
npm i 
```


启动项目

```
npm run serve
```



安装图标字体 这些官网文档都有

```
cnpm install material-design-icons-iconfont -D
cnpm install @fortawesome/fontawesome-free -D
```



关闭语法检测

增加.eslintrc.js

```
module.exports = {
    root: true,
    env: {
        node: true
    },
    'extends': [
        'plugin:vue/essential',
        'eslint:recommended'
    ],
    rules: {
        'no-console': process.env.NODE_ENV === 'production' ? 'error' : 'off',
        'no-debugger': process.env.NODE_ENV === 'production' ? 'error' : 'off',
				'no-console': 'off',
				'no-debugger': 'off',
        'no-undef': 'off',
        'vue/no-unused-vars': 'off',
        'vue/require-v-for-key': 'off',
        'no-unused-vars': 'off',
        'vue/no-unused-components': 'off'
    },
    parserOptions: {
        parser: 'babel-eslint'
    }
};

```





增加请求包

```
cnpm i axios --save

--save 在pacjage.json添加依赖  不加,只是去下载插件,项目中并没有依赖插件
```





删光components views下面的目录

app.vue

```vue
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
	}
</script>
```



.env.dev

```js
NODE_ENV=development
VUE_APP_SERVER=http://127.0.0.1:8000
```



package.json

```json
  "scripts": {
    "serve-dev": "vue-cli-service serve --mode dev",
    "serve-prod": "vue-cli-service serve --mode prod",
    "lint": "vue-cli-service lint"
  },
```





# Nar

顶部栏 侧边栏

```vue
<template>
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

```

# 路由

router/index.js

```vue
import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login.vue'
import Welcome from '@/views/welcome.vue'
import Admin from '@/views/admin.vue'
import User from '@/views/user.vue'
import Role from '@/views/role.vue'
import Menu from '@/views/menu.vue'
import Group from '@/views/group.vue'
import Computer from '@/views/computer.vue'
import PcDetail from '@/views/pcdetail.vue'
import Case from '@/views/case.vue'
import CaseDetail from '@/views/casedetail.vue'
Vue.use(VueRouter)

const routes = [
	{
		path: '*', // 会匹配所有路径
		redirect: '/login'
	}, 
	{
		path: '',
		component: Login
	}, 
	{
		path: '/login',
		component: Login
	},
	{
		path: '/',
		component: Admin,
		children: [
			{
				path: 'welcome',
				component: Welcome
			}, 
			{
				path: 'system/user',
				component: User
			},
			{
				path: 'system/role',
				component: Role
			},
			{
				path: 'system/menu',
				component: Menu
			},
			{
				path: 'system/group',
				component: Group
			},
			{
				path: 'system/pc',
				component: Computer
			},
			{
				path: 'system/pcdetail',
				component: PcDetail
			},
			{
				path: 'system/case',
				component: Case
			},
			{
				path: 'system/casedetail',
				component: CaseDetail
			}
		]
	}

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router

```



# public 

## index.html

```html
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<link rel="icon" href="<%= BASE_URL %>favicon.ico">
		<title>
			<%= htmlWebpackPlugin.options.title %>
		</title>
		<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700,900">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@mdi/font@latest/css/materialdesignicons.min.css">
		<!-- 引入其他的js库 -->
		<!-- jquery-->
		<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
		<!-- 消息框 -->
		<!-- https://sweetalert2.github.io/ -->
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>

		<!-- toast.js -->
		<script src="<%= BASE_URL %>static/js/toast.js"></script>


		<!-- loading等待框 -->
		<script src="<%= BASE_URL %>static/js/loading.js"></script>
		<script src="<%= BASE_URL %>static/js/jquery.mloading.js"></script>
		<link rel="stylesheet" href="<%= BASE_URL %>static/css/jquery.mloading.css">
		
		<!-- confirm确认框 -->
		<script src="<%= BASE_URL %>static/js/confirm.js"></script>
		
		<!-- 引入随机js -->
		<script src="<%= BASE_URL %>static/js/random.js"></script>
		
		
	</head>
	<body>
		<noscript>
			<strong>We're sorry but
				<%= htmlWebpackPlugin.options.title %> doesn't work properly without JavaScript enabled. Please enable it to
				continue.</strong>
		</noscript>
		<div id="app"></div>
		<!-- built files will be auto injected -->
	</body>
</html>

```

## confirm.js

```js
Confirm = {
	// https://sweetalert2.github.io/
	show: function(message, callback) {
		Swal.fire({
			title: '确定?',
			text: message,
			icon: 'warning',
			showCancelButton: true,
			confirmButtonColor: '#3085d6',
			cancelButtonColor: '#d33',
			confirmButtonText: '确认!'
		}).then((result) => {
			if (result.isConfirmed) {
				if (callback) {
					callback();
				}
			}
		})
	}
}

```

## loadinig

```js
Loading = {
	show: function() {
		$("body").mLoading("show");
	},
	
	hide: function() {
		setTimeout(function() {
			$("body").mLoading("hide");
		},100);
	}
};

```

## toast

```js
Toast = {
	success: function(message) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'success',
		  title: message,
		  showConfirmButton: false,
		  timer: 1500
		})
	},
	
	warning: function(message) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'Your work has been saved',
		  showConfirmButton: false,
		  timer: 1500
		})
	},
	
	error: function() {
		Swal.fire({
		  position: 'top-end',
		  icon: 'error',
		  title: 'Your work has been saved',
		  showConfirmButton: false,
		  timer: 1500
		})
	}
}
```

## admin

```vue
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

```





# data-table 
v-data-footer API
[教程1](https://blog.csdn.net/u013089490/article/details/84025743)
[教程2](https://www.freesion.com/article/7176236142/)
pagination
{
  page: number,
  itemsPerPage: number,
  pageStart: number,
  pageStop: number,
  pageCount: number,
  itemsLength: number
}



				:footer-props="{itemsPerPageText: '每页 '}">
					<template v-slot:footer.page-text="props">
						Custom page-text