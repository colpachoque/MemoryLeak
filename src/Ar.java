public class Ar {
    private Ar leak;

    public Ar(Ar leak) {
        this.leak = leak;
    }
}
