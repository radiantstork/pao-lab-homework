public class OutTask implements Task {
    private final String message;

    public OutTask(String message) {
        this.message = message;
    }

    @Override
    public void executeTask() {
        System.out.println(message);
    }
}
