
## 文件命名规范

        
1. **前缀分类（可选）**
    
    - 按内容类型前缀分类，可提高排序与识别效率：
        
        - `note-xxx.md`：一般笔记
            
        - `ref-xxx.md`：参考资料
            
        - `lab-xxx.md`：实验记录
            
        - `read-xxx.md`：阅读笔记
            
2. **日期前缀（适用于日志/随笔类）**
    
    - 如 `2025-05-23-cpu-cache-overview.md`，方便排序和回溯。
        

---

## 🗂 文件夹结构建议

你可以基于“主题+内容类型”的二维划分：

```
/notes
  /cs
    /os
      - intro.md
      - process-management.md
    /computer-architecture
      - cpu.md
      - alu.md
  /math
    /discrete
    /linear-algebra

/reading
  - book-computer-organization.md

/labs
  /verilog
    - lab1-led.md
    - lab2-adder.md

/assets
  /images
    - cpu-diagram.png
  /pdfs
    - risc-v-spec.pdf
```

> 🔧 提示：保持文件路径尽量扁平，避免过深结构，利于 mkdocs 路由生成和维护。

---

## 🏷 标签与元数据管理

1. **统一标签格式（建议使用 YAML Front Matter）**
    
    ```yaml
    ---
    title: ALU Design
    tags: [verilog, digital-logic]
    created: 2025-05-20
    updated: 2025-05-23
    ---
    ```
    
2. **使用 Obsidian 的标签系统（#标签）辅助内部导航**
    
    - 如 `#verilog` `#实验记录` `#考试重点`，结合 Obsidian 的 tag 面板使用。
        
3. **元数据字段可同步用于 MkDocs 插件**
    
    - MkDocs 的 [metadata plugins](https://squidfunk.github.io/mkdocs-material/reference/metadata/) 可自动读取并渲染标题、作者、日期等信息。
        

---

## 🌐 Obsidian 与 MkDocs 的协同配置

1. **统一 Markdown 语法风格**
    
    - 避免使用 Obsidian 特有语法（如 `[[wikilinks]]`），改用标准链接 `[text](path/to/file.md)`。
        
    - 若坚持使用 `[[wikilink]]`，可启用 [mkdocs-obsidian-link](https://github.com/mkdocs/plugins) 插件转换为标准链接。
        
2. **支持搜索与目录优化**
    
    - 启用 `search.suggest`、`toc.integrate` 等 Material 主题功能。
        
    - 配置 `nav:` 项时，合理分组文档。
        
3. **使用 MkDocs 插件增强功能**
    
    - [`mkdocs-glightbox`](https://github.com/blueswen/mkdocs-glightbox)：优化图片查看
        
    - [`mkdocs-awesome-pages-plugin`](https://github.com/lukasgeiter/mkdocs-awesome-pages-plugin)：实现文件夹排序与隐藏
        
    - [`tags-plugin`](https://github.com/matusnovak/mkdocs-tags-plugin)：标签页支持
        

---

## 🔁 工作流建议

- **编辑 → Obsidian**
    
    - 本地快速编辑、笔记撰写、标签管理、双链引用。
        
- **发布 → MkDocs**
    
    - 使用 GitHub Action 或本地脚本将 `obsidian-vault/` 同步为 `docs/` 目录（可过滤 `.obsidian`、模板等）。
        
- **预览 → `mkdocs serve`**
    
    - 随时查看页面展示效果，避免格式问题。
        

---

## ✅ 最佳实践小结

|项目|建议做法|
|---|---|
|命名规则|统一 kebab-case / snake_case，避免空格中文|
|文件结构|主题/内容类型组合，避免过深层级|
|标签管理|Obsidian 标签 + YAML metadata 双轨制|
|Obsidian用法|避免过度依赖插件语法，保持纯 Markdown|
|MkDocs配置|用 nav 显式组织文档，善用主题与插件增强功能|
|自动化部署|使用 CI 或脚本实现自动构建与发布|

---

如果你愿意，我可以帮你生成一个标准的 `mkdocs.yml` 文件模板，适配你的 vault 结构。也可以提供自动化同步脚本（例如 Python + rsync）帮助你从 Obsidian vault 中提取文档。需要吗？