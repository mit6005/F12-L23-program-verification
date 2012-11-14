public interface FindExn {
    //@ requires a != null;
    //@ ensures a[\result] == val;
    //@ signals (IllegalArgumentException) !(\exists int i; 0 <= i && i < a.length; a[i] == val);
    public int find(int[] a, int val) throws IllegalArgumentException;
}

class FindEx implements FindExn {
    public int find(int[] a, int val) throws IllegalArgumentException {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        throw new IllegalArgumentException();
    }
}

class FindLoop implements FindExn {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        while(true);
    }
}
