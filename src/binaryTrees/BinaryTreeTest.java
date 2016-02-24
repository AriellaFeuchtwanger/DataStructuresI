package binaryTrees;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {

	@Test
	public void testTraversal(){
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		
		tree.insert(5);
		tree.insert(9);
		tree.insert(20);
		tree.insert(3);
		tree.insert(6);
		
		ArrayList<Integer> treeList = new ArrayList<Integer>();
		treeList.add(3);
		treeList.add(5);
		treeList.add(6);
		treeList.add(9);
		treeList.add(20);
		
		ArrayList<Integer> treeList2 = tree.traverseTree();
		
		boolean equal = false;
		
		for(int i = 0; i < treeList.size(); i++){
			if(treeList.get(i).equals(treeList2.get(i))){
				equal = true;
			} else{
				equal = false;
			}
		}
		
		Assert.assertTrue(equal);
	}
	
	public void testRearrange(){
		
	}
}
