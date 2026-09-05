const mysql=require('mysql2')
const connection=mysql.createConnection({
    host:'localhost',
    user:'root',
    password:'root'
});
connection.connect((err)=>
{
    if (err)
        console.error("Connection failed")
    else
        console.log("Connected sucesffully")
    //create database college
    const sql1=`CREATE DATABASE IF NOT EXISTS college`;
    connection.query(sql1,(err)=>
    {
        if (err)
            console.error("Database creation failed")
        else
            console.log("Database 'college' created sucesfully!")
        //use database
        connection.changeUser({database:'college'});
        //create table student
    const sql2=`CREATE TABLE IF NOT EXISTS student(ID int AUTO_INCREMENT PRIMARY KEY,NAME VARCHAR(25),AGE int)`;
    connection.query(sql2,(err)=>
        {
            if (err)
                console.error("Table creation failed")
            else
                console.log("Table 'student' created sucesfully")
            //insert 3 values
            const sql3=`INSERT INTO student(NAME,AGE) VALUES('VEENA',22),('MALU',23),('GOPI',23),('Binu',25)`;
            connection.query(sql3,(err)=>
            {
                if (err)
                    console.error("Failed insertion",err)
                else
                    console.log("Values inserted sucesfully")
                //display table
                const sql4=`select * from student`;
                connection.query(sql4,(err,result)=>
                {
                    if (err)
                        console.error("Error in displaying table")
                    else
                        console.table(result)
                    //delete student with id=3
                    const sql4=`DELETE FROM STUDENT WHERE ID=3`;
                    connection.query(sql4,(err)=>
                    {
                        if (err)
                            console.error("Deletion failed")
                        else
                            console.log("Deleted student with id=3")
                        //display table
                        const sql5=`select * from student`;
                        connection.query(sql5,(err,result2)=>
                        {
                            if (err)
                                console.error("Error in displaying table")
                            else
                                console.table(result2)
                            //update binu to beenu
                            const sql6=`UPDATE STUDENT SET NAME='BEENU' WHERE ID=4`;
                            connection.query(sql6,(err)=>
                            {
                                if (err)
                                    console.error("Updation failed")
                                else
                                    console.log("Updated sucesfully")
                            });
                            //display
                            const sql7=`select * from student`;
                            connection.query(sql7,(err,result3)=>
                            {
                                if (err)
                                    console.error("Error in displaying table")
                                else
                                    console.table(result3)
                            });
                        });
                    });
                });
            });
        });
    });
});





