public class Stack implements Container {
    private final Task[] tasks;
    private final int capacity;
    private int size;

    public Stack(int c) {
        this.size = 0;
        this.capacity = c;
        this.tasks = new Task[capacity];
    }

    @Override
    public void push(Task t) {
        if (size < capacity) {
            tasks[size++] = t;
        }
        else {
            System.out.println("Stack is full.");
        }
    }

    @Override
    public Task pop() {
        return isEmpty() ? null : tasks[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Task peek() {
        return isEmpty() ? null : tasks[size];
    }
}
