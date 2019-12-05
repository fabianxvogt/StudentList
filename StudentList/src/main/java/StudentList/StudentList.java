package StudentList;

import LinkedList.LinkedList;
import Student.Student;

public class StudentList extends LinkedList<Student> {

	public static void main(String[] args) {
		StudentList l = new StudentList();
		
		l.insertLast(new Student("Tim", "Test", "00000034", "Informatik"));
		l.insertLast(new Student("Tim", "Test", "00002342", "Modedesign"));
		l.insertLast(new Student("Tim", "Test", "000000ef", "Angewandte Informatik"));
		l.insertLast(new Student("Tim", "Test", "00000001", "Kunst"));
		
		//System.out.println(l.insertionSort().toString());
		System.out.println(l.quickSortBySubject().toString());
		
		System.out.println(l.search("", "", "00000034", "Kunst").toString());
		
	}	
	/**
	 * searches for students whose attributes match with search criteria
	 * 
	 * @param firstName First name of the wanted student
	 * @param name Name of the wanted student
	 * @param studentID Student ID of the wanted student
	 * @param subject Subject of the wanted student 
	 * 
	 * @return results Search results
	 */
	public StudentList search(String firstName, String name, String studentID, String subject) {
		if(this.getFirst() == null) {
			return null;
		}
		Student s;
		StudentList results = new StudentList();
		for (Element<Student> e = this.getFirst(); e.next != null; e = e.next) {
			s = (Student) e.data;
			if(s.getFirstName().equalsIgnoreCase(firstName) ||
			   s.getName().equalsIgnoreCase(name)           ||
			   s.getStudentID().contentEquals(studentID)    ||
			   s.getSubject().equalsIgnoreCase(subject)     ) 
				results.insertLast(s);
		}
		return results;
	}
	/**
	 * sorts this student list by student ID
	 * using insertion sort algorithm
	 * 
	 * @return this Sorted student list
	 */
	public StudentList insertionSortByStudentID() {
		//Insertion Sort
		for (int i = 1; i < this.getLength(); i++) {
			Student candidate = (Student) this.getElement(i).data;
			int j = i;
			while (j > 0) {
				Student prev = (Student) this.getElement(j-1).data;
				if (candidate.getStudentID().compareTo(prev.getStudentID()) > 0)
					break;
				this.getElement(j).data = this.getElement(j-1).data;
			    j--;
			}
			this.getElement(j).data = candidate;
		}
		return this;
	}
	/**
	 * sorts this student list by subject
	 * using insertion sort algorithm
	 * 
	 * @return this Sorted student list
	 */
	public StudentList insertionSortBySubject() {
		for (int i = 1; i < this.getLength(); i++) {
			Student candidate = (Student) this.getElement(i).data;
			int j = i;
			while (j > 0) {
				Student prev = (Student) this.getElement(j-1).data;
				if (candidate.getSubject().compareTo(prev.getSubject()) > 0)
					break;
				this.getElement(j).data = this.getElement(j-1).data;
			    j--;
			}
			this.getElement(j).data = candidate;
		}
		return this;
	}
	/**
	 * sorts this student list by student ID
	 * using quick sort algorithm
	 * 
	 * @return this Sorted student list
	 */
	public StudentList quickSortByStudentID() {
		return this.quickSortByStudentID(0, this.getLength()-1);
	}
	private StudentList quickSortByStudentID(int l, int r) {
	    int q;
	    if (l < r) {
	    	q = partitionStudentID(l, r);
	    	quickSortByStudentID(l, q);
	    	quickSortByStudentID(q + 1, r);
	    }
	    return this;
	}
	
	// helper function for quicksort by StudentID
	private int partitionStudentID(int l, int r) {

		int i, j;
		Student s1 = (Student) this.getElement((l + r) / 2).data;
		i = l - 1;
		j = r + 1;
		Student s2, s3, s4;
		while (true) {
			do {
				i++;
				s2 = (Student) this.getElement(i).data;
			} while (s1.getStudentID().compareTo(s2.getStudentID()) > 0 );
			
			do {
				j--;
				s3 = (Student) this.getElement(j).data;
			} while (s1.getStudentID().compareTo(s3.getStudentID()) < 0 );
			
			if (i < j) {
				s4 = (Student) this.getElement(i).data;
				this.getElement(i).data = this.getElement(j).data;
				this.getElement(j).data = s4;
			} else {
				return j;
			}
		}	
	}
	/**
	 * sorts this student list by subject
	 * using quick sort algorithm
	 * 
	 * @return this Sorted student list
	 */
	public StudentList quickSortBySubject() {
		return this.quickSortBySubject(0, this.getLength()-1);
	}
	private StudentList quickSortBySubject(int l, int r) {
	    int q;
	    if (l < r) {
	    	q = partitionSubject(l, r);
	    	quickSortBySubject(l, q);
	    	quickSortBySubject(q + 1, r);
	    }
	    return this;
	}
	
	// helper function for quicksort by Subject
	private int partitionSubject(int l, int r) {

		int i, j;
		Student s1 = (Student) this.getElement((l + r) / 2).data;
		i = l - 1;
		j = r + 1;
		Student s2, s3, s4;
		while (true) {
			do {
				i++;
				s2 = (Student) this.getElement(i).data;
			} while (s1.getSubject().compareTo(s2.getSubject()) > 0 );
			
			do {
				j--;
				s3 = (Student) this.getElement(j).data;
			} while (s1.getSubject().compareTo(s3.getSubject()) < 0 );
			
			if (i < j) {
				s4 = (Student) this.getElement(i).data;
				this.getElement(i).data = this.getElement(j).data;
				this.getElement(j).data = s4;
			} else {
				return j;
			}
		}	
	}
}
