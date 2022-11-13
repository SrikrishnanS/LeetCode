/*
380. Insert Delete GetRandom O(1)

Implement the RandomizedSet class:

RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.

*/

class RandomizedSet 
{
    private List<Integer> L;
    private Map<Integer, Integer>  M;
    
    
    public RandomizedSet() 
    {
        L = new ArrayList<Integer>();
        M = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) 
    {
        if (M.containsKey(val))
            return false;
        
        L.add(val); // append
        M.put(val, L.size() - 1); // val -> last index
        return true;
    }
    
    public boolean remove(int val) 
    {
        if (!M.containsKey(val))
            return false;
        
        // replace last element in the hole vacated by val
        int hole = M.get(val);
        int newVal = L.get(L.size() - 1);
        
        L.set(hole, newVal);
        M.put(newVal, hole);
    
        L.remove(L.size() - 1);
        M.remove(val);
        return true;
    }
    
    public int getRandom() 
    {
        return L.get(new Random().nextInt(L.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
