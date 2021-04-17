import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';
import axios from 'axios'
// 解决每次ajax请求，对应的sessionId不一致的问题
axios.defaults.withCredentials=true; //让ajax携带cookie
// Vue.prototype.$http=axios;
Vue.prototype.$ajax=axios;
Vue.config.productionTip=false;
// axios.defaults.baseURL = '/';
// axios.defaults.headers.common['Authorization'] = 'TEST';
// axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';

/**
 * axio拦截器
 */
// 添加请求拦截器
axios.interceptors.request.use(function(config) {
	// 在发送之前做些什么
	console.log("请求:", config);
	return config;
}, function(error) {
	// 对请求错误做什么
	return Promise.reject(error);
});
// 添加响应拦截器
axios.interceptors.response.use(function(config) {
	console.log("响应:", config);
	return config;
}, function(error) {
	return Promise.reject(error);
})

new Vue({
	router,
	vuetify,
	render: h => h(App)
}).$mount('#app')
