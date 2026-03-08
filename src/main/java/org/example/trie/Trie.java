package org.example.trie;


import java.util.ArrayList;
import java.util.List;

public class Trie {
     private TrieNode root;

     public Trie(){
         root=new TrieNode();
     }

     public void addWord(String str){
         TrieNode trieNode=root;
         int n=str.length();
         for(int i=0;i<n;i++){
             char ch=str.charAt(i);
             int charInd;
             if(ch==' '){
                 charInd=26;
             }else{
                 charInd=(int)ch-(int)'a';
             }

             TrieNode child=trieNode.getChildAtIndex(charInd);
             if(child==null){
                 TrieNode newTrieNode=new TrieNode();
                 trieNode.addChildAtIndex(charInd,newTrieNode);
                 trieNode=newTrieNode;
             }else{
                 trieNode=child;
             }

             if(i==n-1){
                 trieNode.setEndOfWord(true);
                 trieNode.setCntOfWord(trieNode.getCntOfWord()+1);
             }
         }
     }

     public List<Sentence> allWordsWithStartsWithPrefix(String prefix){
         List<Sentence> res=new ArrayList<>();
         TrieNode trieNode=isPrefixPresent(prefix);
         if(trieNode==null){
             return res;
         }
          getAllWords(trieNode,new StringBuilder(prefix),res);
         return res;
     }


     private void getAllWords(TrieNode node,StringBuilder sb,List<Sentence> res){
         if(node.isEndOfWord()){
             res.add(new Sentence(sb.toString(),node.getCntOfWord()));
         }
         for(int i=0;i<27;i++){
             char ch;
             if(i==26){
                 ch=' ';
             }else{
                 ch=(char)(i+(int)'a');
             }
             TrieNode child=node.getChildAtIndex(i);
             if(child==null){
                 continue;
             }
             sb.append(ch);
             getAllWords(child,sb,res);
             sb.deleteCharAt(sb.length()-1);
         }
     }

     private TrieNode isPrefixPresent(String str){
         TrieNode trieNode=root;
         for(int i=0;i<str.length();i++){
             char ch=str.charAt(i);
             int charInd;
             if(ch==' '){
                 charInd=26;
             }else{
                 charInd=(int)ch-(int)'a';
             }
             TrieNode child=trieNode.getChildAtIndex(charInd);
             if(child==null){
                 return null;
             }
             trieNode=child;
         }
         return trieNode;
     }
}
