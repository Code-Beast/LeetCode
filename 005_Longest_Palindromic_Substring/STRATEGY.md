# 005. Longest Palindromic Substring

Understanding:

1. Two kinds of Palindrome: "adda" or "ada"
2. For character of each position, check whether if it is in the middle of a Palindrome and record the longest one.



Steps:

1. longestPal = "", idxRight = 0, idxLeft = 0

2. For character of each position i:

   (1) Check whether if it is in the middle of a Palindrome like "ada":

   ​	<1> Set length = 1, idxLeft = i - 1, idxRight = i + 1, check whether str[i - 1] == str[i + 1] : if so, length += 2 and go to <2>; else, go to <3>;

   ​	<2> idxLeft --, idxRight ++, check whether str[idxLeft] == str[idxRight]: if so, length += 2 and go to <2>; else, go to <3>;

   ​	<3> update longestPal

   (2) Check whether if it is in the middle of a Palindrome like "adda":

   ​	<1> Set length = 0, idxLeft = i, idxRight = i + 1, check whether str[i] == str[i + 1] : if so, length += 2 and go to <2>; else, go to 3;

   ​	<2> idxLeft --, idxRight ++, check whether str[idxLeft] == str[idxRight]: if so, length += 2 and go to <2>; else, go to <3>;

   ​	<3> update longestPal

3. Return longestPal