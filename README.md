# JDBC-Practice
create a database "gla", in that database create a table "student", which contain following columns :
rollno (int),
name(text),
email(varchar),
cpi(double).
 
 Perform the following queries
 1. Insert  - > INSERT INTO `student` (`rollno`, `name`, `email`, `cpi`) VALUES ('12', 'Vaibhav', 'vai@gmail.com', '5.73');
 2. update where rollno is 12 set cpi t0 8.91 - > UPDATE `student` SET `cpi`= 8.91 WHERE rollno = 12
 3. Delete where cpi = 9.9 -> DELETE FROM `student` WHERE cpi = 9.9;
 4. Select all the data - > SELECT * FROM student;
