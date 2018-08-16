# NOTES

1. In java, Integer.MAX_VALUE is $2^{31}-1$ and Integer.MIN_VALUE is $-2^{31}$
2. In javascript, there is no data type "Integer", instead, all numbers are stored as Number , and:
   * Number.MAX_VALUE is approximately $1.79^{308}$ (or $5^{324}$)
   * Number.MIN_VALUE is approximately $1.79^{-308}$ (or $5^{-324}$)
   * Number.MAX_SAFE_VALUE is $9007199254740991$ (or $2^{53}-1$)
   * Number.MIN_SAFE_VALUE is $-9007199254740991$ (or $-(2^{53}-1)$) 
3. In Python, ```import sys; ``` , then ```sys.maxint``` and ```sys.minint``` can tell you the maximum and minimum of an integer.
4. Using big shifts to double is not as efficient as using multiply in Javascript. (Not true in Java and Python3)