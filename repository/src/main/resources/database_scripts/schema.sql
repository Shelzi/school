CREATE TABLE parents
(
    parent_id   bigint NOT NULL AUTO_INCREMENT,
    age         int          DEFAULT NULL,
    parent_name varchar(255) DEFAULT NULL,
    PRIMARY KEY (parent_id)
);

CREATE TABLE students
(
    student_id   bigint NOT NULL AUTO_INCREMENT,
    student_name varchar(255) DEFAULT NULL,
    PRIMARY KEY (student_id)
);