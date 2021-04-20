import axios from '../axios.js'

export const getSwagger = () => {
	return axios({
		url: '/swagger-ui.html',
		method: 'get',
	})
}