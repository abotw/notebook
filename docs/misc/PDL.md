PDL（**Program Design Language**，程序设计语言）也叫**伪代码**（Pseudocode），是一种**介于自然语言和程序代码之间**的描述方式，用于帮助程序员在正式编码前清晰表达程序逻辑。

虽然PDL没有“统一的强制标准”，但在软件工程中，**有一些约定俗成的规范和写作风格**，目的是做到：

- 结构清晰（体现顺序、选择、循环）
    
- 接近代码（便于转化为程序）
    
- 可读性强（给人看，不是机器执行）
    

---

## 🧩 一、PDL 规范组成要点

|要素|描述|
|---|---|
|控制结构|使用结构化关键字如 `IF`, `THEN`, `ELSE`, `WHILE`, `FOR`, `REPEAT`, `UNTIL` 等|
|缩进|用缩进表示层次和嵌套结构|
|语义|使用自然语言 + 程序逻辑词汇，表达清晰意图|
|注释|可以加入注释（通常用 `//` 或 `--` 表示）|
|数据结构|使用通俗易懂的方式描述变量、数组、记录等|

---

## ✏️ 二、PDL 书写基本格式（模板）

```plaintext
PROCEDURE <过程名>
    // 变量说明
    DECLARE x, y AS INTEGER
    DECLARE result AS REAL

    // 顺序结构
    READ x
    READ y
    result ← x + y

    // 条件结构
    IF result > 100 THEN
        OUTPUT "Too large"
    ELSE
        OUTPUT result
    ENDIF

    // 循环结构
    WHILE x < y DO
        x ← x + 1
        OUTPUT x
    ENDWHILE
ENDPROCEDURE
```

---

## ✅ 三、常见控制结构表示方法

### 1. 顺序结构

```plaintext
READ A
READ B
SUM ← A + B
OUTPUT SUM
```

### 2. 条件结构（IF-ELSE）

```plaintext
IF A > B THEN
    MAX ← A
ELSE
    MAX ← B
ENDIF
```

### 3. 多分支（IF-ELSEIF）

```plaintext
IF score ≥ 90 THEN
    grade ← "A"
ELSEIF score ≥ 80 THEN
    grade ← "B"
ELSE
    grade ← "C"
ENDIF
```

### 4. 循环结构（WHILE）

```plaintext
WHILE count < 10 DO
    OUTPUT count
    count ← count + 1
ENDWHILE
```

### 5. 计数循环（FOR）

```plaintext
FOR i FROM 1 TO 10 DO
    OUTPUT i
ENDFOR
```

---

## 🧪 四、一个完整的PDL例子（计算阶乘）

```plaintext
PROCEDURE ComputeFactorial
    // 输入一个正整数 N，输出 N 的阶乘

    DECLARE N, i, result AS INTEGER
    result ← 1

    READ N

    FOR i FROM 1 TO N DO
        result ← result * i
    ENDFOR

    OUTPUT "The factorial of", N, "is", result
ENDPROCEDURE
```

---

## 🧠 五、小贴士

- PDL 是设计阶段的语言，可以灵活使用，但要**结构清晰**。
    
- 不要拘泥语法，但要注意逻辑表达是否严谨。
    
- PDL 是写给“人”看的，是正式代码的“草稿”，写完可以更容易地转换成 C / Java / Python 等语言。
    