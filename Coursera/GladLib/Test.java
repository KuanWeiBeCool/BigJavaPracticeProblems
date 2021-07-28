
/**
 * Write a description of Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class Test {
    private ArrayList<Integer> testArray;
    public Test(){
        testArray = new ArrayList<Integer>();
    }
    
    public void test(){
        for(int i=0; i < 10; i++){
            testArray.add(i);
        }
        
        for(int num:testArray){
            System.out.println(num);
        }
    }

}
