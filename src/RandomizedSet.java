import java.util.*;

class RandomizedSet {
    private Map<Integer,Integer> hashmap;
    private List<Integer> list;
    private Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashmap=new HashMap<>();
        list =new ArrayList<>();
        random=new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hashmap.containsKey(val)) return false;
        hashmap.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    if(hashmap.containsKey(val)){
        int loc=hashmap.get(val);
        if(loc<list.size()-1){
            int lastElement= list.get(list.size()-1);
            list.set(loc,lastElement);
            hashmap.put(lastElement,loc);
        }
        list.remove(list.size()-1);
        hashmap.remove(val);
        return true;
    }
    return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
    return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */