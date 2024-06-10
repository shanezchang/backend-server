```shell
# mysql
docker run -dit \
  -p 3306:3306 \
  -p 33060:33060 \
  -e MYSQL_ROOT_PASSWORD=51XWf3FBGs2XVqig \
  mysql:latest

```

```sql
-- auto-generated definition
create table t_object_storage
(
    id          bigint unsigned auto_increment
        primary key,
    suffix      tinyint unsigned  not null,
    data_name   varchar(32)       not null,
    data_size   bigint unsigned   not null,
    data_string text              not null,
    delete_flag tinyint default 0 not null,
    create_time bigint unsigned   not null,
    update_time bigint unsigned   not null
)
    comment '对象存储数据表';


-- auto-generated definition
create table t_user_info
(
    id bigint unsigned auto_increment
        primary key
)
    comment '用户信息表';


```