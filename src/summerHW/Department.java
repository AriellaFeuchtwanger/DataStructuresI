package summerHW;

public class Department implements Comparable{

	private String departmentID;
	private String departmentName;
	private String location;
	private String phoneNumber;
	private String faxNumber;
	private Integer chairperson;

	public Department(String departmentID, String departmentName) {
		this(departmentID, departmentName, null, null, null, null);
	}

	public Department(String departmentID, String departmentName,
			String location, String phoneNumber, String faxNumber,
			Integer chairperson) {
		if(departmentID == null){
			throw new InvalidDataException();
		}
		else
			this.departmentID = departmentID;
		
		//Check department name
		if(departmentName == null){
			throw new InvalidDataException();
		}
		else
			this.departmentName = departmentName;
		
		//Do not check other variables for null - not required
		
		//Check phone number
		if(phoneNumber != null){
			if(phoneNumber.length() < 9 || phoneNumber.length() > 10){
				throw new InvalidDataException();
			}
			else
				this.phoneNumber = phoneNumber;
		}
		else
			this.phoneNumber = phoneNumber;
		
		//Check fax number
		if(faxNumber != null){
			if(faxNumber.length() < 9 || faxNumber.length() > 10){
				throw new InvalidDataException();
			}
			else
				this.faxNumber = faxNumber;
		}
		else
			this.faxNumber = faxNumber;
		
		//Initiate other variables
		this.chairperson = chairperson;
		this.location = location;
	}
	
	public void changeLocation(String location){
		if(location == null){
			throw new InvalidDataException();
		}
		else
			this.location = location;
	}
	
	public void changePhoneNumber(String phoneNumber){
		if(phoneNumber == null){
			throw new ModificationException();
		}
		else{
			if(phoneNumber.length() < 10 || phoneNumber.length() > 10){
				throw new ModificationException();
			}
			else
				this.phoneNumber = phoneNumber;			
		}
	}
	
	public void changeFaxNumber(String faxNumber){
		if(faxNumber == null){
			throw new InvalidDataException();
		}
		else{
			if(faxNumber.length() < 9 || faxNumber.length() > 10){
				throw new ModificationException();
			}
			else
				this.faxNumber = faxNumber;
		}
	}
	
	public void changeChairperson(Integer chairperson){
		if(chairperson == null){
			throw new ModificationException();
		}
		else
			this.chairperson = chairperson;
	}
	
	//Getters
	public String getDepartmentID(){
		return departmentID;
	}
	public String getDepartmentName(){
		return departmentName;
	}
	public String getLocation(){
		return location;
	}
	public String getPhoneNumber(){
		return phoneNumber;
	}
	public String getFaxNumber(){
		return faxNumber;
	}
	public Integer getChairperson(){
		return chairperson;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("Department ID: " + getDepartmentID());
		buffer.append(" Department Name: " + getDepartmentName());
		if(location != null){
			buffer.append(" Location: " + getLocation());
		}
		if(chairperson != null){
			buffer.append(" Chairperson: " + getChairperson());
		}
		if(phoneNumber != null){
			buffer.append(" Phone Number: " + getPhoneNumber());
		}
		if(faxNumber != null){
			buffer.append(" Fax Number: " + getFaxNumber());
		}
		
		return buffer.toString();
	}
	
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj == null){
			return false;
		}
		if(getClass() != obj.getClass()){
			return false;
		}
		Department other = (Department) obj;
		if(other.getDepartmentID().equals(departmentID)){
			return true;
		}
		else
			return false;
	}
	
	@Override
	public int compareTo(Object o) {
		Department other = (Department) o;
		return other.getDepartmentID().compareTo(getDepartmentID());
	}

}
