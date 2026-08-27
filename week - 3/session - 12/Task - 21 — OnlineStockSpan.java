import java.util.Stack;

public class OnlineStockSpan {

    private Stack<int[]> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() &&
               stack.peek()[0] <= price) {

            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }
}
