package org.example.service;

import org.example.exception.NoSuchWordExistsException;
import org.example.exception.NotAValidWordException;
import org.example.model.DictWord;

import java.util.TreeMap;

public interface IDictionary {

    boolean addWord(DictWord dictWord) throws NotAValidWordException;

    boolean removeWord(DictWord word) throws NoSuchWordExistsException, NotAValidWordException;

    TreeMap<String, String> listAllWords();

    String searchWord(DictWord word) throws NotAValidWordException, NoSuchWordExistsException;
}
