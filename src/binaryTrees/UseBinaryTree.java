package binaryTrees;

import java.util.ArrayList;
import java.util.Random;

public class UseBinaryTree {
	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.insert(5);
		tree.insert(9);
		tree.insert(20);
		tree.insert(3);
		tree.insert(6);
		tree.insert(30);
		tree.insert(88);
		tree.insert(50);
		tree.insert(79);
		tree.insert(30);
		tree.insert(93);
		tree.insert(25);

		try {
			tree.balance();
		} catch (NullRootException e1) {
			System.out.println("Null root. Cannot do operation.");
		}

		try {
			ArrayList<Integer> treeList = tree.traverseTree();
			for (Integer i : treeList) {
				System.out.println(i);
			}
		} catch (NullRootException e1) {
			System.out.println("Null root. Cannot do operation.");
		}
		try {
			boolean found = tree.remove(25);
			if (found) {
				System.out.println("Found!");
			} else {
				System.out.println("Not found...");
			}
			
			found = tree.remove(35);
			if (found) {
				System.out.println("Found and removed!");
			} else {
				System.out.println("Not found...Can't be removed.");
			}
			
			Integer data = tree.get(30);
			if(data == null){
				System.out.println("Data not found");
			} else{
				System.out.println("Data found!");
			}
			
			data = tree.get(39);
			if(data == null){
				System.out.println("Data not found");
			} else{
				System.out.println("Data found!");
			}
			
		} catch (NullRootException e1) {
			System.out.println("Null root.");
		}
		
		try {
			ArrayList<Integer> treeList = tree.traverseTree();
			for (Integer i : treeList) {
				System.out.println(i);
			}
		} catch (NullRootException e1) {
			System.out.println("Null root. Cannot do operation.");
		}

		/*
		System.out.println("\nTree using random numbers:");
		tree = new BinaryTree<Integer>();
		Random rand = new Random();
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));
		tree.insert(rand.nextInt(1000));

		tree.balance();
		ArrayList<Integer> treeList = tree.traverseTree();
		for (Integer i : treeList) {
			System.out.println(i);
		}
		*/
	}
}
