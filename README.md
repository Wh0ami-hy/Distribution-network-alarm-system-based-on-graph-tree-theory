# Distribution-network-alarm-system-based-on-graph-tree-theory
基于图树理论的配电网报警系统设计与实现



# 规划

## 前端

登录页、信息展示页、故障二叉树页、实景地图页、故障表生成页

## 设计

电力供电系统可以抽象成二叉树系统

开发出二叉树节点添加与删除系统，以及由此自动生成相应的逻辑表格，并能自动根据节点报警，自动生成故障分支报警图。故障分支颜色用红色标出，当故障消失后，颜色转到正常

一个节点代表一个监控点

二叉树，构建二叉树（根据节点编号的顺序）、添加、删除节点

生成表格，统计出故障点

正常用绿色，故障用红色

故障类型：短路、接地报警（）

节点信息：具有监控节点编号、故障信息、地址（经纬度）、电流、电场、温度、湿度、电池电压、太阳能电压等变量参数

数据库存储节点信息

## 功能点

输入节点信息以构建二叉树（将输入的节点信息存到数据库），构建完毕后可以添加、删除节点

故障表示：正常节点是绿色，故障是红色，故障点旁边显示故障编号（1、2、3...）页面左上角列出故障点编号和具体故障的对应。使用随机函数来发生故障以便测试

显示：两种显示方式（地图上、单纯二叉树）

故障页：导出故障节点的统计表格（含故障类型等信息）

高德地图上使用点标记（红故障、绿正常）

全国地图显示所有网点，二叉树只显示故障点

## 技术栈

springboot2.7、MySQL5.7、vue2.x

## 数据库设计

一个数据表，存节点的所有信息

**配电设备信息表**

该表用于存储配电设备的基本信息，包括设备名称、设备型号、设备位置等。

**配电网参数信息表**

该表用于存储配电网的各项参数信息，包括电压、电流、功率等。

**异常报警信息表**

该表用于存储异常情况的报警信息，包括报警时间、报警类型、报警等级等。

**故障报告信息表**

该表用于存储故障定位和诊断的报告信息，包括故障时间、故障设备、故障原因等。