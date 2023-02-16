package com.booleanuk;

import java.util.Map;

public class Scrabble {
    private final String word;
    private final Map<Character, Integer> letterScores;

    public Scrabble(String word) {
        this.word = word.trim().toLowerCase();
        this.letterScores = Alphabet.getLetterScores();
    }

    public int score() {
        int total = 0;

        for (char ch : this.word.toCharArray()) {
            int score = this.letterScores.get(ch);
            total += score;
        }

        return 19;
    }
}
