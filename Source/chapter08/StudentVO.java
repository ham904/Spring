package chapter08;

public class StudentVO {

	private String id;
	private String name;
	private String depart;
	private int grade;
	private int score;
	
	// id 파라미터의 Getter와 Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	// name 파라미터의 Getter와 Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	// depart 파라미터의 Getter와 Setter
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	
	// grade 파라미터의 Getter와 Setter
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	// score 파라미터의 Getter와 Setter
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	
}

