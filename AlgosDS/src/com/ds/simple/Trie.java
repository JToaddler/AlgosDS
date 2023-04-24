package com.ds.simple;

/**
 * 
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 * 
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object. void insert(String word) Inserts the
 * string word into the trie. boolean search(String word) Returns true if the
 * string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input ["Trie", "insert", "search", "search", "startsWith", "insert",
 * "search"] [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output [null, null, true, false, true, null, true]
 * 
 * Explanation Trie trie = new Trie(); trie.insert("apple");
 * trie.search("apple"); // return True trie.search("app"); // return False
 * trie.startsWith("app"); // return True trie.insert("app");
 * trie.search("app"); // return True
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length, prefix.length <= 2000 word and prefix consist only of
 * lowercase English letters. At most 3 * 104 calls in total will be made to
 * insert, search, and startsWith.
 * 
 * https://www.youtube.com/watch?v=giiaIofn31A
 * 
 * @author Anto
 *
 */
public class Trie {

	private Node root;

	class Node {

		public char c;
		public boolean isWord;
		public Node[] children;

		public Node(char c) {
			this.c = c;
			isWord = false;
			children = new Node[26];
		}
	}

	public Trie() {
		this.root = new Node('\0');
	}

	public Node getNode(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null)
				return null;
			curr = curr.children[c - 'a'];
		}
		return curr;
	}

	public void insert(String word) {
		Node curr = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (curr.children[c - 'a'] == null) {
				curr.children[c - 'a'] = new Node(c);
			}
			curr = curr.children[c - 'a'];
		}
		curr.isWord = true;
	}

	public boolean search(String word) {
		Node node = getNode(word);
		return node != null && node.isWord;
	}

	public boolean startsWith(String prefix) {
		Node node = getNode(prefix);
		return node != null;
	}

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("apple");
		trie.insert("apple");
		trie.insert("bee");
		trie.insert("buy");

		System.out.println(trie.startsWith("ap"));
		System.out.println(trie.search("apple"));
		System.out.println(trie.startsWith("bees"));

	}

}