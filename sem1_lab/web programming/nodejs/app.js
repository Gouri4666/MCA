// app.js
const mysql = require('mysql');

// Create a connection
const connection = mysql.createConnection({
  host: 'localhost',       // MySQL host
  user: 'root',            // your MySQL username
  password: '',            // your MySQL root password
  database: 'testdb'       // the database we just created
});

// Connect to the database
connection.connect((err) => {
  if (err) {
    console.error('❌ Error connecting: ', err);
    return;
  }
  console.log('✅ Connected to MySQL!');

  // Query to fetch data from the users table
  connection.query('SELECT * FROM users', (err, results) => {
    if (err) throw err;
    console.log('📄 Users Table:');
    console.table(results);  // displays data in table format
  });

  // Close the connection
  connection.end();
});
