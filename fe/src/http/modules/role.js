import axios from '../axios'

export const getRoles = () => {
	return axios({
		url: '/admin/role/list',
		method: 'get'
	})
}