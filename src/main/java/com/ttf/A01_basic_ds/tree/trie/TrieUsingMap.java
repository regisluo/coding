package com.ttf.A01_basic_ds.tree.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieUsingMap {
    public static class Node {
        int pass;
        int end;
        Map<Integer, Node> nexts;

        //constructor
        public Node(){
            this.pass=0;
            this.end=0;
            this.nexts = new HashMap<>();
        }
    }
    private Node root;
    public TrieUsingMap(){
        this.root = new Node();
    }
    // search the times appears in the trie for the given String s
    public int search(String s){
        if(null==s){
            return 0;
        }
        Node node = this.root;
        char[] chars = s.toCharArray();
        for(char c: chars) {
            int index = c;
            if (node.nexts.get(index) == null) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.pass;
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
            int index = c;
            if (node.nexts.get(index) == null) {
                node.nexts.put(index, new Node());
            }
            node = node.nexts.get(index);
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
                int index = c;
                if (node.nexts.get(index)==null) {
                    // there is no given word in the trie
                    return;
                }
                node.nexts.get(index).pass-=count;
                node = node.nexts.get(index);
            }
            // here the node point to the last char of the given word
            node.end-=count;
        }
    }

    public int prefix(String prefix) {
        if (null == prefix) {
            return 0;
        }
        Node node = root;
        char[] chars = prefix.toCharArray();
        for(char c:chars) {
            int index = c;
            if (node.nexts.get(index)==null){
                return 0;
            }
            node= node.nexts.get(index);
        }
        //here node pointing to the last char of the prefix
        return node.pass;
    }

    public static void main(String[] args) {
        TrieUsingMap trie1 = new TrieUsingMap();
        trie1.add("abc");
        trie1.add("acd");
        trie1.add("abc");
        System.out.println("abc count: " + trie1.search("abc"));
        System.out.println("prefix of ab (expected 2): " + trie1.prefix("ab"));
        trie1.delete("abc");
        System.out.println("search abc after delete: " + trie1.search("abc"));
    }

}
