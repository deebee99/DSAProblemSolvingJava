import java.util.*;

public class RandomizedCollection {
    private Map<Integer, List<Integer>> hashmap;
    private List<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {
        hashmap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (hashmap.containsKey(val)) {
            hashmap.get(val).add(list.size());
            list.add(val);
            return false;
        }
        hashmap.put(val, new ArrayList<>());
        hashmap.get(val).add(list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (hashmap.containsKey(val)) {
            int loc = hashmap.get(val).get(0);
            if (loc < list.size() - 1) {
                int lastElement = list.get(list.size() - 1);
                list.set(loc, lastElement);
                hashmap.get(lastElement).remove(hashmap.get(lastElement).size() - 1);
                hashmap.get(lastElement).add(loc);
                Collections.sort(hashmap.get(lastElement));
            }
            list.remove(list.size() - 1);
            if (hashmap.get(val).size() == 1)
                hashmap.remove(val);
            else hashmap.get(val).remove(0);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */