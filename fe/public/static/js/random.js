Random = {
	randomString: function(e) {
		e = e || 32;
		var t = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678",
			a = t.length,
			n = "";
		for (i = 0; i < e; i++) n += t.charAt(Math.floor(Math.random() * a));
		return n
	},

	randomNum: function(Min, Max) {
		var Range = Max - Min;
		var Rand = Math.random();
		return (Min + Math.round(Rand * Range));
	},

	randomTime: function() {
		endDate = 100000;
		startDate = 2000;
		let date = new Date(1599999999999 + Math.random() * (endDate - startDate));
		let hour = 0 + Math.random() * (23 - 0) | 0;
		let minute = 0 + Math.random() * (59 - 0) | 0;
		let second = 0 + Math.random() * (59 - 0) | 0;
		date.setHours(hour);
		date.setMinutes(minute);
		date.setSeconds(second);
		return date.toLocaleString();

	},
	
	randomType: function(obj) {
	   var len = obj.length;
		 return obj[Random.randomNum(0, len-1)];
	}
}
