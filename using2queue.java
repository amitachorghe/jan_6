import java.util.*;
//import java.util.Stack;
import java.util.LinkedList;

class using2queue {
    Queue<Integer> q1 = new LinkedList<Integer>(), q2 = new LinkedList<Integer>();
    int curr_size;

    public int Stack() {
        curr_size = 0;
        return 0;
    }

    void remove() {
        if (q1.isEmpty())
            return;

        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        q1.remove();
        curr_size--;

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    void add(int x) {
        q1.add(x);
        curr_size++;
    }

    int top() {
        if (q1.isEmpty())
            return -1;

        while (q1.size() != 1) {
            q2.add(q1.peek());
            q1.remove();
        }

        int temp = q1.peek();

        q1.remove();

        q2.add(temp);

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
        return temp;
    }

    int size() {
        return curr_size;
    }

    public static void main(String[] args) {
        using2queue s = new using2queue();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.add(6);
        s.add(7);
        s.add(8);

        System.out.println("Now size: " + s.size());
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        System.out.println(" Now size: " + s.size());
    }
}