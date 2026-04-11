import React, { useState } from 'react';
import './StudentManager.css';

const StudentManager = () => {
  const initialStudents = [
    { id: '1', name: 'Alice', course: 'Computer Science' },
    { id: '2', name: 'Bob', course: 'Mathematics' },
    { id: '3', name: 'Charlie', course: 'Physics' },
    { id: '4', name: 'David', course: 'Chemistry' },
    { id: '5', name: 'Eve', course: 'Biology' },
  ];

  const [students, setStudents] = useState(initialStudents);
  const [newStudent, setNewStudent] = useState({ id: '', name: '', course: '' });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewStudent({ ...newStudent, [name]: value });
  };

  const handleAddStudent = (e) => {
    e.preventDefault();
    if (!newStudent.id || !newStudent.name || !newStudent.course) {
      alert('Please fill all fields');
      return;
    }
    setStudents([...students, newStudent]);
    setNewStudent({ id: '', name: '', course: '' });
  };

  const handleDeleteStudent = (id) => {
    setStudents(students.filter(student => student.id !== id));
  };

  return (
    <div className="student-manager">
      <h2>Student Manager</h2>
      
      <form onSubmit={handleAddStudent} className="add-student-form">
        <input
          type="text"
          name="id"
          placeholder="Student ID"
          value={newStudent.id}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="name"
          placeholder="Student Name"
          value={newStudent.name}
          onChange={handleInputChange}
        />
        <input
          type="text"
          name="course"
          placeholder="Course"
          value={newStudent.course}
          onChange={handleInputChange}
        />
        <button type="submit">Add Student</button>
      </form>

      {students.length === 0 ? (
        <p className="no-students-msg">No students available</p>
      ) : (
        <table className="student-table">
          <thead>
            <tr>
              <th>ID</th>
              <th>Name</th>
              <th>Course</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {students.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.name}</td>
                <td>{student.course}</td>
                <td>
                  <button
                    className="delete-button"
                    onClick={() => handleDeleteStudent(student.id)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
};

export default StudentManager;
