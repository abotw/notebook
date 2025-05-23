
# Naming Conventions

Naming conventions are essential for maintaining a consistent, readable, and maintainable codebase. This note outlines common naming styles for code files, text files, and directories, along with best practices and evaluation metrics.

---

## 1. Common Naming Styles

### Code Files

- **Camel Case**: `MyScript.js`, `DataProcessor.py`  
    _Often used in Java, JavaScript._
    
- **Snake Case**: `data_processor.py`, `main_module.cpp`  
    _Common in Python, C/C++._
    
- **Kebab Case** (hyphenated): `my-script.js`  
    _Often used in web development, especially for CLI tools or config files._
    
- **Pascal Case**: `DataManager.cs`  
    _Preferred in C# and some .NET environments._
    

### Text Files (e.g., Markdown, TXT)

- **Snake Case**: `project_overview.md`, `read_me.txt`
    
- **Kebab Case**: `project-overview.md`, `read-me.txt`
    
- **Lowercase Only**: `changelog.md`, `license.txt`  
    _Widely used in open-source repositories._
    

### Folders

- **Kebab Case**: `source-code/`, `test-data/`, `config-files/`  
    _Popular for readability, especially in URLs._
    
- **Snake Case**: `source_code/`, `test_data/`  
    _Preferred in Python projects._
    
- **Lowercase Only**: `docs/`, `assets/`, `src/`  
    _Common in many repositories._
    

---

## 2. Best Practices

1. **Be consistent**: Stick to one naming convention within a project.
    
2. **Use descriptive names**: Names should clearly indicate content or purpose.
    
    - ✅ `user_controller.py`
        
    - ❌ `file1.py`
        
3. **Avoid spaces and special characters**: Use `-` or `_` instead.
    
4. **Use lowercase for public files**: Easier to reference in case-sensitive systems.
    
5. **Avoid abbreviations** unless they are widely recognized.
    
    - ✅ `configuration.yaml`
        
    - ❌ `cfg.yaml`
        
6. **Use file extensions appropriately**: Reflect the file content or usage.
    

---

## 3. Evaluation Metrics

When assessing naming conventions, consider:

|Metric|Description|
|---|---|
|**Readability**|How easily a human can understand the name at a glance.|
|**Searchability**|How easy it is to locate files using fuzzy search or CLI tools like `find`.|
|**Scalability**|Does the naming scheme adapt well as the project grows?|
|**Tool Compatibility**|Are names compatible across OSes and tools (e.g., no spaces or special chars)?|
|**Sorting Order**|Alphabetical or chronological sorting should make logical sense.|

---

## Conclusion

Consistent and thoughtful naming conventions improve collaboration, reduce errors, and speed up development. Choose a naming style that suits your team’s habits and stick to it across your project.
