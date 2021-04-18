import axios from '../axios'

/**
 * 保存计算机信息
 */
export const save = (data) => {
	return axios({
		url: '/admin/pc/save',
		method: 'post',
		data
	})
}

/**
 * 获取计算机列表
 */
export const list = (id) => {
	return axios({
		url: '/admin/pc/list/' + id,
		method: 'get'
	})
}