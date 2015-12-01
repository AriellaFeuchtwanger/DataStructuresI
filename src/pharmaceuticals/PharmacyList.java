package pharmaceuticals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.ArrayList;

public class PharmacyList implements Serializable {
	private ArrayList<CompanyCodeIndex> codes;
	private ArrayList<CompanyNameIndex> names;
	private RandomAccessFile dataFile;

	public PharmacyList() throws FileNotFoundException {
		codes = new ArrayList<CompanyCodeIndex>();
		names = new ArrayList<CompanyNameIndex>();
		dataFile = new RandomAccessFile("pharmacy", "rw");
	}

	public RandomAccessFile getRAF(){
		return dataFile;
	}
	public void addCompany(String companyCode, String companyName, String phone)
			throws IOException {
		for (CompanyCodeIndex i : codes) {
			if (i.getCompanyCode().trim().equalsIgnoreCase(companyCode)) {
				throw new DuplicateDataException();
			}
		}
		PharmaceuticalCo company = new PharmaceuticalCo(companyCode, companyName, phone);
		long location = dataFile.getFilePointer();
		company.writeToFile(dataFile, location);
		codes.add(new CompanyCodeIndex(companyCode, location));
		names.add(new CompanyNameIndex(companyName, location));
	}

	public PharmaceuticalCo findCompanyCode(String companyCode)
			throws IOException {
		Long location = getLocation(companyCode);
		if (location != null) {
			dataFile.seek(location);
			return new PharmaceuticalCo(dataFile.readUTF(), dataFile.readUTF(),
					dataFile.readUTF());
		} else
			throw new NotFoundException();
	}

	public PharmaceuticalCo findCompanyName(String companyName)
			throws IOException {

		for (CompanyNameIndex i : names) {
			if (i.getCompanyName().trim().equalsIgnoreCase(companyName)) {
				if (i.getStatus() == true) {
					dataFile.seek(i.getLocation());
					return new PharmaceuticalCo(dataFile.readUTF(),
							dataFile.readUTF(), dataFile.readUTF());
				} else
					throw new NotFoundException();
			}
		}
		throw new NotFoundException();

	}

	public void modifyCompanyPhone(String companyCode, String phone)
			throws IOException {
		Long location = getLocation(companyCode);
		if (location != null) {
			dataFile.seek(location);
			PharmaceuticalCo company = new PharmaceuticalCo(dataFile.readUTF(),
					dataFile.readUTF(), dataFile.readUTF());
			company.setPhoneNumber(phone);
			company.writeToFile(dataFile, location);
		} else
			throw new NotFoundException();
	}

	public void removeCompany(String code) {
		for (CompanyCodeIndex i : codes) {
			if (i.getCompanyCode().equalsIgnoreCase(code)) {
				i.setStatus(false);
				for (CompanyNameIndex n : names) {
					if (n.getLocation().equals(i.getLocation())) {
						n.setStatus(false);
						return;
					}
				}
			}
		}

		throw new NotFoundException();
	}

	public ArrayList<CompanyCodeIndex> getCompanies(){
		codes.sort(null);
		return codes;
		
	}
	public Long getLocation(String code) {
		for (CompanyCodeIndex i : codes) {
			if (i.getCompanyCode().equalsIgnoreCase(code)) {
				if (i.getStatus() == true)
					return i.getLocation();
				else
					return null;
			}
		}
		return null;
	}

	public boolean namePresent(String name) {
		for (CompanyNameIndex n : names) {
			if (n.getCompanyName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
}
