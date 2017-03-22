public interface IExample {
    String message();
    int plusPlus();

    int counter();
    IExample copy(IExample example);
    Ar leak();
}