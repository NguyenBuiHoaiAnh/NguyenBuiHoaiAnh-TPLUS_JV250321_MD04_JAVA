use jv250321_person;

DELIMITER $$

CREATE PROCEDURE search_student(
    IN in_name VARCHAR(100)
)
BEGIN
    SELECT * FROM Students
    WHERE full_name LIKE CONCAT('%', in_name, '%');
END $$

DELIMITER ;