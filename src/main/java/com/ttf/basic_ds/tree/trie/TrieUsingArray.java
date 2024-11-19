package com.ttf.basic_ds.tree.trie;

// prefix tree
public class TrieUsingArray {
    public static class Node {
        int pass; // store the times the node is passed
        int end; // store the count of the words ending with this node
        private Node[] nexts; // store next characters after this char
        public Node(){
            this.pass=0;
            this.end=0;
            // suppose the char space is 26 lower case letters
            this.nexts=new Node[26];
        }
    }
    private Node root;
    public TrieUsingArray(){
        root = new Node();
    }
    // insert word into the trie
    public void add(String word) {
        if (null == word){
            return;
        }
        char[] chars = word.toCharArray();
        Node node = root;
        node.pass++;
        for (char c: chars) {
            int index = c-'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }
    // delete all the given word from the trie
    public void delete(String word) {
        if (null == word){
            return;
        }
        // how many times the word appears in the trie
        int count = search(word);
        if (count>0) {
            Node node = root;
            char[] chars = word.toCharArray();
            node.pass-= count;
            for (char c:chars) {
                int index = c-'a';
                if (node.nexts[index]==null) {
                    // there is no given word in the trie
                    return;
                }
                node.nexts[index].pass-=count;
                node = node.nexts[index];
            }
            // here the node point to the last char of the given word
            node.end-=count;
        }
    }
    // search the given word and return the count the word appears in the trie
    public int search(String word) {
        if (null == word){
            return 0;
        }
        Node node=root;
        char[] chars=word.toCharArray();
        for(char c: chars) {
            int index = c-'a';
            if (node.nexts[index] == null) {// if no path to char, return 0;
                return 0;
            }
            node = node.nexts[index];
        }
        // here the node point to the last char of the word
        return node.end;
    }

    // return the count of prefix
    public int prefix(String prefix) {
        if (null == prefix) {
            return 0;
        }
        Node node = root;
        char[] chars = prefix.toCharArray();
        for(char c:chars) {
            int index = c-'a';
            if (node.nexts[index]==null){
                return 0;
            }
            node= node.nexts[index];
        }
        //here node pointing to the last char of the prefix
        return node.pass;
    }

    public static void main(String[] args) {
        TrieUsingArray trie1 = new TrieUsingArray();
        trie1.add("abc");
        trie1.add("acd");
        trie1.add("abc");
        System.out.println("abc count: " + trie1.search("abc"));
        System.out.println("prefix of ab (expected 2): " + trie1.prefix("ab"));
        trie1.delete("abc");
        System.out.println("search abc after delete: " + trie1.search("abc"));
    }

}
