
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipher {
    public String encrypt(String input, int key){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String newAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if (Character.isLowerCase(currChar)){
                int index = alphabet.indexOf(Character.toUpperCase(currChar));
                if (index != -1){
                    output.setCharAt(i, Character.toLowerCase(newAlphabet.charAt(index)));
                }
            }
            else{
                int index = alphabet.indexOf(currChar);
                if (index != -1){
                    output.setCharAt(i, newAlphabet.charAt(index));
                }
            }
        }
        return output.toString();
        
    }
    
    public void testCaesar(){
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key = 15;
        String encrypted = encrypt(message, key);
        
        System.out.println("key is " + key + "\n" + encrypted);
        
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String AlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String AlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if (Character.isLowerCase(currChar)){
                int index = alphabet.indexOf(Character.toUpperCase(currChar));
                if (index != -1){
                    if (i % 2 == 0){
                        output.setCharAt(i, Character.toLowerCase(AlphabetKey1.charAt(index)));
                    }
                    else{
                        output.setCharAt(i, Character.toLowerCase(AlphabetKey2.charAt(index)));
                    }                    
                }
            }
            else{
                int index = alphabet.indexOf(currChar);
                if (index != -1){
                    if (i % 2 == 0){
                        output.setCharAt(i,AlphabetKey1.charAt(index));
                    }
                    else{
                        output.setCharAt(i, AlphabetKey2.charAt(index));
                    }                    
                }
                
            }
        }
        return output.toString();
        
    }
    
    public void testCaesarTwoKeys(){
        // FileResource fr = new FileResource();
        // String message = fr.asString();
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        int key1 = 8;
        int key2 = 21;
        String encrypted = encryptTwoKeys(message, key1, key2);
        
        System.out.println(encrypted);
        
    }    
}
