package ui;

import model.Course;

public class Main {

	private static Course c;

	public static void main(String[] args) {
		c = new Course();
		c.addStudent(5678, "A");
		c.addStudent(6789, "juanito");
		c.addStudent(5542, "cinco");
		c.addStudent(7890, "militar");
		c.addStudent(6788, "arawack");
		c.addStudent(5912, "holi");
		c.addStudent(5582, "emilio");
		c.addStudent(5308, "don juan");
		c.addStudent(5398, "pipe");

		
		System.out.println(c.successor(5542).getName());
	
//		for (int I = 0; I < 9; I++) {
//			System.out.println(c.amplitud().get(I).getName()+"   "+c.amplitud().get(I).getCode());
//		}
	}

}
