# PDF Tools

在 macOS 上，有许多开源且实用的 PDF 处理工具，涵盖查看、注释、合并、拆分、加密、压缩等功能。以下是一些推荐：

|应用名称|简介|支持功能|官网/下载地址|
|---|---|---|---|
|**Skim**|专注于学术论文阅读的 PDF 阅读器|高亮、注释、书签、LaTeX 预览|[skim-app.sourceforge.net](https://skim-app.sourceforge.net/)|
|**PDFsam Basic**|功能强大的 PDF 分割/合并工具|拆分、合并、旋转、提取页面|[pdfsam.org](https://pdfsam.org/)|
|**OCRmyPDF**|给 PDF 添加 OCR 文字识别层|图像转文字、保留原始布局|[github.com/ocrmypdf/ocrmypdf](https://github.com/ocrmypdf/OCRmyPDF)|
|**PDF Arranger**|轻量级的页面操作工具|重排页面、旋转、提取、合并|[github.com/pdfarranger/pdfarranger](https://github.com/pdfarranger/pdfarranger)|
|**Qoppa PDF Studio（非免费，但跨平台）**|虽不是开源，但比 Acrobat 轻巧|编辑、注释、表单、OCR|[pdfstudio.com](https://www.qoppa.com/pdfstudio/)|

## 补充命令行工具

| 工具                                     | 简介                 | 安装方法（Homebrew）             |
| -------------------------------------- | ------------------ | -------------------------- |
| **Poppler（`pdftotext`、`pdfimages` 等）** | 转换 PDF 为文本、提取图片    | `brew install poppler`     |
| **Ghostscript**                        | PDF 压缩、转换          | `brew install ghostscript` |

---

### 示例：压缩 PDF（命令行）

```bash
gs -sDEVICE=pdfwrite -dCompatibilityLevel=1.4 -dPDFSETTINGS=/screen \
   -dNOPAUSE -dQUIET -dBATCH -sOutputFile=output.pdf input.pdf
```
