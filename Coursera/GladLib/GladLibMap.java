import edu.duke.*;
import java.util.*;

public class GladLibMap {
    private ArrayList<String> usedList;
    private ArrayList<String> usedCategory;
    private Random myRandom;
    private HashMap<String, ArrayList<String>> myMap;
    
    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "datalong";
    
    public GladLibMap(){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }
    
    public GladLibMap(String source){
        myMap = new HashMap<String, ArrayList<String>>();
        initializeFromSource(source);
        myRandom = new Random();
    }
    
    private void initializeFromSource(String source) {
        
        myMap.put("adjectiveList", readIt(source+"/adjective.txt"));
        myMap.put("nounList", readIt(source+"/noun.txt"));
        myMap.put("colorList", readIt(source+"/color.txt"));
        myMap.put("countryList", readIt(source+"/country.txt"));
        myMap.put("nameList", readIt(source+"/name.txt"));
        myMap.put("animalList", readIt(source+"/animal.txt"));
        myMap.put("timeframeList", readIt(source+"/timeframe.txt"));
        myMap.put("verbList", readIt(source+"/verb.txt"));
        myMap.put("fruitList", readIt(source+"/fruit.txt"));
        
        usedList = new ArrayList<String>();
        usedCategory = new ArrayList<String>();
    }
    
    private String randomFrom(ArrayList<String> source){
        int index = myRandom.nextInt(source.size());
        return source.get(index);
    }
    
    private String getSubstitute(String label) {
        String listName = label + "List";
        // System.out.println(listName);
        if (label.equals("number")){
            return ""+myRandom.nextInt(50)+5;
        }
        if (myMap.containsKey(listName)){
            // System.out.println("Yes");
            return randomFrom(myMap.get(listName));
        }
        return "**UNKNOWN**";
    }
    
    private String processWord(String w){
        int first = w.indexOf("<");
        int last = w.indexOf(">",first);
        if (first == -1 || last == -1){
            return w;
        }
        // String prefix = w.substring(0,first);
        // System.out.println("prefix: " + prefix);
        // String suffix = w.substring(last+1);
        // System.out.println("suffix: " + prefix);
        String category = w.substring(first+1,last);

        if ((usedCategory.indexOf(category) == -1) && (!category.equals("number"))){
            usedCategory.add(category);
        }
        String sub = getSubstitute(w.substring(first+1,last));
        
        while (usedList.indexOf(sub) != -1){
            sub = getSubstitute(w.substring(first+1,last));
        }
        
        usedList.add(sub);
        return sub;
    }
    
    private void printOut(String s, int lineWidth){
        int charsWritten = 0;
        for(String w : s.split("\\s+")){
            if (charsWritten + w.length() > lineWidth){
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w+" ");
            charsWritten += w.length() + 1;
        }
    }
    
    private String fromTemplate(String source){
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String word : resource.words()){
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }
    
    private ArrayList<String> readIt(String source){
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        else {
            FileResource resource = new FileResource(source);
            for(String line : resource.lines()){
                list.add(line);
            }
        }
        return list;
    }
    
    public void makeStory(){
        usedList.clear();
        usedCategory.clear();
        System.out.println("\n");
        String story = fromTemplate("data/madtemplate2.txt");
        printOut(story, 60);
        
        int totalWords = totalWordsInMap();
        int totalWordsCategory = totalWordsConsidered();
        System.out.println("Total words: " + totalWords + "; Total words considered " + totalWordsCategory);
    }
    
    private int totalWordsInMap(){
        int totalCount = 0;
        for(String listName : myMap.keySet()){
            totalCount += myMap.get(listName).size();
        }
        return totalCount;
        
    }
    
    private int totalWordsConsidered(){
        int totalCount = 0;
        for(String category : usedCategory){
            String listName = category + "List";
            System.out.println(listName);
            totalCount += myMap.get(listName).size();
            
        }
        return totalCount;
    }

}
