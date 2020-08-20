-- note
create table if not exists `tb_note` {
    `id` int primary key  auto_increment   comment '主键',
    `content` varchar(500) default null  comment '内容',
    `seqNo` varchar not null  comment '序列号',
    `who` varchar not null  comment '发出人',
    `createTime` datetime now()  comment '创建日期',
    `updateTime` datetime now()  comment '更新日期'
} ENGINE=InnoDB DEFAULT CHARSET=gbk AUTO_INCREMENT=1;
-- noter
create table if not exists `tb_noter` {
    `id` int primary key  auto_increment  comment '主键',
    `acctName` varchar(500) not null default '' comment '用户名',
    `password` varchar(500)  not null default '123456'  comment '内容',
    `acctMail` varchar(500) not null default '123456'  comment '邮箱',
    `nickname` varchar(500) not null default ''  comment '昵称',
    `gender` varchar not null  comment '性别',
    `preNoteSeqNo` varchar not null  comment '上一条发生闪念的序列号',
    `createTime` datetime now()  comment '创建日期',
    `updateTime` datetime now()  comment '更新日期'
} ENGINE=InnoDB DEFAULT CHARSET=gbk AUTO_INCREMENT=1;