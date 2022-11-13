/* 50. Pow(x, n)

Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
class Solution 
{
    public double myPow(double x, int n) 
    {
        if (n < 0)
            return myPow(1/x, -n);
        else if (n == 0)
            return 1.0;
        
        if (n % 2 == 0) // even n
            return myPow((x * x), (n / 2));
        else
            return x * myPow((x * x), (n / 2));
    }
}