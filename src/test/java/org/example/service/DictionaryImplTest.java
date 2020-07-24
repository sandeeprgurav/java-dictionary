package org.example.service;

import org.example.exception.NoSuchWordExistsException;
import org.example.exception.NotAValidWordException;
import org.example.model.DictWord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DictionaryImplTest {

    IDictionary dictionary;
    DictWord rightWord;
    DictWord nullWord;
    DictWord numericWord;
    TreeMap<String, String> actualMap;
    TreeMap<String, String> expectedMap;
    public static final String PLEASE_ENTER_PROPER_WORD = "Please enter proper word";

    @Before
    public void setUp() throws NotAValidWordException {
        dictionary = new DictionaryImpl();
        rightWord = new DictWord("Able", "having the power, skill, means");
        actualMap = new TreeMap<>();
        expectedMap = new TreeMap<>();
        expectedMap.put(rightWord.getWord(), rightWord.getMeaning());
    }

    @Test
    public void addWordSuccess() throws NotAValidWordException, NoSuchWordExistsException {
        Assert.assertTrue(dictionary.addWord(rightWord));
        Assert.assertEquals(dictionary.searchWord(rightWord), rightWord.getMeaning());
    }

    @Test(expected = NotAValidWordException.class)
    public void addWordFailureWithNullInput() throws NotAValidWordException {
        nullWord = new DictWord("", "");
        Assert.assertTrue(dictionary.addWord(nullWord));
    }

    @Test
    public void addWordFailureWithNumericalInput() {
        Exception exception = assertThrows(Exception.class, () -> {
            numericWord = new DictWord("1", "2");
        });

        String actualMessage = exception.getMessage();
        Assert.assertEquals(PLEASE_ENTER_PROPER_WORD, actualMessage);
    }

    @Test
    public void removeWordSuccess() throws NotAValidWordException, NoSuchWordExistsException {
        dictionary.addWord(rightWord);
        DictWord wordToRemove = new DictWord(rightWord.getWord());
        Assert.assertTrue(dictionary.removeWord(wordToRemove));
    }

    @Test(expected = NoSuchWordExistsException.class)
    public void removeWordFailureIfNotPresent() throws NotAValidWordException, NoSuchWordExistsException {
        DictWord wordToRemove = new DictWord(rightWord.getWord());
        Assert.assertTrue(dictionary.removeWord(wordToRemove));
    }

    @Test
    public void removeWordFailureIfFailureInput() {
        Exception exception = assertThrows(Exception.class, () -> {
            nullWord = new DictWord("", "");
        });

        String actualMessage = exception.getMessage();
        Assert.assertEquals(PLEASE_ENTER_PROPER_WORD, actualMessage);
    }

    @Test
    public void listAllWordsSuccess() throws NotAValidWordException {
        dictionary.addWord(rightWord);
        dictionary.addWord(rightWord);
        actualMap = dictionary.listAllWords();
        Assert.assertEquals(expectedMap, actualMap);
    }

    @Test
    public void listAllWordsEmpty() throws NotAValidWordException {
        TreeMap<String, String> nullMap = new TreeMap<>();
        Assert.assertEquals(nullMap, actualMap);
    }

    @Test
    public void searchWordSuccess() throws NotAValidWordException, NoSuchWordExistsException {
        dictionary.addWord(rightWord);
        Assert.assertEquals(dictionary.searchWord(new DictWord(rightWord.getWord())), "having the power, skill, means");
    }

    @Test(expected = NoSuchWordExistsException.class)
    public void searchWordFailure() throws NotAValidWordException, NoSuchWordExistsException {
        Assert.assertEquals(dictionary.searchWord(new DictWord(rightWord.getWord())), "having the power, skill, means");
    }

    @Test
    public void searchWordFailureOnWrongInput() {
        Exception exception = assertThrows(Exception.class, () -> {
            Assert.assertEquals(dictionary.searchWord(new DictWord("")), "having the power, skill, means");
        });

        String actualMessage = exception.getMessage();
        Assert.assertEquals(PLEASE_ENTER_PROPER_WORD, actualMessage);

    }

}