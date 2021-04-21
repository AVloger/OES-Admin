/**
 * axios拦截器 
 * 可以进行拦截和响应拦截
 * 在发送请求和响应请求时执行一些操作
 */
import axios from 'axios'
import config from './config'
import router from '@/router'

export default function $axios(options) {
	return new Promise((resolve, reject) => {
		const instance = axios.create({
			baseURL: config.baseUrl,
			headers: config.headers,
			timeout: config.timeout,
			withCredentials: config.withCredentials
		})
		// 添加请求拦截器
		instance.interceptors.request.use(function(config) {
			console.log("请求:", config);
			let token = Cookies.get("token");
			if (token) {
				config.headers.token = token;
			} else {
				// 重定向到登录页面
				router.push("/login");
			}
			return config;
		}, function(error) {
			return Promise.reject(error);
		})
		// 添加响应拦截器
		instance.interceptors.response.use(function(config) {
			console.log("响应:", config);

			return config;
		}, function(error) {
			// 重定向到登录页面
			// router.push("/login");
			Loading.hide();
			setInterval(function() {
				router.replace({
					path: '/login'
				})
				location.reload();
			}, 500);
			return Promise.reject(error.header);
		})
		// 请求处理
		instance(options).then(res => {
			resolve(res)
			return false
		}).catch(error => {
			reject(error)
		})
	})
}
