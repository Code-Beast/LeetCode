| Differences             | Python3 list<br>====================================================== | Python3 tuple (Cannot_Change)<br>=================================================== | Python3  set (Unordered & No Repeat)<br>================================================= | Javascript Array<br>================================================ | Java Array<br>===================================================== |
| ----------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Data Type               | Different                                                    | Different                                                    |                                                              | Different                                                    | Same                                                         |
| Creation                | myList = ['physics', 'chemistry', 1997, 2000]                | tup1 = ('physics', 'chemistry', 1997, 2000)<br>tup2 = (1, 2, 3, 4, 5 )<br>tup1 = (50,)<br>tup3 = "a", "b", "c", "d" | // Method1<br>mySet =  {1, 2, 3, 4, 5, 'element'};<br>// Method2<br>mySetFromStr = set("abc123") // {'a', 'b', 'c', '1', '2', '3'}<br> | // Method 1<br>var myCars=new Array();  myCars[0]="Saab";        myCars[1]="Volvo"; myCars[2]="BMW";<br>//Method 2<br>var myCars=new Array("Saab","Volvo","BMW");<br>//Method 3<br>var myCars=["Saab","Volvo","BMW"]; | // Declaration<br>int[] arr;<br>int arr[];<br>// Initialization<br>arr = new int[8];<br>int[] arr = {1, 2, 3} |
| Index                   | myList[0] # 'physics'                                        | tup1[0] # cannot change                                      | #                                                            | myCars[0]                                                    | arr[0]                                                       |
| Slicing                 | myList[1 : 3] # ['chemistry', 1997]<br>myList[2 :] # [1997, 2000]<br>myList[: 2] # ['physics', 'chemistry']<br>myList[1 : -1] # ['chemistry', 1997] | tup2[1 : 5]                                                  | #                                                            | myCars.slice(1, 3) // ["Volvo", "BMW"]                       | int[] newArr = Arrays.copyOfRange(arr, 1, 3);                |
| Inversion               | invertedList = myList[:: -1]<br>myList.reverse() # list changed | tup2[:: -1]                                                  | #                                                            | myCars.reverse() // myCars changed                           | // fixed length, new array                                   |
| Addition                | myList.append(10)                                            | tup1 + (2)                                                   | mySet.add(1)<br>mySet.update([1, 2, 'a'])<br>mySet.update({1, 2, 'a'})<br>mySet.update((1, 2, 'a'))<br>mySet.update("abc")<br>mySet.update({"abc", "acd"}) | newLength = myCars.push(1, 2, 3, 4)                          | // fixed length, new array                                   |
| Empty Array             | myList = []                                                  | tup1 = ()                                                    | emptySet = set();                                            | var emptyArr1 = [];<br>var emptyArr2 = new Array();          | arr = new int[0] // empty array<br>arr = null // empty reference |
| Printing                | print(myList)                                                | print(tup1)                                                  | print(mySet);                                                | // use iteration                                             | // use iteration                                             |
| Deletion                | delete myList[2] # ['physics', 'chemistry', 2000]<br>myList.pop(2) | del tup1 # delete the whole tuple                            | mySet.remove(1) # If no 1, throw error<br>mySet.discard(1) # If no 1, no error<br>mySet.pop() # delete randomly | delete myCars[0] // replace with undefined (length and index will not update)<br>myCars.splice(1, 2) // delete 2 elements from position 1 and update index and length | // fixed length, new array                                   |
| Length                  | len(myList)                                                  | len(tup1)                                                    | len(mySet)                                                   | myCars.length                                                | arr.length                                                   |
| Concatenation           | list1 + list2<br>list1.extend(list2)                         | tup1 + tup2                                                  | a = set('abracadabra') <br> b = set('alacazam') <br> a - b #  {'r', 'd', 'b'}<br> a \| b #  {'a', 'c', 'r', 'd', 'b', 'm', 'z', 'l'}<br> a & b #  {'a', 'c'}<br> a ^ b #  {'r', 'd', 'b', 'm', 'z', 'l'} | myCars.concat([1, 2], [2, 3]);                               | // fixed length, new array                                   |
| Repeating               | myList * 4                                                   | ('Hi!',) * 4                                                 | #                                                            | // use iteration                                             | // use iteration                                             |
| Iteration               | for x in myList: <br>    print(x)<br>for i in range(len(myList)):<br>    print(myList[i])<br>for i, x in enumerate(myList):<br>    print(x) | for x in (1, 2, 3): print(x)<br>for i in range(len(tup1)) : print(tup1[i])<br>for i, x in enumerate(tup1): print(x) | for i, x in enumerate(mySet): print(x)<br>for x in mySet: print(x)<br> | for (let car in myCars) {<br>    console.log(car);<br>}<br>for (let i = 0; i < myCars.length; i ++){<br>    console.log(myCars[i]);<br>}<br> | for (int i = 0; i < arr.length; i ++) { <br>    System.out.println(arr[i]); <br>}<br>for (int element: arr) { <br>    System.out.println(element);<br>} |
| Max Element             | max(myList)                                                  | max(tup1)                                                    | max(mySet)                                                   | Math.max.apply(null, myCars)<br>Math.max(...arr)             | Arrays.sort(arr);<br>arr[arr.length-1]                       |
| Min Element             | min(myList)                                                  | min(tup1)                                                    | min(mySet)                                                   | Math.min.apply(null, myCars)<br>Math.min( ...arr )           | Arrays.sort(arr);<br>arr[0]                                  |
| First Appearance        | myList.index('chemistry') # 1                                | tup1.index(1997)                                             | #                                                            | myCars. indexOf("Volvo")                                     | java.util.Arrays.binarySearch(arr, 7)                        |
| Insertion               | myList.insert(0, 'chemistry');                               | #                                                            | #                                                            | myCars.splice(2, 0, 'May', 'haha');                          | // fixed length, new array                                   |
| Pop                     | popped = myList.pop() # delete last element<br>myList.pop(1) // delete element at postion 1 | #                                                            | #                                                            | popped = myCars.pop()                                        | // fixed length, new array                                   |
| Counting                | myList.count('chemistry') # 1                                | tup1.count(1997)                                             | #                                                            | myCars.filter(function(x) {<br>    return x==="Volvo"<br>}).length | // use iteration                                             |
| Remove First Appearance | myList.remove('chemistry')                                   | #                                                            | #                                                            | //                                                           | // fixed length, new array                                   |
| Sorting                 | myList.sort() # ascending<br>myList.sort(reverse = True) # descending<br>def takeSecond(elem):<br>    return elem[1]<br>myList.sort(key = takeSecond) # according to the second element<br>sorted(myList) # new list<br>sorted(myList, reverse = True) # new list<br>sorted(myList, key = takeSecond) # new list | tup1.sort() # ascending<br>tup1.sort(reverse = True) # descending<br>def takeSecond(elem):<br>    return elem[1]<br>tup1.sort(key = takeSecond) # according to the second element<br>sorted(tup1) # new list<br>sorted(tup1, reverse = True) # new list<br>sorted(tup1, key = takeSecond) # new list | #                                                            | myCars.sort() // Ascending<br>var points = [40,100,1,5,25,10];<br>points.sort(function(a,b){return a-b}); //  1,5,10,25,40,100 | Arrays.sort(arr); // arr changed<br>Arrays.sort(arr, 0, 3); // sort position 0, 1, 2<br>Comparator cmp = new MyComparator();<br>Arrays.sort(arr, cmp);<br>class MyComparator implements Comparator<Integer>{  <br>    @Override<br>    public int compare(Integer o1, Integer o2) { <br>        if(o1 < o2) {  return1;} <br>        else if(o1 > o2) { return -1;}<br>        else { return0;} <br>    } <br>} |
| New Method              | #                                                            | #                                                            | #                                                            | Array.prototype.myUcase=function() { <br>    for (i=0;i<this.length;i++) {<br>        this[i]=this[i].toUpperCase();<br>    } <br>} | //                                                           |
| Fill With X             | #                                                            | #                                                            | #                                                            | myCars.fill("fill_content");                                 | java.util.Arrays.fill(arr, 1)                                |
| Copy                    | #                                                            | #                                                            | #                                                            | myCars.copyWithin(1,1,2); // ["Saab","Volvo","BMW"]          | //                                                           |
| If Contain              | 'chemistry' in myList # True                                 | 'chemistry' in tup1 # True                                   | 1 in mySet # True                                            | myCars.includes("Saab") // true                              | java.util.Arrays.asList(arr).contains(1)                     |
| Is "Object"             | type(myList) is list                                         | type(tup1) is tuple                                          | type(mySet) is set                                           | Array.isArray(myCars) // true                                | // Method 1<br>public static boolean isArray(Object obj) { <br>    if (null == obj) {<br>        return false;<br>    }<br>    obj.getClass().isArray(); <br>}<br>// Method 2<br>arr instanceof int[] |
| toString                | ";".join(str(i) for i in myList; # 'physics; chemistry;1997;2000' | ";".join(str(i) for i in tup2) # '1;2;3;4'                   | ";".join(str(i) for i in mySet) # '1;2;a'                    | myCars.join() // "Saab,Volvo,BMW"<br>myCars.join(";") // "Saab;Volvo;BMW"<br>myCars.toString() // "Saab,Volvo,BMW" | Arrays.toString(arr)                                         |
| Last Appearance         | len(list) - list[:: -1].index(1997) - 1                      | len(tup1) - tup1[:: -1].index(1997) - 1                      | #                                                            | myCars.lastIndexOf("Saab")                                   | //                                                           |
| Pop First Element       | #                                                            | #                                                            | #                                                            | firstElement = myCars.shift();                               | //                                                           |
| Add from Front          | myList.insert(0, 'newFront');<br>myList = ['newFront'] + myList; | #                                                            | #                                                            | newLength = myCars.unshift(1, 2, 3, 4);                      | //                                                           |



# Supplementary Materials:

## Python3

### list

1. myList.clear() # clear the whole list to []

2. myList2 = myList1.copy() # return a copy of myList1 # myList2 = myList1[:] can do the same trick

3. a = myList, if you change elements in a, myList will also be altered.

4. a = [x for x in 'abracadabra' if x not in 'abc'] # ['r', 'd', 'r']

5. 2D list: list_2d = [ [0 for i in range(5)] for i in range(5)]

6. myList[start: end: span]

   ```python
   >>> l = [i for i in range(0,15)]
   >>> print(l[::2])
   [0, 2, 4, 6, 8, 10, 12, 14]
   ```

7. Create an empty list with length 10: ``` list_empty = [None]*10```. 

### tuple

1. a = tuple(x for x in 'abracadabra' if x not in 'abc') # ('r', 'd', 'r')

2. When an element of tuple is a mutable object, it can be altered:

   ```python
   >>> a = (1,[3,2])
   >>> a[1][0] = 1
   >>> a
   (1, [1, 2])
   >>> a[1].append(3)
   >>> a
   (1, [1, 2, 3])
   >>> del a[1][2]
   >>> a
   (1, [1, 2])
   >>> del a[1]
   Traceback (most recent call last):
     File "<stdin>", line 1, in <module>
   TypeError: 'tuple' object doesn't support item deletion
   >>> del a[1][1]
   >>> del a[1][0]
   >>> a
   (1, [])
   ```

3. Insert an element:

   ```python
   tuple1 = (1,2,4,5)
   tuple2 = tuple1[:2] + (3,) + tuple1[2:]
   print(tuple2) // (1, 2, 3, 4, 5)
   ```

   

### set

1. mySet = {x for x in 'abracadabra' if x not in 'abc'} # {'r', 'd'}
2. mySet.clear() can clear the whole set # set() is what's left



## Javascript

### Array

1. arr.constructor # 'function Array() { [native code] }'

2. arr.entries() returns a iteratable object:

   ```js
   var fruits = ["Banana", "Orange", "Apple", "Mango"];
   var x = fruits.entries();
   console.log(x.next().value); // [0, "Banana"]
   console.log(x.next().value); // [1, "Orange"]
   console.log(x.next().value); // [2, "Apple"]
   console.log(x.next().value); // [3, "Mongo"]
   console.log(x.next().value); // undefined
   ```

3. ```arr.every(callback[, thisArg])```: **true** if the callback function returns a [truthy](https://developer.mozilla.org/en-US/docs/Glossary/truthy) value for every array element; otherwise, **false**. (callback function params: currentValue[, index[, array])

4. ```var newArray = arr.filter(callback(element[, index[, array]])[, thisArg])``` returns a new array with the elements that pass the test. If no elements pass the test, an empty array will be returned.

5. ```arr.find(callback[, thisArg])``` returns a value in the array if an element passes the test; otherwise, undefined.

6. ```arr.findIndex(callback[, thisArg])``` returns an index in the array if an element passes the test; otherwise, **-1**.

7. arr.forEach() usage:

   ```js
   arr.forEach(function callback(currentValue[, index[, array]]) {
       //your iterator
   }[, thisArg]);
   ```

8. The **keys()** method returns a new **Array Iterator** object that contains the keys for each index in the array.

   ```js
   var array1 = ['a', 'b', 'c'];
   var iterator = array1.keys(); 
     
   for (let key of iterator) {
     console.log(key); // expected output: 0 1 2
   }
   ```

   or

   ```js
   var array1 = ['a', 'b', 'c'];
   var iterator = array1.keys(); 
     
   console.log(iterator.next().value);
   console.log(iterator.next().value);
   console.log(iterator.next().value);
   // expected output: 0 1 2
   ```

9. The **map()** method creates a new array with the results of calling a provided function on every element in the calling array.

   ```js
   var array1 = [1, 4, 9, 16];
   
   // pass a function to map
   const map1 = array1.map(x => x * 2);
   
   console.log(map1);
   // expected output: Array [2, 8, 18, 32]
   ```

10. The **some()** method tests whether at least one element in the array passes the test implemented by the provided function.

    ```js
    var array = [1, 2, 3, 4, 5];
    
    var even = function(element) {
      // checks whether an element is even
      return element % 2 === 0;
    };
    
    console.log(array.some(even));
    // expected output: true
    ```

11. The **values()** method returns a new **Array Iterator** object that contains the values for each index in the array.

    ```js
    var array1 = ['a', 'b', 'c'];
    var iterator = array1.values();
    
    for (var value of iterator) {
      console.log(value); // expected output: "a" "b" "c"
    }
    ```

    or

    ```js
    var array1 = ['a', 'b', 'c'];
    var iterator = array1.values(); 
      
    console.log(iterator.next().value);
    console.log(iterator.next().value);
    console.log(iterator.next().value);
    // expected output: "a" "b" "c"
    ```

12. The **Array.of()** method creates a new `Array` instance with a variable number of arguments, regardless of number or type of the arguments.

    ```js
    Array.of(7);       // [7] 
    Array.of(1, 2, 3); // [1, 2, 3]
    
    Array(7);          // [ , , , , , , ]
    Array(1, 2, 3);    // [1, 2, 3]
    ```

13. The **Array.from()** method creates a new, shallow-copied `Array` instance from an array-like or iterable object.

    ```js
    console.log(Array.from('foo'));
    // expected output: Array ["f", "o", "o"]
    
    var setObj = new Set(["a", "b", "c"]);
    var objArr = Array.from(setObj);
    objArr[1] == "b";  // true
    
    console.log(Array.from([1, 2, 3], x => x + x));
    // expected output: Array [2, 4, 6]
    ```



## Java

### Array

1. Multi-dimensional Array:

   ```java
   int a[][] = new int[2][3];
   ```

   ```java
   String s[][] = new String[2][];
   s[0] = new String[2];
   s[1] = new String[3];
   s[0][0] = "Good";
   s[0][1] = "Luck";
   s[1][0] = "to";
   s[1][1] = "you";
   s[1][2] = "!";
   ```

2. java.util.Arrays.equals(arr1, arr2) compares two arrays. It returns true if they are the same; otherwise, returns false.

