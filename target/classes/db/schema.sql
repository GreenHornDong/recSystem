--DROP TABLE IF EXISTS user;
--
--CREATE TABLE user
--(
--    userId BIGINT(20) NOT NULL COMMENT '主键ID' auto_increment,
--    username VARCHAR(30) NULL DEFAULT NULL COMMENT '用户名',
--    password VARCHAR(100) NULL DEFAULT NULL COMMENT '密码',
--    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
--    authorVerified BOOLEAN DEFAULT FALSE COMMENT '是否认证为作者',
--    lastLogin VARCHAR(30) NULL DEFAULT NULL COMMENT '上次登录时间',
--    PRIMARY KEY (userId)
--);
--
--DROP TABLE IF EXISTS titleAuthorLinkTable;
--
--CREATE TABLE titleAuthorLinkTable
--(
--    author VARCHAR(400) NULL DEFAULT NULL COMMENT '作者',
--    title VARCHAR(230) NULL DEFAULT NULL COMMENT '标题',
--    link VARCHAR(500) NULL DEFAULT NULL COMMENT '链接',
--    comments VARCHAR(500) NULL DEFAULT NULL COMMENT '信息',
--    subjects VARCHAR(500) NULL DEFAULT NULL COMMENT '类别',
--    datetime VARCHAR(500) NULL DEFAULT NULL COMMENT '时间',
--    abstract VARCHAR(5000) NULL DEFAULT NULL COMMENT '摘要'
--);