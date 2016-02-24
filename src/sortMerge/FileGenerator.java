package sortMerge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class FileGenerator {
	private String fileName;
	private File file;
	private int amount;
	
	public FileGenerator(String fileName, int amount) throws IOException{
		this.fileName = fileName;
		this.amount = amount;
		generateNumbers();
	}
	
	private void generateNumbers() throws IOException{
		file = new File(fileName);
		Random rand = new Random();
		FileWriter fw = new FileWriter(file);
		PrintWriter writer = new PrintWriter(fw);
		writer.write("");
		for(int i = 0; i < amount; i++){
			int num = rand.nextInt(99);
			num++;
			writer.write(num + " ");
		}
		writer.flush();
		writer.close();
	}
	
	public File getFile(){
		return file;
	}
}
