package ua.com.foxminded.anagrams.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void TestGetAnagram_FirstNoLetter_ShouldAnagramOnlyLetter() {
        Anagram anagram = new Anagram();
        String expected = "!asd";
        String actual = anagram.getAnagram("!dsa");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_LastNoLetter_ShouldAnagramOnlyLetter() {
        Anagram anagram = new Anagram();
        String expected = "asd!";
        String actual = anagram.getAnagram("dsa!");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_InMiddleNoLetter_ShouldAnagramOnlyLetter() {
        Anagram anagram = new Anagram();
        String expected = "as!d";
        String actual = anagram.getAnagram("ds!a");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_Whitespaces_ShouldReturnWhitespaces() {
        Anagram anagram = new Anagram();
        String expected = "  ";
        String actual = anagram.getAnagram("  ");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_OneWhitespace_ShouldReturnOneWhitespace() {
        Anagram anagram = new Anagram();
        String expected = " ";
        String actual = anagram.getAnagram(" ");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_OnlyNoLetter_ShouldNotAnagram() {
        Anagram anagram = new Anagram();
        String expected = "532!.";
        String actual = anagram.getAnagram("532!.");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_OnlySpecificSymbols_ShouldNotAnagram() {
        Anagram anagram = new Anagram();
        String expected = "!\\\"№;%:?*()_+";
        String actual = anagram.getAnagram("!\\\"№;%:?*()_+");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_OnlyLetter_ShouldAnagram() {
        Anagram anagram = new Anagram();
        String expected = "asdfqwe";
        String actual = anagram.getAnagram("ewqfdsa");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_TwoWordsAndSpaces_ShouldAnagramOnlyLetterInWordsAndSaveWhitespaces() {
        Anagram anagram = new Anagram();
        String expected = "  Dfs!as  fh!uG ";
        String actual = anagram.getAnagram("  sas!fD  Gu!hf ");
        assertEquals(expected, actual);
    }

    @Test
    void TestGetAnagram_Null_ShouldThrowIllegalArgumentException() {
        Anagram anagram = new Anagram();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            anagram.getAnagram(null);
        });
    }
}
