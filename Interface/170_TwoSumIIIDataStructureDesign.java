/*
170. Two Sum III - Data structure design

Design a data structure that accepts a stream of integers and checks if it has a pair of integers that sum up to a particular value.

Implement the TwoSum class:

TwoSum() Initializes the TwoSum object, with an empty array initially.
void add(int number) Adds number to the data structure.
boolean find(int value) Returns true if there exists any pair of numbers whose sum is equal to value, otherwise, it returns false.

*/

class TwoSum
{
    private Map<Integer, Integer> map;
    public TwoSum()
    {
        map = new HashMap<Integer, Integer>();
    }

    public void add(int number)
    {
        map.put(number, map.getOrDefault(number, 0) + 1);
    }

    public boolean find(int sum)
    {
        for (int num : map.keySet())
        {
            int delta = sum - num;

            if ((delta == num && map.getOrDefault(num, 0) >= 2) ||
                (delta != num && map.containsKey(delta)))
               return true;
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(sum);
 */
