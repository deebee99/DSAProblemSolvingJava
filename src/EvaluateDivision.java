import javafx.util.Pair;
import java.util.*;

public class EvaluateDivision {
    Map<String, List<Pair<String, Double>>> adjacencyList;

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        adjacencyList = new HashMap<>();
        double[] ans = new double[queries.size()];
        int n = equations.size();
        for (int i = 0; i < n; i++) {
            final String key = equations.get(i).get(0);
            final String value = equations.get(i).get(1);
            if (!adjacencyList.containsKey(key)) adjacencyList.put(key, new ArrayList<>());
            adjacencyList.get(key).add(new Pair<>(value, values[i]));

            if (!adjacencyList.containsKey(value)) adjacencyList.put(value, new ArrayList<>());
            adjacencyList.get(value).add(new Pair<>(key, (double) 1 / values[i]));

        }
        int k = 0;
        for (List<String> query : queries) {
            ans[k++] = dfs(query.get(0), query.get(1));
        }
        return ans;
    }

    private double dfs(String s, String d) {
        Stack<Pair<String, Double>> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add(s);
        stack.add(new Pair<>(s, 1.0));
        if (s.equals(d) && adjacencyList.containsKey(s)) return 1;
        while (!stack.isEmpty()) {
            String cur = stack.peek().getKey();
            Double value = stack.peek().getValue();
            stack.pop();

            List<Pair<String, Double>> tempList = adjacencyList.get(cur);
            if (tempList == null) continue;
            for (Pair<String, Double> stringDoublePair : tempList) {
                if (!set.contains(stringDoublePair.getKey())) {
                    final double valueSoFar = value * stringDoublePair.getValue();
                    if (stringDoublePair.getKey().equals(d)) return valueSoFar;
                    stack.push(new Pair<>(stringDoublePair.getKey(), valueSoFar));
                    set.add(stringDoublePair.getKey());
                }
            }
        }
        return -1.0;
    }
}