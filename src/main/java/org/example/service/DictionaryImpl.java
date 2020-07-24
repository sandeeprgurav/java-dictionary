package org.example.service;

import org.example.exception.NoSuchWordExistsException;
import org.example.model.DictWord;

import java.util.TreeMap;

import static org.example.utils.DictionaryUtils.NOT_PRESENT_IN_THE_DICTIONARY;

public class DictionaryImpl implements IDictionary {

    TreeMap<String, String> dictmap;

    public DictionaryImpl() {
        dictmap = new TreeMap<String, String>();
    }

    public boolean addWord(DictWord dictWord) {
        if (dictmap.get(dictWord.getWord()) != null && (!dictmap.get(dictWord.getWord()).contains(dictWord.getMeaning()))) {
            dictmap.put(dictWord.getWord(), (dictmap.get(dictWord.getWord()) + "," + dictWord.getMeaning()));
        } else {
            dictmap.put(dictWord.getWord(), dictWord.getMeaning());
        }
        return true;
    }

    public boolean removeWord(DictWord word) throws NoSuchWordExistsException {
        if (!dictmap.containsKey(word.getWord())) {
            throw new NoSuchWordExistsException(word + NOT_PRESENT_IN_THE_DICTIONARY);
        }
        dictmap.remove(word.getWord());
        return true;
    }

    public TreeMap<String, String> listAllWords() {
        return dictmap;
    }

    public String searchWord(DictWord word) throws NoSuchWordExistsException {
        String meaning = "";
        meaning = dictmap.get(word.getWord());
        if (meaning == null) {
            throw new NoSuchWordExistsException(NOT_PRESENT_IN_THE_DICTIONARY);
        }
        return meaning;
    }
}
