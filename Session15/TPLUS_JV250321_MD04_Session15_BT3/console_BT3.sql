create database jv250321_person;
use jv250321_person;

create table Students (
    student_id int primary key auto_increment,
    full_name varchar(100) not null,
    date_of_birth date not null,
    email varchar(100) not null unique
);

/* get_all_students */

DELIMITER &&
create procedure get_all_students()
begin
    select * from Students;
end &&
DELIMITER &&

/* add_student */
DELIMITER &&
create procedure add_student(
    IN in_full_name varchar(100),
    IN in_date_of_birth date,
    IN in_email varchar(100)
)
begin
    insert into Students(full_name,date_of_birth,email)
    values (full_name,date_of_birth,email);
end &&
DELIMITER &&

/* update_student */
DELIMITER &&
create procedure update_student(
    in_id int,
    in_full_name varchar(100),
    in_date_of_birth date,
    in_email varchar(100)
)
begin
    update Students
    set full_name = in_full_name,
        date_of_birth = in_date_of_birth,
        email = in_email
    where student_id = in_id;
end &&
DELIMITER &&

/* find_student_by_id */
DELIMITER &&
create procedure find_student_by_id(
    IN in_id int
)
begin
    select s.full_name from Students s
    where student_id = in_id;
end &&
DELIMITER &&

/* delete_student */
DELIMITER &&
create procedure delete_student(
    in_id int
)
begin
    delete from Students
    where student_id = in_id;
end &&
DELIMITER &&

