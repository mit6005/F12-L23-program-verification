class Increment {
    public static int[] increment(int[] a) {
        int[] b = new int[a.length];

        for (int j = 0; j < a.length; ++j)
            b[j] = a[j]+1;

        return b;
    }

    public static int[] increment2(int[] a) {
        return increment(increment(a));
    }
}
