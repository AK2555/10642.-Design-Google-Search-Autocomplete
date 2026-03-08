package org.example.trie;

public class Sentence {
    private String str;
    private int cnt;
    public Sentence(String str,int cnt){
        this.str=str;
        this.cnt=cnt;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
