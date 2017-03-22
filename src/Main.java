public class Main {
    private static IExample example1;
    private static IExample example2;

    public static void main(String[] args) throws InterruptedException {
        example1 = ExampleFactory.newInstance();
        System.out.println(Runtime.getRuntime().totalMemory());

        while (true) {
            System.out.println(Runtime.getRuntime().freeMemory());
            example2 = ExampleFactory.newInstance().copy(example2);

            System.out.println("1) " +
                    example1.message() + " = " + example1.plusPlus());
            System.out.println("2) " +
                    example2.message() + " = " + example2.plusPlus());
            System.out.println();

            Thread.currentThread().sleep(2000);
        }
    }
}

