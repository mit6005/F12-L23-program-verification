public interface FindStrict {
    //@ requires a != null;
    //@ requires (\exists int i; 0 <= i && i < a.length; a[i] == val);
    //@ ensures a[\result] == val;
    public int find(int[] a, int val);
}

class FindA implements FindStrict {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        return a.length;
    }
}

class FindB implements FindStrict {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        return -1;
    }
}

class FindEx implements FindStrict {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        throw new IllegalArgumentException();
    }
}
