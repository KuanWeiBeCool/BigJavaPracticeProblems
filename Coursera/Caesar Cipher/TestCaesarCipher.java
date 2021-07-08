
/**
 * Write a description of TestCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipher {
    private int[] countLetters(String sentence){
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] freqs = new int[26];
        for (int k = 0; k < sentence.length(); k++){
            char currChar = sentence.charAt(k);
            currChar = Character.toLowerCase(currChar);
            int index = alphabet.indexOf(currChar);
            if (index != -1){
                freqs[index]++;
            }
        }
        return freqs;
    }   
    
    private int indexOfMax(int [] values){
        int maxValue = values[0];
        int maxIndex = 0;
        int i = 1;
        while (i < values.length){
            int currValue = values[i];
            if (currValue > maxValue){
                maxIndex = i;
                maxValue = currValue;
            }
            i++;
        }
        return maxIndex;
    }
    
    public void simpleTests(){
        FileResource resource = new FileResource();
        CaesarCipher cc = new CaesarCipher(15);
        String message = resource.asString();
        String encrypted = cc.encrypt(message);
        // String encrypted = "wwwwwkkwwkwk";
        // String decrypted = cc.decrypt(encrypted);
        // String decrypted = breakCaesarCipher(encrypted);
        System.out.println(encrypted);
        // System.out.println(decrypted);
    }
    
    public String breakCaesarCipher(String input){
        int [] freqs = countLetters(input);
        int maxIndex = indexOfMax(freqs);
        int dkey = maxIndex - 4; // assume 'e' would be the most common letter in the original message
        if (maxIndex < 4){
            dkey = 26 - (4 - maxIndex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(input);
    }
    

}
