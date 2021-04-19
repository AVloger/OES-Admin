/**
 * 这里把axios注册为vue插件使用 
 * 并将api模块挂载在vue原型的$api对象上
 * 这样能获取this引用的地方可以通过 _this.$api.子模块.方法 的方式来调用api
 */
import api from './api'

const install = Vue => {  
    Object.defineProperties(Vue.prototype, {
        // 注意，此处挂载在 Vue 原型的 $api 对象上
        $api: {
            get() {
                return api
            }
        }
    })
}

export default install