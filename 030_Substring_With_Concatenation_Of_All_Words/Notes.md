# NOTES

1. In Python3, hash(object) 
   * The hash() method takes a single parameter:
     - **object** - the object whose hash value is to be returned (integer, string, float, tuple or object)
   * hash() cannot get the hash value of immutable objects except for tuple
   * hash(100) will return 100, which is true for all integers
   * When the parameter is an obeject, the hash value is not only related to the contents of that object but also its id(), in other words, the address of the object.
2. ```for char in "string" : ...``` works in python
3. In javascript, to judge whether an array is empty, use ```arr.length == 0``` instead of ```arr == []```
4. In javascript, use ```of``` to loop through a list instead of ```in```
5. In java, if you want to judge whether two strings equal, use ```str1.equals(str2)``` instead of ```str1 == str2```
6. In java, HashMap has get(key), getOrDefault(key, default), put(key, value), replace(key, value) and clear().