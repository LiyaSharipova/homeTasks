package ru.kpfu.itis.group11403.sharipova.queue;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;;

public class Faculty {
	private Student [] students;

	public Faculty(Student[] students) {
		super();
		this.students = students;
	}
	public Student [] RandomLuckyStudents(int length){
		boolean f=false;
		Random rnd = new Random();
		int randomStudent=rnd.nextInt(students.length-1);
		List<Student> someStudents= new ArrayList<Student>(length);
		while (someStudents.size()<length){
			if(!someStudents.contains(students[randomStudent])){
				someStudents.add(students[randomStudent]);
				f=true;
			}
			else randomStudent=rnd.nextInt(students.length);
		}
		return someStudents.toArray(new Student[length]);
	}
}
