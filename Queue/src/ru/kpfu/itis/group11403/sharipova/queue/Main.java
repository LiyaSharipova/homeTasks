package ru.kpfu.itis.group11403.sharipova.queue;

public class Main {

	public static void main(String[] args) {
		Student[] students= new Student[3];
		students[0] = new Student(10, 1940, "John");
		students[1] = new Student(11, 1942,"Paul");
		students[2] = new Student(22, 1943,"George ");
		Student[] students2= new Student[2];
		students2[0] = new Student(33, 1940,"Ringo");
		students2[1] = new Student(44, 1970,"Blackbird");
		Faculty[] faculties= {new Faculty(students), new Faculty(students2)};
		Clinic pol=new Clinic(faculties);
		pol.createQueue(4);
		pol.print();
	}

}
