package files;

import java.util.Scanner;

public class FolderExplorerMain {
	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the path of the folder you would like to explore: ");
		String folder = keyboard.next();
		
		FolderExplorer explorer = new FolderExplorer(folder);
		System.out.println(explorer.toString());
		
		keyboard.close();
	}
}
