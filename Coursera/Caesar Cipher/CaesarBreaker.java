
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarBreaker {
    public void testDecrypt(){
        CaesarCipher cc = new CaesarCipher();
        String message = "eeeeeeeeeeeeeeeees";
        // int key = 15;
        // String encrypted = cc.encrypt(message, key);
        // String decrypted = decrypt(encrypted);
        // System.out.println(decrypted);
        int key1 = 23;
        int key2 = 2;
        // String encrypted = cc.encryptTwoKeys(message, key1, key2);
        // String encrypted = "Xifqvximt tsdtlxzrx iijirvtl ek Uybi afvbw yehvv xyi gfqdse iekmfrrpzdrxzse";
        FileResource resource = new FileResource();
        String encrypted = resource.asString();
        String decrypted = decryptTwoKeys(encrypted);
        System.out.println(decrypted);
    }
    
    
    public String decrypt(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = indexOfMax(freqs);
        int dkey = maxDex - 4; // assume 'e' would be the most common letter in the original message
        if (maxDex < 4){
            dkey = 26 - (4 - maxDex);
        }
        return cc.encrypt(encrypted, 26-dkey);
    }
    
    public int[] countLetters(String sentence){
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
    
     public int indexOfMax(int [] values){
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
    
    public String halfOfString(String message, int start){
        int index = start;
        String newMessage = "";
        while (index < message.length()){
            newMessage += message.charAt(index);
            index += 2;
        }
        return newMessage;
    }
    
    
    public void testHalfOfString(){
        String message = "Qbkm Zgis";
        System.out.println(halfOfString(message, 0));
        System.out.println(halfOfString(message, 1));
    }
    
    public int getKey(String s){
        int [] freqs = countLetters(s);
        int maxIndex = indexOfMax(freqs);
        int dkey = maxIndex - 4; // assume 'e' would be the most common letter in the original message
        if (maxIndex < 4){
            dkey = 26 - (4 - maxIndex);
        }
        return dkey;
    }
    
    public String decryptTwoKeys(String encrypted){
        CaesarCipher cc = new CaesarCipher();
        String partOne = halfOfString(encrypted, 0);
        String partTwo = halfOfString(encrypted, 1);
        int key1 = getKey(partOne);
        int key2 = getKey(partTwo);
        System.out.println("key1: " + key1 + " key2: " + key2);
        // int key1 = 2;
        // int key2 = 20;
        return cc.encryptTwoKeys(encrypted, 26-key1, 26-key2);
    }
    
    
}
