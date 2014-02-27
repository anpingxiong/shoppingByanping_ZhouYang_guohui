select * from t_goods; 
drop   database shoppingdb;
select * from t_comment;
create database shoppingdb;
use shoppingdb;
/*==============================================================*/
/* Table: t_ad                                         */
/*==============================================================*/
create table t_ad
(
   aid                  int not null auto_increment,  
   aURL              varchar(50) not null,
   overdate         date,
   exp                 varchar(200),
   primary key(aid)
);
insert into t_ad values(null,"http://www.baidu.com",null,"百度");
select * from t_ad;

/*==============================================================*/
/* Table: t_user                                         */
/*==============================================================*/
create table t_user
(
   uid                  int not null auto_increment,  
   username             varchar(20),
   password             varchar(20),
   email                varchar(30),
   name                 varchar(20),
   address              varchar(50),
   province             varchar(10),
   city                 varchar(10),
   urban                varchar(10),
   post                 varchar(10),
   tel                  varchar(15),
   expense              double,               
   level                int,        
   state                int,
   pdate                date,
   primary key (uid)
);
insert into t_user values(null,'arron','12345',null,null,null,null,null,null,null,null,null,null,null,now());

 

/*==============================================================*/
/* Table: t_sort                                       */
/*==============================================================*/
create table t_sort
(
   sid                  int not null auto_increment,   /*涓婚� */
   name                 varchar(20),
   exp                  varchar(200),
   pid                  int,       
   primary key (sid)
);
 
insert into t_sort values(null,'食品','食品',0);
insert into t_sort values(null,'健康美容','健康美容',0);
insert into t_sort values(null,'家居日用','家居日用',0);
insert into t_sort values(null,'家电通信','家电通信',0);
insert into t_sort values(null,'服饰鞋帽','服饰鞋帽',0);
insert into t_sort values(null,'IT数码','IT数码',0);


insert into t_sort values(null,'素食区','素食区',1);
insert into t_sort values(null,'熟食区','熟食区',1);
insert into t_sort values(null,'香烟区','香烟区',1);
insert into t_sort values(null,'烟酒区','烟酒区',1);

insert into t_sort values(null,'护肤区','护肤区',2);
insert into t_sort values(null,'彩妆区','彩妆区',2);
insert into t_sort values(null,'美发区','美发区',2);
insert into t_sort values(null,'香水区','香水区',2);
insert into t_sort values(null,'瘦身区','瘦身区',2);

insert into t_sort values(null,'洗涤用品','洗涤用品',3);

insert into t_sort values(null,'电视区','电视区',4);
insert into t_sort values(null,'冰箱区','冰箱区',4);
insert into t_sort values(null,'电话区','电话区',4);
insert into t_sort values(null,'手机区','手机区',4);

insert into t_sort values(null,'女装区','女装区',5);
insert into t_sort values(null,'男装区','男装区',5);
insert into t_sort values(null,'童装区','童装区',5);
insert into t_sort values(null,'鞋帽区','鞋帽区',5);

insert into t_sort values(null,'数码相机','数码相机',6);
insert into t_sort values(null,'摄像影財','摄像影財',6);
insert into t_sort values(null,'MP3/MP4','MP3/MP4',6);
insert into t_sort values(null,'U盘/移动设备','U盘/移动设备',6);

 

/*==============================================================*/
/* Table: t_goods                                            */
/*==============================================================*/
create table t_goods
(
   gid                  int auto_increment,   
   name                 varchar(20),
   marketprice          double,
   nowprice             double,
   discount             double,   
   bargain              int,     /*这是？？？ 特价？？*/
   exp                  varchar(200),
   sid                  int,    /*类id*/
   pdate                date,
   goodsnum             int,
   ordernum             int,
   primary key (gid)
);

alter table t_goods add constraint FK_Reference_5 foreign key (sid)
      references t_sort (sid) on delete cascade on update cascade;
