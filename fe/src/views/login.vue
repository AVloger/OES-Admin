<template>
	<!-- login页面 -->
	<v-app>
		<v-snackbar top height="80" v-model="snackbar" :timeout="timeout">{{snackbarText}}</v-snackbar>
		<v-container class="fill-height">
			<v-row class="justify-center">
				<v-col cols="12" md="5">
					<v-card>
						<v-card-text>
							<h1 class="text-center blue--text display-2">欢迎登录</h1>
						</v-card-text>
						<v-card-text>
							<v-text-field label="请输入姓名" v-model="user.name"></v-text-field>
							<v-text-field label="请输入密码" type="password" v-model="user.password"></v-text-field>

							<v-row>
								<v-col cols="6">
									<v-text-field label="请输入验证码" v-model="user.imageCode"></v-text-field>
								</v-col>
								<v-spacer></v-spacer>
								<v-col cols="3" class="d-flex justify-center align-center mr-10 ">
									<!-- <v-img  min-width="100"  v-bind:src="srcCode" id="image-code" v-on:click="getImageCode"></v-img> -->
									<img id="image-code" width="200%" />
								</v-col>
							</v-row>
						</v-card-text>
						<v-card-actions>
							<v-spacer></v-spacer>
							<v-btn class="primary" @click="login">
								登录
							</v-btn>
							<v-spacer></v-spacer>
						</v-card-actions>
					</v-card>
				</v-col>

			</v-row>
		</v-container>
	</v-app>
</template>

<script>
	// import Cookies from 'js-cooki'
	export default {
		// https://www.cnblogs.com/chenzeyongjsj/p/8093789.html
		// created:在模板渲染成html前调用，即通常初始化某些属性值，然后再渲染成视图。
		// mounted:在模板渲染成html后调用，通常是初始化页面完成后，再对html的dom节点进行一些需要的操作。
		mounted() {
			let _this = this;
			_this.getImageCode();
			// 绑定时间

			// $("#image-code").unbind().bind("click", _this.getImageCode());

			$("#image-code").on("click", function() {
				var img_path = process.env.VUE_APP_SERVER + '/admin/kaptcha/getImageCode';
				$('#image-code').prop("src", process.env.VUE_APP_SERVER + '/admin/kaptcha/getImageCode');
			});
		},
		data: function() {
			return {
				timeout: 500,
				snackbarText: '',
				snackbar: false,
				user: {},
				srcCode: "",
			}
		},
		methods: {
			login() {
				let _this = this;
				if (Tool.isEmpty(_this.user.name) || Tool.isEmpty(_this.user.password) || Tool.isEmpty(_this.user
						.imageCode)) {
					_this.snackbar = true;
					_this.snackbarText = '用户名、密码、验证码不能为空';
					return;
				}

				_this.$api.login.login(_this.user).then(res => {
					if (res.data.code == '200') {
						// console.log("登录成功");
						// console.log("token:", res.data.content.token);
						Cookies.set("token", res.data.content.token);
						_this.$router.push("/welcome");
					} else {
						_this.snackbar = true;
						_this.snackbarText = res.data.message;
						_this.user = {};
						_this.getImageCode();
					}

				})
				// _this.$router.push("/welcome");

			},
			// 获取验证码
			getImageCode() {
				let _this = this;
				document.getElementById("image-code").click();
				$('#image-code').attr("src", this.global.baseUrl + '/admin/kaptcha/getImageCode');
			},
		}
	}
</script>

<style>

</style>
