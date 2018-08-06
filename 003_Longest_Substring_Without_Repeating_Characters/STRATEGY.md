# My Strategy

### Algorithm:

1. At the beginning, let maxLength = 0, substring = "".
2. Then put the first character of the given string into substring, and so far maxLength = 1.
3. Next, append next character in the given string into substring, if any character in the previous substring is the same as the appended character, delete charaters from the beginning of the substring to that character inclusively. For example, if we append 'a' to the substring so that it becomes "bcada", then we deleter character from the beginning 'b' to the first repeated character 'a', which makes substring = "da".
4. Compare the length of the current substring with maxLength, if it is larger, then update maxLength.
5. Repeat Step 3 and Step 4 until the end of the given string is reached.

