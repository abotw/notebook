
# 使用 Pandoc 将 Markdown 转换为 Word（.docx）文档

本笔记简要总结了使用 Pandoc 工具将 Markdown 文件转换为 Microsoft Word 格式（.docx）的常见方法，适用于快速参考与日常使用。

---

## 基本概念

- **Pandoc**：一个强大的文档转换工具，支持多种输入与输出格式，广泛用于 Markdown 与其他格式之间的互转。
    
- **Markdown（Markdown）**：一种轻量级标记语言，常用于编写格式化文本。
    
- **Word 文档（.docx）**：Microsoft Word 使用的文档格式，基于 Office Open XML 标准。
    

---

## 基础命令

```bash
pandoc input.md -o output.docx
```

- `input.md`：输入的 Markdown 文件。
    
- `-o output.docx`：指定输出的 Word 文件名。
    

---

## 常用选项

### 设置标题页元信息

```bash
pandoc input.md -o output.docx --metadata title="文档标题"
```

可设置的元信息还包括 `author`（作者）、`date`（日期）等。

---

### 使用自定义样式模板（参考 Word 样式）

```bash
pandoc input.md -o output.docx --reference-doc=template.docx
```

- `--reference-doc`：指定一个样式参考文档，Pandoc 将以该 Word 文件的样式为模板。
    

> 建议将 `template.docx` 预先设置好所需的字体、标题样式、段落格式等。

---

### 保留目录结构（添加自动目录）

```bash
pandoc input.md -o output.docx --toc
```

- `--toc`（Table of Contents）：自动生成目录，基于 Markdown 中的标题层级。
    

---

### 指定输入和输出格式（可选）

```bash
pandoc -f markdown -t docx input.md -o output.docx
```

- `-f`：指定输入格式（默认为 markdown）。
    
- `-t`：指定输出格式（默认为 docx，若输出文件后缀为 .docx，可省略）。
    

---

## 示例命令汇总

```bash
# 基础转换
pandoc README.md -o README.docx

# 使用模板
pandoc report.md -o report.docx --reference-doc=style.docx

# 添加目录和元信息
pandoc thesis.md -o thesis.docx --toc --metadata title="毕业论文" --metadata author="张三"

# 明确格式转换（一般可省略）
pandoc -f markdown -t docx notes.md -o notes.docx
```

---

## 附加建议

- 若 Pandoc 默认样式不满足需求，建议搭配 Word 模板文件使用 `--reference-doc`。
    
- 转换时尽量保持 Markdown 语法规范，避免嵌套 HTML 或特殊语法，以确保 Word 文档格式正确。
    
- 可通过 `--highlight-style` 选项设置代码块高亮样式，适用于包含代码的文档。
    

---

## 参考命令帮助

```bash
pandoc --help
pandoc --list-highlight-styles
```

---

## 常见问题排查

- **中文乱码**：确保源文件编码为 UTF-8，或添加 `--from markdown+smart`。
    
- **图像不显示**：确保图像路径正确，建议使用相对路径，且图像文件应与输出文件一起移动。
    
- **样式不生效**：检查 `reference-doc` 模板是否正确，并包含了所需的段落与标题样式。
