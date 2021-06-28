
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
public class Part1 {
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        // String countryInformartion = countryInfo(parser, "Nauru");
        // System.out.println(countryInformartion);
        
        // listExportersTwoProducts(parser, "gold", "diamonds");
        
        int numOfGoldExporters = numberOfExporters(parser, "sugar");
        System.out.println(numOfGoldExporters);
        
        // bigExporters(parser, "$999,999,999,999");
    }
    
    public String countryInfo(CSVParser parser, String country){
        System.out.println(country);
        for (CSVRecord record : parser){
            String theCountry = record.get("Country");
            if (theCountry.equals(country)) {
                String export = record.get("Exports");
                String value = record.get("Value (dollars)");
                return country + ": " + export + ": " + value;
            }            
        }
        return "NOT FOUND";
    }
    
    public void listExportersTwoProducts(CSVParser parser, String exportitem1, String exportitem2){
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if (export.contains(exportitem1) && export.contains(exportitem2)) {
                String country = record.get("Country");
                System.out.println(country);
            }            
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportitem){
        int count = 0;
        for (CSVRecord record : parser){
            String export = record.get("Exports");
            if (export.contains(exportitem)) {
                count++;
            }            
        }
        return count;
    }
    
    public void bigExporters(CSVParser parser, String amount){
        int amountLength = amount.length();
        for (CSVRecord record : parser){
            String amountPerCountry = record.get("Value (dollars)");
            String country = record.get("Country");
            if (amountPerCountry.length() > amountLength){
                System.out.println(country + " " + amountPerCountry);
            }
        }
    }

}
