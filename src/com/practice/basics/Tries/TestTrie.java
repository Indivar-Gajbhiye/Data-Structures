package com.practice.basics.Tries;

public class TestTrie {

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("indi");
		System.out.println(trie.root.getChildren());
		System.out.println(trie.search("indi"));
	}

}
