import java.util.ArrayList;
import java.lang.*;


public class Display {
    
    public static String displayWord(int length) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "_ ";
        }
        return s;
    }
    

    public static String displayProgress(ArrayList<Letter> letters, int length, int remain) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += "_ ";
        }
        StringBuilder progress = new StringBuilder(s);
        for (int i = 0; i < letters.size(); i++) {
            int[] pos = letters.get(i).getPosition();
            for (int j = 0; j < pos.length; j++) {
                progress.setCharAt(2*pos[j], letters.get(i).getLetter());
            }
        }
        return String.valueOf(progress);
    }
    
    public static String hang(int i) {
        if (i == 0) {
            return "";
        } else if (i == 1) {
            return "\n"+
                   "\n"+
                   "\n"+
                   "\n"+
                   "\n"+
                   "\n"+
                   "\n"+
                   "===========\n";            
        } else if (i == 2) {
            return "\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n";            
        } else if (i == 3) {
            return "__________\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n";            
        } else if (i == 4) {
            return "__________\n"+
                   "|     |\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n";            
        } else if (i == 5){
            return "__________\n"+
                   "|     |\n"+
                   "|     〇\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n";            
        } else if (i == 6){
            return "__________\n"+
                   "|     |\n"+
                   "|     〇\n"+
                   "|     |\n"+
                   "|     |\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n";            
        } else if (i == 7){
            return "__________\n"+
                   "|     |\n"+
                   "|     〇\n"+
                   "|    /|"+"\n"+
                   "|     |\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n";            
        } else if (i == 8){
            return "__________\n"+
                   "|     |\n"+
                   "|     〇\n"+
                   "|    /|"+"\\"+"\n"+
                   "|     |\n"+
                   "|\n"+
                   "|\n"+
                   "===========\n"+
                   "Be careful!";            
        } else if (i == 9){
            return "__________\n"+
                   "|     |\n"+
                   "|     〇\n"+
                   "|    /|"+"\\"+"\n"+
                   "|     |\n"+
                   "|    /\n"+
                   "|\n"+
                   "===========\n"+
                   "One last mistake allowed!";            
        } else if (i == 10) {
            return "__________\n"+
                   "|     |\n"+
                   "|     〇\n"+
                   "|    /|"+"\\"+"\n"+
                   "|     |\n"+
                   "|    / "+"\\"+"\n"+
                   "|\n"+
                   "===========\n" + "GAME OVER X_X";
                
        } else {
            return "";
        }
    }
    
}