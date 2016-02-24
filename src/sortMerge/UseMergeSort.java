package sortMerge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UseMergeSort {
	public static void main(String[] args) throws IOException {
		FileGenerator fg = new FileGenerator("unsortedIntegers.txt", 100);
		File unsortedFile = fg.getFile();
		/*
		Scanner unsortedReader = new Scanner(unsortedFile);
		int[] unsorted = new int[100];
		int countUnsorted = 0;
		
		while(unsortedReader.hasNext()){
			unsorted[countUnsorted] = unsortedReader.nextInt();
			countUnsorted++;
		}
		
		for(int i = 0; i < 100; i++){
			System.out.println((i + 1) + ". " + unsorted[i]);
		}
		*/
		MergeSort sorter = new MergeSort("unsortedIntegers.txt", 100);
		File file = sorter.getSortedFile();

		Scanner reader = new Scanner(file);
		int[] numbers = new int[100];
		int count = 0;

		while (reader.hasNext()) {
			numbers[count] = reader.nextInt();
			count++;
		}

		for (int i = 0; i < 100; i++) {
			System.out.println((i + 1) + ". " + numbers[i]);
		}
	}
}
