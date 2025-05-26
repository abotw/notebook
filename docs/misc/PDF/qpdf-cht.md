---
github: https://github.com/qpdf/qpdf
site: https://qpdf.sourceforge.io/
date: 2025-05-26T08:48:00
---

# qpdf

`qpdf` 是一个开源的跨平台的命令行工具，主要用于对 PDF 文件进行**结构性**处理（即页面级处理，非内容级编辑）。

它适合用来拆分、合并、重排页面、加密/解密、压缩、解压缩等操作，尤其适合脚本自动化场景。

```sh
$ brew install qpdf
```

```shell
$ curl cheat.sh/

# qpdf
# Versatile PDF transformation software.
# More information: <https://github.com/qpdf/qpdf>.

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

## 1.  Extract 提取页码（拆分 PDF）

```bash
# Extract pages 1-3, 5 and 6-10 from a PDF file and save them as another one:
qpdf --empty --pages input.pdf 1-3,5,6-10 -- output.pdf

# 提取第 3-5 页
qpdf input.pdf --pages . 3-5 -- output.pdf
# 提取不连续页码（第 1、3、7 页）
qpdf input.pdf --pages . 1 3 7 -- output.pdf
```

- `--empty`：表示 **不使用输入文件**，即不从某个 PDF 开始修改，而是 **从零开始创建一个新 PDF**。
	- `--empty` 常用于合并、抽取多个 PDF 文件的页面时，没有主文件。
- `--pages`：开始页面操作，`--pages` 后可以指定多个来源文件（例如 A.pdf、B.pdf 等）
- `.`：**表示使用当前输入文件** `input.pdf` 作为**页面来源**（如果有多个文件，可以用其它文件名替代）。
- 如果要提取全部页，可以用 `1-z`（z 表示最后一页）。
- `--`：表示页码（页面列表）结束，起到分隔符的作用，后面跟的是**输出文件名**。

## 2. 合并多个 PDF 文件

将 `a.pdf` 的全部页和 `b.pdf` 的第 2-4 页合并：

```bash
qpdf --empty --pages a.pdf b.pdf 2-4 -- output.pdf
```

## 3. 加密 PDF

使用密码加密 PDF 文件：

```bash
qpdf --encrypt user-password owner-password 128 -- input.pdf output.pdf
```

> 示例：

```bash
qpdf --encrypt user123 admin456 256 -- input.pdf output.pdf
```
## 4. 解密 PDF

解密一个已加密的 PDF（需要拥有密码）：

```bash
qpdf --password=admin456 --decrypt input.pdf output.pdf
```

## 5. 优化（线性化）PDF 用于网页快速预览

```bash
qpdf --linearize input.pdf output.pdf
```

## 6. 检查 PDF 文件结构是否有效

```bash
qpdf --check input.pdf
```

## 7. 压缩或解压缩 PDF

解压缩 PDF 对象流（调试用）：

```bash
qpdf --qdf --object-streams=disable input.pdf output.pdf
```
