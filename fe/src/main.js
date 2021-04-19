import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import global from '@/utils/global'
// import { baseUrl } from '@/utils/global'
import axios from 'axios'
import api from './http'

Vue.use(api);// 注册使用api模块
Vue.prototype.global = global // 挂载全局配置模块
Vue.config.productionTip=false;


new Vue({
	router,
	vuetify,
	render: h => h(App)
}).$mount('#app')
