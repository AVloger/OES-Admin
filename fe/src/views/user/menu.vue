<template>
  <v-app>
    <div class="ma-2">
      <h1 class="grey--text display-1">资源管理</h1>
    </div>

    <p class="ma-10">
      <v-row>
        <v-col cols="5">
          <v-treeview
            v-model="selection"
            :items="items"
            :selection-type="selectionType"
            selectable
            open-all
          ></v-treeview>
        </v-col>
        <v-col cols="6">
          <v-textarea
            solo
            name="input-7-1"
            hint="输入资源配置信息"
            value="输入资源配置信息"
          ></v-textarea>
        </v-col>
        <v-col cols="1">
          <v-btn color="primary" class="mb-10"> 新增 </v-btn>
          <v-btn color="primary"> 刷新 </v-btn>
        </v-col>
      </v-row>
    </p>
  </v-app>
</template>

<script>
export default {
  data: function () {
    return {
      selectionType: "leaf",
      selection: [],
      items: [
        {
          id: 1,
          name: "权限管理",
          children: [
            {
              name: "用户权限管理",
              children: [
                {
                  name: "用户管理",
                  children: [
                    { name: "添加用户" },
                    { name: "编辑用户" },
                    { name: "删除用户" },
                    { name: "更改密码" },
                    { name: "搜索用户" },
                  ],
                },
                {
                  name: "角色管理",
                  children: [{ name: "分配权限" }],
                },
                {
                  name: "资源管理",
                  children: [{ name: "保存" }],
                },
              ],
            },
            {
              id: 4,
              name: "案件管理",
              children: [
                { id: 5, name: "Grandchild #1" },
                { id: 6, name: "Grandchild #2" },
              ],
            },
            {
              name: "计算机管理",
              children: [{ name: "保存" }],
            },
          ],
        },
      ],
    };
  },
};
</script>

<style>
</style>
