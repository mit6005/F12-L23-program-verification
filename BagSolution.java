// This file comes from a tutorial by the ESC/Java2 team at ETAPS 2009.

class Bag0 {
  int[] a;
  int n;

  //@invariant a != null;
  //@invariant n <= a.length;

  //@requires input != null;
  Bag0(int[] input) {
    n = input.length;
    a = new int[n];
    System.arraycopy(input, 0, a, 0, n);
  }

  //@requires n > 0;
  int extractMin() {
    int m = Integer.MAX_VALUE;
    int mindex = 0;
    
    for (int i = 0; i < n; i++) {
      if (a[i] < m) {
        mindex = i;
        m = a[i];
      }
    }
    n--;
    a[mindex] = a[n];
    return m;
  }
}
