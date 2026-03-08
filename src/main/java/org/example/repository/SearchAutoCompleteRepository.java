package org.example.repository;

import org.example.trie.Sentence;

import java.util.List;

public interface SearchAutoCompleteRepository {
    void save(String word);
    List<Sentence> getAllSentence(String prefix);
}
