package summerHW;

public class Address {
	private String street;
	private String city;
	private USState state;
	private String zip;

	public Address(String street, String city, String state, String zip) {
		if (street != null) {
			this.street = street;
		} else {
			throw new InvalidDataException();
		}

		if (city != null) {
			this.city = city;
		} else {
			throw new InvalidDataException();
		}

		state.trim();
		if (state != null) {
			USState test = findState(state);
			if (test == null) {
				throw new InvalidDataException();
			} else {
				this.state = test;
			}
		}

		if (zip != null) {
			if (zip.length() == 5 || zip.length() == 9) {
				this.zip = zip;
			} else {
				throw new InvalidDataException();
			}
		} else {
			throw new InvalidDataException();
		}
	}

	public void setStreet(String street) {
		if (street != null) {
			this.street = street;
		} else {
			throw new ModificationException();
		}
	}

	public void setCity(String city) {
		if (city != null) {
			this.city = city;
		} else {
			throw new ModificationException();
		}
	}

	public void setState(String stateName) {
		if (stateName != null) {
			USState test = findState(stateName);
			if (test != null) {
				this.state = test;
			} else {
				throw new ModificationException();
			}
		} else {
			throw new ModificationException();
		}
	}

	public void setZip(String zip) {
		if (zip != null) {
			this.zip = zip;
		} else {
			throw new ModificationException();
		}
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state.getStateName();
	}

	public String getZip() {
		return zip;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();

		buffer.append("Address: ");
		buffer.append(getStreet() + " " + getCity() + ", ");
		buffer.append(getState() + " " + getZip());
		return buffer.toString();
	}

	private static USState findState(String state){
		for (USState aState : USState.values()){
			if (aState.getStateName().equalsIgnoreCase(state)){
				return aState;
			}
			if(aState.getStateCode().equalsIgnoreCase(state)){
				return aState;
			}
		}
		return null;   //couldn't find the state
	}
}
