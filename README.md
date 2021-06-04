# MsCrowd

## 介绍

本项目是一个在线众筹平台通过向普通大众募集资金来支持创业项目，支持者可以获得与支持金额相当的回报。项目主要是从单一架构到分布式架构的过渡阶段，适合学完SSM框架后，需要通过一个项目巩固所学知识技能，并平滑过渡到分布式开发的小伙伴。 

整个项目分后台管理系统和前台会员系统两部分： 

> 1.后台管理系统是基于SSM整合的单一架构 
>
> 2.前台会员系统是基于SpringBoot+SpringCloud的微服务架构

后台模块

> 父工程 mscrowdfunding01-admin-parent
> 
> Web工程 mscrowdfunding02-admin-webui
> 
> 主要工程 mscrowdfunding03-admin-component
> 
> 实体类模块 mscrowdfunding04-admin-entiy
> 
> 工具类模块 mscrowdfunding05-common-util
> 
> 逆向工程模块 mscrowdfunding06-common-reverse

前台模块---------------------------------------------------端口号                                                 
> 注册中心：mscrowdfunding08-member-eureka------------------1000
> 
> MySQL数据服务：mscrowdfunding10-member-mysql-provider-----2000
> 
> Redis数据服务：mscrowdfunding11-member-redis-provider-----3000
> 
> 会员中心：mscrowdfunding12-member-authentication-consumer-4000
> 
> 项目维护：mscrowdfunding13-member-project-consumer--------5000
> 
> 订单维护：mscrowdfunding14-member-order-consumer----------7000
> 
> 支付功能：mscrowdfunding15-member-pay-consumer------------8000
> 
> 网关：mscrowdfunding16-member-zuul-------------------------80

更详细项目信息可以关注[Readme](https://gitee.com/baiwei_melon_seeds/ms-crowd/edit/master/Readme)笔记文件夹。
