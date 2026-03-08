package org.example.repositoryImpl;

import org.example.repository.SearchAutoCompleteRepository;
import org.example.trie.Sentence;
import org.example.trie.Trie;

import java.util.List;

public class InMemoryRepositoryImpl implements SearchAutoCompleteRepository {
      private Trie inMemoryDatabase;

      public InMemoryRepositoryImpl(){
          inMemoryDatabase=new Trie();
      }


    @Override
    public void save(String word) {
        inMemoryDatabase.addWord(word);
    }

    @Override
    public List<Sentence> getAllSentence(String prefix) {
       return inMemoryDatabase.allWordsWithStartsWithPrefix(prefix);
    }
}
