// conn.js
const mysql = require('mysql');

// Create connection
const connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '', // add your MySQL password if any
  database: 'CollegeDB'
});

// Connect to MySQL
connection.connect((err) => {
  if (err) {
    console.error('Database connection failed:', err.stack);
    return;
  }
  console.log('Connected to MySQL Database: CollegeDB');
});

module.exports = connection;
