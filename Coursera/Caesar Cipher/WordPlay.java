
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        char upperCh = Character.toUpperCase(ch);
        if ((upperCh == 'A') || (upperCh == 'E') || (upperCh == 'I') || (upperCh == 'O') || (upperCh == 'U')){
            return true;
        }
        return false;
    }
    
    public void testIsVowel(){
        char ch1 = 'a';
        char ch2 = 'e';
        char ch3 = 'x';
        System.out.println(ch1 + ": " + isVowel(ch1));
        System.out.println(ch2 + ": " + isVowel(ch2));
        System.out.println(ch3 + ": " + isVowel(ch3));
    }
    
    public String replaceVowels (String phrase, char ch){
        StringBuilder newPhrase = new StringBuilder(phrase);
        String chS = Character.toString(ch);
        for (int i = 0; i < newPhrase.length(); i++){
            char currChar = newPhrase.charAt(i);
            if (isVowel(currChar)){
                newPhrase.replace(i, i+1, chS);
            }
        }
        return newPhrase.toString();
    }
    
    public void testReplaceVowels(){
        String s1 = "Hello World";
        char ch = '*';
        System.out.println(replaceVowels(s1, ch));
    }
    
    public String emphasize(String phrase, char ch){
        char upperCh = Character.toUpperCase(ch);
        char lowerCh = Character.toLowerCase(ch);
        StringBuilder newPhrase = new StringBuilder(phrase);
        for (int i = 0; i < newPhrase.length(); i++){
            char currChar = newPhrase.charAt(i);
            if ((currChar == upperCh) || (currChar == lowerCh)){
                if (i % 2 == 0){
                    newPhrase.setCharAt(i, '*');
                }
                else{
                    newPhrase.setCharAt(i, '+');
                }
            }
        }
        return newPhrase.toString();
    }
    
    public void testEmphasize(){
        String s1 = "dna ctgaaactga";
        char ch = 'a';
        String s2 = "Maaary Bella Abracadabra";
        System.out.println(emphasize(s1, ch));
        System.out.println(emphasize(s2, ch));
    }
    
}
