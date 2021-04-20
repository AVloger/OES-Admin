/**
 * api聚合模块，汇合module目录下所有子模块的api
 */
import * as user from './modules/user'
import * as role from './modules/role'
import * as group from './modules/group'
import * as pc from './modules/pc'
import * as login from './modules/login'
import * as tool from './modules/tool'
// 默认全部导出
export default {
	user, 
	role,
	group,
	pc,
	login,
	tool
}