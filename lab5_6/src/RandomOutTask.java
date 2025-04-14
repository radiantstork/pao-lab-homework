import java.util.Random;

public class RandomOutTask implements Task {
    private final int number;

    RandomOutTask(int limit) {
        this.number = new Random().nextInt(limit);
    }

    RandomOutTask(int inf, int sup) {
        this.number = new Random().nextInt(inf, sup);
    }

    @Override
    public void executeTask() {
        System.out.println(number);
    }
}
