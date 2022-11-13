/*
69. Sqrt(x)

Given a non-negative integer x, compute and return the square root of x.

*/

int sqrt0(int x, int l, int r)
{
    int m;
    long sqr;
    if (x < 2)
        return x;
    else if (l > r)
        return r;
    m = (int)((r-l)/2) + l;
    sqr = (long)m * m;

    if (sqr < x)
        return sqrt0(x, m + 1, r);
    else if (sqr > x)
        return sqrt0(x, l, m - 1);
    else
        return m;
    return 0;
}

int mySqrt(int x)
{
    if (x < 2)
        return x;
    
    return sqrt0(x, 2, x/2);
}
