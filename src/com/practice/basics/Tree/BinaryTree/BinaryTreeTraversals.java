package com.practice.basics.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversals {

	public static void main(String[] args) {
		BinaryTreeNode rootNode = BinaryTreeUtil.constructBinaryTree();
		System.out.println("Pre Order traversal Recursive: " + preOrderTraversalRecursive(rootNode, new ArrayList<>()));
		System.out.println("Pre Order traversal Iterative: " + preOrderTraversalIterative(rootNode));
		System.out.println("In Order traversal Recursive: " + inOrderTraversalRecursive(rootNode, new ArrayList<>()));
		System.out.println("In Order traversal Iterative: " + inOrderTraversalIterative(rootNode));
		System.out.println("Post Order traversal Recursive: " + postOrderTraversalRecursive(rootNode, new ArrayList<>()));
	}

	private static List<Integer> preOrderTraversalRecursive(BinaryTreeNode root, List<Integer> result) {
		if (root != null) {
			result.add(root.getData());
			preOrderTraversalRecursive(root.getLeft(), result);
			preOrderTraversalRecursive(root.getRight(), result);
		}
		return result;
	}

	private static List<Integer> preOrderTraversalIterative(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		/*
		 * Using stack to maintain the current node as we have to traverse the
		 * right subtree after left subtree
		 */
		Stack<BinaryTreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryTreeNode node = stack.pop();
			result.add(node.getData());
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
			}
		}
		return result;
	}

	private static List<Integer> inOrderTraversalRecursive(BinaryTreeNode root, List<Integer> result) {
		if (root != null) {
			inOrderTraversalRecursive(root.getLeft(), result);
			result.add(root.getData());
			inOrderTraversalRecursive(root.getRight(), result);
		}
		return result;
	}
	
	private static List<Integer> inOrderTraversalIterative(BinaryTreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}

		Stack<BinaryTreeNode> stack = new Stack<>();
		BinaryTreeNode currentNode = root;
		boolean flag = false;
		
		while (!flag) {
			if (currentNode != null) {
				stack.push(currentNode);
				currentNode = currentNode.getLeft();
			} else {
				if (stack.isEmpty()) {
					flag = true;
				} else {
					currentNode = stack.pop();
					result.add(currentNode.getData());
					currentNode = currentNode.getRight();
				}
			}
		}
		return result;
	}

	private static List<Integer> postOrderTraversalRecursive(BinaryTreeNode root, List<Integer> result) {
		if (root != null) {
			postOrderTraversalRecursive(root.getLeft(), result);
			postOrderTraversalRecursive(root.getRight(), result);
			result.add(root.getData());
		}
		return result;
	}

}
