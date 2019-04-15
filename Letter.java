
public class Letter {
    
    private char letter;
    private int[] position;
    
    public Letter (String s, int[] p) {
        letter = s.charAt(0);
        position = p;
    }
    
    public String toString(){
        return String.valueOf(letter);
    }
    
    public char getLetter(){
        return letter;
    }
    
    public int[] getPosition(){
        return position;
    }

}