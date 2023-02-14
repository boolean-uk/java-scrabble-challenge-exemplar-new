package com.booleanuk;

import java.util.Map;

public class Scrabble {
    private final String word;
    private final Map<Character, Integer> letterScores;

    public Scrabble(String word) {
        this.word = word;
        this.letterScores = Alphabet.getLetterScores();
    }

    public int score() {
        int total = 0;

        if (this.word.length() == 0) {
            return total;
        }

        String lower = this.word.trim().toLowerCase();

        for (char ch : lower.toCharArray()) {
            int score = this.letterScores.get(ch);
            total += score;
        }

        return total;
    }
}
