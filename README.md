## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).


query

admin table:
create table admin (
    admin_id varchar(6) primary key not null, 
    username varchar(50), 
    name varchar(50), 
    age varchar(5), 
    phone varchar(10), 
    city varchar(50), 
    email varchar(50), 
    gender varchar(50), 
    password varchar(50)
);


insert query:
insert into admin (admin_id, username, name, age, phone, city, email, gender, password) values ("558574", "admin", "Rahul", "24", "8585878745", "Delhi", "rahul@gmail.com","male", "admin");

patient table : 
create table patient_info(ID varchar(20),Number varchar(10),Name varchar(20),Gender varchar(10),Patient_Disease varchar(20),Room_Number varchar(20),Time varchar(100),Deposite varchar(100));



room insert :
 insert into Room values ("100","Availabil", "500", "G Bed 1");
 insert into Room values ("101", "Availabil", "500", "G Bed 2");
 insert into Room values ("102","Availabil", "500", "G Bed 3");
 insert into Room values ("103", "Availabil", "500", "G Bed 4");
 insert into Room values("200","Availabil", "1500","Private Room");
 insert into Room values("201", "Availabil", "1500","Private Room");
 insert into Room values ("202", "Availabil", "1500","Private Room");
 insert into Room values("203","Availabil","1500","Private Room");
 insert into Room values("300","Availabil","3500", "ICU Bed 1");
 insert into Room values ("301", "Availabil","3500", "ICU Bed 2");
 insert into Room values ("382", "Availabil","3500", "ICU Bed 3");
 insert into Room values("303", "Availabil", "3500","ICU Bed 4");
 insert into Room values("384","Availabil","3500", "ICU Bed 5");
 insert into Room values("385","Availabil","3500", "ICU Bed 6");


 department insert : 
 insert into department values("Surgical department", "123456789");
 insert into department values("Nursing department", "123456789");
 insert into department values("Operation theater complex (OT)", "123456789");
 insert into department values("Paramedical department", "123456789");


 employee table : 
 create table EMP_INFO (Name varchar(20), Age varchar(20), Phone Number varchar(20), salary varchar(20), Gmail varchar(20), Aadhar Number varchar(20));

 employee insert  : 
 insert into EMP_INFO values("Doctors1", "30","123456789", "50000", "gr@gmail.com","123456789101");
 insert into EMP_INFO values ("Doctors2", "30","123456789", "50000","gr@gmail.com","123456789101");