/* James Dinh
 * 03/17/2015
 * Purpose: Explore Regular Expressions
 * Input: None, except possibly File names
 * Output: Number of matches found
 */
public class RegexTester {
  
  public static void main(String[] arg) {
      
    // Match two z's in a row
    System.out.println("Matches for two z's in a row");
    Regex.findPattern("scrabble.txt", "z{2}?", false);
    System.out.println("Expected: 385\n");
    
    // Match two vowels in a row
    System.out.println("Matches for two vowels in a row");
    Regex.findPattern("scrabble.txt", "[aeiou]{2}", false);
    System.out.println("Expected: 63864\n");
    
    // Match 3+ vowels
    System.out.println("Matches for more than 2 vowels in a word");
    Regex.findPattern("scrabble.txt", "[aeiou].*[aieou].*[aieou]", false);
    System.out.println("Expected: 132420\n");
    
    // Match two x's
    System.out.println("Matches for two x's in a word");
    Regex.findPattern("scrabble.txt", "x.*x", false);
    System.out.println("Expected: 16\n");
    
    // Match Q w/o U and write to file
    System.out.println("Matches for all words that start with Q and not followed by a U");
    Regex.findPattern("scrabble.txt.", "\\Aq[^u]", true);
    System.out.println("Expected: 25\n");   
  }
}
