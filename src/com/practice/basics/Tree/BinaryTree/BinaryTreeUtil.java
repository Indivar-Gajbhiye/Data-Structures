package com.practice.basics.Tree.BinaryTree;

public class BinaryTreeUtil {

	public static BinaryTreeNode constructBinaryTree() {
		
		BinaryTreeNode root = new BinaryTreeNode(1);
		BinaryTreeNode leftNode = new BinaryTreeNode(2);
		BinaryTreeNode rightNode = new BinaryTreeNode(3);
		BinaryTreeNode leftLeftNode = new BinaryTreeNode(4);
		BinaryTreeNode leftRightNode = new BinaryTreeNode(5);
		BinaryTreeNode rightLeftNode = new BinaryTreeNode(6);
		BinaryTreeNode rightRightNode = new BinaryTreeNode(7);
		leftNode.setLeft(leftLeftNode);
		rightNode.setLeft(rightLeftNode);
		leftNode.setRight(leftRightNode);
		rightNode.setRight(rightRightNode);
		root.setLeft(leftNode);
		root.setRight(rightNode);
		
		return root;
	}
}
