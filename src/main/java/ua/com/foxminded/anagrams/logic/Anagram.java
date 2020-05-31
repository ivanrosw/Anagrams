package ua.com.foxminded.anagrams.logic;

public class Anagram {

    private static final String WHITE_SPACE_PATTERN = "\\s++";

    public String getAnagram(String phrase) {
        if (phrase == null) {
            throw new IllegalArgumentException();
        }

        String[] words = phrase.trim().split(WHITE_SPACE_PATTERN);
        String[] anagramWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            anagramWords[i] = processWord(words[i]);
        }
        return appendAnagramWords(phrase, anagramWords);
    }

    private String processWord(String word) {
        Character[] originalWordChars = new Character[word.length()];
        for (int i = 0; i < word.length(); i++) {
            originalWordChars[i] = word.charAt(i);
        }

        Character[] anagramWordChars = new Character[originalWordChars.length];
        int enteringIndex = anagramWordChars.length;
        for (int i = 0; i < originalWordChars.length; i++) {
            if (!Character.isLetter(originalWordChars[i])) {
                anagramWordChars[i] = originalWordChars[i];
            }
        }
        for (int i = 0; i < originalWordChars.length; i++) {
            if (Character.isLetter(originalWordChars[i])) {
                enteringIndex--;
                if (anagramWordChars[enteringIndex] != null) {
                    enteringIndex--;
                }
                anagramWordChars[enteringIndex] = originalWordChars[i];
            }
        }

        StringBuilder anagramResultWord = new StringBuilder();
        for (int i = 0; i < anagramWordChars.length; i++) {
            anagramResultWord.append(anagramWordChars[i]);
        }
        return anagramResultWord.toString();
    }

    private String appendAnagramWords(String phrase, String[] anagramWords) {
        int anagramWordIndex = 0;
        StringBuilder anagram = new StringBuilder();
        String[] phraseSymbols = phrase.split("");
        boolean wordAppended = false;
        for (int i = 0; i < phraseSymbols.length; i++) {
            if (phraseSymbols[i].equals(" ")) {
                anagram.append(" ");
                wordAppended = false;
            } else {
                if (!wordAppended) {
                    anagram.append(anagramWords[anagramWordIndex]);
                    anagramWordIndex++;
                    wordAppended = true;
                }
            }
        }
        return anagram.toString();
    }
}
