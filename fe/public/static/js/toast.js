Toast = {
	success: function(message) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'success',
		  title: message,
		  showConfirmButton: false,
		  timer: 1500
		})
	},
	
	warning: function(message) {
		Swal.fire({
		  position: 'top-end',
		  icon: 'warning',
		  title: 'Your work has been saved',
		  showConfirmButton: false,
		  timer: 1500
		})
	},
	
	error: function() {
		Swal.fire({
		  position: 'top-end',
		  icon: 'error',
		  title: 'Your work has been saved',
		  showConfirmButton: false,
		  timer: 1500
		})
	}
}