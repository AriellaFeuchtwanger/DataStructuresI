package summerHW;

public enum Section {
	BA("BA"), BB("BB"), BC("BC"), FA("FA"), FB("FB"), FD("FD"), OL("OL"), FC(
			"FC"), FE("FE");

	private String section;

	private Section(String section) {
		this.section = section;
	}

	public String getSection() {
		return this.section;
	}

}
