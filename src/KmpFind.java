public class KmpFind {
  
  /**
   * Find a word in a string.
   * @param s the string to search
   * @param w the word to find in the string.
   * @return Returns true or false.
   */
  public boolean find(String s, String w) {
    int k = 0;
    char[] sc = s.toCharArray();
    char[] ws = w.toCharArray();
    for (char c : sc) {
      if (ws[k] == c) {
        k++;
        if (k == ws.length) {
          System.out.println("Word is in string.");
          return true;
        }
      } else {
        k = 0;
      }
    }
    System.out.println("Word is not in string.");
    return false;
  }
  
  /**
   * Testing driver code.
   * @param args User arguments.
   */
  public static void main(String[] args) {
    KmpFind kmpfind= new KmpFind();
    if (kmpfind.find("TestMe", "Test")) {
      System.out.println("Found.");
    } else {
      System.out.println("Not found.");
    }
  }
}
