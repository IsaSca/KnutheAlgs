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
          return true;
        }
      } else {
        k = 0;
      }
    }
    return false;
  }
  
  /**
   * Table function required by KMPFind
   * @param w the word.
   * @return A table for the word.
   */
  public int[] table(char[] w) {
    int[] T = new int[w.length];
    T[0] = -1;
    int cnd = 0;
    int pos;
    for (pos = 0; pos < w.length-1; pos++) {
      if (w[pos] == w[cnd]) {
        T[pos] = T[cnd];
      } else {
        T[pos] = cnd;
        cnd = T[cnd];
        while (cnd >= 0 && (w[pos] < w[cnd] || w[pos] > w[cnd])) {
          cnd = T[cnd];
        }
      }
      cnd = cnd+1;
    }
    T[pos] = cnd;
    return T;
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
