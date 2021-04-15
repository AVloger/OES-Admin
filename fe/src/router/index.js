import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login.vue'
import Welcome from '@/views/welcome.vue'
import Admin from '@/views/admin.vue'
import User from '@/views/user/user.vue'
import Role from '@/views/user/role.vue'
import Menu from '@/views/user/menu.vue'
import Group from '@/views/group.vue'
import Computer from '@/views/computer.vue'
import PcDetail from '@/views/pcdetail.vue'
import Case from '@/views/case.vue'
import CaseDetail from '@/views/casedetail.vue'
import Swagger from '@/views/swagger.vue'
import Test from '@/views/test.vue'
import Test2 from '@/views/test2.vue'
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
			}, {
				path: 'tools/swagger',
				component: Swagger
			}, 
			{
				path: 'test/test',
				component: Test
			}, {
				path: 'test/test2',
				component: Test2
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
