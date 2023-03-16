package com.booleanuk;

import java.util.HashMap;

public class Scrabble {
    HashMap<Character, Integer> letterScore = new HashMap<>();
    String word;
    public Scrabble(String word) {
        this.word = word.toUpperCase();
        this.buildScores();
    }
    
    public void buildScores() {
        letterScore.put('A', 1);
        letterScore.put('B', 3);
        letterScore.put('C', 3);
        letterScore.put('D', 2);
        letterScore.put('E', 1);
        letterScore.put('F', 4);
        letterScore.put('G', 2);
        letterScore.put('H', 4);
        letterScore.put('I', 1);
        letterScore.put('J', 8);
        letterScore.put('K', 5);
        letterScore.put('L', 1);
        letterScore.put('M', 3);
        letterScore.put('N', 1);
        letterScore.put('O', 1);
        letterScore.put('P', 3);
        letterScore.put('Q', 10);
        letterScore.put('R', 1);
        letterScore.put('S', 1);
        letterScore.put('T', 1);
        letterScore.put('U', 1);
        letterScore.put('V', 4);
        letterScore.put('W', 4);
        letterScore.put('X', 8);
        letterScore.put('Y', 4);
        letterScore.put('Z', 10);
    }

    public int score() {
        int totalScore = 0;
        int multiplier = 1;
        for (char ch : this.word.toCharArray()) {
            switch(ch) {
                case '[':
                    multiplier = multiplier * 2;
                    break;
                case ']':
                    multiplier = multiplier / 2;
                    break;
                case '{':
                    multiplier = multiplier * 3;
                    break;
                case '}':
                    multiplier = multiplier / 3;
                    break;
                default:
                    totalScore += this.getLetterScore(ch) * multiplier;
            }
        }
        return totalScore;
    }

    public int getLetterScore(char letter) {
        return this.letterScore.getOrDefault(letter, 0);
    }
}
