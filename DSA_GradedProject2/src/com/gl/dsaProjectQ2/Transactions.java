package com.gl.dsaProjectQ2;

// Node class
class Node {
	int val;
	Node left, right;

	Node(int item) {
		val = item;
		left = right = null;
	}
}

// Transactions data stored as BST data structure
public class Transactions {

	public static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void BTToSkewed(Node root) {

		
		if (root == null) {
			return;
		}

		BTToSkewed(root.left);

		Node rightNode = root.right;
		
		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		BTToSkewed(rightNode);

	}

	static void traverse(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + " ");
		traverse(root.right);
	}

	// Driver code using the given BST values
	public static void main(String[] args) {

		Transactions.node = new Node(50);
		Transactions.node.left = new Node(30);
		Transactions.node.right = new Node(60);
		Transactions.node.left.left = new Node(10);
		Transactions.node.right.left = new Node(55);

		BTToSkewed(node);
		traverse(headNode);
	}

}