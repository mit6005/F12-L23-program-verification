public interface FindDefault {
    /*@ requires a != null;
      ensures (\result != -1 && a[\result] == val)
      || (\result == -1 && !(\exists int i; 0 <= i && i < a.length; a[i] == val)); */
    public int find(int[] a, int val);
}

class FindA implements FindDefault {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        return a.length;
    }
}

class FindB implements FindDefault {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        return -1;
    }
}
