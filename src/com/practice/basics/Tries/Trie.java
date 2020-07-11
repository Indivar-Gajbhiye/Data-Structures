package com.practice.basics.Tries;

import java.util.Map;

public class Trie {

	public TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		Map<Character, TrieNode> children = root.getChildren();

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode node;
			if (children.containsKey(c)) {
				node = children.get(c);
			} else {
				node = new TrieNode(c);
				children.put(c, node);
			}
			children = node.getChildren();

			// set leaf node
			if (i == word.length() - 1) {
				node.setLeaf(true);
			}
		}
	}

	public TrieNode searchNode(String str) {
		Map<Character, TrieNode> children = root.getChildren();
		TrieNode node = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				node = children.get(c);
				children = node.getChildren();
			} else {
				return null;
			}
		}

		return node;
	}

	public boolean search(String word) {
		TrieNode node = searchNode(word);

		if (node != null && node.isLeaf()) {
			return true;
		} else {
			return false;
		}
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null) {
			return false;
		} else {
			return true;
		}
	}
}
