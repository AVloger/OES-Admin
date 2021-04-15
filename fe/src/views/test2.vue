<template>
	<v-app>
		<div class="ma-2 grey--text display-1">客户端通信测试</div>


		<v-row class="ma-2 ">
			<v-col cols="3">
				<v-text-field label="请输入ip" v-model="ip"></v-text-field>
			</v-col>
			<v-col cols="2" class="ma-2">
				<v-btn class="primary" @click="connectRemotePC()">
					连接ip
				</v-btn>
			</v-col>
			<template v-if="flag">
				<v-col cols="3" >
					<v-textarea solo name="input-7-4" label="向ip端发送请求" v-model="msg"></v-textarea>
				</v-col>
				
				<v-col cols="2">
					<v-btn @click="sentMsg()" class="info">发送</v-btn>
				</v-col>
			</template>
		</v-row>


	</v-app>
</template>

<script>
	export default {
		data: function() {
			return {
				// 需要通信的ip
				ip: "10.7.51.185",
				flag: false,
				// 给服务端发送信号
				msg: "",
			}
		},


		methods: {
			// 连接远端ip 
			connectRemotePC() {
				let _this = this;
				_this.$ajax.post(process.env.VUE_APP_SERVER + '/admin/communication/connect/' + _this.ip).then(res => {
					if(res.data.code=='200') _this.flag = true;
				});
			},
			
			// 发送信息
			sentMsg() {
				let _this = this;
				_this.$ajax.post(process.env.VUE_APP_SERVER + '/admin/communication/getMsg', {
					msg: _this.msg
				}).then(res => {
					
				});
			}
		},
	}
</script>


<style>
</style>
