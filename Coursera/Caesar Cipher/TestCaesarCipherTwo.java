
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    private String halfOfString(String message, int start){
        int index = start;
        String newMessage = "";
        while (index < message.length()){
            newMessage += message.charAt(index);
            index += 2;
        }
        return newMessage;
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
    
    public void simpleTests(){
        FileResource resource = new FileResource();
        CaesarCipherTwo cc = new CaesarCipherTwo(14, 24);
        String encrypted = resource.asString();
        // String encrypted = cc.encrypt(message);
        // String encrypted = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String decrypted = cc.decrypt(encrypted);
        // String decrypted = breakCaesarCipher(encrypted);
        // System.out.println(encrypted);
        System.out.println(decrypted);
    }
    
    private int getKey(String s){
        int [] freqs = countLetters(s);
        int maxIndex = indexOfMax(freqs);
        int dkey = maxIndex - 4; // assume 'e' would be the most common letter in the original message
        if (maxIndex < 4){
            dkey = 26 - (4 - maxIndex);
        }
        return dkey;
    }    
    
    public String breakCaesarCipher(String input){
       
        String partOne = halfOfString(input, 0);
        String partTwo = halfOfString(input, 1);
        int key1 = getKey(partOne);
        int key2 = getKey(partTwo);
        System.out.println("key1: " + key1 + " key2: " + key2);
        CaesarCipherTwo cc = new CaesarCipherTwo(key1, key2);
        // int key1 = 2;
        // int key2 = 20;
        return cc.decrypt(input);        
    }
}
