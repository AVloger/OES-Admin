import axios from '../axios'

export const login = (data) => {
	return axios({
		url: '/admin/login',
		method: 'post',
		data
	})
}