package summerHW;

import java.time.LocalDate;

public class CompletedCourse extends Course{
	private Integer studentID;
	private Grade grade;
	private LocalDate completedDate;
	
	public CompletedCourse(String courseID, String description, Integer credits, String deptID, Integer studentID, Double grade, Integer month, Integer day, Integer year){
		super(courseID, description, credits, deptID);
		
		if(month != null && day != null && year != null){
			completedDate = LocalDate.of(year, month, day);
		}
		else{
			throw new InvalidDataException();
		}
		
		if(studentID == null){
			throw new InvalidDataException();
		}
		else{
			this.studentID = studentID;
		}
		
		if(grade == null){
			throw new InvalidDataException();
		}
		else{
			if(grade > 4.0 || grade < 0.0){
				throw new InvalidDataException();
			}
			else{
				Grade aGrade = findGrade(grade);
				if(aGrade != null){
					this.grade = aGrade;
				}
				else{
					throw new InvalidDataException();
				}
			}
		}
	}
	
	public Integer getStudent(){
		return studentID;
	}
	public Double getGrade(){
		return grade.getGrade();
	}
	public LocalDate getCompletedDate(){
		return completedDate;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("\nCompleted Course: ");
		buffer.append(super.toString());
		buffer.append(" Completed by Student #" + getStudent());
		buffer.append(" Grade Earned: " + getGrade());
		buffer.append(" Date Completed: " + getCompletedDate().toString());
		
		return buffer.toString();
	}
	public Grade findGrade(Double grade){
		Double mark = 0.0;
		if(grade == 4.0){
			mark = 4.00;
		}
		else if(grade < 4.0 && grade >= 3.7){
			mark = 3.7;
		}
		else if(grade < 3.7 && grade >= 3.3){
			mark = 3.3;
		}
		else if(grade < 3.3 && grade >= 3.0){
			mark = 3.0;
		}
		else if(grade < 3.0 && grade >= 2.7){
			mark = 2.7;
		}
		else if(grade < 2.7 && grade >= 2.3){
			mark = 2.3;
		}
		else if(grade < 2.3 && grade >= 2.0){
			mark = 2.0;
		}
		else if(grade < 2.0 && grade >= 1.7){
			mark = 1.7;
		}
		else if(grade < 1.7 && grade >= 1.3){
			mark = 1.3;
		}
		else if(grade >= 1.0){
			mark = 1.0;
		}
		else if(grade >= 0.7){
			mark = 0.7;
		}
		else
			mark = 0.0;
		
		for(Grade aGrade : Grade.values()){
			if(mark == aGrade.getGrade())
				return aGrade;
		}
		return null;
	}
}
