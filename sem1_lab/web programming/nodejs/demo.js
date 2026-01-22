const mysql=require('mysql2')
const server=mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'root',
});
server.connect((err)=>
{
    if (err)
        console.error("Connection failed")
    else
        console.log("Connected to server")
});
//create db
const create_db=`CREATE DATABASE IF NOT EXISTS collegedb`;
server.query(create_db,(err)=>
{
    if (err)
        console.error("Database creation failed")
    else
        console.log("Database created sucesfully!")
});
//use db
const use_db=`USE collegedb`;
server.query(use_db,(err)=>
{
    if (err)
        console.error("Error in selecting database")
    else
        console.log("Database :collegedb")
});
//create table student
const create_tb=`CREATE TABLE IF NOT EXISTS students(ID INT AUTO_INCREMENT PRIMARY KEY,
                                                    NAME VARCHAR(25),
                                                    AGE INT,
                                                    COURSE VARCHAR(25))`;
server.query(create_tb,(err)=>
{
    if (err)
        console.error("Table creation failed!")
    else
        console.log("Table student created ")
});
//insert 2 values
const insert_val=`INSERT INTO students(NAME,AGE,COURSE) VALUES('Ammu',22,'MCA'),('Veena',25,'BCA'),('Malu',25,'DS')`;
server.query(insert_val,(err)=>
{
    if(err)
        console.log("Insertion failed")
    else
        console.log("Values inserted")
});
//show table
const display_tb=`SELECT *FROM students`;
server.query(display_tb,(err,result)=>
{
    if (err)
        console.error("Failed to display table")
    else
        console.table(result)

});
//delete student with id=1
const delete_stu=`DELETE FROM students WHERE id=2`;
server.query(delete_stu,(err,result)=>
{
    if(err)
        console.error("deletion failed")
    else
    {
        console.log("Updated")
    }
});
//display updated table
const display_tb2=`SELECT *FROM students`;
server.query(display_tb2,(err,result)=>
{
    if (err)
        console.error("Failed to display table")
    else
        console.table(result)

});
//alter course=MCA of student with id=3
const alter_tb=`UPDATE students SET COURSE='MCA' where ID=3 `;
server.query(alter_tb,(err)=>
{
    if(err)
        console.error("Updation Failed")
    else
        console.log("Updated students with id=3")
});
//display table
const display_tb3=`SELECT * FROM students`;
server.query(display_tb3,(err,result)=>
{
    if(err)
        console.error("Can't display")
    else
        console.table(result)
});