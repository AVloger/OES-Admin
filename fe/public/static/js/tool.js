Tool = {
	/**
	 * 空校验 null或""都返回true
	 */
	isEmpty: function(obj) {
		if ((typeof obj == 'string')) {
			// https://blog.csdn.net/dreamjay1997/article/details/86599404
			return !obj || obj.replace(/\s+/g, "") == ""
		} else {
			return (!obj || JSON.stringify(obj) === "{}" || obj.length === 0);
		}
	},

	/**
	 * 非空校验
	 */
	isNotEmpty: function(obj) {
		return !this.isEmpty(obj);
	},

	/**
	 * 长度校验
	 */
	isLength: function(str, min, max) {
		return $.trim(str).length >= min && $.trim(str).length <= max;
	},




}
