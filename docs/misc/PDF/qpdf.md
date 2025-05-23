# qpdf

`qpdf` 是一个功能强大的开源命令行工具，主要用于对 PDF 文件进行**结构性**处理（非内容级编辑）。它适合用来拆分、合并、重排页面、加密/解密、压缩、解压缩等操作，尤其适合脚本自动化场景。

## cht

```shell
$ curl cheat.sh/

# qpdf
# Versatile PDF transformation software.
# More information: <https://github.com/qpdf/qpdf>.

# Extract pages 1-3, 5 and 6-10 from a PDF file and save them as another one:
qpdf --empty --pages input.pdf 1-3,5,6-10 -- output.pdf

# Merge (concatenate) all the pages of a list of PDF files and save the result as a new PDF:
qpdf --empty --pages file1.pdf file2.pdf file3.pdf -- output.pdf

# Merge (concatenate) given pages from a list of PDF files and save the result as a new PDF:
qpdf --empty --pages file1.pdf 1,6-8 file2.pdf 3,4,5 -- output.pdf

# Write each group of n pages to a separate output file with a given filename pattern:
qpdf --split-pages=n input.pdf out_%d.pdf

# Rotate certain pages of a PDF with a given angle:
qpdf --rotate=90:2,4,6 --rotate=180:7-8 input.pdf output.pdf

# Remove the password from a password-protected file:
qpdf --password=password --decrypt input.pdf output.pdf

$
```

## qpdf 简介

- **全名**：QPDF — PDF transformation and inspection tool
    
- **用途**：用于结构性修改 PDF 文件（页面级处理，不是内容级编辑）
    
- **平台**：跨平台，支持 macOS、Linux、Windows
    
- **官网**：[https://qpdf.sourceforge.io](https://qpdf.sourceforge.io/)
    
- **安装方式（macOS）**：
    
    ```bash
    brew install qpdf
    ```
    

---

## 常用功能与用法

### 1. 提取页码（拆分 PDF）

提取第 3-5 页：

```bash
qpdf input.pdf --pages . 3-5 -- output.pdf
```

提取不连续页码（第 1、3、7 页）：

```bash
qpdf input.pdf --pages . 1 3 7 -- output.pdf
```

---

### 2. **合并多个 PDF 文件**

将 `a.pdf` 的全部页和 `b.pdf` 的第 2-4 页合并：

```bash
qpdf --empty --pages a.pdf b.pdf 2-4 -- output.pdf
```

---

### 3. **加密 PDF**

使用密码加密 PDF 文件：

```bash
qpdf --encrypt user-password owner-password 128 -- input.pdf output.pdf
```

> 示例：

```bash
qpdf --encrypt user123 admin456 256 -- input.pdf output.pdf
```

---

### 4. **解密 PDF**

解密一个已加密的 PDF（需要拥有密码）：

```bash
qpdf --password=admin456 --decrypt input.pdf output.pdf
```

---

### 5. **优化（线性化）PDF 用于网页快速预览**

```bash
qpdf --linearize input.pdf output.pdf
```

---

### 6. **检查 PDF 文件结构是否有效**

```bash
qpdf --check input.pdf
```

---

### 7. **压缩或解压缩 PDF**

解压缩 PDF 对象流（调试用）：

```bash
qpdf --qdf --object-streams=disable input.pdf output.pdf
```

---

## 小结：qpdf 是什么？

|特性|说明|
|---|---|
|操作粒度|页级（不能编辑文字，但可以重组页面等）|
|支持合并拆分|✅|
|支持加密解密|✅（带用户/拥有者密码）|
|支持命令行自动化|✅（适合批处理或脚本使用）|
|内容编辑|❌（不能修改页面内容或注释）|
