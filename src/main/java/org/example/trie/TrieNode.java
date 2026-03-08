package org.example.trie;

public class TrieNode {
    private boolean isEndOfWord;
    private int cntOfWord;
    private TrieNode[] children;

    // a-z -> 0-25  and ' ' -> 26
    public TrieNode(){
        this.isEndOfWord=false;
        this.cntOfWord=0;
        children=new TrieNode[27];
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public int getCntOfWord() {
        return cntOfWord;
    }

    public void setCntOfWord(int cntOfWord) {
        this.cntOfWord = cntOfWord;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public TrieNode getChildAtIndex(int index){
        return this.children[index];
    }

    public void addChildAtIndex(int index,TrieNode trieNode){
        this.children[index]=trieNode;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }
}
