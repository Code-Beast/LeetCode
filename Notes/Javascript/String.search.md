[String.search](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/search) uses a [RegExp](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/RegExp), and converts its argument to one if it isn't already. `[]` and `()` are special characters to RegExp.

You can directly create a regexp and escape the characters like so:

```js
var n = str.search(/\[\]/);
```

But if you're searching for a literal string, then you should be using [String.indexOf](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/indexOf) instead.

```js
var n = str.indexOf("[]");
```

