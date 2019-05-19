package model;

public class Student implements Comparable<Student> {

	private int code;
	private String name;
	private Student left;
	private Student right;
	private Student previous;

	public Student(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Student getLeft() {
		return left;
	}

	public void setLeft(Student left) {
		this.left = left;
	}

	public Student getRight() {
		return right;
	}

	public void setRight(Student right) {
		this.right = right;
	}

	public Student getPrevious() {
		return previous;
	}

	public void setPrevious(Student previous) {
		this.previous = previous;
	}

	@Override
	public int compareTo(Student otherStudent) {
		int comparator = 0;
		if (code < otherStudent.getCode()) {
			comparator = -1;
		} else if (code > otherStudent.getCode()) {
			comparator = 1;
		}
		return comparator;
	}
}