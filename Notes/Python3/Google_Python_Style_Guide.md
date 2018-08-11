<!--
AUTHORS:
Prefer only GitHub-flavored Markdown in external text.
See README.md for details.
-->

# Google Python Style Guide


<a id="background"></a>
## 1 Background

Python is the main dynamic language used at Google. This style guide is a list
of *dos and don'ts* for Python programs.

To help you format code correctly, we've created a [settings file for
Vim](google_python_style.vim). For Emacs, the default settings should be fine.

Many teams use the [yapf](https://github.com/google/yapf/)
auto-formatter to avoid arguing over formatting.


<a id="s2-python-language-rules"></a>
<a id="python-language-rules"></a>
## 2 Python Language Rules

<a id="s2.1-lint"></a>
<a id="lint"></a>
### 2.1 Lint

Run `pylint` over your code.

<a id="s2.1.1-definition"></a>
#### 2.1.1 Definition

`pylint` is a tool for finding bugs and style problems in Python source
code. It finds problems that are typically caught by a compiler for less dynamic
languages like C and C++. Because of the dynamic nature of Python, some
warnings may be incorrect; however, spurious warnings should be fairly
infrequent.

<a id="s2.1.2-pros"></a>
#### 2.1.2 Pros

Catches easy-to-miss errors like typos, using-vars-before-assignment, etc.

<a id="s2.1.3-cons"></a>
#### 2.1.3 Cons

`pylint` isn't perfect. To take advantage of it, we'll need to sometimes: a)
Write around it b) Suppress its warnings or c) Improve it.

<a id="s2.1.4-decision"></a>
#### 2.1.4 Decision

Make sure you run `pylint` on your code.


Suppress warnings if they are inappropriate so that other issues are not hidden.
To suppress warnings, you can set a line-level comment:

```python {.good}
dict = 'something awful'  # Bad Idea... pylint: disable=redefined-builtin
```

`pylint` warnings are each identified by symbolic name (`empty-docstring`)
Google-specific warnings start with `g-`.

If the reason for the suppression is not clear from the symbolic name, add an
explanation.

Suppressing in this way has the advantage that we can easily search for
suppressions and revisit them.

You can get a list of `pylint` warnings by doing:

```shell
pylint --list-msgs
```

To get more information on a particular message, use:

```shell
pylint --help-msg=C6409
```

Prefer `pylint: disable` to the deprecated older form `pylint: disable-msg`.

Unused argument warnings can be suppressed by deleting the variables at the
beginning of the function. Always include a comment explaining why you are
deleting it. "Unused." is sufficient. For example:

```python {.good}
def viking_cafe_order(spam, beans, eggs=None):
    del beans, eggs  # Unused by vikings.
    return spam + spam + spam
```

Other common forms of suppressing this warning include using '`_`' as the
identifier for the unused argument, prefixing the argument name with
'`unused_`', or assigning them to '`_`'. These forms are allowed but no longer
encouraged. The first two break callers that pass arguments by name, while the
latter does not enforce that the arguments are actually unused.

<a id="s2.2-imports"></a>
<a id="imports"></a>
### 2.2 Imports

Use `import`s for packages and modules only, not for individual classes or
functions.

<a id="s2.2.1-definition"></a>
#### 2.2.1 Definition

Reusability mechanism for sharing code from one module to another.

<a id="s2.2.2-pros"></a>
#### 2.2.2 Pros

The namespace management convention is simple. The source of each identifier is
indicated in a consistent way; `x.Obj` says that object `Obj` is defined in
module `x`.

<a id="s2.2.3-cons"></a>
#### 2.2.3 Cons

Module names can still collide. Some module names are inconveniently long.

<a id="s2.2.4-decision"></a>
#### 2.2.4 Decision

* Use `import x` for importing packages and modules.
* Use `from x import y` where `x` is the package prefix and `y` is the module
  name with no prefix.
* Use `from x import y as z` if two modules named `y` are to be imported or if
  `y` is an inconveniently long name.
* Use `import y as z` only when `z` is a standard abbreviation (e.g., `np` for
  `numpy`).

For example the module `sound.effects.echo` may be imported as follows:

```python {.good}
from sound.effects import echo
...
echo.EchoFilter(input, output, delay=0.7, atten=4)
```

Do not use relative names in imports. Even if the module is in the same package,
use the full package name. This helps prevent unintentionally importing a
package twice.

