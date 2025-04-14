public interface Container {
    void push(Task t);

    Task pop();

    Task peek();

    boolean isEmpty();
}
