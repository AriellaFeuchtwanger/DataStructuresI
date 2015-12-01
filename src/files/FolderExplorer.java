package files;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FolderExplorer {
	private String folder;
	private HashMap<String, ArrayList<File>> files;
	private ArrayList<File> mainFolder;

	public FolderExplorer(String folder) {
		this.folder = folder;
		files = new HashMap<String, ArrayList<File>>();
		mainFolder = new ArrayList<File>();

		File aFile = new File(folder);
		if (aFile.isDirectory()) {
			File[] dirList = aFile.listFiles();
			for (int i = 0; i < dirList.length; i++) {
				mainFolder.add(dirList[i]);
			}
		}
		findFiles(this.folder);
	}

	private void findFiles(String folder) {
		File aFile = new File(folder);
		ArrayList<File> fileNames = new ArrayList<File>();

		if (aFile.isDirectory()) {
			File[] dirList = aFile.listFiles();
			for (int i = 0; i < dirList.length; i++) {
				if (dirList[i].isDirectory()) {
					findFiles(dirList[i].getPath());
				}
				fileNames.add(dirList[i]);
			}
		}

		files.put(aFile.getName(), fileNames);
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(folder);
		buffer.append("\n");
		for (File aFile : mainFolder) {
			buffer.append(aFile.getName());
			buffer.append(" ");
			if (files.containsKey(aFile.getName())) {
				ArrayList<File> contents = files.get(aFile.getName());
				for (File name : contents) {
					buffer.append(name.getName());
					buffer.append(" ");
					buffer.append(name.length());
					buffer.append("\t");
				}
			} else {
				buffer.append(aFile.length());
			}
			buffer.append("\n");
		}

		return buffer.toString();
	}
}
