CREATE TABLE IF NOT EXISTS article (
    id int NOT NULL AUTO_INCREMENT,
    title varchar(100) NOT NULL,
    content varchar(1000) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE SPRING.MEMBER (
    NO  INT  PRIMARY KEY AUTO_INCREMENT,
    ID  VARCHAR(30) NOT NULL UNIQUE,
    PASSWORD VARCHAR(100) NOT NULL,
    ROLE  VARCHAR(10) DEFAULT 'ROLE_USER',
    NAME  VARCHAR(15) NOT NULL,
    PHONE  VARCHAR(13),
    EMAIL  VARCHAR(100),
    ADDRESS  VARCHAR(100),
    HOBBY  VARCHAR(100)
);

-- CREATE TABLE SPRING.MEMBER (
--    NO  INT  PRIMARY KEY AUTO_INCREMENT,
--    ID  VARCHAR(30) NOT NULL UNIQUE,
--    PASSWORD VARCHAR(100) NOT NULL,
--    ROLE  VARCHAR(10) DEFAULT 'ROLE_USER',
--    NAME  VARCHAR(15) NOT NULL,
--    PHONE  VARCHAR(13),
--    EMAIL  VARCHAR(100),
--    ADDRESS  VARCHAR(100),
--    HOBBY  VARCHAR(100),
--    STATUS  VARCHAR(1) DEFAULT 'Y' CHECK(STATUS IN('Y', 'N')),
--    ENROLL_DATE DATETIME  DEFAULT CURRENT_TIMESTAMP,
--    MODIFY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
-- );