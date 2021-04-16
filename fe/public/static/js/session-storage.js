SESSION_KEY_GROUP = "SESSION_KEY_GROUP"; //点击跳转计算机列表时，保存组别信息
SessionStorage = {
	get: function(key) {
		let v = sessionStorage.getItem(key);
		if (v && typeof(v) !== 'undefined' && v!== 'undefined') {
			return JSON.parse(v);
		}
	},
	
	set: function(key, data) {
		sessionStorage.setItem(key, JSON.stringify(data));
	},
	
	remove: function(key) {
		sessionStorage.removeItem(key);
	},
	
	clearAll: function(key) {
		sessionStorage.clear();
	}
}