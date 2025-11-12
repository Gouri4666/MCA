// src/pages/StudentList.jsx
import React from "react";
import "./App.css"; // use the same CSS file (or import a page-specific CSS)

function StudentList() {
  // an array of students (id used as unique key)
  const students = [
    { id: 1, name: "Gouri" },
    { id: 2, name: "Nandana" },
    { id: 3, name: "Rahul" },
    { id: 4, name: "Arjun" }
  ];

  return (
    <div className="student-card">
      <h1>Student List</h1>

      <ul className="student-list">
        {students.map(student => (
          // use id as the key (important for React list rendering)
          <li key={student.id} className="student-item">
            {student.id}. {student.name}
          </li>
        ))}
      </ul>

    </div>
  );
}
export default StudentList;
