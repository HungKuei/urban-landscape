/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : localhost:3306
 Source Schema         : landscape

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 05/04/2020 14:46:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for enterprise
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `credit_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业信用代码',
  `enterprise_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业名称',
  `legal_person` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '法人代表',
  `person` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `register_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '注册代码',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业注册地址',
  `enterprise_type` int(11) NULL DEFAULT NULL COMMENT '企业类型',
  `register_capital` int(255) NULL DEFAULT NULL COMMENT '注册资金',
  `website` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网站',
  `email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `is_foreign` int(1) NULL DEFAULT NULL COMMENT '是否外地企业',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登记状态',
  `found_time` datetime(0) NOT NULL COMMENT '成立时间',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES (1, '915001037094313939', '重庆大地园林设计工程股份有限公司', 'test', NULL, NULL, '915001037094313939', '浙江杭州西湖区', 1, 10000, 'http:www.cqddyl.com', '1458@163.com', 0, '开业', '2020-03-30 09:10:40', 1, '2020-03-30 15:56:09', '2020-03-30 16:02:58');
INSERT INTO `enterprise` VALUES (2, '912344437094313939', '重庆大地园林管护工程股份有限公司', 'test', NULL, NULL, '91500245667694313939', '浙江杭州西湖区', 2, 10000, 'http:www.cqddyl.com', '1458@163.com', 0, '开业', '2020-03-30 09:10:40', 1, '2020-04-04 15:19:26', '2020-04-04 15:20:28');
INSERT INTO `enterprise` VALUES (3, '123456789', '中国林业集团', '郭洪奎', '郭洪奎', '18888888834', NULL, '北京', 0, NULL, NULL, 'hungkuei@163.com', NULL, NULL, '2020-04-04 15:55:36', 2, '2020-04-04 23:56:00', '2020-04-04 23:56:00');
INSERT INTO `enterprise` VALUES (4, '78945612325', '中国林业集团二局', '郭洪奎', '郭洪奎', '18888888834', NULL, '北京', 0, NULL, NULL, 'hungkuei@163.com', NULL, NULL, '2020-04-07 16:00:00', 6, '2020-04-05 00:32:36', '2020-04-05 00:32:36');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `type` int(255) NOT NULL COMMENT '类型（新闻、政策、公告）',
  `origin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '数据来源',
  `new_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `clicks` bigint(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '点击次数',
  `is_rem` int(1) NULL DEFAULT NULL COMMENT '是否推荐',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '学术标准 |《园林绿化工程施工招标投标管理标准》首发', 0, '本站', 'http://www.cqylxy.com/UpLoadFiles/image/20151028/20151028105952_6250.jpg', '**Stuxnet 蠕虫病毒可能是有史以来最复杂的软件。 **\\r\\n\\r\\n我们不知道 Stuxnet 的作者是谁，只知道大概是在2005年至2010年间编写的。\\r\\n\\r\\n这种病毒藏在 U 盘上。当 U 盘插入 PC，它会自动运行，将自已复制到该 PC。它至少有三种自动运行的方法。如果某种方法行不通，就尝试另一种。其中的两种运行方法是全新的，使用了 Windows 的两个无人知晓的秘密 Bug。\\r\\n\\r\\n一旦蠕虫进入 PC ，它会尝试获得该 PC 的管理员权限，使用的也是前面提到的那两个无人知道的秘密 Bug。然后，它把自己留下的痕迹全部清除，不让防病毒软件检测到它的存在，用户不会看到任何东西。这种蠕虫隐藏得很好，出现后一年多，没有任何一家安全公司发现它的存在。\\r\\n\\r\\n它会秘密访问 [http://www.mypremierfutbol.com](http://www.mypremierfutbol.com/) 或 [http://www.todaysfutbol.com](http://www.todaysfutbol.com/) 这两个网站，告诉服务器已经成功侵入了一台新的 PC，然后从网站下载最新版本自行更新。\\r\\n\\r\\n它会将自身复制到任何插入该 PC 的 U 盘。使用的 U 盘驱动程序由 Realtek 公司进行了数字签名，但是 Realtek 公司并不知道有这个签名。这意味着，蠕虫作者能够获取 Realtek 公司的最高密钥。\\r\\n\\r\\n它利用两个 Windows 的 Bug ----一个涉及网络打印机，另一个涉及网络文件----将自己传播到局域网里面的其他计算机上。\\r\\n\\r\\n直到这一步，它的真正任务还没有开始。\\r\\n\\r\\n它在每一台计算机上寻找一种由西门子设计的用于大型工业机械自动化的控制软件。一旦发现这种软件，它会使用另*一个*以前未知的 Bug，将自身复制到工业控制器的驱动程序。然后，它会检查两家特定公司的工业电机，其中一家公司在伊朗，另一家在芬兰。它要搜索的特定电机称为变频驱动器，主要用于运行工业离心机，提纯多种化学品，比如铀。\\r\\n\\r\\n由于蠕虫完全控制了离心机，因此它可以做任何事情，可以将离心机全部关闭，也可以将它们全部摧毁：只需设定以最大速度旋转离心机，直到它们全都像炸弹一样爆炸，杀死任何恰好站在附近的人。\\r\\n\\r\\n但它没有这么做，一旦它控制了每台离心机......它就进入潜伏。一旦达到设定的时间，它就会悄悄地唤醒自己，锁住离心机，使得人类无法关闭这些机器。然后悄悄地，蠕虫开始旋转这些离心机，修改了安全参数，增加了一些气体压力......\\r\\n\\r\\n此外，它还会在离心机正常运转的时候，偷录一段21秒的数据记录。当它控制离心机运行的时候，会一遍又一遍地播放这段数据记录。管理人员会看到，计算机屏幕上的所有离心机运行数据都很正常，但这其实是蠕虫让他们看的。\\r\\n\\r\\n现在让我们想象一下，有一家工厂正在用离心机净化铀。电脑上的所有数字都表明离心机运行正常。但是，离心机正在悄悄地出问题，一个接一个地倒下，这使得铀产量一直下降。铀必须是纯净的。你的铀不够纯净，无法做任何有用的事情。\\r\\n\\r\\n工厂的管理者根本找不到原因，离心机的数据是正常的。你永远不会知道，所有这些问题都是由一种计算机蠕虫引起的。这是一种历史上最狡猾和最聪明的计算机蠕虫，它由一些拥有无限资金和无限资源的令人难以置信的秘密团队编写，并且设计时只考虑一个目的：偷偷摧毁某个国家的核弹计划，并且不被发现。', 14, 1, '2019-03-29 22:52:32', '2020-04-05 13:19:42');
