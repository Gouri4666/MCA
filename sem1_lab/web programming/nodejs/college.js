// college.js
const db = require('./conn.js');

// Create Students table
const createTable = () => {
  const sql = `
    CREATE TABLE IF NOT EXISTS Students (
      id INT AUTO_INCREMENT PRIMARY KEY,
      name VARCHAR(50),
      age INT,
      course VARCHAR(30)
    )
  `;

  db.query(sql, (err, result) => {
    if (err) throw err;
    console.log('Students table created (if not exists).');
  });
};

// Run the function
createTable();
