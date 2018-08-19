# NOTES

## Java

1. Assuming 2's complement (or that `i` is unsigned), `-i` is equal to `~i+1`.

   `i & (~i + 1)` is a trick to extract the lowest set bit of `i`.

   It works because what +1 actually does is to set the lowest clear bit, and clear all bits lower than that. So the only bit that is set in both `i` and `~i+1` is the lowest set bit from `i` (that is, the lowest clear bit in `~i`). The bits lower than that are clear in `~i+1`, and the bits higher than that are non-equal between `i` and `~i`.

2. Two's complement of x:

   For 32-bit integers:

   ```
   x + ~x = 1111 1111 1111 1111 1111 1111 1111 1111
   x + ~x + 1 =   1111 1111 1111 1111 1111 1111 1111 1111 + 1
              = 1 0000 0000 0000 0000 0000 0000 0000 0000
   ```

   The leftmost `1`-bit will simply be discarded, because it doesn't fit in 32-bits (integer overflow). So,

   ```
   x + ~x + 1 = 0
   -x = ~x + 1
   ```

   So you can see that the negative `x` can be represented by `~x + 1`, which we call the two's complement of `x`.

   