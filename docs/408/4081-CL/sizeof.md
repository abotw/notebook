# `sizeof`

**Purpose:**  
`sizeof` is a compile-time operator used to determine **the size (in bytes)** of a data type or object.

---

## 🔹 Syntax

```c
sizeof(expression)
sizeof type
```

- Parentheses are **optional** when used with a **type** in `sizeof`, but **required** when used with an **expression**.
    

---

## 🔹 Examples

```c
sizeof(int);           // returns size of int (e.g., 4)
sizeof x;              // if x is a variable
sizeof(x + 1);         // evaluates type of the expression, not the result
```

---

## 🔹 Key Characteristics

- **Evaluated at compile time** (except for VLAs – Variable Length Arrays).
    
- **Does not evaluate expressions**:
    
```c
int x = 10;
sizeof(x++);  // x is not incremented
```
    

---

## 🔹 Common Sizes (in bytes)

|Type|Typical Size (x86)|
|---|---|
|`char`|1|
|`short`|2|
|`int`|4|
|`long`|4 or 8|
|`float`|4|
|`double`|8|
|pointer|4 or 8|

(Use `sizeof` instead of hardcoding these for portability.)

---

## 🔹 Use Cases

**Memory allocation:**
    
```c
int *arr = malloc(10 * sizeof(int));
```
    
**Array size calculation:**
    
```c
int a[5];
size_t len = sizeof(a) / sizeof(a[0]);  // Number of elements
```
    
**Portability and safety checks in system programming.**
    

---

## ⚠️ Notes and Gotchas

- `sizeof("abc")` returns **4**, because string literals include the null terminator.
    
- For pointers: `sizeof(ptr)` gives size of pointer, not what it points to.
    
- For structs: Includes padding for alignment.
    
