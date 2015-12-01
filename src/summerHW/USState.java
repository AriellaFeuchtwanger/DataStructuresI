package summerHW;

public enum USState {

	AL("Alabama", "AL"), AK("Alaska", "AK"), AZ("Arizona", "AZ"), AR(
			"Arkansas", "AR"), CA("California", "CA"), CO("Colorado", "CO"), CT(
			"Connecticut", "CT"), DE("Delaware", "DE"), FL("Florida", "FL"), GA(
			"Georgia", "GA"), HI("Hawaii", "HI"), ID("Idaho", "ID"), IL(
			"Illinois", "IL"), IN("Indiana", "IN"), IA("Iowa", "IA"), KS(
			"Kansas", "KS"), KY("Kentucky", "KY"), LA("Louisiana", "LA"), ME(
			"Maine", "ME"), MD("Maryland", "MD"), MA("Massachusetts", "MA"), MI(
			"Michigan", "MI"), MN("Minnesota", "MN"), MS("Mississippi", "MS"), MO(
			"Missouri", "MO"), MT("MONTANA", "MT"), NE("NEBRASKA", "NE"), NV(
			"Nevada", "NV"), NH("New Hampshire", "NH"), NJ("New Jersey", "NJ"), NM(
			"New Mexico", "NM"), NY("New York", "NY"), NC("North Carolina",
			"NC"), ND("North Dakota", "ND"), OH("OHIO", "OH"), OK("Oklahoma",
			"OK"), OR("Oregon", "OR"), PA("Pennsylvania", "PA"), RI(
			"Rhode Island", "RI"), SC("South Carolina", "SC"), SD(
			"South Dakota", "SD"), TN("Tennessee", "TN"), TX("Texas", "TX"), UT(
			"Utah", "UT"), VA("Virginia", "VA"), VT("Vermont", "VT"), WA(
			"Washington", "WA"), WV("West Virginia", "WV"), WI("Wisconsin",
			"WI"), WY("Wyoming", "WY");

	private String stateName;
	private String stateCode;

	private USState(String stateName, String stateCode) {
		this.stateName = stateName;
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public String getStateCode() {
		return stateCode;
	}
}