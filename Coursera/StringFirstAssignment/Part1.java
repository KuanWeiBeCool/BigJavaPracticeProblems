
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public String findSimpleGene(String dna){
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
            return result;
        }
        else {
        return "";
        }
    }
    
    public void testSimpleGene () {
        //First Test Case
        String dna = "ATGCACGCAGTAA";
        System.out.println("Original DNA: " + dna); 
        String result = findSimpleGene(dna);
        System.out.println("Found sequence: " + result);
        
        //Second Test Case
        dna = "CCAGTCTAA";
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna);
        System.out.println("Found sequence: " + result);

        //Third Test Case
        dna = "GCATGCACTAA";
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna);
        System.out.println("Found sequence: " + result);      
        
        //Forth Test Case
        dna = "GCATCTTCACG";
        System.out.println("Original DNA: " + dna); 
        result = findSimpleGene(dna);
        System.out.println("Found sequence: " + result);          
    }

}
