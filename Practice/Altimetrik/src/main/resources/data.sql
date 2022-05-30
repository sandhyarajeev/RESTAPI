insert into department(dept_id, dept_name) values('D001','Software');
insert into department(dept_id, dept_name) values('D002','Hardware');
insert into department(dept_id, dept_name) values('D003','HR');
insert into department(dept_id, dept_name) values('D004','Housekeeping');

insert into employee(emp_id,first_name,last_name,contact_number) values('E001','sandhya','rajeev',3224);
insert into employee(emp_id,first_name,last_name,contact_number) values('E002','nakul','rajeev',3224);
insert into employee(emp_id,first_name,last_name,contact_number) values('E003','mukund','rajeev',3224);
insert into employee(emp_id,first_name,last_name,contact_number) values('E004','rajeev','varma',3224);


insert into employee_dept(dept_id,emp_id) values('D001','E001');
 insert into employee_dept(dept_id,emp_id) values('D001','E003');
insert into employee_dept(dept_id,emp_id) values('D002','E004');
insert into employee_dept(dept_id,emp_id) values('D001','E002');

insert into project_dept (proj_id,project_name,dept_id) values('P001','rest','D001');
insert into project_dept (proj_id,project_name,dept_id) values('P001','rest','D003');
insert into project_dept (proj_id,project_name,dept_id) values('P002','rest','D002');
insert into project_dept (proj_id,project_name,dept_id) values( 'P003','rest','D004');

select * from project_dept;
insert into emp_dept_project(proj_id,emp_id,dept_id) values ('P001','E002','D001');
insert into emp_dept_project(proj_id,emp_id,dept_id) values ('P001','E003','D001');
insert into emp_dept_project(proj_id,emp_id,dept_id) values ('P003','E003','D004');
insert into emp_dept_project(proj_id,emp_id,dept_id) values ('P003','E001','D004');
insert into emp_dept_project(proj_id,emp_id,dept_id) values ('P002','E002','D002');

select * from emp_dept_project;
