package com.booleanuk;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ScrabbleTest {
    @Test
    public void shouldGive0ForEmptyWords() {
        Scrabble scrabble = new Scrabble("");
        Assertions.assertEquals(0, scrabble.score());
    }

    @Test
    public void shouldGive0ForWhiteSpace() {
        Scrabble scrabble = new Scrabble("\n\r\t\b\f");
        Assertions.assertEquals(0, scrabble.score());
    }

    @Test
    public void shouldScore1ForA() {
        Scrabble scrabble = new Scrabble("a");
        Assertions.assertEquals(1, scrabble.score());
    }

    @Test
    public void shouldScore4ForF() {
        Scrabble scrabble = new Scrabble("f");
        Assertions.assertEquals(4, scrabble.score());
    }

    @Test
    public void shouldScore6ForStreet() {
        Scrabble scrabble = new Scrabble("street");
        Assertions.assertEquals(6, scrabble.score());
    }

    @Test
    public void shouldScore22ForQuirky() {
        Scrabble scrabble = new Scrabble("quirky");
        Assertions.assertEquals(22, scrabble.score());
    }

    @Test
    public void shouldScore41ForCaseInsensitiveWord() {
        Scrabble scrabble = new Scrabble("OXyPHEnBUTaZoNE");
        Assertions.assertEquals(41, scrabble.score());
    }

    @Test
    public void doubleLetterScoreScores16() {
        // t scores 1, w scores 4, e scores 1, l scores 1, v scores 4 doubled scores 8, e scores 1
        // 1+4+1+1+8+1= 16
        Scrabble scrabble = new Scrabble("twel[v]e");
        Assertions.assertEquals(16, scrabble.score());
    }
    @Test
    public void tripleLetterScoreScores20() {
        // t scores 1, w scores 4, e scores 1, l scores 1, v scores 4 tripled scores `1, e scores 1
        // 1+4+1+1+12+1=20
        Scrabble scrabble = new Scrabble("twel{v}e");
        Assertions.assertEquals(20, scrabble.score());
    }

    @Test
    public void doubleWordScoreScores22() {
        // j scores 8, o scores 1, g scores 2, 8+1+2 = 11
        // Double word score makes 22
        Scrabble scrabble = new Scrabble("[jog]");
        Assertions.assertEquals(22, scrabble.score());
    }

    @Test
    public void tripleWordScoreScores15() {
        // d scores 2, o scores 1, g scores 2, 2+1+2 = 5
        // Triple word score makes 15
        Scrabble scrabble = new Scrabble("{dog}");
        Assertions.assertEquals(15, scrabble.score());
    }

    @Test
    public void nestedTripleLetterInDoubleWordScores22() {
        // f scores 4, o scores 1, g scores 2 tripled = 6, 4+1+6 = 11
        // Double word score gives 22
        Scrabble scrabble = new Scrabble("[fo{g}]");
        Assertions.assertEquals(22, scrabble.score());
    }

    @Test
    public void nestedDoubleLetterInTripleWordScores33() {
        // f scores 4 doubled = 8, o scores 1, g scores 2, 8+1+2 = 11
        // Triple word score gives 33
        Scrabble scrabble = new Scrabble("{[f]og}");
        Assertions.assertEquals(33, scrabble.score());
    }
}
