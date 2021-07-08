
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    public CaesarCipher(int key){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
    }
    public String encrypt(String input){
        StringBuilder output = new StringBuilder(input);
        for (int i = 0; i < output.length(); i++){
            char currChar = output.charAt(i);
            if (Character.isLowerCase(currChar)){
                int index = alphabet.indexOf(Character.toUpperCase(currChar));
                if (index != -1){
                    output.setCharAt(i, Character.toLowerCase(shiftedAlphabet.charAt(index)));
                }
            }
            else{
                int index = alphabet.indexOf(currChar);
                if (index != -1){
                    output.setCharAt(i, shiftedAlphabet.charAt(index));
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
                int index = shiftedAlphabet.indexOf(Character.toUpperCase(currChar));
                if (index != -1){
                    output.setCharAt(i, Character.toLowerCase(alphabet.charAt(index)));
                }
            }
            else{
                int index = shiftedAlphabet.indexOf(currChar);
                if (index != -1){
                    output.setCharAt(i, alphabet.charAt(index));
                }
            }
        }
        return output.toString();
    }
    
}
