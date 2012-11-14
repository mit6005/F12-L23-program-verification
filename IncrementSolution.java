class Increment {
    //@ requires a != null;
    //@ ensures \result != null;
    //@ ensures \result.length == a.length;
    //@ ensures (\forall int i; 0 <= i && i < a.length; \result[i] == a[i] + 1);
    public static int[] increment(int[] a) {
        int[] b = new int[a.length];

        for (int j = 0; j < a.length; ++j)
            b[j] = a[j]+1;

        return b;
    }

    //@ requires a != null;
    //@ ensures (\forall int i; 0 <= i && i < a.length; \result[i] == a[i] + 2);
    public static int[] increment2(int[] a) {
        return increment(increment(a));
    }
}
