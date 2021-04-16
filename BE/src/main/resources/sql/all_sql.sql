-- 用户表
create table user (
	id integer primary key autoincrement,  -- id
	name text not null, -- 用户名
	password text not null, -- 密码
	phone text not null, -- 联系电话
	remark text -- 备注
);

insert into user (name, password, phone, remark) values ('super-admin', 'super-admin', '1234567', '我是超级管理员');
insert into user (name, password, phone, remark) values ('case-admin1', 'case-admin1', '12431234', '我是案件管理员1');
insert into user (name, password, phone, remark) values ('case-admin2', 'case-admin2', '13411412', '我是案件管理员2');
insert into user (name, password, phone, remark) values ('investigator1', 'investigator1', '124124', '我是调查员1');
insert into user (name, password, phone, remark) values ('investigator2', 'investigator2', '124312', '我是调查员2');
insert into user (name, password, phone, remark) values ('reviewer1', 'reviewer1', '12412412', '我是审阅员1');
insert into user (name, password, phone, remark) values ('reviewer2', 'reviewer2', '11241', '我是审阅员2');

-- 角色表
create table role (
    id integer primary key autoincrement, -- id
    name text not null, -- 角色名
    description text  -- 角色描述
);
insert into role (name) values ('超级管理员');
insert into role (name) values ('案件管理员');
insert into role (name) values ('调查员');
insert into role (name) values ('审阅员');

-- 用户角色关联表
create table user_role (
    id  integer primary key autoincrement, -- id
    user_id integer not null , -- 用户id
    role_id integer not null -- 角色id
);
insert into user_role (user_id, role_id) values (1,1);
insert into user_role (user_id, role_id) values (2,2);
insert into user_role (user_id, role_id) values (3,2);
insert into user_role (user_id, role_id) values (4,3);
insert into user_role (user_id, role_id) values (5,3);
insert into user_role (user_id ,role_id) values (6,4);
insert into user_role (user_id, role_id) values (7,4);


-- 计算机表
create table pc (
    id integer primary key autoincrement, -- id
    ip text not null, -- ip
    pc_name text, -- 计算机名
    group_id integer not null default 1 , -- 计算机分组 默认为0
    account_name text, -- 远程账号用户名
    account_password  text, -- 远程账号密码
    status text,
    client_flag integer not null default 0, -- 是否安装了审查客户端 0:未安装 1：已安装
    manage_flag integer not null default 0 -- 是否已经添加了管理 0：没有被添加管理 1： 已经被添加了管理
);

insert into pc (ip, group_id) values ('127.0.0.1', 1);
insert into pc (ip, group_id) values ('10.8.0123.0', 1);
-- 计算机组
create table pc_group (
    id integer primary key autoincrement, -- id
    name text -- 计算机组别
);
insert into pc_group (name) values ("默认分组");


-- 案件表
create table sys_case (
    id integer primary key autoincrement, -- 案件id
    create_by integer, -- 案件创建人id | 超级管理员id
    create_time text, -- 案件创建时间
    type_id integer, -- 案件类型id
    total_time datetime-- 案件历时

) ;
-- 案件类型表
create table case_type (
    id integer primary key autoincrement, -- 案件类型id
    name text -- 案件类型名
);

insert into case_type (name) values ('贪污');
insert into case_type (name) values ('受贿');
insert into case_type (name) values ('出卖商业秘密');
insert into case_type (name) values ('日常检查');





-- 任务表
create table sys_task (
    id integer primary key autoincrement , -- 取证任务id
    name text, -- 取证任务名字
);

-- 插件表
create table plugin (
    id integer primary key autoincrement, -- id
    name text -- 插件名
);
-- 登录日志
create table login_info (
    id integer primary key autoincrement, -- id
    user_id integer , -- 登录用户id
    ip_addr text, -- 登录ip地址
    login_time datetime -- 登录时间
);