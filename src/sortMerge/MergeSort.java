package sortMerge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

	private ArrayList<File> files;
	private int amount;
	private String unsortedFileName;

	public MergeSort(String unsortedFileName, int amount) throws IOException {
		this.amount = amount;
		this.files = new ArrayList<File>();
		this.unsortedFileName = unsortedFileName;
		sort();
	}

	public File getSortedFile() {
		return files.get(0);
	}

	public void sort() throws IOException {
		sortIntegers();
	}

	private void merge() throws IOException {
		if (files.size() > 1) {
			File file1 = files.get(0);
			File file2 = files.get(1);
			int[] temporary1 = new int[amount];
			int[] temporary2 = new int[amount];
			int count1 = 0; // keep track of the first file
			int count2 = 0; // keep track of the second file

			Scanner fileReader = new Scanner(file1);

			while (fileReader.hasNext()) {
				temporary1[count1] = fileReader.nextInt();
				count1++;
			}

			fileReader = new Scanner(file2);

			while (fileReader.hasNext()) {
				temporary2[count2] = fileReader.nextInt();
				count2++;
			}

			//count1--;
			//count2--;
			// Remove the second file - the first one will be the temporary
			// merged list
			files.remove(1);
			File sortedFile = new File("sortedIntegers.txt");
			PrintWriter writer = new PrintWriter(new FileWriter(sortedFile));
			int current1 = 0; // keep track of where you are
			int current2 = 0;
			writer.write(" ");

			while (current1 < count1 && current2 < count2) {
				if (temporary1[current1] <= temporary2[current2]) {
					writer.write(temporary1[current1] + " ");
					current1++; // no need to check it, because it won't go
								// through too many times
				} else {
					writer.write(temporary2[current2] + " ");
					current2++;
				}
			}

			if (current1 == count1) { // went through temporary1
				while (current2 < count2) {
					writer.write(temporary2[current2] + " ");
					current2++;
				}
			} else if (current2 == count2) {
				while (current1 < count1) {
					writer.write(temporary1[current1] + " ");
					current1++;
				}
			}
			files.set(0, sortedFile);

			writer.flush();
			writer.close();
			merge();
		}
	}

	private void sortIntegers() throws IOException {
		int num = amount / 5; // To split the file.
		int count = 1;
		Scanner reader = new Scanner(new File(unsortedFileName));
		int[] unsorted = new int[num];

		while (reader.hasNext()) {
			for (int i = 0; i < num; i++) {
				unsorted[i] = reader.nextInt();
			}

			Arrays.sort(unsorted);
			StringBuilder builder = new StringBuilder();
			builder.append("temp" + count + ".txt");
			PrintWriter pw = new PrintWriter(new FileWriter(new File(
					builder.toString())));

			for (int i = 0; i < num; i++) {
				pw.write(unsorted[i] + " ");
			}
			files.add(new File(builder.toString()));
			pw.close();
			count++;
		}

		merge();
	}
}
