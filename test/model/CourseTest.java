package model;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CourseTest {

	private Course course;
	private List<Student> trail;

	public void setupScenary1() {
		course = new Course();
		Student root = new Student(5678, "A");
		root.setRight(new Student(6789, "juanito"));
		root.setLeft(new Student(5542, "cinco"));
		root.getRight().setRight(new Student(7890, "militar"));
		root.getRight().setLeft(new Student(6788, "arawack"));
		root.getRight().getLeft().setLeft(new Student(5912, "holi"));
		root.getLeft().setRight(new Student(5582, "emilio"));
		root.getLeft().setLeft(new Student(5308, "don juan"));
		root.getLeft().getLeft().setRight(new Student(5398, "pipe"));
	}

	@Test
	public void setupStage1Preorder() {
		trail = new ArrayList<Student>();
		trail.add(new Student(5678, "A"));
		trail.add(new Student(6789, "juanito"));
		trail.add(new Student(5542, "cinco"));
		trail.add(new Student(7890, "militar"));
		trail.add(new Student(6788, "arawack"));
		trail.add(new Student(5912, "holi"));
		trail.add(new Student(5582, "emilio"));
		trail.add(new Student(5308, "don juan"));
		trail.add(new Student(5398, "pipe"));
	}
	
	@Test
	public void setupStage1PostOrder() {
		trail = new ArrayList<Student>();
		trail.add(new Student(5398, "pipe"));
		trail.add(new Student(5308, "don juan"));
		trail.add(new Student(5582, "emilio"));
		trail.add(new Student(5542, "cinco"));
		trail.add(new Student(5912, "holi"));
		trail.add(new Student(6788, "arawack"));
		trail.add(new Student(7890, "militar"));
		trail.add(new Student(6789, "juanito"));
		trail.add(new Student(5678, "A"));		
	}

	@Test
	public void preOrderTest() {
		setupStage1Preorder();
		setupScenary1();
		List<Student> list = course.preOrder();
		for (int I = 0; I < list.size(); I++) {
			assertTrue("The index " + I + " of preorder trail is different", list.get(I).compareTo(trail.get(I)) == 0);
		}
	}
	
	@Test
	public void postOrderTest() {
		setupStage1PostOrder();
		setupScenary1();
		List<Student> list = course.postOrder();
		for (int I = 0; I < list.size(); I++) {
			assertTrue("The index " + I + " of postorder trail is different", list.get(I).compareTo(trail.get(I)) == 0);
		}
	}

}
