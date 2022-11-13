/* 1570. Dot Product of Two Sparse Vectors

Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?
 */
class SparseVector 
{
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int length;
    SparseVector(int[] nums) 
    {
        this.length = nums.length;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] != 0)
                this.map.put(i, nums[i]); // do not store 0s.
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) 
    {
        int sum = 0;        
        for (int i : vec.map.keySet())
            if (this.map.containsKey(i))
                sum += this.map.get(i) * vec.map.get(i);
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);