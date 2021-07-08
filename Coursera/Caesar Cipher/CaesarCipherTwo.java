
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipherTwo {
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    
    public CaesarCipherTwo(int key1, int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
    }
    
    public String encrypt(String input){
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if (Character.isLowerCase(currChar)){
                int index = alphabet.indexOf(Character.toUpperCase(currChar));
                if (index != -1){
                    if (i % 2 == 0){
                        output.setCharAt(i, Character.toLowerCase(shiftedAlphabet1.charAt(index)));
                    }
                    else{
                        output.setCharAt(i, Character.toLowerCase(shiftedAlphabet2.charAt(index)));
                    }                    
                }
            }
            else{
                int index = alphabet.indexOf(currChar);
                if (index != -1){
                    if (i % 2 == 0){
                        output.setCharAt(i,shiftedAlphabet1.charAt(index));
                    }
                    else{
                        output.setCharAt(i, shiftedAlphabet2.charAt(index));
                    }                    
                }
                
            }
        }
        return output.toString();
        
    }
    
    public String decrypt(String input){
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if (Character.isLowerCase(currChar)){
                if (i % 2 == 0){   
                    int index = shiftedAlphabet1.indexOf(Character.toUpperCase(currChar));
                    if (index != -1){
                        output.setCharAt(i, Character.toLowerCase(alphabet.charAt(index)));
                    }
                }
                else{
                    int index = shiftedAlphabet2.indexOf(Character.toUpperCase(currChar));
                    if (index != -1){
                        output.setCharAt(i, Character.toLowerCase(alphabet.charAt(index)));
                    }
                }                    
            }
            else{
                if (i % 2 == 0){   
                    int index = shiftedAlphabet1.indexOf(currChar);
                    if (index != -1){
                        output.setCharAt(i, alphabet.charAt(index));
                    }
                }
                else{
                    int index = shiftedAlphabet2.indexOf(currChar);
                    if (index != -1){
                        output.setCharAt(i, alphabet.charAt(index));
                    }
                }                    
            }
                
            }
        return output.toString();
    } 
}
