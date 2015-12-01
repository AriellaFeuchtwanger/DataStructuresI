package pharmaceuticals;

import java.io.Serializable;

public class CompanyCodeIndex implements Comparable, Serializable{
	private String companyCode;
	private Long location;
	private boolean isActive = true;

	public CompanyCodeIndex(String companyCode, Long location) {
		if (companyCode != null)
			this.companyCode = companyCode;
		else
			throw new InvalidDataException();

		if (location >= 0)
			this.location = location;
		else
			throw new InvalidDataException();
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public Long getLocation() {
		return location;
	}

	public boolean getStatus() {
		return isActive;
	}

	public void setStatus(boolean status){
		isActive = status;
	}
	public int compareTo(Object obj) {
		if (obj instanceof CompanyCodeIndex) {
			CompanyCodeIndex other = (CompanyCodeIndex) obj;
			return companyCode.compareTo(other.getCompanyCode());
		} else
			throw new InvalidDataException();
	}

	public String toString() {
		StringBuffer b = new StringBuffer();

		b.append("\nCompany Code: " + getCompanyCode());
		b.append(" Location: " + getLocation());
		// No reason to add the status - you're only adding it if it's active
		return b.toString();
	}

	public boolean equals(Object obj) {
		return false;
	}
}
