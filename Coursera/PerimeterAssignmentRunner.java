import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int numPoints = 0;
        for (Point currPt : s.getPoints()){
            numPoints = numPoints + 1;
        }
        return numPoints;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double length = getPerimeter(s);
        int numLength = getNumPoints(s);
        
        return length/numLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide){
                largestSide = currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        double largestX = 0.0;
        // Start wth prevPt = the last point 
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double x = currPt.getX();
            if (x > largestX){
                largestX = x;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        double perimeter;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            perimeter = getPerimeter(s);
            if (perimeter > largestPerimeter){
                largestPerimeter = perimeter;
            }
        }
        return largestPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeter = 0.0;
        double perimeter;
        File targetFile = null;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            perimeter = getPerimeter(s);
            if (perimeter > largestPerimeter){
                largestPerimeter = perimeter;
                targetFile = f;
            }
        }
        return targetFile.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("number of points = " + numPoints);
        System.out.println("Average length = " + averageLength);
        System.out.println("Largest Side = " + largestSide);
        System.out.println("Largest X = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        double largestPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("Largest perimeter of all files = " + largestPerimeter);
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        String f = getFileWithLargestPerimeter();
        System.out.println(f);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
