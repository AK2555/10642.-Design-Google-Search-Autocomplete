package org.example;

import org.example.repositoryImpl.InMemoryRepositoryImpl;
import org.example.service.SearchAutoCompleteService;

import java.util.ArrayList;
import java.util.List;

public class SearchAutocomplete {


    SearchAutoCompleteService service;

    public SearchAutocomplete(String[] sentences, int[] times) {
       this.service=new SearchAutoCompleteService(new InMemoryRepositoryImpl());
       service.addAllWords(sentences,times);
    }

    /**
     * Handles one character of user input.
     * @param c next character (lower-case letter, space, or '#')
     * @return top-3 historical hot sentences matching the current prefix,
     *         or an empty list when no match / after '#'.
     */
    public List<String> getSuggestions(char c) {
        return service.getSuggestions(c);
    }
}
