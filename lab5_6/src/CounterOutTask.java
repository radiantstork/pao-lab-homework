public class CounterOutTask implements Task {
    private static int counter = 0;

    @Override
    public void executeTask() {
        ++counter;
        System.out.println(counter);
    }
}
