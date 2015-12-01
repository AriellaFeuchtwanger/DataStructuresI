package summerHW;

public class Person implements Comparable{
	protected Integer ID;
	private String firstName;
	private String lastName;
	private Character midInitial;
	private Address address;
	private String phone;
	private Character gender;

	public Person(Integer ID, String firstName, String lastName, String street,
			String city, String state, String zip, Character gender) {
		this(ID, firstName, lastName, null, street, city, state, zip, null, gender);
	}
	
	public Person(Integer ID, String firstName, String lastName, Character midInitial, String street,
			String city, String state, String zip, String phone, Character gender){
		if(ID == 0)
			throw new InvalidDataException();
		else
			this.ID = ID;

		if(firstName == null)
			throw new InvalidDataException();
		else
			this.firstName = firstName;

		if(lastName == null)
			throw new InvalidDataException();
		else
			this.lastName = lastName;

		this.midInitial = midInitial;

		if(phone != null && !phone.equalsIgnoreCase("N/A")){
			if(phone.length() > 10 || phone.length() < 9)
				throw new InvalidDataException();
		}
		this.phone = phone;

		if(gender == 'f' || gender == 'F' || gender == 'M' || gender == 'm'){
			this.gender = gender;
		}
		else
			throw new InvalidDataException();
		state.trim();
		address = new Address(street, city, state, zip);
	}
	
	public void changeLastName(String name){
		if(name == null){
			throw new ModificationException();
		}
		else
			this.lastName = name;
	}
	
	public void changeAddress(String street, String city, String state, String zip){
		this.address = new Address(street, city, state, zip); //no need to check the input, it'll be taken care of
	}
	
	public void changePhoneNumber(String phoneNumber){
		if(phoneNumber == null){
			throw new ModificationException();
		}
		else{
			if(phoneNumber.length() == 10 || phoneNumber.length() == 9){
				this.phone = phoneNumber;
			}
			else
				throw new InvalidDataException();
		}
	}
	
	public Integer getID(){
		return ID;
	}
	public String getLastName(){
		return this.lastName;
	}
	public String getFirstName(){
		return this.firstName;
	}
	public Character getMiddleInitial(){
		if(midInitial != null){
			return midInitial;
		}
		else
			return null;
	}
	public String getPhoneNumber(){
		if(phone != null){
			return phone;
		}
		else
			return null;
	}
	public Address getAddress(){
		return this.address;
	}
	public Character getGender(){
		return gender;
	}
	
	public String toString(){
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("\nID: " + getID());
		buffer.append(" Name: " + getLastName() + ", " + getFirstName());
		if(midInitial != null)
			buffer.append(" " + getMiddleInitial());
		buffer.append(" " + getAddress().toString());
		buffer.append(" Phone Number: ");
		if(phone != null)
			buffer.append(getPhoneNumber());
		else
			buffer.append("N/A");
		buffer.append(" Gender: " + getGender());
		
		return buffer.toString();
	}
	
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(obj == this){
			return true;
		}
		if(obj.getClass() != getClass()){
			return false;
		}
		Person other = (Person) obj;
		if(other.getID().equals(getID())){
			return true;
		}
		else
			return false;
	}
	
	@Override
	public int compareTo(Object o) {
		Person other = (Person) o;
		return getID().compareTo(other.getID());
	}

}
