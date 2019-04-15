//package com.company;
import java.lang.Math;

public class Vocab implements Comparable<Vocab> {

    private String spelling;
    private String meaning;
    private String pos; // part of speech
    private String note;

    public Vocab(String w, String m, String p, String n) {
        spelling = w;
        meaning = m;
        pos = p;
        note = n;
    }

    public int compareTo(Vocab v){
        String word1 = spelling;
        String word2 = v.getSpelling();
        return word1.compareTo(word2);
    }
    
    public String toString() {
        String s = spelling;
        if (pos.length() > 0) {
            return spelling + " (" + pos + "): " + meaning + "\n" +note;
        }
        return spelling + ": " + meaning + "\n" +note;
    }

    public String getSpelling() {
        return spelling;
    }

    public String getMeaning() {
        return meaning;
    }

    public String getPos() {
        return pos;
    }

    public String getNote() {
        return note;
    }
}

