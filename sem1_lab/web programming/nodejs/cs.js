// Import mysql2 module (install with: npm install mysql2)
const mysql = require('mysql2');

// Create connection to MySQL
const db = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',   // enter your MySQL password if you have one
  database: 'CollegeDB' // your database name
});

// Connect to MySQL
db.connect((err) => {
  if (err) {
    console.log('Error connecting to MySQL:', err);
    return;
  }
  console.log('✅ Connected to MySQL database.');

  // 1️⃣ Display all students enrolled in "Computer Science"
  const selectQuery = `SELECT * FROM students WHERE course = 'Computer Science'`;
  db.query(selectQuery, (err, results) => {
    if (err) throw err;
    console.log('\n📘 Students enrolled in Computer Science:');
    console.table(results);

    // 2️⃣ Update the course of student with id = 2
    const updateQuery = `UPDATE students SET course = 'Data Science' WHERE id = 2`;
    db.query(updateQuery, (err, updateResult) => {
      if (err) throw err;
      console.log('\n✏️ Updated student with id = 2 to Data Science.');

      // 3️⃣ Delete the student record with id = 3
      const deleteQuery = `DELETE FROM students WHERE id = 3`;
      db.query(deleteQuery, (err, deleteResult) => {
        if (err) throw err;
        console.log('\n🗑️ Deleted student with id = 3.');

        // Close the connection
        db.end();
      });
    });
  });
});