Note that there is an explicit exemption for imports from the [typing
module](#typing-imports).

<a id="s2.3-packages"></a>
<a id="packages"></a>
### 2.3 Packages

Import each module using the full pathname location of the module.

<a id="s2.3.1-pros"></a>
#### 2.3.1 Pros

Avoids conflicts in module names. Makes it easier to find modules.

<a id="S2.3.2-cons"></a>
#### 2.3.2 Cons

Makes it harder to deploy code because you have to replicate the package
hierarchy.

<a id="s2.3.3-decision"></a>
#### 2.3.3 Decision

All new code should import each module by its full package name.

Imports should be as follows:

```python {.good}
# Reference in code with complete name.
import absl.flags

# Reference in code with just module name (preferred).
from absl import flags
```

<a id="s2.4-exceptions"></a>
<a id="exceptions"></a>
### 2.4 Exceptions

Exceptions are allowed but must be used carefully.

<a id="s2.4.1-definition"></a>
#### 2.4.1 Definition

Exceptions are a means of breaking out of the normal flow of control of a code
block to handle errors or other exceptional conditions.

<a id="s2.4.2-pros"></a>
#### 2.4.2 Pros

The control flow of normal operation code is not cluttered by error-handling
code. It also allows the control flow to skip multiple frames when a certain
condition occurs, e.g., returning from N nested functions in one step instead of
having to carry-through error codes.

<a id="s2.4.3-cons"></a>
#### 2.4.3 Cons

May cause the control flow to be confusing. Easy to miss error cases when making
library calls.

<a id="s2.4.4-decision"></a>
#### 2.4.4 Decision

Exceptions must follow certain conditions:

- Raise exceptions like this: `raise MyError('Error message')` or `raise
    MyError()`. Do not use the two-argument form (`raise MyError, 'Error
    message'`).

- Make use of built-in exception classes when it makes sense. For example,
    raise a `ValueError` if you were passed a negative number but were expecting
    a positive one. Do not use `assert` statements for validating argument
    values of a public API. `assert` is used to ensure internal correctness, not
    to enforce correct usage nor to indicate that some unexpected event
    occurred. If an exception is desired in the latter cases, use a raise
    statement. For example:


    ```python {.good}
    Yes:
      def ConnectToNextPort(self, minimum):
        """Connects to the next available port.  Returns the new minimum port."""
        if minimum <= 1024:
          raise ValueError('Minimum port must be greater than 1024.')
        port = self._FindNextOpenPort(minimum)
        if not port:
          raise ConnectionError('Could not connect to service on %d or higher.' % (minimum,))
        assert port >= minimum, 'Unexpected port %d when minimum was %d.' % (port, minimum)
        return port
    ```

    ```python {.bad}
    No:
      def ConnectToNextPort(self, minimum):
        """Connects to the next available port.  Returns the new minimum port."""
        assert minimum > 1024, 'Minimum port must be greater than 1024.'
        port = self._FindNextOpenPort(minimum)
        assert port is not None
        return port
    ```

- Libraries or packages may define their own exceptions. When doing so they
    must inherit from an existing exception class. Exception names should end in
    `Error` and should not introduce stutter (`foo.FooError`).

- Never use catch-all `except:` statements, or catch `Exception` or
    `StandardError`, unless you are re-raising the exception or in the outermost
    block in your thread (and printing an error message). Python is very
    tolerant in this regard and `except:` will really catch everything including
    misspelled names, sys.exit() calls, Ctrl+C interrupts, unittest failures and
    all kinds of other exceptions that you simply don't want to catch.

- Minimize the amount of code in a `try`/`except` block. The larger the body
    of the `try`, the more likely that an exception will be raised by a line of
    code that you didn't expect to raise an exception. In those cases, the
    `try`/`except` block hides a real error.

- Use the `finally` clause to execute code whether or not an exception is
    raised in the `try` block. This is often useful for cleanup, i.e., closing a
    file.

- When capturing an exception, use `as` rather than a comma. For example:


    ```python {.good}
    try:
      raise Error
    except Error as error:
      pass
    ```

<a id="s2.5-global-variables"></a>
<a id="global-variables"></a>
### 2.5 Global variables

Avoid global variables.

<a id="s2.5.1-definition"></a>
#### 2.5.1 Definition

Variables that are declared at the module level or as class attributes.

<a id="s2.5.2-pros"></a>
#### 2.5.2 Pros

Occasionally useful.

<a id="s2.5.3-cons"></a>
#### 2.5.3 Cons

Has the potential to change module behavior during the import, because
assignments to global variables are done when the module is first imported.

<a id="s2.5.4-decision"></a>
#### 2.5.4 Decision

Avoid global variables.

While they are technically variables, module-level constants are permitted and
encouraged. For example: `MAX_HOLY_HANDGRENADE_COUNT = 3`. Constants must be
named using all caps with underscores. See [Naming](#s3.16-naming) below.

If needed, globals should be declared at the module level and made internal to
the module by prepending an `_` to the name. External access must be done
through public module-level functions. See [Naming](#s3.16-naming) below.

<a id="s2.6-nested"></a>
<a id="nested"></a>
### 2.6 Nested/Local/Inner Classes and Functions

Nested local functions or classes are fine when used to close over a local
variable. Inner classes are fine.

<a id="s2.6.1-definition"></a>
#### 2.6.1 Definition

A class can be defined inside of a method, function, or class. A function can be
defined inside a method or function. Nested functions have read-only access to
variables defined in enclosing scopes.

<a id="s2.6.2-pros"></a>
#### 2.6.2 Pros

Allows definition of utility classes and functions that are only used inside of
a very limited scope. Very
[ADT](http://www.google.com/url?sa=D&q=http://en.wikipedia.org/wiki/Abstract_data_type)-y.

<a id="s2.6.3-cons"></a>
#### 2.6.3 Cons

Instances of nested or local classes cannot be pickled. Nested functions and
classes cannot be directly tested. Nesting can make your outer function longer
and less readable.

<a id="s2.6.4-decision"></a>
#### 2.6.4 Decision

They are fine with some caveats: Avoid nested functions or classes except when
closing over a local value for easier future comprehension. Do not nest a
function just to hide it from users of a module. Instead, prefix its name with
an \_ at the module level so that it can still be accessed by tests.

<a id="list-comprehensions"></a>
<a id="s2.7-list_comprehensions"></a>
<a id="list_comprehensions"></a>
### 2.7 Comprehensions & Generator Expressions

Okay to use for simple cases.

<a id="s2.7.1-definition"></a>
#### 2.7.1 Definition

List, Dict, and Set comprehensions as well as generator expressions provide a
concise and efficient way to create container types and iterators without
resorting to the use of traditional loops, `map()`, `filter()`, or `lambda`.

<a id="s2.7.2-pros"></a>
#### 2.7.2 Pros

Simple comprehensions can be clearer and simpler than other dict, list, or set
creation techniques. Generator expressions can be very efficient, since they
avoid the creation of a list entirely.

<a id="s2.7.3-cons"></a>
#### 2.7.3 Cons

Complicated comprehensions or generator expressions can be hard to read.

<a id="s2.7.4-decision"></a>
#### 2.7.4 Decision

Okay to use for simple cases. Each portion must fit on one line: mapping
expression, `for` clause, filter expression. Multiple `for` clauses or filter
expressions are not permitted. Use loops instead when things get more
complicated.

```python {.good}
Yes:
  result = []
  for x in range(10):
      for y in range(5):
          if x * y > 10:
              result.append((x, y))

  for x in xrange(5):
      for y in xrange(5):
          if x != y:
              for z in xrange(5):
                  if y != z:
                      yield (x, y, z)

  return ((x, complicated_transform(x))
          for x in long_generator_function(parameter)
          if x is not None)

  squares = [x * x for x in range(10)]

  eat(jelly_bean for jelly_bean in jelly_beans
      if jelly_bean.color == 'black')
```

```python {.bad}
No:
  result = [(x, y) for x in range(10) for y in range(5) if x * y > 10]

  return ((x, y, z)
          for x in xrange(5)
          for y in xrange(5)
          if x != y
          for z in xrange(5)
          if y != z)
```

<a id="s2.8-default-iterators-and-operators"></a>
<a id="default-iterators-and-operators"></a>
### 2.8 Default Iterators and Operators

Use default iterators and operators for types that support them, like lists,
dictionaries, and files.

<a id="s2.8.1-definition"></a>
#### 2.8.1 Definition

Container types, like dictionaries and lists, define default iterators and
membership test operators ("in" and "not in").

<a id="s2.8.2-pros"></a>
#### 2.8.2 Pros

The default iterators and operators are simple and efficient. They express the
operation directly, without extra method calls. A function that uses default
operators is generic. It can be used with any type that supports the operation.

<a id="s2.8.3-cons"></a>
#### 2.8.3 Cons

You can't tell the type of objects by reading the method names (e.g. has\_key()
means a dictionary). This is also an advantage.

<a id="s2.8.4-decision"></a>
#### 2.8.4 Decision

Use default iterators and operators for types that support them, like lists,
dictionaries, and files. The built-in types define iterator methods, too. Prefer
these methods to methods that return lists, except that you should not mutate a
container while iterating over it.

```python {.good}
Yes:  for key in adict: ...
      if key not in adict: ...
      if obj in alist: ...
      for line in afile: ...
      for k, v in dict.iteritems(): ...
```

```python {.bad}
No:   for key in adict.keys(): ...
      if not adict.has_key(key): ...
      for line in afile.readlines(): ...
```

<a id="s2.9-generators"></a>
<a id="generators"></a>
### 2.9 Generators

Use generators as needed.

<a id="s2.9.1-definition"></a>
#### 2.9.1 Definition

A generator function returns an iterator that yields a value each time it
executes a yield statement. After it yields a value, the runtime state of the
generator function is suspended until the next value is needed.

<a id="s2.9.2-pros"></a>
#### 2.9.2 Pros

Simpler code, because the state of local variables and control flow are
preserved for each call. A generator uses less memory than a function that
creates an entire list of values at once.

<a id="s2.9.3-cons"></a>
#### 2.9.3 Cons

None.

<a id="s2.9.4-decision"></a>
#### 2.9.4 Decision

Fine. Use "Yields:" rather than "Returns:" in the docstring for generator
functions.

<a id="s2.10-lambda-functions"></a>
<a id="lambda-functions"></a>
### 2.10 Lambda Functions

Okay for one-liners.

<a id="s2.10.1-definition"></a>
#### 2.10.1 Definition

Lambdas define anonymous functions in an expression, as opposed to a statement.
They are often used to define callbacks or operators for higher-order functions
like `map()` and `filter()`.

<a id="s2.10.2-pros"></a>
#### 2.10.2 Pros

Convenient.

<a id="s2.10.3-cons"></a>
#### 2.10.3 Cons

Harder to read and debug than local functions. The lack of names means stack
traces are more difficult to understand. Expressiveness is limited because the
function may only contain an expression.

<a id="s2.10.4-decision"></a>
#### 2.10.4 Decision

Okay to use them for one-liners. If the code inside the lambda function is any
longer than 60-80 chars, it's probably better to define it as a regular (nested)
function.

For common operations like multiplication, use the functions from the `operator`
module instead of lambda functions. For example, prefer `operator.mul` to
`lambda x, y: x * y`.

<a id="s2.11-conditional-expressions"></a>
<a id="conditional-expressions"></a>
### 2.11 Conditional Expressions

Okay for one-liners.

<a id="s2.11.1-definition"></a>
#### 2.11.1 Definition

Conditional expressions (sometimes called a “ternary operator”) are mechanisms
that provide a shorter syntax for if statements. For example:
`x = 1 if cond else 2`.

<a id="s2.11.2-pros"></a>
#### 2.11.2 Pros

Shorter and more convenient than an if statement.

<a id="s2.11.3-cons"></a>
#### 2.11.3 Cons

May be harder to read than an if statement. The condition may be difficult to
locate if the expression is long.

<a id="s2.11.4-decision"></a>
#### 2.11.4 Decision

Okay to use for one-liners. In other cases prefer to use a complete if
statement.

<a id="s2.12-default-argument-values"></a>
<a id="default-argument-values"></a>
### 2.12 Default Argument Values

Okay in most cases.

<a id="s2.12.1-definition"></a>
#### 2.12.1 Definition

You can specify values for variables at the end of a function's parameter list,
e.g., `def foo(a, b=0):`.  If `foo` is called with only one argument,
`b` is set to 0. If it is called with two arguments, `b` has the value of the
second argument.

<a id="s2.12.2-pros"></a>
#### 2.12.2 Pros

Often you have a function that uses lots of default values, but-rarely-you want
to override the defaults. Default argument values provide an easy way to do
this, without having to define lots of functions for the rare exceptions. Also,
Python does not support overloaded methods/functions and default arguments are
an easy way of "faking" the overloading behavior.

<a id="s2.12.3-cons"></a>
#### 2.12.3 Cons

Default arguments are evaluated once at module load time. This may cause
problems if the argument is a mutable object such as a list or a dictionary. If
the function modifies the object (e.g., by appending an item to a list), the
default value is modified.

<a id="s2.12.4-decision"></a>
#### 2.12.4 Decision

Okay to use with the following caveat:

Do not use mutable objects as default values in the function or method
definition.

```python {.good}
Yes: def foo(a, b=None):
         if b is None:
             b = []
Yes: def foo(a, b: Optional[Sequence] = None):
         if b is None:
             b = []
```

```python {.bad}
No:  def foo(a, b=[]):
         ...
No:  def foo(a, b=time.time()):  # The time the module was loaded???
         ...
No:  def foo(a, b=FLAGS.my_thing):  # sys.argv has not yet been parsed...
         ...
```

<a id="s2.13-properties"></a>
<a id="properties"></a>
### 2.13 Properties

Use properties for accessing or setting data where you would normally have used
simple, lightweight accessor or setter methods.

<a id="s2.13.1-definition"></a>
#### 2.13.1 Definition

A way to wrap method calls for getting and setting an attribute as a standard
attribute access when the computation is lightweight.

<a id="s2.13.2-pros"></a>
#### 2.13.2 Pros

Readability is increased by eliminating explicit get and set method calls for
simple attribute access. Allows calculations to be lazy. Considered the Pythonic
way to maintain the interface of a class. In terms of performance, allowing
properties bypasses needing trivial accessor methods when a direct variable
access is reasonable. This also allows accessor methods to be added in the
future without breaking the interface.

<a id="s2.13.3-cons"></a>
#### 2.13.3 Cons

Must inherit from `object` in Python 2. Can hide side-effects much like operator
overloading. Can be confusing for subclasses.

<a id="s2.13.4-decision"></a>
#### 2.13.4 Decision

Use properties in new code to access or set data where you would normally have
used simple, lightweight accessor or setter methods. Properties should be
created with the `@property` [decorator](#s2.17-function-and-method-decorators).

Inheritance with properties can be non-obvious if the property itself is not
overridden. Thus one must make sure that accessor methods are called indirectly
to ensure methods overridden in subclasses are called by the property (using the
Template Method DP).

```python {.good}
Yes: import math

     class Square(object):
         """A square with two properties: a writable area and a read-only perimeter.

         To use:
         >>> sq = Square(3)
         >>> sq.area
         9
         >>> sq.perimeter
         12
         >>> sq.area = 16
         >>> sq.side
         4
         >>> sq.perimeter
         16
         """

         def __init__(self, side):
             self.side = side

         @property
         def area(self):
             """Gets or sets the area of the square."""
             return self._get_area()

         @area.setter
         def area(self, area):
             return self._set_area(area)

         def _get_area(self):
             """Indirect accessor to calculate the 'area' property."""
             return self.side ** 2

         def _set_area(self, area):
             """Indirect setter to set the 'area' property."""
             self.side = math.sqrt(area)

         @property
         def perimeter(self):
             return self.side * 4
```

<a id="s2.14-truefalse-evaluations"></a>
<a id="truefalse-evaluations"></a>
### 2.14 True/False evaluations

Use the "implicit" false if at all possible.

<a id="s2.14.1-definition"></a>
#### 2.14.1 Definition

Python evaluates certain values as `False` when in a boolean context. A quick
"rule of thumb" is that all "empty" values are considered false, so
`0, None, [], {}, ''` all evaluate as false in a boolean context.

<a id="s2.14.2-pros"></a>
#### 2.14.2 Pros

Conditions using Python booleans are easier to read and less error-prone. In
most cases, they're also faster.

<a id="s2.14.3-cons"></a>
#### 2.14.3 Cons

May look strange to C/C++ developers.

<a id="s2.14.4-decision"></a>
#### 2.14.4 Decision

Use the "implicit" false if at all possible, e.g., `if foo:` rather than
`if foo != []:`. There are a few caveats that you should keep in mind though:

- Never use `==` or `!=` to compare singletons like `None`. Use `is` or
    `is not`.

- Beware of writing `if x:` when you really mean `if x is not None:`-e.g.,
    when testing whether a variable or argument that defaults to `None` was set
    to some other value. The other value might be a value that's false in a
    boolean context!

- Never compare a boolean variable to `False` using `==`. Use `if not x:`
    instead. If you need to distinguish `False` from `None` then chain the
    expressions, such as `if not x and x is not None:`.

- For sequences (strings, lists, tuples), use the fact that empty sequences
    are false, so `if seq:` and `if not seq:` are preferable to `if len(seq):`
    and `if not len(seq):` respectively.

- When handling integers, implicit false may involve more risk than benefit
    (i.e., accidentally handling `None` as 0). You may compare a value which is
    known to be an integer (and is not the result of `len()`) against the
    integer 0.

    ```python {.good}
    Yes: if not users:
             print('no users')
    
         if foo == 0:
             self.handle_zero()
    
         if i % 10 == 0:
             self.handle_multiple_of_ten()
    
         def f(x=None):
             if x is None:
                 x = []
    ```

    ```python {.bad}
    No:  if len(users) == 0:
             print('no users')
    
         if foo is not None and not foo:
             self.handle_zero()
    
         if not i % 10:
             self.handle_multiple_of_ten()
    
         def f(x=None):
             x = x or []
    ```

- Note that `'0'` (i.e., `0` as string) evaluates to true.

<a id="s2.15-deprecated-language-features"></a>
<a id="deprecated-language-features"></a>
### 2.15 Deprecated Language Features

Use string methods instead of the `string` module where possible. Use function
call syntax instead of `apply`. Use list comprehensions and `for` loops instead
of `filter` and `map` when the function argument would have been an inlined
lambda anyway. Use `for` loops instead of `reduce`.

<a id="s2.15.1-definition"></a>
#### 2.15.1 Definition

Current versions of Python provide alternative constructs that people find
generally preferable.

<a id="s2.15.2-decision"></a>
#### 2.15.2 Decision

We do not use any Python version which does not support these features, so there
is no reason not to use the new styles.

```python {.good}
Yes: words = foo.split(':')

     [x[1] for x in my_list if x[2] == 5]

     map(math.sqrt, data)    # Ok. No inlined lambda expression.

     fn(*args, **kwargs)
```

```python {.bad}
No:  words = string.split(foo, ':')

     map(lambda x: x[1], filter(lambda x: x[2] == 5, my_list))

     apply(fn, args, kwargs)
```

<a id="s2.16-lexical-scoping"></a>
<a id="lexical-scoping"></a>
### 2.16 Lexical Scoping

Okay to use.

<a id="s2.16.1-definition"></a>
#### 2.16.1 Definition

A nested Python function can refer to variables defined in enclosing functions,
but can not assign to them. Variable bindings are resolved using lexical
scoping, that is, based on the static program text. Any assignment to a name in
a block will cause Python to treat all references to that name as a local
variable, even if the use precedes the assignment. If a global declaration
occurs, the name is treated as a global variable.

An example of the use of this feature is:

```python {.good}
def get_adder(summand1):
    """Returns a function that adds numbers to a given number."""
    def adder(summand2):
        return summand1 + summand2

    return adder
```

<a id="s2.16.2-pros"></a>
#### 2.16.2 Pros

Often results in clearer, more elegant code. Especially comforting to
experienced Lisp and Scheme (and Haskell and ML and ...) programmers.

<a id="s2.16.3-cons"></a>
#### 2.16.3 Cons

Can lead to confusing bugs. Such as this example based on
[PEP-0227](http://www.google.com/url?sa=D&q=http://www.python.org/dev/peps/pep-0227/):

```python {.bad}
i = 4
def foo(x):
    def bar():
        print(i, end='')
    # ...
    # A bunch of code here
    # ...
    for i in x:  # Ah, i *is* local to foo, so this is what bar sees
        print(i, end='')
    bar()
```

So `foo([1, 2, 3])` will print `1 2 3 3`, not `1 2 3
4`.

<a id="s2.16.4-decision"></a>
#### 2.16.4 Decision

Okay to use.

<a id="s2.17-function-and-method-decorators"></a>
<a id="function-and-method-decorators"></a>
### 2.17 Function and Method Decorators

Use decorators judiciously when there is a clear advantage. Avoid
`@staticmethod` and limit use of `@classmethod`.

<a id="s2.17.1-definition"></a>
#### 2.17.1 Definition

[Decorators for Functions and
Methods](https://docs.python.org/2/whatsnew/2.4.html#pep-318-decorators-for-functions-and-methods)
(a.k.a "the `@` notation"). One common decorator is `@property`, used for
converting ordinary methods into dynamically computed attributes. However, the
decorator syntax allows for user-defined decorators as well. Specifically, for
some function `my_decorator`, this:

```python {.good}
class C(object):
    @my_decorator
    def method(self):
        # method body ...
```

is equivalent to:

```python {.good}
class C(object):
    def Methodmethod(self):
        # method body ...
    Methodmethod = MyDecoratormy_decorator(Methodmethod)
```

<a id="s2.17.2-pros"></a>
#### 2.17.2 Pros

Elegantly specifies some transformation on a method; the transformation might
eliminate some repetitive code, enforce invariants, etc.

<a id="s2.17.3-cons"></a>
#### 2.17.3 Cons

Decorators can perform arbitrary operations on a function's arguments or return
values, resulting in surprising implicit behavior. Additionally, decorators
execute at import time. Failures in decorator code are pretty much impossible to
recover from.

<a id="s2.17.4-decision"></a>
#### 2.17.4 Decision

Use decorators judiciously when there is a clear advantage. Decorators should
follow the same import and naming guidelines as functions. Decorator pydoc
should clearly state that the function is a decorator. Write unit tests for
decorators.

Avoid external dependencies in the decorator itself (e.g. don't rely on files,
sockets, database connections, etc.), since they might not be available when the
decorator runs (at import time, perhaps from `pydoc` or other tools). A
decorator that is called with valid parameters should (as much as possible) be
guaranteed to succeed in all cases.

Decorators are a special case of "top level code" - see [main](#s3.17-main) for
more discussion.

Never use `@staticmethod` unless forced to in order to integrate with an API
defined in an existing library. Write a module level function instead.

Use `@classmethod` only when writing a named constructor or a class-specific
routine that modifies necessary global state such as a process-wide cache.

<a id="s2.18-threading"></a>
<a id="threading"></a>
### 2.18 Threading

Do not rely on the atomicity of built-in types.

While Python's built-in data types such as dictionaries appear to have atomic
operations, there are corner cases where they aren't atomic (e.g. if `__hash__`
or `__eq__` are implemented as Python methods) and their atomicity should not be
relied upon. Neither should you rely on atomic variable assignment (since this
in turn depends on dictionaries).

Use the Queue module's `Queue` data type as the preferred way to communicate
data between threads. Otherwise, use the threading module and its locking
primitives. Learn about the proper use of condition variables so you can use
`threading.Condition` instead of using lower-level locks.

<a id="s2.19-power-features"></a>
<a id="power-features"></a>
### 2.19 Power Features

Avoid these features.

<a id="s2.19.1-definition"></a>
#### 2.19.1 Definition

Python is an extremely flexible language and gives you many fancy features such
as custom metaclasses, access to bytecode, on-the-fly compilation, dynamic
inheritance, object reparenting, import hacks, reflection, modification of
system internals, etc.

<a id="s2.19.2-pros"></a>
#### 2.19.2 Pros

These are powerful language features. They can make your code more compact.

<a id="s2.19.3-cons"></a>
#### 2.19.3 Cons

It's very tempting to use these "cool" features when they're not absolutely
necessary. It's harder to read, understand, and debug code that's using unusual
features underneath. It doesn't seem that way at first (to the original author),
but when revisiting the code, it tends to be more difficult than code that is
longer but is straightforward.

<a id="s2.19.4-decision"></a>
#### 2.19.4 Decision

Avoid these features in your code.

Standard library modules and classes that internally use these features are okay
to use (for example, `abc.ABCMeta`, `collections.namedtuple`, and `enum`).

<a id="s2.20-modern-python"></a>
<a id="modern-python"></a>
### 2.20 Modern Python: Python 3 and from \_\_future\_\_ imports {#modern-python}

Python 3 is here. While not every project is ready to use it yet, all code should be written with an eye towards the future.

<a id="s2.20.1-definition"></a>
#### 2.20.1 Definition

Python 3 is a significant change in the Python language. While existing code is
often written with 2.7 in mind there are some simple things to do to make code
more explicit about its intentions and thus better prepared for use under Python
3 without modification.

<a id="s2.20.2-pros"></a>
#### 2.20.2 Pros

Code written with Python 3 in mind is more explicit and easier to get running
under Python 3 once all of the dependencies of your project are ready.

<a id="s2.20.3-cons"></a>
#### 2.20.3 Cons

Some people find the additional boilerplate to be ugly. Others say "but I don't
use that feature in this file" and want to clean-up. Please don't. It is better
to always have the future imports in all files so that they are not forgotten
during later edits when someone starts using such a feature.

<a id="s2.20.4-decision"></a>
#### 2.20.4 Decision

##### from \_\_future\_\_ imports

Use of `from __future__ import` statements is encouraged. All new code should
contain the following and existing code should be updated to be compatible when
possible:

```python {.good}
from __future__ import absolute_import
from __future__ import division
from __future__ import print_function
```

If you are not already familiar with those, read up on each here: [absolute
imports](https://www.python.org/dev/peps/pep-0328/), [new `/` division
behavior](https://www.python.org/dev/peps/pep-0238/), and [the print
function](https://www.python.org/dev/peps/pep-3105/).

There are other `from __future__` import statements. Use them as you see fit. We
do not include `unicode_literals` in our recommendations as it is not a clear
win due to implicit default codec conversion consequences it introduces in many
places within Python 2.7. Most code is better off with explicit use of `b''` and
`u''` bytes and unicode string literals as necessary.

##### The six, future, or past libraries.

When your project needs to actively support use under both Python 2 and 3, use
of these libraries is encouraged as you see fit. They exist to make your code
cleaner and life easier.

<a name="s2.21-typed-code"></a>
<a name="typed-code"></a>
### 2.21 Type Annotated Code

You can annotate Python 3 code with type hints according to
[PEP-484](https://www.python.org/dev/peps/pep-0484/), and type-check the code at
build time with a type checking tool like
[pytype](https://github.com/google/pytype).


Type annotations can be in the source or in a [stub pyi
file](https://www.python.org/dev/peps/pep-0484/#stub-files). Whenever possible,
annotations should be in the source. Use pyi files for third-party or extension
modules.


<a id="s2.21.1-definition"></a>
#### 2.21.1 Definition

Type annotations (or "type hints") are for function or method arguments and
return values:

```python {.good}
def func(a: int) -> List[int]:
```

You can also declare the type of a variable using a special comment:

```python {.good}
a = SomeFunc()  # type: SomeType
```

<a id="s2.21.2-pros"></a>
#### 2.21.2 Pros

Type annotations improve the readability and maintainability of your code. The
type checker will convert many runtime errors to build-time errors, and reduce
your ability to use [Power Features](#power-features).

<a id="s2.21.3-cons"></a>
#### 2.21.3 Cons

You will have to keep the type declarations up to date. You might see type errors that you think are valid code. Use of a [type checker](https://github.com/google/pytype)
may reduce your ability to use [Power Features](#power-features).

<a id="s2.21.4-decision"></a>
#### 2.21.4 Decision

This highly depends on the complexity of your project. Give it a try.


<a id="s3-python-style-rules"></a>
<a id="python-style-rules"></a>
## 3 Python Style Rules

<a id="s3.1-semicolons"></a>
<a id="semicolons"></a>
### 3.1 Semicolons

Do not terminate your lines with semi-colons and do not use semi-colons to put
two statements on the same line.

<a id="s3.2-line-length"></a>
<a id="line-length"></a>
### 3.2 Line length

Maximum line length is *80 characters*.

Exceptions:

-   Long import statements.
-   URLs, pathnames, or long flags in comments.
-   Long string module level constants not containing whitespace that would be
    inconvenient to split across lines such as URLs or pathnames.
-   Pylint disable comments. (e.g.: `# pylint: disable=invalid-name`)

Do not use backslash line continuation except for `with` statements requiring
three or more context managers.

Make use of Python's [implicit line joining inside parentheses, brackets and
braces](http://docs.python.org/reference/lexical_analysis.html#implicit-line-joining).
If necessary, you can add an extra pair of parentheses around an expression.

```python {.good}
Yes: foo_bar(self, width, height, color='black', design=None, x='foo',
             emphasis=None, highlight=0)

     if (width == 0 and height == 0 and
         color == 'red'
```