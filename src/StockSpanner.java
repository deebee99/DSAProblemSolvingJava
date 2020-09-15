import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Stack;

public class StockSpanner {
    Stack <Pair<Integer,Integer>> stack;
    public StockSpanner() {
        stack=new Stack<>();
    }

    public int next(int price) {
        int w=1;
        while(!stack.empty() && stack.peek().getKey()>price) {
            w+=stack.pop().getValue();
        }
        stack.push(new Pair<>(price,w));
        return w;
    }
}
