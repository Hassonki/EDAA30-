package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  public BinaryNode<E> root;  // Används också i BSTVisaulizer
  public  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
		comparator = (e1, e2) -> ((Comparable<E>) e1).compareTo(e2);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
	}	

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if(root == null){
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		return addRec(root, x);
	}
	
	private boolean addRec(BinaryNode<E> n, E x) {
		int compResult = comparator.compare(x, n.element);

		if(compResult == 0){
			return false;
		}else if(compResult < 0){
			if(n.left == null){
				n.left = new BinaryNode<E>(x);
				size++;
				return true;
			}else{
				return addRec(n.left, x);	
			}
		}else{
			if(n.right == null){
				n.right = new BinaryNode<E>(x);
				size++;
				return true;
			}else{
				return addRec(n.right, x);
			}
		}
	}
	

	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return heightRec(root);
	}

	private int heightRec(BinaryNode<E> root) {
		if (root == null) {
			return 0;
		}

		int left = heightRec(root.left);
		int right = heightRec(root.right);

		return Math.max(left, right) + 1;
	}


	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null; 		//fungerar i java annars mst man traversera genom alla noder och nulla dem
		size=0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(root);
	}

	private void printTree(BinaryNode<E> n) {
		if(n != null){
			printTree(n.left);
			System.out.println(n.element);
			printTree(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		ArrayList<E> sorted = new ArrayList<>();
		toArray(root, sorted);

		root = buildTree(sorted, 0, sorted.size()-1); 
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if(n != null){
			toArray(n.left, sorted);
			sorted.add(n.element);
			toArray(n.right, sorted);
		}
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if(first > last){ //tom lista
			return null;
		}
		//Beräkna mitten av listan
		int mid = first + ((last - first) / 2);

		//skapa en nod och gör till root
		BinaryNode<E> node = new BinaryNode<E>(sorted.get(mid)); 

		//gör samma sak för vänstra barnet
		node.left = buildTree(sorted, first, mid - 1);

		//gör samma sak för högra barnet
		node.right = buildTree(sorted, mid + 1, last);
		
		return node;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		BinaryNode(E element) {
			this.element = element;
		}	
	}
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(); 
		
		// tree.add(10);
		// tree.add(29);
		// tree.add(15);
		// tree.add(5);
		// tree.add(70);
		// tree.add(90);
		 tree.add(9);
		 tree.add(1);
		 tree.add(3);
		tree.add(10);
		tree.add(20);
		tree.add(40);
		tree.add(27);
        tree.add(15);
		BSTVisualizer bst = new BSTVisualizer("Vårt träd", 300, 500);
		//BSTVisualizer bst2 = new BSTVisualizer("Vårt träd", 300, 500);
		tree.rebuild();
		bst.drawTree(tree);
		// BinarySearchTree<Character> charTree = new BinarySearchTree<>();
		// charTree.add('H');
		// charTree.add('A');
		// charTree.add('M');
		// charTree.add('Z');
		// charTree.add('X');
		// bst.drawTree(charTree);
		// charTree.printTree();

		System.out.println(tree.height());
		tree.printTree();
	}

}
