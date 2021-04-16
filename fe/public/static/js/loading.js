Loading = {
	show: function() {
		$("body").mLoading("show");
	},

	hide: function(callback) {
		// 延时，避免过快而导致现象不明显

		setTimeout(  
			function() {
				$("body").mLoading("hide");
				callback();
			}, 200);
	}
};
