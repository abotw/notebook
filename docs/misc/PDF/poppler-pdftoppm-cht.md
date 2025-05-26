---
site: https://poppler.freedesktop.org/
date: 2025-05-26T09:08:00
---

# Poppler 和 pdftoppm 工具速查笔记

Poppler 是一个用于处理 PDF 文件的开源库，广泛用于各类 Linux 发行版中。`pdftoppm` 是 Poppler 提供的命令行工具之一，用于将 PDF 页面转换为图像格式（如 PPM、PNG、JPEG）。本笔记简明列出常用命令及参数说明，适合快速查阅与使用。

---

## 一、基本概念

- **Poppler**：一个基于 Xpdf 的 PDF 渲染库，支持命令行工具如 `pdftoppm`、`pdfinfo` 等。
    
- **pdftoppm**：Poppler 提供的 PDF 转图像工具，可将 PDF 文件的每一页转换为图像格式，适合用于图像识别、预览生成等场景。
    
- **PPM（Portable Pixmap Format）**：一种无压缩的图像格式，适用于高保真图像处理。
    

---

## 二、安装方法

### macOS

```sh
brew install poppler
```

###  Debian/Ubuntu

```bash
sudo apt update
sudo apt install poppler-utils
```

---

## 三、pdftoppm 基本用法

### 1. 转换为 PPM 图像

```bash
pdftoppm input.pdf outputname
```

> 会生成类似 `outputname-1.ppm`, `outputname-2.ppm` 等图像文件。

### 2. 指定图像格式（如 PNG）

```bash
# Generate a PNG file instead a PPM file:
pdftoppm -png path/to/input/file.pdf output_image_name_prefix
```

### 3. 指定页码范围

```bash
pdftoppm -f 2 -l 5 -png input.pdf outputname
```

- `-f`：起始页（First page）
    
- `-l`：结束页（Last page）
    

### 4. 指定图像分辨率（DPI）

```bash
# 批量提取高分辨率图像
pdftoppm -png -r 300 input.pdf outputname
```

- `-r`：分辨率（Resolution），单位为 DPI（Dots Per Inch）

### 5. 转换单页并输出至 stdout（标准输出）

```bash
pdftoppm -f 1 -l 1 -png input.pdf
```

### 6. 设置图像尺寸（缩放）

```bash
pdftoppm -scale-to 1024 -png input.pdf outputname
```

- `-scale-to`：将图像宽度或高度缩放至指定大小，自动保持纵横比。
    

---

## 四、常用参数汇总

| 参数          | 说明                       |
| ----------- | ------------------------ |
| `-png`      | 输出为 PNG 格式（默认为 PPM）      |
| `-jpeg`     | 输出为 JPEG 格式              |
| `-f`        | 起始页码（First page）         |
| `-l`        | 结束页码（Last page）          |
| `-r`        | 输出图像分辨率（Resolution, DPI） |
| `-scale-to` | 指定图像宽或高，保留纵横比            |
| `-cropbox`  | 使用 PDF 的裁剪框而非媒体框         |
| `-mono`     | 输出单色图像（Monochrome）       |
| `-gray`     | 输出灰度图像（Grayscale）        |

---

## 五、示例应用场景

- **提取封面缩略图**：
    
    ```bash
    pdftoppm -f 1 -l 1 -png -scale-to 400 input.pdf cover
    ```
    
- **结合 ImageMagick 转为其他格式**：
    
    ```bash
    pdftoppm -png input.pdf temp && convert temp-1.png output.webp
    ```
    

---

## 六、相关工具

- `pdfinfo`：查看 PDF 元数据
    
- `pdftotext`：提取 PDF 文本内容
    
- `pdfimages`：提取 PDF 内嵌图像
    
- `pdfseparate` / `pdfunite`：PDF 拆分与合并
    

---

## 七、参考链接

- Poppler 项目主页：[https://poppler.freedesktop.org/](https://poppler.freedesktop.org/)
    
- `pdftoppm` 手册页：可通过 `man pdftoppm` 查看详细参数
    

---

**适用人群**：文档自动化处理、OCR（Optical Character Recognition，光学字符识别）预处理、PDF 封面提取等任务的终端用户和开发者。