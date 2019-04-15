//package com.company;
import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.ArrayList;


public class VocabList {
    
    private int count; // how many words
    ArrayList<Vocab> vocabList;
    
    public VocabList(){
        count = 0;
    }

    public ArrayList<Vocab> makeList(String[] files)
            throws IOException { 
        String[] f = files;
        ArrayList<Vocab> vocabList = new ArrayList<Vocab>();
        for (int i = 0; i < f.length; i++) {
            FileReader fileReader = new FileReader(f[i]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            try {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null){
                    count ++;
                    String w = "";
                    String m = "";
                    String p = "";
                    String n = "";
                    String[] s = currentLine.split("\\s+");
                    w = s[0];
                    if (s.length == 2) {
                        m = s[1];
                    } else if (s.length == 3) {
                        m = s[1];
                        p = s[2];
                    } else if (s.length == 4) {
                        m = s[1];
                        p = s[2];
                        n = s[3];
                    }

                    Vocab currentWord = new Vocab(w,m,p,n);
                    vocabList.add(currentWord);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Something is wrong.");
            } finally {
                fileReader.close();
                bufferedReader.close();
            }
        }
        
        return vocabList;
    }
    
    public void printStuff(String[] f){
        System.out.println("Loading...");

        if (f.length == 1) {
            System.out.println("Playing with " + count + " words from " 
                               + f[0].replace(".txt", "."));
        } else {
            String fString = "";
            for (int i = 0; i < f.length- 2; i++) {
                fString += f[i].replace(".txt", ", ");
            }
            String s1 = f[f.length-2].replace(".txt", "");
            String s2 = f[f.length-1].replace(".txt", "");
            fString += s1 + " and " + s2 + ".";
            System.out.println("Playing with " + count + " words from " + fString);            
        }
        
    }
}
