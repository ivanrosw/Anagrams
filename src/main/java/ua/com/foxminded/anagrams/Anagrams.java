package ua.com.foxminded.anagrams;

import ua.com.foxminded.anagrams.logic.Anagram;

public class Anagrams {

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.getAnagram("fsd!s fdsyuz mnblot!") + "|Done");
        System.out.println(anagram.getAnagram("    ") + "|Done");
        System.out.println(anagram.getAnagram("    fsd    qwe!   z3c  ") + "|Done");
    }
}
