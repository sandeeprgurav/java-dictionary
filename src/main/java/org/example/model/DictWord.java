package org.example.model;

import org.example.exception.NotAValidWordException;
import org.example.utils.DictionaryUtils;

public class DictWord {
    private final String word;
    private final String meaning;

    public DictWord(String word, String meaning) throws NotAValidWordException {
        if (!isValid(word) || !isValid(meaning)) throw new NotAValidWordException(DictionaryUtils.ENTER_PROPER_WORD);
        this.word = word;
        this.meaning = meaning;
    }

    public DictWord(String word) throws NotAValidWordException {
        if (!isValid(word)) throw new NotAValidWordException(DictionaryUtils.ENTER_PROPER_WORD);
        this.word = word;
        meaning = null;
    }

    public String getWord() {
        return word;
    }

    public String getMeaning() {
        return meaning;
    }

    private boolean isValid(String word) {
        return ((!word.equals(""))
                && (word != null)
                && (word.matches("^[a-zA-Z,.!? ]*$")));
    }
}
