/* James Dinh
 * 03/17/2015
 * Purpose: Explore Regular Expressions
 * Input: None, except possibly File names
 * Output: Number of matches found
 */
import java.io.*;
import java.util.regex.*;
import java.util.Scanner;

public class Regex {
  
  // static variables
  private static Scanner reader;
  private static File inFile;
  private static PrintWriter writer;
  private static File outFile;

  // Finds specified pattern in specified File
  // The boolean determines whether the results will be written to a file
  public static void findPattern(String inFileName, String inPattern, boolean fileWrite) {
    inFile = new File(inFileName);
    Pattern patt = Pattern.compile(inPattern);

    // If output File needs to be created prompt user for the name
    if (fileWrite) {
      outFile = new File("Regex Test File.txt");  
    }
    
    try {    
      // Initialize Scanner and PrintWriter (if necessary)
      reader = new Scanner(inFile);
      if (fileWrite)
        writer = new PrintWriter(outFile);
      // Declare local variables
      String token;
      Matcher match;
      int counter = 0;
           
      // While the file has tokens, continue reading form file
      while (reader.hasNext()) {       
        // Read in, the next token and set the Matcher to that String
        token = reader.next();
        match = patt.matcher(token);
        
        // The "if" prevents possible double-counting
        if (match.find()) {
          counter++; // keeps track of # of matches
          // If output File is created, write matches to that file
          if (fileWrite)
            writer.println(token);
        }
      }
      // Display total number of matches
      System.out.println("Number of matches found: " + counter);
    }
    catch (FileNotFoundException fnfe) {
      System.out.println("File not found.");
    }
    finally {
      reader.close();
      if (writer != null)
        writer.close();
    }
  }
}
