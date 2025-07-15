create database ss16_BT1;
use ss16_BT1;

create table students (
    id int primary key auto_increment,
    name varchar(100),
    age int
);

DELIMITER &&
create procedure add_students(
    in student_name varchar(100),
    in student_age int
)
BEGIN
    INSERT INTO students(name, age)
    VALUES (student_name, student_age);
END;
DELIMITER &&;

/* update */
DELIMITER &&
create procedure update_students(
    in id_in int,
    in name_in varchar(100),
    in age_in int
)
begin
    update students
    set name = name_in,
        age = age_in
    where id = id_in;
end &&
DELIMITER &&

/* delete */
DELIMITER &&
create procedure delete_students_by_age(
    in max_age int,
    out deleted_count int
)
begin
    delete from students
    where age < max_age;
    set deleted_count = ROW_COUNT();
end &&
DELIMITER &&