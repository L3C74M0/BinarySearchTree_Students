package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
	
	private Student root;
	
	public Course() {
		
	}
	
	public void addStudent(int c, String n) {
		Student toAdd = new Student(c, n);
		if (root == null) {
			root = toAdd;
		} else {
			Student current = root;
			boolean stoped = true;
			while (stoped) {
				if (toAdd.compareTo(current) < 0) {
					if (current.getLeft() == null) {
						current.setLeft(toAdd);
						toAdd.setPrevious(current);
						stoped=false;
					} else {
						current = current.getLeft();
					}
				}else {
					if (current.getRight() == null) {
						current.setRight(toAdd);
						toAdd.setPrevious(current);
						stoped=false;
					} else {
						current = current.getRight();
					}
				}
			}
		}
	}
	
	public Student searchStudent(int c) {
		boolean stoped = true;
		Student current = root;
		while (stoped) {
			if (c == current.getCode()) {
				stoped = false;
			} else if (c < current.getCode()) {
				current = current.getLeft();
			} else if (c > current.getCode()) {
				current = current.getRight();
			}
		}
		return current;
	}
	
	public List<Student> preOrder(){
		return preOrder(root);
	}
	
	private List<Student> preOrder(Student currentNode){
		List<Student> list = new ArrayList<Student>();
		if(currentNode != null) {
			list.add(currentNode);
			List<Student> nodoLeft = preOrder(currentNode.getLeft());
			List<Student> nodeRight = preOrder(currentNode.getRight());
			list.addAll(nodoLeft);
			list.addAll(nodeRight);
		}
		return list;
	}
	
	public List<Student> inOrder(){
		return inOrder(root);
	}
	
	public List<Student> inOrder(Student currentNode){
		List<Student> list = new ArrayList<Student>();
		if(currentNode!= null) {
			List<Student> nodeLeft = inOrder(currentNode.getLeft());
			List<Student> nodeRight = inOrder(currentNode.getRight());
			list.addAll(nodeLeft);
			list.add(currentNode);
			list.addAll(nodeRight);
		}
		return list;
	}
	
	public List<Student> postOrder(){
		return postOrder(root);
	}
	
	public List<Student> postOrder(Student currentNode){
		List<Student> list = new ArrayList<Student>();
		if(currentNode != null) {
			List<Student> nodeLeft = postOrder(currentNode.getLeft());
			List<Student> nodeRight = postOrder(currentNode.getRight());
			list.addAll(nodeLeft);
			list.addAll(nodeRight);
			list.add(currentNode);
		}
		return list;
	}
	
	public List<Student> amplitud(){
		return amplitud(root,0);
	}
	
	public List<Student> amplitud(Student currentNode, int depth){
		List<Student> list = new ArrayList<Student>();
		if(currentNode != null) {

		}
		return list;
	}
	
	public Student minimalNode() {
		if (root != null) {
			Student current = root;
			return minimalNode(current);
		} else {
			return null;
		}
	}

	private Student minimalNode(Student current) {
		if (current.getLeft() == null) {
			return current;
		} else {
			return minimalNode(current.getLeft());
		}
	}
	
	public Student successor(int code) {
		return successor(searchStudent(code));
	}
	
	private Student successor(Student consulted) {
		Student current = consulted;
		if (current.getRight() != null) {
			return minimalNode(current.getRight());
		} else {
			while (current == current.getPrevious().getRight()) {
				current = current.getPrevious();
			}
			return current.getPrevious();
		}

	}

}
