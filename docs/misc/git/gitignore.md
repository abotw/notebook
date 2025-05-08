---
date: 2025-05-08T12:07:00
---

## 🧾 Git 忽略特定文件或文件夹速查笔记

### 📂 基础规则（`.gitignore` 文件）

|规则语法|作用|
|---|---|
|`filename`|忽略当前目录下的某个文件|
|`/folder/`|忽略当前目录下的指定文件夹|
|`*.log`|忽略所有 `.log` 结尾的文件|
|`**/temp/`|忽略任意位置的 `temp/` 文件夹|
|`!keep.txt`|强制跟踪某个原本会被忽略的文件|

---

### 🎯 常见用法

#### 1. 忽略当前目录下的 `site/` 文件夹：

```
/site/
```

#### 2. 忽略子路径中的 `.obsidian/` 文件夹（如 `docs/.obsidian/`）：

```
/docs/.obsidian/
```

#### 3. 忽略所有目录下的 `.DS_Store` 文件：

```
**/.DS_Store
```

#### 4. 忽略所有 `node_modules` 文件夹：

```
node_modules/
```

#### 5. 忽略所有 `.log` 文件，但保留 `important.log`：

```
*.log
!important.log
```

---

### ⚠️ 忽略已被 Git 跟踪的文件或文件夹

如果某文件或文件夹 **已被 Git 跟踪**，`.gitignore` 不会生效，需先将其从缓存中移除：

```bash
git rm -r --cached 路径名
```

例如：

```bash
git rm -r --cached site
git rm -r --cached docs/.obsidian
```

然后提交更改：

```bash
git commit -m "Stop tracking ignored files"
```

---

### ✅ 提示与最佳实践

- `.gitignore` 应放在仓库根目录。
    
- 可以创建多级 `.gitignore`（如子文件夹下）。
    
- 可使用 GitHub 提供的 `.gitignore` 模板：[https://github.com/github/gitignore](https://github.com/github/gitignore)
    
- 若不确定是否忽略成功，可运行：
    

```bash
git check-ignore -v 路径名
```