INSERT INTO `news` VALUES (3, '属性不能获取全局变量变更后的状态的问题 官方说明', 1, '新华社', 'http://www.cqylxy.com/UpLoadFiles/image/20151028/20151028105519_4375.jpg', '## 问题描述\n\nVuex适合于中大型项目，在小型项目中使用往往是杀鸡用牛刀。\n\n官方说明如下:\n\n> 如果您不打算开发大型单页应用，使用 Vuex 可能是繁琐冗余的。确实是如此——如果您的应用够简单，您最好不要使用 Vuex。\n\n但最近使用自定义的全局变量时，却遇到了`computed`计算属性不能获取全局变量变更后的状态的问题。\n\n```js\n// src/state/index.js\nexport default {\n	state1: \'\',\n	state2: \'\'\n}\n\n// main.js\nimport state from \'./state\'\nVue.prototype.$state = state\n\n// demo.vue\ncomputed: {\n    state1() {\n        console.log(\'in computed...\')\n        return this.$state.state1\n    }\n},\nwatch: {\n    state1: function(newValue) {\n        console.log(\'newValue: \' + newValue)\n    }\n}    \n```\n\n\n\n当通过其他方式改变`state1`的值时，发现`computed`和`watch`的代码并没有执行，查阅了相关资料才发现这种方式创建的全局变量**是不可交互的**。\n\n## 解决方法\n\n```js\n// src/state/index.js\nexport default {\n	state1: \'\',\n	state2: \'\'\n}\n\n// main.js\nimport state from \'./state\'\nnew Vue({\n  el: \'#app\',\n  router,\n  components: { App },\n  template: \'<App/>\'\n  // 关键在此处，注意此处data不是函数形式\n  data: { // only place where data is not a function\n    state\n  },\n})\n\n// demo.vue\ncomputed: {\n    state1() {\n        console.log(\'in computed...\')\n        return this.$root.state.state1\n    }\n},\nwatch: {\n    state1: function(newValue) {\n        console.log(\'newValue: \' + newValue)\n    }\n}  \n```\n\n按上面写法就能成功创建可交互的全局变量了。\n\n\n\n## 参考\n\n[https://cn.vuejs.org/v2/guide/state-management.html#简单状态管理起步使用](https://cn.vuejs.org/v2/guide/state-management.html#简单状态管理起步使用)\n\n[https://stackoverflow.com/questions/51275301/how-to-react-to-a-global-variable-with-vue](https://stackoverflow.com/questions/51275301/how-to-react-to-a-global-variable-with-vue)', 16, 0, '2018-03-30 11:51:10', '2020-04-05 13:19:08');
INSERT INTO `news` VALUES (5, '关于开展2016年重庆市园林专业大学生暑期实习活动的通知', 2, '本站', 'http://www.cqylxy.com/UpLoadFiles/image/20151028/20151028112606_2500.jpg', '各园林企事业单位、相关高校：\n\n暑期是大学生参与社会实践，积累职业经验的宝贵时间。为了让大学生更多的了解社会，增强大学生将所学知识与实际操作相结合的能力，提高综合就业竞争力，重庆市园林局积极引导园林企事业单位大力提供实习岗位，联合开展2016年重庆市园林专业大学生暑期实习活动。通过此次活动的开展，力争在园林行业中建立良性的人才储备，推动企业健康发展，为“科学发展、富民兴渝”做出贡献。\n     一、活动安排\n\n此活动由重庆市园林局主办，重庆市人才交流服务中心园林分中心（以下简称园林人才中心）承办，目的是在暑期为广大园林及相关专业大学生搭建就业创业实践的平台。拟从园林企事业单位中为大学生提供实习岗位。 \n     二、申报条件及程序\n\n（一）实习岗位确定：有意提供岗位的企事业单位请到园林人才网(http://www.cqylrc.com/)下载并填写《2016年重庆市园林专业大学生暑期实习岗位信息表》；加盖公章后将扫描件和电子档在7月1日前发送到邮箱150414145@qq.com。\n\n（二）实习生申报：此次实习活动的参与高校为西南大学、文理学院等四所高校，四所高校吸中有意参加实习的大学生由所在学校负责组织在园林人才网(http://www.cqylrc.com/)下载并填写《2016年重庆市大学生暑期实习活动申请表》，实习大学生应为在校大三学生，品学兼优，具有吃苦耐劳精神，身体健康，自愿前往生产一线实习。学生根据实习岗位情况填写《申请表》并加贴一寸彩照后将扫描件和电子档在7月1日前发送到邮箱150414145@qq.com。\n\n三、活动组织管理及要求 \n\n（一）重庆市园林人才中心根据校企需求，统筹安排和推进活动开展，并做好校企对接工作。\n\n（二）市园林局人事处和园林人才中心在大学生实习期间将采取实地随访、电话询问等方式随时了解和掌握实习情况。\n\n（三）高校要做好实习大学生的思想教育工作，参加实习的学生应本着自愿的原则推荐,在实习期内能够服从管理要求，遵章守纪，不得无故离岗。 \n\n（四）用人单位安排的实习岗位原则上应在生产第一线，指派有丰富实践经验的工程技术人员作为指导老师；为实习学生提供食宿和给予一定的基本生活补助（不低于600元/月），企业应做好大学生安全教育和防范工作，并购买人身意外伤害保险。接收北京林业大学实习生的企业还需承担大学生的往返基本交通费补贴。\n\n（五）联系人：杜梦捷，联系电话：023-68810895\n\n \n\n附件：1. 2016年重庆市园林专业大学生暑期实习岗位信息表 2．2016年重庆市大学生暑期实习活动申请表\n\n\n \n\n \n\n重庆市人才交流服务中心园林分中心\n\n2016年6月27日', 10, 1, '2020-03-30 12:32:39', '2020-04-05 13:19:48');
INSERT INTO `news` VALUES (6, '学术标准 |《园林绿化工程施工招标投标管理标准》首发', 0, '本站', 'http://localhost/upload/2020/04/05/9d5bcf2f-804c-42c0-85ab-502d495ff2e1.jpg', '<p><strong>Stuxnet 蠕虫病毒可能是有史以来最复杂的软件。 </strong></p>\\r\\n<p>我们不知道 Stuxnet 的作者是谁，只知道大概是在2005年至2010年间编写的。</p>\\r\\n<p>这种病毒藏在 U 盘上。当 U 盘插入 PC，它会自动运行，将自已复制到该 PC。它至少有三种自动运行的方法。如果某种方法行不通，就尝试另一种。其中的两种运行方法是全新的，使用了 Windows 的两个无人知晓的秘密 Bug。</p>\\r\\n<p>一旦蠕虫进入 PC ，它会尝试获得该 PC 的管理员权限，使用的也是前面提到的那两个无人知道的秘密 Bug。然后，它把自己留下的痕迹全部清除，不让防病毒软件检测到它的存在，用户不会看到任何东西。这种蠕虫隐藏得很好，出现后一年多，没有任何一家安全公司发现它的存在。</p>\\r\\n<p>它会秘密访问 <a href=\\\"http://www.mypremierfutbol.com/\\\">http://www.mypremierfutbol.com</a> 或 <a href=\\\"http://www.todaysfutbol.com/\\\">http://www.todaysfutbol.com</a> 这两个网站，告诉服务器已经成功侵入了一台新的 PC，然后从网站下载最新版本自行更新。</p>\\r\\n<p>它会将自身复制到任何插入该 PC 的 U 盘。使用的 U 盘驱动程序由 Realtek 公司进行了数字签名，但是 Realtek 公司并不知道有这个签名。这意味着，蠕虫作者能够获取 Realtek 公司的最高密钥。</p>\\r\\n<p>它利用两个 Windows 的 Bug ----一个涉及网络打印机，另一个涉及网络文件----将自己传播到局域网里面的其他计算机上。</p>\\r\\n<p>直到这一步，它的真正任务还没有开始。</p>\\r\\n<p>它在每一台计算机上寻找一种由西门子设计的用于大型工业机械自动化的控制软件。一旦发现这种软件，它会使用另<em>一个</em>以前未知的 Bug，将自身复制到工业控制器的驱动程序。然后，它会检查两家特定公司的工业电机，其中一家公司在伊朗，另一家在芬兰。它要搜索的特定电机称为变频驱动器，主要用于运行工业离心机，提纯多种化学品，比如铀。</p>\\r\\n<p>由于蠕虫完全控制了离心机，因此它可以做任何事情，可以将离心机全部关闭，也可以将它们全部摧毁：只需设定以最大速度旋转离心机，直到它们全都像炸弹一样爆炸，杀死任何恰好站在附近的人。</p>\\r\\n<p>但它没有这么做，一旦它控制了每台离心机......它就进入潜伏。一旦达到设定的时间，它就会悄悄地唤醒自己，锁住离心机，使得人类无法关闭这些机器。然后悄悄地，蠕虫开始旋转这些离心机，修改了安全参数，增加了一些气体压力......</p>\\r\\n<p>此外，它还会在离心机正常运转的时候，偷录一段21秒的数据记录。当它控制离心机运行的时候，会一遍又一遍地播放这段数据记录。管理人员会看到，计算机屏幕上的所有离心机运行数据都很正常，但这其实是蠕虫让他们看的。</p>\\r\\n<p>现在让我们想象一下，有一家工厂正在用离心机净化铀。电脑上的所有数字都表明离心机运行正常。但是，离心机正在悄悄地出问题，一个接一个地倒下，这使得铀产量一直下降。铀必须是纯净的。你的铀不够纯净，无法做任何有用的事情。</p>\\r\\n<p>工厂的管理者根本找不到原因，离心机的数据是正常的。你永远不会知道，所有这些问题都是由一种计算机蠕虫引起的。这是一种历史上最狡猾和最聪明的计算机蠕虫，它由一些拥有无限资金和无限资源的令人难以置信的秘密团队编写，并且设计时只考虑一个目的：偷偷摧毁某个国家的核弹计划，并且不被发现。</p>\\r\\n', 8, 1, '2021-03-29 22:52:32', '2020-04-05 13:19:57');
INSERT INTO `news` VALUES (7, '新馆肺炎确证通报', 2, '新华社', 'http://localhost/upload/2020/04/05/4c8e904f-c725-46c6-a5b8-b8cb8f0f3620.jpg', 'material-server\n介绍\n基于SpringBoot2.xx+MyBatis+Mapper+PageHelper+MySql+Swagger物资回收管理系统api接口服务\n\n软件架构\n软件架构说明\n\n安装教程\nxxxx\nxxxx\nxxxx\n使用说明\nxxxx\nxxxx\nxxxx\n参与贡献\nFork 本仓库\n新建 Feat_xxx 分支\n提交代码\n新建 Pull Request\n码云特技\n使用 Readme_XXX.md 来支持不同的语言，例如 Readme_en.md, Readme_zh.md\n码云官方博客 blog.gitee.com\n你可以 https://gitee.com/explore 这个地址来了解码云上的优秀开源项目\nGVP 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目\n码云官方提供的使用手册 https://gitee.com/help\n码云封面人物是一档用来展示码云会员风采的栏目 https://gitee.com/gitee-stars/', 0, 1, '2020-04-05 13:22:29', '2020-04-05 13:23:57');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `enterprise_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '企业名称',
  `project_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '项目名称',
  `project_type` int(1) NOT NULL COMMENT '项目类型',
  `scale` int(32) NULL DEFAULT NULL COMMENT '规模',
  `region` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '区域',
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目所在地',
  `amount` double(32, 0) NULL DEFAULT NULL COMMENT '金额',
  `contract_date` datetime(0) NOT NULL COMMENT '合同日期',
  `start_date` datetime(0) NOT NULL COMMENT '开工时间',
  `enterprise_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '企业负责人',
  `project_person` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '项目负责人',
  `remart` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, '中国林业集团二局', '名豪·百年文化广场文旅城一体化项目', 0, 55000, '城口县', '重庆市城口县葛城街道', 84, '2015-02-28 16:00:00', '2019-02-28 16:00:00', '董长卫', '蔡绣娟', '⑴对切坡、基坑开挖、地下暗挖等涉及施工安全的重点部位和环节在设计文件中是否予以说明。⑵对防范生产安全事故提出意见，并在开工前向施工单位进行技术交底。', '建设中');
INSERT INTO `project` VALUES (5, '重庆大地园林设计工程股份有限公司', '重庆市园林工程项目', 1, 30000, '塔山街', '中国', 100000, '2020-03-10 16:00:00', '2020-03-17 16:00:00', 'admin', 'admin', '备注', '已竣工');

-- ----------------------------
-- Table structure for qualification
-- ----------------------------
DROP TABLE IF EXISTS `qualification`;
CREATE TABLE `qualification`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enterprise_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '企业名称',
  `type` int(1) NULL DEFAULT NULL COMMENT '资质类别',
  `certificate_code` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '证书编号',
  `level` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资质等级',
  `issued_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '核发机关',
  `vesting_date` datetime(0) NOT NULL COMMENT '授予日期',
  `period_validity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资质有效期',
  `good` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '良好信息',
  `bad` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '不良信息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qualification
-- ----------------------------
INSERT INTO `qualification` VALUES (1, '重庆大地园林设计工程股份有限公司', 1, '12345687954125', '二级', '浙江地质总局', '2020-03-08 17:42:04', '十年', '无', '无');
INSERT INTO `qualification` VALUES (2, '重庆大地园林管护工程股份有限公司', 2, '857498561615456', '二级', '重庆市林业局', '2020-03-31 03:54:10', '五年', '无', '无');

-- ----------------------------
-- Table structure for supervise
-- ----------------------------
DROP TABLE IF EXISTS `supervise`;
CREATE TABLE `supervise`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(1) NOT NULL COMMENT '类型',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话(手机)',
  `email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'E-Mail',
  `address` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `title` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `reply` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `status` int(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '反馈时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supervise
-- ----------------------------
INSERT INTO `supervise` VALUES (1, 0, '郭洪奎', '18888888888', 'hungkuei@163.com', '浙江杭州', '问题反馈', '《园林绿化工程施工招标投标管理标准》是中国风景园林学会开展团体标准工作以来，首部编制完成并出版的团体标准，标志着学会团体标准工作取得突破性进展。', '回复内容', 1, '2020-03-30 13:35:04');
INSERT INTO `supervise` VALUES (2, 0, '郭洪奎', '18888888888', 'hungkuei@163.com', '联系地址', '标题', 'sadasfgdrhtr的复合体恒天然恒天然华人', 'ssdasfa给v但是公司的', 1, '2020-04-04 21:49:55');
INSERT INTO `supervise` VALUES (3, 1, '发达的', '18888888834', 'hsssuei@163.com', '联系地址', '标题2', 'sadasfgdrhtr的复sfgrghhgth人', '问题已解决', 1, '2020-04-04 21:51:12');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `role` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `email` varchar(55) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `pre_info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '简介',
  `status` int(1) NOT NULL COMMENT '状态',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时将',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'admin', '188xxxxxxxx', 'hungkuei@163.com', '女', 'http://localhost/upload/2020/04/05/0156a381-5860-4e51-96a0-6115fe60d51f.png', '😄普通大学生，技术爱好者', 0, '2020-03-08 18:54:14', '2020-04-05 12:34:41');
INSERT INTO `user` VALUES (2, 'hugnkuei', 'e10adc3949ba59abbe56e057f20f883e', 'user', '18859587545', '4778@qq.com', '女', 'http://localhost/upload/2020/04/05/08c9b84c-a550-4bbb-806f-cf0356b98133.jpg', NULL, 0, '2020-04-04 23:56:00', '2020-04-04 23:56:00');
INSERT INTO `user` VALUES (6, 'super', '29481bf5d996d39610e57c0254ee33b7', 'user', NULL, NULL, NULL, NULL, NULL, 0, '2020-04-05 00:32:27', '2020-04-05 12:55:27');

SET FOREIGN_KEY_CHECKS = 1;
