
/**
 * Write a description of CodonCount here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
public class CodonCount {
    private HashMap<String,Integer> codonCount;
    
    public CodonCount(){
        codonCount = new HashMap<String,Integer>();
    }
    
    private void buildCodonMap(int start,String dna){
        codonCount.clear();
        String codon;
        for (int i=start; i<=dna.length()-3; i+=3){
            codon = dna.substring(i, i+3);
            if (!codonCount.containsKey(codon)){
                codonCount.put(codon,1);
            }
            else{
                codonCount.put(codon,codonCount.get(codon)+1);
            }
        }
    }
    
    private String getMostCommonCodon(){
        int maxCount = 0;
        String maxCodon = "";
        for (String codon : codonCount.keySet()){
            if (codonCount.get(codon) > maxCount){
                maxCount = codonCount.get(codon);
                maxCodon = codon;
            }
        }
        return maxCodon;
    }
    
    private void printCodonCounts(int start,int end){
        for (String codon : codonCount.keySet()){
            int count = codonCount.get(codon);
            if ((count >= start) && (count <= end)){
                System.out.println(codon + " : " + count);
            }
        }
    }
    
    public void tester(){
        // FileResource resource = new FileResource();
        String dna = "ATTAATACTTTGTTTAACAGTAATTATTCAACTATTAAATATTTAAATAATTAAGTTATTAAACTATTAAGTACAGGGCCTGTATCTCTGATGCTGAACTATGATGTGTGACTTAAGCCCCCAAATACATCATGTTATTTGGATCCAAGGTGCTGCACAGAACGCTGACCCTCTCTAAGAGCTGGGTATTACT";
        for (int i=0; i<3; i++){
            buildCodonMap(i,dna);
            System.out.println("Starting at " + i + ": ");
            System.out.println("Total number of unique codons: " + codonCount.size());
            String maxCodon = getMostCommonCodon();
            int maxCount = codonCount.get(maxCodon);
            System.out.println("Most common codon: " + maxCodon + "; Count: " + maxCount);
            int start = 4;
            int end = 4;
            System.out.println("Counts of codons between 1 and 5 inclusive are:");
            printCodonCounts(start, end);
        }
    }
}