
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
    public int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);
        
        while (currIndex != -1){
            if ((currIndex - startIndex) % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex+1);
            }
        }
        return dna.length();
    }
    
    public String findGene(String dna, int startIndex){
        startIndex = dna.indexOf("ATG", startIndex);
        // System.out.println("startIndex: " + startIndex);
        if (startIndex == -1){
            return "";
        }
        int TAAStopIndex = findStopCodon(dna, startIndex, "TAA");
        int TAGStopIndex = findStopCodon(dna, startIndex, "TAG");
        // System.out.println("TAAStopIndex: " + TAAStopIndex);
        // System.out.println("TAGStopIndex: " + TAGStopIndex);
        if ((TAAStopIndex == dna.length()) & (TAGStopIndex == dna.length())){
            return "";
        }
        int geneLengthTAA = TAAStopIndex - startIndex;
        int geneLengthTAG = TAGStopIndex - startIndex;
        if (geneLengthTAA > geneLengthTAG){
            return dna.substring(startIndex, TAGStopIndex + 3);
        }
        else{
            return dna.substring(startIndex, TAAStopIndex + 3);
        }
    }
    public void testFindStopCodon(){
        // // First case
        // String dna = "xxxyyTAAxTAA";
        // int result = findStopCodon(dna, 0, "TAA");
        // if (result != 9){
            // System.out.println(result);
            // System.out.println("Error case 1");
        // }
        // // Second case
        // dna = "xxxyyyTAAxxxyyyTAA";
        // result = findStopCodon(dna, 0, "TAA");
        // if (result != 6){
            // System.out.println(result);
            // System.out.println("Error case 2");
        // }
        // // Third case
        // dna = "xxxyyyTAATGA";
        // result = findStopCodon(dna, 0, "TGA");
        // if (result != 9){
            // System.out.println(result);
            // System.out.println("Error case 3");
        // }
        // // Forth case
        // dna = "xxxyyyxxTAATGA";
        // result = findStopCodon(dna, 0, "TGA");
        // if (result != 14){
            // System.out.println(result);
            // System.out.println("Error case 4");
        // }
        String dna = "CGATGACTGTAATGTAG";
        int result = findStopCodon(dna, 2, "TAA");
        System.out.println(result);
    }
    
    public void testFindGene(){
        // First Case
        String dna = "TAATAG";
        String gene = findGene(dna, 0);
        System.out.println("First gene found: " + gene);
        
        // Second Case
        dna = "CGATGACTGTAATGTAG";
        gene = findGene(dna, 0);
        System.out.println("Second gene found: " + gene);
        
        // Third Case
        dna = "CGATGACTGTAGTGTAA";
        gene = findGene(dna, 0);
        System.out.println("Third gene found: " + gene);        
        
        // Forth Case
        dna = "CGATGACTTAAGTGTAG";
        gene = findGene(dna, 0);
        System.out.println("Forth gene found: " + gene); 
        
        // Fifth Case
        dna = "CGATGACTTAGGTGTAA";
        gene = findGene(dna, 0);
        System.out.println("Fifth gene found: " + gene); 

        // Sixth Case
        dna = "CGATGACTATACGTGTAG";
        gene = findGene(dna, 0);
        System.out.println("Sixth gene found: " + gene); 
    }
    
    public void printAllGenes(){
        String dna = "CGATGACTGTAGTGTAACATGCACTAGTTAATGTAA";
        int startIndex = 0;
        String gene;
        while (true) {
            gene = findGene(dna, startIndex);
            System.out.println(gene);
            if (gene.isEmpty()){
                break;
            }
            startIndex = dna.indexOf("ATG", startIndex) + gene.length();
        }
        
    }
}
