package org.example.service;

import org.example.repository.SearchAutoCompleteRepository;
import org.example.trie.Sentence;

import java.util.*;

public class SearchAutoCompleteService {
    private SearchAutoCompleteRepository repository;
    private StringBuilder sb;

    public SearchAutoCompleteService(SearchAutoCompleteRepository repository){
        sb=new StringBuilder();
        this.repository=repository;
    }

    public void addAllWords(String[] sentences, int[] times) {
        for(int i=0;i<sentences.length;i++){
            String str=sentences[i];
            if(isCharPresent(str,'#')){
                continue;
            }
            for(int j=0;j<times[i];j++){
                repository.save(str);
            }
        }
    }

    private boolean isCharPresent(String str,char ch){
        Set<Character> set=new HashSet<>();
        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        return set.contains(ch);
    }


    public List<String> getSuggestions(char ch) {
        if(ch=='#'){
            repository.save(sb.toString());
            sb=new StringBuilder();
            return new ArrayList<>();
        }
       sb.append(ch);
       List<Sentence> res=repository.getAllSentence(sb.toString());

        Collections.sort(res,(Sentence a, Sentence b)->{
            if(a.getCnt()!=b.getCnt()){
                return b.getCnt()-a.getCnt();
            }else{
                int val=  a.getStr().compareTo(b.getStr());
                return val;
            }
        });

        int min=Math.min(res.size(),3);
       List<String> res1=new ArrayList<>();
       for(int i=0;i<min;i++){
           res1.add(res.get(i).getStr());
       }
       return res1;

    }
}
