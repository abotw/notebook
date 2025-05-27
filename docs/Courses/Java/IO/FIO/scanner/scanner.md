Here's a **brief overview** of the **common constructors and instance methods** of the `Scanner` class in Java.

------

### 🛠️ **Common Constructors**

| Constructor                   | Description                                                  |
| ----------------------------- | ------------------------------------------------------------ |
| `Scanner(InputStream source)` | Most common; reads input from input streams like `System.in`. |
| `Scanner(File source)`        | Reads input from a file.                                     |
| `Scanner(String source)`      | Reads input from a string.                                   |

------

### 📘 **Common Instance Methods**

| Method          | Description                                       |
| --------------- | ------------------------------------------------- |
| `next()`        | Reads the next **word/token** (skips whitespace). |
| `nextLine()`    | Reads the **entire line** of input.               |
| `nextInt()`     | Reads the next input as an **int**.               |
| `nextDouble()`  | Reads the next input as a **double**.             |
| `nextBoolean()` | Reads the next input as a **boolean**.            |
| `hasNext()`     | Checks if there's another token.                  |
| `hasNextInt()`  | Checks if the next token is an int.               |
| `close()`       | Closes the scanner to free resources.             |

------

>   🧠 Tip: `next()` stops at whitespace, while `nextLine()` reads everything until a newline.

