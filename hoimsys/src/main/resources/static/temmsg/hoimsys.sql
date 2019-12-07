/*
Navicat MySQL Data Transfer

Source Server         : sss
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : hoimsys

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2019-12-07 13:07:51
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dt_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '科室编号',
  `dt_name` varchar(50) DEFAULT NULL,
  `dt_mobile` varchar(20) DEFAULT NULL,
  `dt_room_number` varchar(10) DEFAULT NULL,
  `dt_info` varchar(255) DEFAULT NULL COMMENT '科室描述',
  `dt_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dt_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', '内科', '770521', 'A栋101', '科室为包含心血管、神经内科、呼吸内科、消化内科的综合大内科，技术力量强，现有临床医生均系正规院校毕业，并与兴义市医院建立了长期的协作关系。科室拥有动态心电及血压监测、电生理检测仪、床边监护仪、肺功能检测仪、呼吸机、电子胃镜等先进设备，以消化、呼吸、疑难重症等系统疾病为重点；“把知识传递给患者，把健康带给患者”是科室始终坚持的服务理念。', 'dt_id1.jpg');
INSERT INTO `department` VALUES ('2', '外科', '770522', 'A栋102', '在普外、肝胆外科、泌尿外科、骨科等专业方面积累了丰富的经验，采用手法复位，小夹板、石膏外固定治疗四肢骨折。诊治各种痔疮、肛瘘、肛裂及各种肛肠疾病，效果好，痛苦小，无需住院。可开展全消化系统外科手术、胆囊切除术、胃穿孔修补术、肠粘连松解术、肝囊肿开窗引流术以及急腹症、胆囊及胆管结石、腹股沟疝、泌尿系结石、前列腺增生、肿瘤的手术。\r\n并根据需要可提供州市医院知名专家的指导.', 'dt_id2.jpg');
INSERT INTO `department` VALUES ('3', '妇产科', '770523', 'A栋103', '病区环境优雅舒适，科室设备齐全。开展药物流产、人工流产、引产，妇科及产科常见病、多发病、并发症的诊治处理；各种难产处理；围产期保健；新生儿窒息抢救及护理；子宫肌瘤、卵巢囊肿、宫外孕的手术治疗。能为孕产妇及其家人提供医疗、保健咨询服务和产程中母亲/胎儿的双重监护陪护；并为母亲提供爱婴技术指导以及新生儿免疫接种等服务。医生亲自观察产程，为产妇的安全分娩提供可靠的保证，并让您享受家庭化病房的温馨服务。', 'dt_id3.jpg');
INSERT INTO `department` VALUES ('4', '儿科', '770524', 'A栋104', '儿科现有医务人员责任心强、经验丰富，能为患儿提供科学合理的治疗，努力让家长放心、满意。能开展儿科常见病、多发病的诊断治疗和小儿疾病的预防及健康指导；小儿喂养指导、计划免疫指导、常见疾病的家庭防治和护理等。配有微量注射泵、雾化吸入器和心电监护仪等儿科专业治疗、抢救设备。\r\n服务宗旨：以认真负责的态度对待每一位就诊患儿，让家长放心、满意。', 'dt_id4.jpg');
INSERT INTO `department` VALUES ('5', '中医康复科', '770525', 'A栋105', '中医康复科由中医、针灸、理疗、按摩、医学康复组成。科室设备齐全，有超短波治疗仪、超声波治疗仪、紫外线治疗仪、磁疗治疗仪、中频治疗仪、中药熏蒸床、微波治疗仪、等。开展了支气管哮喘、颈椎病、腰椎病、中风后遗症，面瘫、各种头痛，腰腿痹症以及各种神经、内分泌系统疾病的治疗。\r\n服务宗旨：为您提供温馨服务、使您拥有健康生活。', 'dt_id5.jpg');
INSERT INTO `department` VALUES ('6', '门诊', '770500', 'A栋100', '负责治疗本身疾病并不紧急，不需要住院进行治疗的患者的部门叫门诊部。门诊部会依照各种疾病分科室', 'dt_id6.jpg');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `d_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '医生编号',
  `dt_id` int(11) DEFAULT NULL COMMENT '所属科室id',
  `t_id` int(11) DEFAULT NULL COMMENT '职称id',
  `d_name` varchar(255) DEFAULT NULL,
  `d_sex` varchar(2) DEFAULT NULL COMMENT 'w:男；m：女',
  `d_mobile` varchar(20) DEFAULT NULL,
  `d_password` varchar(20) DEFAULT NULL,
  `d_limits_number` int(2) DEFAULT NULL COMMENT '0:不可用；1：科室医生：2：门诊医生；3：药房管理员；99：超级管理员',
  `d_img` varchar(100) DEFAULT NULL,
  `d_info` varchar(255) DEFAULT NULL COMMENT '医生简介',
  PRIMARY KEY (`d_id`),
  KEY `doctor_department` (`dt_id`),
  KEY `doctor_title` (`t_id`),
  CONSTRAINT `doctor_department` FOREIGN KEY (`dt_id`) REFERENCES `department` (`dt_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `doctor_title` FOREIGN KEY (`t_id`) REFERENCES `title` (`t_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', '2', '4', '盛志勇', '男', '17523468862', '123456', '1', 'd_id1.jpg', '外科专家，中国工程院院士，博士生导师。1942年毕业于国立上海医学院。1947年在美国德克萨斯州立大学医学院研修一年。历任上海红十字会第一医院（现华山医院）、中山医院外科医师、主治医师；军事医学科学院实验外科系副主任、副研究员；解放军总医院创伤外科、烧伤科主任、主任医师；解放军军医进修学院外科教授；');
INSERT INTO `doctor` VALUES ('2', '2', '4', '卢世壁', '男', '15624985612', '123456', '1', 'd_id2.jpg', '骨外科学专家，中国工程院院士，博士生导师。现为中国人民解放军总医院骨科研究所所长，并担任国际生物材料科学与工程会士，华裔骨科学会理事，中国残疾人康复协会理事长，中国医院协会医疗技术应用专业委员会主任委员，中国医药生物技术协会骨组织库分会主任委员等学术任职。主要从事骨科基础研究与临床工作，是我国国产人工关节研制的奠基人。');
INSERT INTO `doctor` VALUES ('3', '1', '4', '陈香美', '女', '15418623456', '123456', '1', 'd_id3.jpg', '肾脏病学专家，博士生导师，中国工程院院士，解放军肾脏病研究所所长暨重点实验室主任、解放军总医院肾病专科医院院长，中华医学会理事、中华肾脏病学会主任委员、《中华肾脏病杂志》总编辑、中国中西医结合学会常务副会长、国家药品评审专家。两次担任\"973\"衰老项目首席科学家、国家自然科学基金\"创新研究群体\"学术带头人。');
INSERT INTO `doctor` VALUES ('4', '3', '2', '张翔宇', '女', '15243168455', '123456', '1', 'd_id4.jpg', '妇产科常见病的诊断和治疗；对围产期、产科危重病的救治、分娩突发情况的处理有着丰富的实践经验和快速处置能力。对各种原因导致的不孕症治疗有独到之处。尤其是在产前咨询及孕期指导、产科并发症的诊治上经验丰富。');
INSERT INTO `doctor` VALUES ('5', '4', '3', '李丽曼', '女', '13256489751', '123456', '1', 'd_id5.jpg', '擅长儿童多动症、抽动症、遗尿症、智力低下、发育迟缓、矮小症、性早熟等儿童疾病的临床诊断、评估、治疗');
INSERT INTO `doctor` VALUES ('6', '5', '1', '潘建', '男', '15246513158', '123456', '1', 'd_id6.jpg', '潘主任，新乡潘氏中医主帅，网络红医，技术精湛，爱心无限！熟知中西医科学知识，高级心理咨询医师，擅长中医药特殊问题防治，传承百年家学经验，深入系统学习中医临床知识，临床工作26年，诊治各类患者数万例，积累了丰厚的临床经验');
INSERT INTO `doctor` VALUES ('7', '6', '1', '门诊王', '男', '147258', '123456', '2', 'd_id7.jpg', '门诊医生');
INSERT INTO `doctor` VALUES ('8', null, null, '超级管理员', '男', '1152', '1152', '99', 'd_id8.jpg', '超级管理员');
INSERT INTO `doctor` VALUES ('9', null, null, '仓库李', '男', '1178', '1178', '3', 'd_id9.jpg', '仓库管理员');

-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `m_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药品编号',
  `m_name` varchar(255) DEFAULT NULL,
  `m_brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `m_specifications` varchar(255) DEFAULT NULL COMMENT '规格',
  `m_type` varchar(255) DEFAULT NULL COMMENT '类别',
  `m_price` decimal(10,0) DEFAULT NULL COMMENT '药品单价',
  `m_remark` varchar(255) DEFAULT NULL,
  `m_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('1', '泰毕全 达比加群酯胶囊', '泰毕全', '110mg以达比加群', '处方药', '163', '用于预防非瓣膜性房颤患者的卒中和全身性栓塞', 'm_id1.jpg');
INSERT INTO `medicine` VALUES ('2', '同仁堂 安宫牛黄丸', '同仁堂', '3g*1丸/盒', '处方药', '560', '清热解毒，镇惊开窍。用于热病，邪入心包，高热惊厥，神昏谵语；中风昏迷及脑炎、脑膜炎、中毒性脑病、脑出血、败血症见上述症候者', 'm_id2.jpg');
INSERT INTO `medicine` VALUES ('3', '同仁堂 同仁牛黄清心丸', '同仁堂', '金衣3g*10丸', '处方药', '125', '适用症状：口眼喎斜，半身不遂', 'm_id3.jpg');
INSERT INTO `medicine` VALUES ('4', '白云山 华佗再造丸', '白云山', '8g*16袋/盒', '处方药', '450', '活血化瘀,化瘀通络,行气止痛,中风恢复口眼歪斜、言语不清；', 'm_id4.jpg');

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '病人编号',
  `p_mobile` varchar(20) NOT NULL,
  `p_password` varchar(25) NOT NULL,
  `p_name` varchar(50) NOT NULL,
  `p_sex` varchar(2) NOT NULL COMMENT 'm:男；w:女',
  `p_birthday` date NOT NULL,
  `p_id_card` varchar(50) NOT NULL COMMENT '身份证号',
  `p_address` varchar(255) NOT NULL,
  `p_status` int(2) DEFAULT NULL COMMENT '门诊状态码（当前挂号单状态）-1为未挂号',
  `p_img` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1', '17125829693', '123456', '张三', '男', '2000-12-03', '412531685921', '新乡市红旗渠222号', '-1', 'p_id1.jpg');
INSERT INTO `patient` VALUES ('2', '12541587415', '123456', '李四', '男', '2004-12-03', '521642355488', '郑州市惠济区333号', '0', 'p_id2.jpg');
INSERT INTO `patient` VALUES ('3', '15412448451', '123456', '王五', '男', '1999-11-01', '52145944521545', '新乡市牧野区444号', '1', 'p_id3.jpg');

-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `ps_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药单编号id',
  `m_id` int(11) DEFAULT NULL COMMENT '药品id',
  `ps_price` decimal(10,0) DEFAULT NULL COMMENT '单价',
  `ps_number` int(11) DEFAULT NULL COMMENT '药品数量',
  `ps_pay_number` varchar(255) DEFAULT NULL COMMENT '缴费凭证号（药品费用)',
  `ps_remark` varchar(255) DEFAULT NULL COMMENT '药单编号',
  `ps_status` varchar(2) DEFAULT NULL COMMENT '药单状态，0为未取药',
  `p_id` int(11) DEFAULT NULL COMMENT '病人id',
  PRIMARY KEY (`ps_id`),
  KEY `prescription_medicine` (`m_id`),
  CONSTRAINT `prescription_medicine` FOREIGN KEY (`m_id`) REFERENCES `medicine` (`m_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `prescription_registration` FOREIGN KEY (`ps_id`) REFERENCES `registration` (`ps_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of prescription
-- ----------------------------

-- ----------------------------
-- Table structure for registration
-- ----------------------------
DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '挂号单id',
  `p_id` int(11) DEFAULT NULL COMMENT '病人id',
  `dt_id` int(11) DEFAULT NULL COMMENT '挂号科室id',
  `d_id` int(11) DEFAULT NULL COMMENT '医生id',
  `r_date` date DEFAULT NULL,
  `r_fee` decimal(18,2) DEFAULT NULL COMMENT '挂号费用',
  `ps_id` int(11) DEFAULT NULL COMMENT '药单编号',
  `r_info` varchar(255) DEFAULT NULL COMMENT '病因',
  `r_remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `r_pay_number` varchar(255) DEFAULT NULL COMMENT '缴费凭证号：0为未缴费',
  `r_status` int(2) DEFAULT NULL COMMENT '挂号单状态，0：为缴费（挂号费用），1：待到门诊处，2：待到科室医生处，3：已诊断，4：已取药（完成）',
  PRIMARY KEY (`r_id`),
  KEY `registration_patient` (`p_id`),
  KEY `registration_department` (`dt_id`),
  KEY `ps_id` (`ps_id`),
  KEY `registration_doctor` (`d_id`),
  CONSTRAINT `registration_department` FOREIGN KEY (`dt_id`) REFERENCES `department` (`dt_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `registration_doctor` FOREIGN KEY (`d_id`) REFERENCES `doctor` (`d_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `registration_patient` FOREIGN KEY (`p_id`) REFERENCES `patient` (`p_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of registration
-- ----------------------------
INSERT INTO `registration` VALUES ('1', '2', '6', '7', '2019-12-03', '100.00', null, null, null, '0', '0');
INSERT INTO `registration` VALUES ('2', '3', '6', '1', '2019-12-03', '100.00', null, null, null, 'p_id_r_id_pay100_sss', '1');

-- ----------------------------
-- Table structure for storage
-- ----------------------------
DROP TABLE IF EXISTS `storage`;
CREATE TABLE `storage` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '药库药品存储id',
  `m_id` int(11) DEFAULT NULL COMMENT '药品id',
  `s_in_price` decimal(10,0) DEFAULT NULL COMMENT '药品进价',
  `s_number` int(11) DEFAULT NULL COMMENT '数量',
  `s_location` varchar(255) DEFAULT NULL COMMENT '存储位置',
  `s_in_time` date DEFAULT NULL COMMENT '入库时间',
  `s_last_days` int(11) DEFAULT NULL COMMENT '剩余过期天数',
  `d_id` int(11) DEFAULT NULL COMMENT '存储人员id',
  `s_out_price` decimal(10,0) DEFAULT NULL COMMENT '售价',
  PRIMARY KEY (`s_id`),
  KEY `storage` (`m_id`),
  KEY `storage_doctor` (`d_id`),
  CONSTRAINT `storage` FOREIGN KEY (`m_id`) REFERENCES `medicine` (`m_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `storage_doctor` FOREIGN KEY (`d_id`) REFERENCES `doctor` (`d_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of storage
-- ----------------------------
INSERT INTO `storage` VALUES ('2', '1', '100', '200', '地下一层302', '2019-12-03', '720', '9', '163');
INSERT INTO `storage` VALUES ('3', '2', '560', '150', '地下一层303', '2019-12-03', '365', '9', '560');
INSERT INTO `storage` VALUES ('4', '3', '100', '100', '地下一层304', '2019-12-03', '720', '9', '125');
INSERT INTO `storage` VALUES ('5', '4', '300', '150', '地下一层305', '2019-12-03', '720', '9', '450');

-- ----------------------------
-- Table structure for title
-- ----------------------------
DROP TABLE IF EXISTS `title`;
CREATE TABLE `title` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职称id',
  `t_name` varchar(255) DEFAULT NULL COMMENT '职称名称',
  `t_fee` decimal(10,0) DEFAULT NULL COMMENT '挂号所需费用',
  `t_remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of title
-- ----------------------------
INSERT INTO `title` VALUES ('1', '医师', '100', '初级职称');
INSERT INTO `title` VALUES ('2', '主治医师', '200', '中级职称');
INSERT INTO `title` VALUES ('3', '副主任医师', '300', '副高级职称');
INSERT INTO `title` VALUES ('4', '主任医师', '400', '正高级职称');
