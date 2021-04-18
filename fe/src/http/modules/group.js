import axios from '../axios'


/**
 * 获取所有计算机分组
 */
export const getGroups = () => {
	return axios({
		url: '/admin/group/list',
		method: 'get'
	})
}

/**
 * 保存分组信息
 */
export const save = (data) => {
	return axios({
		url: '/admin/group/save',
		method: 'post',
		data
	})
}