delete  from t_goods;
insert into t_goods values(null,'联想电视',2890,1602,55.4,0,'超薄显示屏，立体感强',17,now(),100,10);
insert into t_goods values(null,'同创电视',3000,2500,83.3,0,'超薄显示屏，立体感强',17,now(),100,10);
insert into t_goods values(null,'创维电视',1800,1500,83.3,0,'显示效果好',17,now(),100,10);
insert into t_goods values(null,'小天使电视',3800,2500,65.8,1,'非常给力',17,now(),100,10);
insert into t_goods values(null,'何达电视',1500,1300,86.7,0,'显示效果好，非常实惠',17,now(),100,10);
insert into t_goods values(null,'LG电视',1800,1599,88.3,1,'显示效果好，非常实惠',17,now(),100,10);


 


/*==============================================================*/
/* Table: t_order                                            */
/*==============================================================*/
 
create table t_order
(
   oid                  varchar(20) not null,   
   odate                date,
   total                double,                 
   payway               int,
   billinfo             int,                    
   getmethod           int,
   timereq              int,                /*鍙戣揣鏃堕棿*/
   exp                  varchar(200),
   uid                  int,
   state          int ,
   primary key (oid)
);


alter table t_order add constraint FK_Reference_8 foreign key (uid)
      references t_user (uid) on delete cascade on update cascade;
      insert into t_order values('20101009',now(),1000,1,0,1,1,'发货快点',1,1);
      
      
/*==============================================================*/
/* Table: t_orderitem                                         */
/*==============================================================*/
 drop table t_orderitem;
 
create table t_orderitem
(
   id                   int not null auto_increment,
   oid                  varchar(20),   
   gid                  int,
   num                  int  ,   
   primary key (id)
);


alter table t_orderitem add constraint FK_Reference_6 foreign key (oid)
      references t_order (oid) on delete cascade on update cascade;

alter table t_orderitem add constraint FK_Reference_9 foreign key (gid)
      references t_goods (gid) on delete cascade on update cascade;
      
      insert into t_orderitem values(null,'20101009',1,10);
 
/*==============================================================*/
/* Table: t_address                                    */
/*==============================================================*/
 drop table t_address
create table t_address
(
   getname              varchar(20) not null,  /*涓婚敭涓嶅悎鐞�*/
   address              varchar(50),
   post                 varchar(10),
   tel                  varchar(15),  
   oid                  varchar(20),
   primary key (oid)
);

alter table t_address add constraint FK_Reference_7 foreign key (oid)
      references t_order (oid) on delete cascade on update cascade;
/*==============================================================*/
/* Table: t_comment                                       */
/*==============================================================*/
create table t_comment
(
   id                   int not null auto_increment,
   gid                  int,
   uid                  int,
   content              varchar(200),
   primary key (id)
);

alter table t_comment add constraint FK_Reference_3 foreign key (gid)
      references t_goods (gid) on delete cascade on update cascade;
alter table t_comment add constraint FK_Reference_4 foreign key (uid)
      references t_user (uid) on delete cascade on update cascade;
/*==============================================================*/
/* Table: t_favorite                                          */
/*==============================================================*/
create table t_favorite
(
   id                   int not null auto_increment,
   uid                  int,
   gid                  int,
   primary key (id)
);

alter table t_favorite add constraint FK_Reference_10 foreign key (gid)
      references t_goods (gid) on delete cascade on update cascade;

alter table t_favorite add constraint FK_Reference_2 foreign key (uid)
      references t_user (uid) on delete cascade on update cascade;
/*==============================================================*/
/* Table: t_notice                                           */
/*==============================================================*/
create table t_notice
(
   id                   int not null auto_increment,
   title                varchar(50),
   content              varchar(200),
   pdate                date,
   overdate             date,
   primary key (id)
);   

select * from t_goods;
//select * from   t_goods  where (year(now()) =year(pdate)) and (month(now())=month(pdate)) and (day(now())-day(pdate)<3) ;
select * from t_goods where name like '%电视%'  order  by  gid desc;