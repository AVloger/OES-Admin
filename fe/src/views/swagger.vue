
<template>
	<v-app>
		<div class="display-1 grey--text ma-2">API文档</div>
		<iframe :src="src" frameborder="no" style="width: 100%;height: 100%" scrolling="auto" class="ma-2"/>
	</v-app>
</template>
<script>
export default {
  name: "Swagger",
  data() {
    return {
      src: process.env.VUE_APP_SERVER + "/swagger-ui.html",
      height: document.documentElement.clientHeight - 94.5 + "px;",
    };
  },
};
</script>