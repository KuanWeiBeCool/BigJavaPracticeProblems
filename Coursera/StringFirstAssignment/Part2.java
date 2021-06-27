
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon){
        // Check for all upper or lower cases
        int count = 0;
        int length = dna.length();
        for (int i = 0; i < length; i++){
            if (Character.isUpperCase(dna.charAt(i))){
                count++;
            }
        }
        if (count == 0){
            dna = dna.toUpperCase();
        }
        if ((count > 0) & (count < length)){
            return "";
        }
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        int endIndex = dna.indexOf("TAA", startIndex+3);
        if (endIndex == -1){
            return "";
        }
        String result = dna.substring(startIndex, endIndex+3);
        if (result.length() % 3 == 0){
            if (count == 0){
                return result.toLowerCase();
            }
            return result;
        }
        else {
        return "";
        }
    }
    
    public void testSimpleGene () {
        //First Test Case
        String dna = "ATGCACGCAGTAA";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        System.out.println("Original DNA: " + dna); 
        String result = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Found sequence: " + result);
        
        //Second Test Case
        dna = "CCAGTCTAA";
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Found sequence: " + result);

        //Third Test Case
        dna = "GCATGCACTAA";
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Found sequence: " + result);      
        
        //Forth Test Case
        dna = "GCATCTTCACG";
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Found sequence: " + result);     
        
        //Fifth Test Case
        dna = "GCATGCACTAA".toLowerCase();
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna, startCodon, stopCodon);
        System.out.println("Found sequence: " + result);   
    }

}

