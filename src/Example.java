public class Example implements IExample {
    private int counter;
    private Ar leak;

    private static final long[] cache = new long[1000000];

    public String message() {
        return "Version 2";
    }

    public int plusPlus() {
        return counter++;
    }

    public int counter() {
        return counter;
    }

    public Ar leak() {
        return new Ar(leak);
    }

    public IExample copy(IExample example) {
        if (example != null) {
            counter = example.counter();
            leak = example.leak();
        }
        return this;
    }
}
