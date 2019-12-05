package Student;

public class Student {

	private String firstName;
	private String name;
	private String studentID;
	private String subject;

	public Student(String firstName, String name, String studentID, String subject) {
		this.setFirstName(firstName);
		this.setName(name);
		this.setStudentID(studentID);
		this.setSubject(subject);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String toString() {
		return 	"First name: " 	+ this.firstName 	+ "\n" +
				"Name: " 		+ this.name			+ "\n" +
				"Student ID: " 	+ this.studentID	+ "\n" +
				"Subject: "		+ this.subject		+ "\n";
	}
}	
