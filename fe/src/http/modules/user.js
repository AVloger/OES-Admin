/**
 * 用户管理模块
 */
import axios from '../axios'

// 分页查询
export const findPage = (data) => {
	return axios({
		url: '/admin/user/pageUser/',
		method: 'post',
		data
	})
}


// 保存
export const save = (data) => {
	return axios({
		url: '/admin/user/save',
		method: 'post',
		data
	})
}
// 根据id删除用户
export const delUser = (userId) => {
	return axios({
		url: '/admin/user/delete/' + userId,
		method: 'delete'
	})
}
// 获取所有角色
export const getRoles = () => {
	return axios({
		url: '/admin/role/list',
		method: 'get'
	})
}

// 获取每个用户的角色
export const getRolesByUser = (userId) => {
	return axios({
		url: '/admin/userRole/roleList/' + userId,
		method: 'get'
	})
}

// 分配角色
export const saveRoles = (data) => {
	return axios({
		url: '/admin/userRole/saveRoles',
		method: 'post',
		data
	})
}