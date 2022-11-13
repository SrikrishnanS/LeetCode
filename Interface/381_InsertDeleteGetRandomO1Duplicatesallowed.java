/*
381. Insert Delete GetRandom O(1) - Duplicates allowed

RandomizedCollection is a data structure that contains a collection of numbers, possibly duplicates (i.e., a multiset). It should support inserting and removing specific elements and also removing a random element.

Implement the RandomizedCollection class:

RandomizedCollection() Initializes the empty RandomizedCollection object.
bool insert(int val) Inserts an item val into the multiset, even if the item is already present. Returns true if the item is not present, false otherwise.
bool remove(int val) Removes an item val from the multiset if present. Returns true if the item is present, false otherwise. Note that if val has multiple occurrences in the multiset, we only remove one of them.
int getRandom() Returns a random element from the current multiset of elements. The probability of each element being returned is linearly related to the number of same values the multiset contains.
You must implement the functions of the class such that each function works on average O(1) time complexity.

Note: The test cases are generated such that getRandom will only be called if there is at least one item in the RandomizedCollection.

*/

class RandomizedCollection 
{
    private Map<Integer, Set<Integer>> indexMap;
    
    private List<Integer> list;
    
    private Random random;

    public RandomizedCollection() 
    {
        indexMap = new HashMap<Integer, Set<Integer>>();
        list = new ArrayList<Integer>();
        random = new Random();
    }
    
    public boolean insert(int val) 
    {
        boolean absent = !indexMap.containsKey(val);

        list.add(val); // append to list
        indexMap.putIfAbsent(val, new HashSet<Integer>());
        indexMap.get(val).add(list.size() - 1);
        return absent;
    }
    
    public boolean remove(int val) 
    {
        boolean present = indexMap.containsKey(val);
    
        if (present)
        {
            int rmIndex = indexMap.get(val).iterator().next();
            
            int lastIndex = list.size() - 1;
            int lastVal = list.get(lastIndex);
            
            list.set(rmIndex, lastVal);
            list.remove(lastIndex);
            indexMap.get(val).remove(rmIndex);
            indexMap.get(lastVal).add(rmIndex);
            indexMap.get(lastVal).remove(lastIndex);      
            
            if (indexMap.get(val).isEmpty())
                indexMap.remove(val);
        }
        return present;
    }
    
    public int getRandom() 
    {
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
