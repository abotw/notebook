# GCC 编译标准速查

## 📌 基本语法

```bash
gcc -std=<标准> your_file.c -o output
```

例如：

```bash
gcc -std=c99 main.c -o main
```

---

## 📚 常用标准选项说明

|标准名称|编写形式|简介|
|---|---|---|
|C89|`-std=c89` 或 `-std=iso9899:1990`|ANSI C，早期标准，有限支持现代特性|
|C90|`-std=c90`（等同于 c89）|ISO 采纳 C89 标准，几乎相同|
|GNU89|`-std=gnu89`|C89 + GNU 扩展（GCC 默认的旧标准）|
|C99|`-std=c99`|引入 `//` 注释、`inline`、`stdint.h` 等|
|GNU99|`-std=gnu99`|C99 + GNU 扩展|
|C11|`-std=c11`|增加 `_Generic`、多线程、`static_assert` 等|
|GNU11|`-std=gnu11`|C11 + GNU 扩展|
|C17（C18）|`-std=c17` 或 `-std=c18`|C11 bug 修正版本，内容基本相同|
|C23|`-std=c2x`（或 `-std=c23`，GCC 13+）|最新标准，尚未广泛支持|

---

## ⚙️ 强制标准（禁用 GNU 扩展）

如需完全按照标准（不含 GNU 扩展）编译：

```bash
gcc -std=c99 -pedantic -Wall -Wextra your_file.c
```

说明：

- `-pedantic`：严格遵循标准
    
- `-Wall`：开启大多数警告
    
- `-Wextra`：开启更多警告
    

---

## 🧪 示例测试代码

```c
// test.c
#include <stdio.h>

int main(void) {
    printf("Hello, C standard!\n");
    return 0;
}
```

```bash
gcc -std=c11 test.c -o test
```

---

## 🧩 检查当前默认标准

```bash
echo | gcc -dM -E -x c - | grep __STDC_VERSION__
```

或使用 `gcc -v` 查看版本信息。
