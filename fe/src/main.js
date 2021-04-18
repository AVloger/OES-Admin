import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import global from '@/utils/global'
import axios from 'axios'
import api from './http'
Vue.use(api);
// 解决每次ajax请求，对应的sessionId不一致的问题
axios.defaults.withCredentials=true; //让ajax携带cookie
Vue.prototype.global = global // 挂载全局配置模块
Vue.config.productionTip=false;


new Vue({
	router,
	vuetify,
	render: h => h(App)
}).$mount('#app')
