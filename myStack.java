import java.util.Stack;

public class myStack {

    int min = -1;
    static int demoVal = 9999;
    Stack<Integer> st = new Stack<Integer>();

    void getMin() {
        System.out.println("min is : " + min);
    }

    void push(int val) {

        if (st.isEmpty() || val < min) {
            min = val;
        }

        st.push(val * demoVal + min);

        System.out.println("pushed : " + val);
    }

    int pop() {
        if (st.isEmpty()) {
            System.out.println("stack underflow");
            return -1;
        }

        int val = st.pop();

        if (!st.isEmpty())

            min = st.peek() % demoVal;
        else
            min = -1;
        System.out.println("popped : " + val / demoVal);
        return val / demoVal;
    }

    int peek() {
        return st.peek() / demoVal;
    }

    public static void main(String[] args) {
        myStack m = new myStack();

        int[] arr = { 5, 3, 1, 9, 8, 1, 21, 32, 11 };

        for (int i = 0; i < arr.length; i++) {
            m.push(arr[i]);
            m.getMin();
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            m.pop();
            m.getMin();
        }
    }
}