# NOTES

## Java

1. Java 2D array initialization:

   ```java
   // Type 1: all elements are initialized to 0
   int[][] multi = new int[5][10];
   
   // Type 2
   int[][] multi = new int[5][];
   multi[0] = new int[10];
   multi[1] = new int[10];
   multi[2] = new int[10];
   multi[3] = new int[10];
   multi[4] = new int[10];
   
   // Type 3
   int[][] multi = new int[][]{
     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
     { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
   };
   ```

2. Java HashSet:

   ```java
   // Constructors
   // Default initial capacity is 16 and default load factor is 0.75.
   HashSet h = new HashSet(); 
   HashSet h = new HashSet(int initialCapacity);
   HashSet h = new HashSet(int initialCapacity, float loadFactor);
   HashSet h = new HashSet(Collection C);
   
   // Example
   import java.util.*;
    
   class Test
   {
       public static void main(String[]args)
       {
           HashSet<String> h = new HashSet<String>();
    
           // Adding elements into HashSet usind add()
           h.add("India");
           h.add("Australia");
           h.add("South Africa");
           h.add("India");// adding duplicate elements
    
           // Displaying the HashSet
           System.out.println(h);
           System.out.println("List contains India or not:" +
                              h.contains("India"));
    
           // Removing items from HashSet using remove()
           h.remove("Australia");
           System.out.println("List after removing Australia:" + h);
    
           // Iterating over hash set items
           System.out.println("Iterating over list:");
           Iterator<String> i = h.iterator();
           while (i.hasNext())
               System.out.println(i.next());
       }
   }
   
   // Methods:
   /**
   1. boolean add(E e): Used to add the specified element if it is not present, if it is present then return false.
   2. void clear(): Used to remove all the elements from set.
   3. boolean contains(Object o): Used to return true if an element is present in set.
   4. boolean remove(Object o): Used to remove the element if it is present in set.
   5. Iterator iterator(): Used to return an iterator over the element in the set.
   6. boolean isEmpty(): Used to check whether the set is empty or not. Returns true for empty and false for non-empty condition for set.
   7. int size(): Used to return the size of the set.
   8. Object clone(): Used to create a shallow copy of the set. (Elements themselves are not copied)
   */
   ```

3. If a statement is too long

   ```java
   if ((condition1 && condition2)
           || (condition3 && condition4)
           ||!(condition5 && condition6)) {
       doSomethingAboutIt();
   } 
   ```

4. In java, int is 32-bit

5. The size of an array can be accessed by ```arr.length```

