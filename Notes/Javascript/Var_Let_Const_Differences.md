# Differences between ```var```, ```let``` and ```const``` for variable declaration

> Part of this artical is cited from [Var, let and const- what's the difference?](https://dev.to/sarah_chima/var-let-and-const--whats-the-difference-69e)

Keywords ```let``` and ```const``` came with ES6. This article talks about the differences between them and keyword ```var```



## Var

### Features

* ```var``` declarations are globally or locally (function) scoped;

* ```var``` declarations are not;

* ```var``` variables can be re-declared and updated;

* Hoisting of ```var``` : variable and function declarations (not definition) are moved to the top of its scope, thus it is ok to do this: (`var` variables are hoisted to the top of its scope and initialized with a value of undefined.).

* ```js
  console.log (greeter);
  var greeter = "say hello"
  ```

* The assignment of a undeclared variable will make it a global variable.

### Problems

* ```var``` declarations are not block scoped, which means the variable below is a global variable:  

* ```js
  if (times > 3) {
      var greeter = "say Hello instead"; 
  }
  ```



## Let

### Features

* ```let``` is block scoped (A block is chunk of code bounded by {});

* ```let``` can be updated but not re-declared;

* ```let``` declarations are hoisted but not initialized (```var``` declarations are hoisted and initialized with ```undefined```), so if you try to use a `let` variable before declaration, you'll get a `Reference Error`.

* In switch statement, you may run into this error because case clause is not a block:

* ```js
  switch (x) {
    case 0:
      let foo;
      break;
  
    case 1:
      let foo; // TypeError for redeclaration.
      break;
  }
  ```

  But you can create a block in case clause to get rid of the error:

  ```js
  let x = 1;
  
  switch(x) {
    case 0: {
      let foo;
      break;
    }  
    case 1: {
      let foo;
      break;
    }
  }
  ```



## Const

###Features

* ```const``` declarations are block scoped;

* ```const``` variables cannot be updated or re-declared;

* ```const``` variables must be initialized when declared;

* A ```const``` cannot be updated, but its properties can be updated.

* ```const``` declarations are hoisted but not initialized

  