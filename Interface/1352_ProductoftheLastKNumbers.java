/* 1352. Product of the Last K Numbers

Design an algorithm that accepts a stream of integers and retrieves the product of the last k integers of the stream.

Implement the ProductOfNumbers class:

ProductOfNumbers() Initializes the object with an empty stream.
void add(int num) Appends the integer num to the stream.
int getProduct(int k) Returns the product of the last k numbers in the current list. You can assume that always the current list has at least k numbers.
The test cases are generated so that, at any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 */
class ProductOfNumbers 
{
    private List <Integer> L;
    public ProductOfNumbers() 
    {
        L = new ArrayList<>();
        L.add(1);
    }
    
    public void add(int num) 
    {
        int size     = L.size();
        int previous = L.get(size - 1);

        if (num == 0)
        {
            L.clear();
            L.add(1);
        }
        else
            L.add(num * previous);
    }
    
    public int getProduct(int k) 
    {
        int size = L.size();
        if (k >= size)
            return 0;
        return L.get(size - 1) / L.get(size - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
