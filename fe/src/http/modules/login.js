import axios from '../axios'

export const login = (data) => {
	return axios({
		url: '/admin/login',
		method: 'post',
		data
	})
}

export const logout = () => {
	return axios({
		url: '/admin/logout',
		method: 'get'
	})
}