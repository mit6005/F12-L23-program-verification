public interface Find {
    // Return the index of val within a.
    public int find(int[] a, int val);
}

class FindA implements Find {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        return a.length;
    }
}

class FindB implements Find {
    public int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        return -1;
    }
}

class FindEx implements Find {
    public int find(int[] a, int val) throws IllegalArgumentException {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) return i;
        }

        throw new IllegalArgumentException();
    }
}
