
/**
 * Write a description of Part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    public boolean twoOccurrences(String stringa, String stringb){
        int startIndex = 0;
        int count = -1;
        int newStartIndex = 0;
        int stringaLength = stringa.length();
        while (startIndex != -1) {
            startIndex = stringb.indexOf(stringa, newStartIndex);
            newStartIndex = startIndex + stringaLength;
            count++;
        }
        if (count >= 2){
            return true;
        }
        else{
            return false;
        }
    }
    
    public String lastPart(String stringa, String stringb){
        int startIndex = 0;
        int stringaLength = stringa.length();
        int stringbLength = stringb.length();
        startIndex = stringb.indexOf(stringa);
        if (startIndex != -1){
            return stringb.substring(startIndex+stringaLength, stringbLength);
        }
        else{
            return stringb;
        }
    }
    
    public void testing(){
        // twoOccurrences
        // First test case
        String stringb = "A story by Abby Long";
        String stringa = "by";
        boolean result = twoOccurrences(stringa, stringb);
        System.out.println(result);
        
        // Second test case
        stringb = "banana";
        stringa = "a";
        result = twoOccurrences(stringa, stringb);
        System.out.println(result);
        
        // Third test case
        stringb = "ctgtatgta";
        stringa = "atg";
        result = twoOccurrences(stringa, stringb);
        System.out.println(result);
        
        
        // First test case
        stringb = "banana";
        stringa = "an";
        String part = lastPart(stringa, stringb);
        System.out.println(part);
        
        // lastPart
        // Second test case
        stringb = "forest";
        stringa = "zoo";
        part = lastPart(stringa, stringb);
        System.out.println(part);
    
    }
}
