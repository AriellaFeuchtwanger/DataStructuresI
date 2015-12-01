package pharmaceuticals;

import java.io.Serializable;

public class CompanyNameIndex implements Comparable, Serializable{
	private String companyName;
	private Long location;
	private boolean isActive = true;
	
	public CompanyNameIndex(String companyName, Long location){
		if(companyName != null)
			this.companyName = companyName;
		else
			throw new InvalidDataException();
		
		if(location < 0)
			throw new InvalidDataException();
		else
			this.location = location;
	}
	
	public String getCompanyName(){
		return companyName;
	}
	public Long getLocation(){
		return location;
	}
	public boolean getStatus(){
		return isActive;
	}
	
	public void setStatus(boolean status){
		isActive = status;
	}
	
	public int compareTo(Object obj){
		if(obj instanceof CompanyNameIndex){
			CompanyNameIndex other = (CompanyNameIndex) obj;
			return location.compareTo(other.getLocation());
		}
		else
			throw new InvalidDataException();
	}
	
	public String toString(){
		StringBuffer b = new StringBuffer();
		b.append("\nCompany Name: " + getCompanyName());
		b.append(" Location: " + getLocation());
		return b.toString();
	}
	
	public boolean equals(Object obj){
		return false;
	}

}
