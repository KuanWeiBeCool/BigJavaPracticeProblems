
/**
 * Write a description of WordLength here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class WordLength {
    public void countWordLengths(FileResource resource, int [] counts){
        int length;
        for (String word : resource.words()){
            length = 0;
            for (int index = 0; index < word.length(); index++){
                char currChar = word.charAt(index);
                if ((index == 0) || (index == word.length()-1)){
                    if (Character.isLetter(currChar)){
                        length++;
                    }
                }
                else{
                    length++;
                }  
            }
            if (length > 0){
                counts[length]++;
            }
            if (length >= counts.length){
                counts[counts.length-1]++;
            }
        }
        for (int k=0; k<counts.length; k++){
            if (counts[k] > 0){
                System.out.println(counts[k] + " words of length " + k);
            }
        }
    }
    
    public void testCountWordLengths(){
        FileResource resource = new FileResource();
        int [] counts = new int [31];
        countWordLengths(resource, counts);
        System.out.println(indexOfMax(counts));
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
    
}
