//create connection to mysql2
const mysql=require('mysql2');
const connection=mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'root',

});
connection.connect((err)=>
{
    if (err)
    {
        console.log("Connection failed!");
        return;
    }
    console.log("Connected sucesfully");
}
);
//create database
const sql='CREATE DATABASE collegedb';
connection.query(sql,(err,result)=>
    {
        if(err)
        {
            console.log("Failed to create database");
            return;
        }
        console.log("Database collegedb created!");
    });
//use database
connection.changeUser({ database: 'collegedb' })

//create table
 const sql2 = `
                CREATE TABLE IF NOT EXISTS student (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(50),
                    email VARCHAR(100)
                )
            `;
connection.query(sql2,(err,result2)=>
    {
        if(err)
        {
            console.log("Failed to create table");
            return;
        }
        console.log("table student created!");
    });