<template>
	<v-app>
		<div class="ma-2 grey--text display-1">管理端通信测试</div>



<v-container class="ma-2">
	<v-row>
				<v-col cols="2">
					<v-btn @click="connect" class="primary">链接</v-btn>
				</v-col>
	
			</v-row>
	
			<v-row>
				
				<v-col cols="2">
					<v-text-field label="请输入要通信的对象ip" v-model="to"></v-text-field>
				</v-col>
				<v-col cols="6">
					<v-btn @click="start" class="ma-2 primary" >开始任务</v-btn>
					<v-btn @click="pause" class=",a-2 info">停止任务</v-btn>
					<v-btn @click="pingpong" class="ma-2 warning">心跳</v-btn>
				</v-col>
				<v-col cols="3">
					接收消息:
					<div id="receiveMsg">
					</div>
				</v-col>
			</v-row>
			
	<!-- 		<v-row>
				<input type="file" id="input-file" ref="selectFile" @change="uploadFile"/>
			</v-row> -->
</v-container>


	</v-app>
</template>

<script>
	export default {

		data: function() {
			return {
				// 需要通信的ip
				host: '',
				to: '/10.5.10.214:50652',
				// 自己的ip
				flag: false,
				// 给服务端发送信号
				msg: "",
				webUrl: "ws://10.7.51.185:8088/ws",
				socket: "",
			}
		},

		mounted() {
			// 初始化
			this.init();
		},


		methods: {
			init() {
				let _this = this;
				_this.socket = new WebSocket(_this.webUrl);
				_this.socket.onopen = function() {
					console.log("链接建立成功");
				}
				_this.socket.onclose = function() {
					console.log("链接断开");
				}
				_this.socket.onerror = function() {
					console.log("发生异常");
				}
				_this.socket.onmessage = function(e) {
					console.log("接收消息:", e.data);
					var ele = document.getElementById("receiveMsg");
					var html = receiveMsg.innerHTML;
					receiveMsg.innerHTML = html + "<br />" + e.data;
				}

			},
			// 第一次链接  
			connect() {
				let _this = this;
				_this.msg = "init";
				_this.socket.send(_this.msg);
			},


			
			/**
			 * 开启任务
			 */
			start() {
				var list = [0];
				var list_str = JSON.stringify(list)
				
				let _this = this;
				var obj = {
					flag: '1', // 开始
					taskId: '1243', // 取证任务id
					plugin: list_str ,// 插件id 列表
					to: _this.to
				};
				console.log(obj);
				_this.msg = JSON.stringify(obj);
				_this.socket.send(_this.msg);
				_this.msg="";
			},
			/**
			 * 停止任务
			 */
			pause() {
				let _this = this;
				_this.msg = _this.host+"@" + _this.to +"@" + '1-task1-pc1-[plugin1,plugin2,plugin3]';
				_this.socket.send(_this.msg);
				_this.msg="";
			},
			
			/**
			 * 心跳检测
			 */
			pingpong() {
				
			},
			
			/**
			 * 选取文件
			 */
			uploadFile() {
				// let _this = this;
				// let inputDom = _this.$refs.selectFile;
				// let fil = inputDom.files;
				// let formData = new window.FormData();
				// formData.append("file", fil[0]);
				// formData.append("name", _this.to);
				// console.log(fil[0]);
				// // _this.socket.send(formData);
				// _this.socket.send(formData);
			}
		},
	}
</script>


<style>
</style>
