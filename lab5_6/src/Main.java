public class Main {
    public static void main(String[] args) {
        // Exercise 1
        // a)
        System.out.println("a. OutTask");
        OutTask out = new OutTask("This is a message");
        out.executeTask();
        out.executeTask();
        System.out.println();

        // b)
        System.out.println("b. RandomOutTask");
        RandomOutTask rout1 = new RandomOutTask(100);
        rout1.executeTask();
        RandomOutTask rout2 = new RandomOutTask(1, 10);
        rout2.executeTask();
        System.out.println();

        // c)
        System.out.println("c. CounterOutTask");
        CounterOutTask cout = new CounterOutTask();
        cout.executeTask();
        cout.executeTask();
        cout.executeTask();
        cout.executeTask();
        System.out.println();


        // Exercise 2
        // a)
        Stack s = new Stack(3);
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
        System.out.println(s.peek());
        s.push(cout);
        s.push(rout1);
        s.push(rout2);
        s.push(out);
        while (!s.isEmpty()) {
            Task t = s.pop();
            t.executeTask();
        }
        System.out.println();

        // b)
        Queue q = new Queue(3);
        System.out.println(q.pop());
        System.out.println(q.isEmpty());
        System.out.println(q.peek());
        q.push(rout2);
        q.push(out);
        q.push(cout);
        q.push(rout1);
        while (!q.isEmpty()) {
            Task t = q.pop();
            t.executeTask();
        }
    }
}