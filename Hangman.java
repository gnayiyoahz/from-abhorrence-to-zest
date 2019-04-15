//package com.company;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.util.List;


public class Hangman {

    private int round;
    private int score;
    private String g;
    private int remain;

    public Hangman() {
        round = 0;
        score = 0;
        g = "";
        remain = 0;
    }
    
    public void play(String s) {
        String[] filenames = s.split("\\s+");
        VocabList vl = new VocabList();
        Vocab myWord;
        ArrayList<Vocab> words;
        
        try{
            
            words = vl.makeList(filenames);
            vl.printStuff(filenames);
            
            do {
                round ++;
                // randomly get a Vocab object from list
                int rand = (int)(Math. random()*words.size());//!!!
                myWord = words.get(rand);
                String spell = myWord.getSpelling();
                // System.out.println(spell);
                // display the word
                System.out.println(Display.displayWord(spell.length()));
                
                int errors = 0;
                remain = spell.length();
                ArrayList<String> letterNo = new ArrayList<String>();
                ArrayList<Letter> letterYes = new ArrayList<Letter>();
                
                while (errors <= 9 && remain != 0) {
                    // guess correctly
                    ArrayList<Integer> myGuess = guess(spell);
                    if(myGuess.size()> 0) {
                        int[] id = myGuess.stream().mapToInt(i -> i).toArray();
                        Letter currentLetter = new Letter(g,id);
                        if (letterYes.toString().contains(g)) {
                            System.out.println("You've guessed it before.");
                        } else if (myGuess.get(0) == -1) {
                            System.out.println("Bravo! The word is "+ spell +".");
                            remain = 0;
                        } else {
                            System.out.println("Cool!");
                            letterYes.add(currentLetter);
                            remain -= myGuess.size();
                        }

                    } else {
                        //guess wrongly
                        if (letterNo.contains(g)) {
                            System.out.println("You've guessed it before.");
                        } else {
                        System.out.println("Try again.");                        
                        errors++;
                        letterNo.add(g);
                        }
                    }
                    
                    System.out.println(Display.displayProgress(letterYes,spell.length(), remain));                      
                    if (letterYes.size() != 0){
                        System.out.println("Correct guesses: " + letterYes.toString());           
                    }            
                    if (letterNo.size() != 0) {
                        System.out.println("Wrong guesses: " + letterNo.toString());
                    }    
                    System.out.println(Display.hang(errors));
                }
                
                if (errors < 9){
                    score += 1;
                    System.out.println("Congratulations!");
                }
                
                System.out.println(myWord.toString());
                System.out.println("Rounds: " + round + ". Your score: " + score);
                
            } while (cont()); 
            
        } catch (IOException e) {
            System.out.println("Something is wrong.");
        } 
 
        
    }
   
// ask if continue    
    public boolean cont(){
        Scanner input = new Scanner(System.in);
        System.out.println("Press 'enter' to stop.");
        String s = input.nextLine();
        return (s.length()>0);
    }
    
// guess    
    public ArrayList<Integer> guess(String sp){
        Scanner input = new Scanner(System.in);
        System.out.println("Press input a letter (or the word!).");
        g = input.nextLine();
        ArrayList<Integer> indices = new ArrayList<Integer>();        
        if (g.length() == 1) {
            if (sp.contains(g)){
                int index = sp.indexOf(g);
                while (index >= 0) {
                    indices.add(index);
                    index = sp.indexOf(g, index+1);
                }   
            }
        } else {
            if (g.equals(sp)) {
                indices.add(-1);
            } else {
                System.out.println("Nope.");
            }
        }
        return indices;
    }
    
}
