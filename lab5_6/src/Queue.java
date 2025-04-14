public class Queue implements Container {
    private int head;
    private int tail;
    private int size;
    private final int capacity;
    private final Task[] tasks;

    public Queue(int c) {
        this.head = 0; this.tail = 0; this.size = 0; this.capacity = c;
        this.tasks = new Task[capacity];
    }

    @Override
    public void push(Task t) {
        if (size < capacity) {
            tasks[tail] = t;
            tail = (tail + 1) % capacity;
            ++size;
        }
        else {
            System.out.println("Queue is full.");
        }
    }

    public Task pop() {
        if (isEmpty()) {
            return null;
        }
        Task t = tasks[head];
        head = (head + 1) % capacity;
        --size;
        return t;
    }

    @Override
    public Task peek() {
        return isEmpty() ? null : tasks[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
