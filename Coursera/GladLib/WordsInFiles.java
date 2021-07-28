
/**
 * Write a description of WordsInFiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import java.io.*;
public class WordsInFiles {
    private HashMap<String,ArrayList<String>> wordMap;
    
    public WordsInFiles(){
        wordMap = new HashMap<String,ArrayList<String>>();
    }
    
    private void addWordsFromFile(File f){
        FileResource fr = new FileResource(f);
        for (String word : fr.words()){
            if (!wordMap.containsKey(word)){
                wordMap.put(word,new ArrayList<String>());
                wordMap.get(word).add(f.getName());
            }
            else{
                if (wordMap.get(word).indexOf(f.getName())==-1){
                    wordMap.get(word).add(f.getName());
                }
            }
        } 
    }
    
    private void buildWordFileMap(){
        wordMap.clear();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            addWordsFromFile(f);
        }
    }
    
    private int maxNumber(){
        int maxCount = 0;
        for(String word : wordMap.keySet()){
            int count = wordMap.get(word).size();
            if (count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
    
    private ArrayList<String> wordsInNumFiles(int number){
        ArrayList<String> words = new ArrayList<String>();
        for(String word : wordMap.keySet()){
            int count = wordMap.get(word).size();
            if (count == number){
                words.add(word);
            }
        }
        return words;
    }
    
    private void printFilesIn(String word){
        for (String name : wordMap.get(word)){
            System.out.println(name);
        }
        
    }
    
    public void tester(){
        buildWordFileMap();
        int maxCount = maxNumber();
        System.out.println("Max files: " + maxCount);
        System.out.println("The number of words is: ");
        ArrayList<String> words = wordsInNumFiles(maxCount);
        System.out.println(words.size());
        System.out.println("The number of words in four files is: ");
        ArrayList<String> wordsInFour = wordsInNumFiles(4);
        System.out.println(wordsInFour.size());
        printFilesIn("red");
        // for(String word:words){
            // System.out.println(word + " appears in files:");
            // printFilesIn(word);
        // }
    }
}
