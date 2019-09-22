package com.collabera.example.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.collabera.example.model.Student;

@Service
public class StudentService {
	
	// usually done with a database but we are hard coding the data
	
	private static List<Student> students = new ArrayList<Student>(); // arrayList use polymorphism
	private static int idCounter = 1;
	
	static { // static block(it will run once)
		students.add(new Student(idCounter++,"stan","Lee",LocalDate.of(1993, 03, 29),"computer science"));
		students.add(new Student(idCounter++,"mark","T",LocalDate.of(2000, 1, 2),"political science"));
		students.add(new Student(idCounter++,"Marhsall","Mathers",LocalDate.of(1999, 12, 4),"not declared"));
		students.add(new Student(idCounter++,"Slim","Shady",LocalDate.of(1893, 05, 2),"chemistry"));
		students.add(new Student(idCounter++,"Marco","Polo",LocalDate.of(1983, 02, 9),"literature"));

	}
	
	// C.R.U.D create read update delete
	
	// Create
	public Student addStudent(String firstName, String lastName, LocalDate dob, String major) {
		Student student = new Student(idCounter++,firstName,lastName,dob,major);
		students.add(student);
		return student;	
	}
	
	// Read
	public List<Student> getAllStudents() {
		return students;
	}
	
	public Student getStudent(int id) {
		Student student = null;
		
		for(int i=0; i<students.size();i++) {
			if(id == students.get(i).getId()) {
				student = students.get(i);
				break;
			}
		}
		return student;
	}
	
	public List<Student> getStudentsInMajor(String major) {
		List<Student> studentMajor = new ArrayList<Student>();
		
		for(int i=0; i<students.size();i++) {
			if(major.toLowerCase().equals(students.get(i).getMajor().toLowerCase())) {
				studentMajor .add(students.get(i));
			}		
		}
		return studentMajor;
	}
	
	// Update
	public void updateStudent(Student student) {
		Student studentToUpdate = getStudent(student.getId());
		
		studentToUpdate.setFirstName(student.getFirstName());
		studentToUpdate.setLastName(student.getLastName());
		studentToUpdate.setMajor(student.getMajor());
		studentToUpdate.setDateOfBirth(student.getDateOfBirth());			
	}
	
	// Delete
	public void deleteStudent(int id) {
		
		for(int i=0; i<students.size(); i++) {
			if(id == students.get(i).getId()) {
				students.remove(students.get(i));
			}
		}
	}
	
	public void deleteAllStudent() {
		students.clear();
	}	

}
