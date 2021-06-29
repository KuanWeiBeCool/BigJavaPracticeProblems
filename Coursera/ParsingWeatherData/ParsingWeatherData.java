
/**
 * Write a description of ParsingWeatherData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class ParsingWeatherData {
    public CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestTempRow=null;
        double coldestTemp = 10000.0;
        for (CSVRecord record : parser){
            double temp = Double.parseDouble(record.get("TemperatureF"));
            if ((temp < coldestTemp) && (temp != -9999)){
                coldestTemp = temp;
                coldestTempRow = record;
            }
        }
        return coldestTempRow;  
    }
    
    public void fileWithColdestTemperature(){
        DirectoryResource dr = new DirectoryResource();
        File coldestTempFile = null;
        double coldestTemp = 10000.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            double temp = Double.parseDouble(coldestHourInFile(parser).get("TemperatureF"));
            if (temp < coldestTemp) {
                coldestTemp = temp;
                coldestTempFile = f;
            }
        }
        System.out.println("Coldest day was in file " + coldestTempFile.getName());
        System.out.println("Coldest temperature on that day was " + coldestTemp);
        System.out.println("All the temperatures on the coldest day were:");
        FileResource fr = new FileResource(coldestTempFile);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser){
            System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
        }
    }
    
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumidityRow=null;
        double lowestHumidity = 10000.0;
        for (CSVRecord record : parser){
            if (!record.get("Humidity").equals("N/A")){
                double humidity = Double.parseDouble(record.get("Humidity"));
                if ((humidity < lowestHumidity) && (humidity != -9999)){
                    lowestHumidity = humidity;
                    lowestHumidityRow = record;
                }
            }
        }
        return lowestHumidityRow; 
    }
    
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }
    
    public void fileWithLowestHumidity(){
        DirectoryResource dr = new DirectoryResource();
        File lowestHumidityFile = null;
        double lowestHumidity = 10000.0;
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser();
            double humidity = Double.parseDouble(lowestHumidityInFile(parser).get("Humidity"));
            if (humidity < lowestHumidity) {
                lowestHumidity = humidity;
                lowestHumidityFile = f;
            }
        }
        System.out.println("Lowest humidity day was in file " + lowestHumidityFile.getName());
        System.out.println("Lowest humidity on that day was " + lowestHumidity);
        System.out.println("All the humidity on the lowest humidity day were:");
        FileResource fr = new FileResource(lowestHumidityFile);
        CSVParser parser = fr.getCSVParser();
        for (CSVRecord record : parser){
            System.out.println(record.get("DateUTC") + ": " + record.get("Humidity"));
        }
    }
    
    public double averageTemperatureInFile(CSVParser parser){
        double sumTemp = 0.0;
        int count = 0;
        double averageTemp;
        for (CSVRecord record : parser){
            sumTemp = sumTemp + Double.parseDouble(record.get("TemperatureF"));
            count++;
        }
        averageTemp = sumTemp / count;
        return averageTemp;
    }
    
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature is " + averageTemp);
    }
    
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        double sumTemp = 0.0;
        int count = 0;
        double averageTemp;
        for (CSVRecord record : parser){
            double humidity = Double.parseDouble(record.get("Humidity"));
            if ((humidity >= value) && (humidity != -9999)){
                sumTemp = sumTemp + Double.parseDouble(record.get("TemperatureF"));
                count++;
            }
        }
        if (count > 0){
            averageTemp = sumTemp / count;
        }
        else {
            averageTemp = -9999.0;
        }
        return averageTemp;
    }
    
    public void testAverageTemperatureWithHighHumidityInFile(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double averageTemp = averageTemperatureWithHighHumidityInFile(parser, 80);
        if (averageTemp != -9999.0){
            System.out.println("Average temperature when high humidity is " + averageTemp);
        }
        else {  
            System.out.println("No temperatures with that humidity");
        }
    }
}
