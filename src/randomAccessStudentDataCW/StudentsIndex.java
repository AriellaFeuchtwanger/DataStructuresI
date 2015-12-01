package randomAccessStudentDataCW;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentsIndex implements Serializable{
	private ArrayList<StudentIndexRec> index;
	
	
	/**
	 * set up an index for the first time
	 * 
	 */
	public StudentsIndex (){
		index = new ArrayList<StudentIndexRec>();
		
	}
	
	
	/**
	 * 
	 * @param studentID
	 * @param fileLocation
	 * @throws Exception if duplicate 
	 */
	public void addStudentToIndex(Integer studentID, Long fileLocation)throws DuplicateDataException{
		StudentIndexRec dummy = new StudentIndexRec(studentID, fileLocation);
		if(index.contains(dummy)){
			throw new DuplicateDataException();
		}
		else{
			index.add(dummy);
		}
	}
	
	/**
	 * 
	 * @param studentID
	 * @return  Long  - location of record in the data file
	 * @throws NotFoundException
	 */
	
	public Long findStudentLocation (Integer studentID)throws NotFoundException{
		int e = findStudent(studentID);
		return index.get(e).getFileLocation();
	}
	
	/**
	 * 
	 * @param studentID
	 * @return  element number of the studentindexrec in the array
	 * @throws NotFoundException
	 */
	private int  findStudent(Integer studentID)throws NotFoundException{
		/*
		for(StudentIndexRec e : index){
			if(e.getStudentID().equals(studentID)){
				return index.indexOf(e);
			}
		}
		*/
		StudentIndexRec dummy = new StudentIndexRec(studentID, 1L);
		Collections.binarySearch(index, dummy);
		throw new NotFoundException();
	}
	
	/**
	 * 
	 * @param studentID
	 * @return true if studentid appears in the index array
	 */
	
	public boolean hasStudent(Integer studentID){
		for(StudentIndexRec e : index){
			if(e.getStudentID().equals(studentID)){
				return true;
			}
		}
		return false;
	}
	
	public void removeStudent(Integer studentID) throws NotFoundException{
		int e = findStudent(studentID);
		index.remove(e);
	}
	
     private void sortIndex(){}{
    	 index.sort(null);
     }
	
   /*  
     private int findStudentBinSearch(Integer studentID){
    	 return index.binarySearch(studentID);
     }
	*/

}
