<template>
  <v-app class="ma-2">
    <div class="display-1 grey--text">角色管理</div>
 <!-- 
    <v-dialog v-model="roleDialog" persistent max-width="300">
      <v-card>
        <v-card-title> 角色分配资源权限 </v-card-title>
        <v-treeview
          selectable
          :items="items"
          v-model="selection"
          selection-type="leaf"
          return-object
        ></v-treeview>
        <v-card-text> </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn color="primary" @click="save(role)"> 保存 </v-btn>

          <v-btn @click="roleDialog = false" color="warning">取消</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog> -->

    <!-- 按钮 -->
    <div class="mt-5 mb-5">
      <v-btn class="mr-5" color="primary" @click="addrole()"> 新增 </v-btn>
      <v-btn color="warning" @click="listroles"> 刷新 </v-btn>
    </div>

    <!-- 列表展示 -->
    <v-container>
      <v-row class="justify-center">
        <v-col cols="12" md="12">
          <v-simple-table>
            <thead>
              <tr>
                <th class="text-center">序号</th>
                <th class="text-center">角色</th>
                <th class="text-center">描述</th>
                <th class="text-center">操作</th>
              </tr>
            </thead>
            <tbody>
              <tr v-for="role in roles">
                <td class="text-center">{{ role.id }}</td>
                <td class="text-center">{{ role.name }}</td>
                <td class="text-center">{{ role.dept }}</td>

                <td>
                  <v-row class="justify-space-around">
                    <v-btn small color="primary" @click="editrole(role)">
                      <v-icon>edit</v-icon>
                    </v-btn>
                    <v-btn small color="error" @click="deleterole(role.id)">
                      <v-icon>delete</v-icon>
                    </v-btn>
                  </v-row>
                </td>
              </tr>
            </tbody>
          </v-simple-table>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
import axios from "axios";
export default {
  name: "Role",
  data: function () {
    return {
      selectionType: "leaf",
      selection: [],
      items: [
        {
          id: 1,
          name: "资源管理",
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
      role: {},
      roles: [
        {
          id: 1,
          name: "超级管理员",
          dept: "一切权限",
        },
        {
          id: 2,
          name: "案件管理员",
          dept: "",
        },
        {
          id: 3,
          name: "调查员",
          dept: "对权限范围内的目标计算机执行取证任务",
        },
        {
          id: 4,
          name: "审阅员",
          dept: "只允许查看权限范围内的取证结果",
        },
      ],
      roleDialog: false,
    };
  },
  created() {
    let _this = this;
    _this.listroles();
  },

  methods: {
    /**
     * 查询所有用户
     */
    listroles() {
      let _this = this;
    },
    /**
     * 编辑用户
     */
    editrole(role) {
      let _this = this;
      _this.role = $.extend({}, role);
      _this.roleDialog = true;
    },
    /**
     * 新增role
     */
    addrole() {
      let _this = this;
      _this.role = {};
      _this.roleDialog = true;
    },

    /**
     * 根据id删除用户
     */
    deleterole(id) {
      let _this = this;
      Confirm.show("用户删除之后不可恢复，确定吗？", function () {});
    },

    /**
     * 保存
     */
    save(role) {
      let _this = this;
    },
  },
};
</script>

<style>
</style>
