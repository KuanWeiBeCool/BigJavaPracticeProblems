
/**
 * Write a description of Part4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class Part4 {
    public void printURL(){
        URLResource urlR = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
        int targetIndex = 0;
        for (String url:urlR.lines()){
            targetIndex = url.toLowerCase().indexOf("youtube.com");
            if (targetIndex != -1){
                int startIndex = url.lastIndexOf("\"", targetIndex);
                int endIndex = url.indexOf("\"", targetIndex);
                System.out.println(url.substring(startIndex+1, endIndex));
            }
        }
    }

}
