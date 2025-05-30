
# 浮点数加减运算的基本步骤

## 浮点加减运算的五个步骤（以 IEEE754 标准为基础）：

1. **对阶（Exponent Alignment）**
    
    - 使两个操作数的阶码（Exponent）相等。
        
    - 方法：将较小的阶码向较大的对齐，同时**右移对应尾数**（Mantissa），注意右移时要补 0（即“逻辑右移”），并记录移出的位以便后续舍入。
        
    - 阶码不变，以大的为准。
        
2. **尾数求和（Mantissa Addition/Subtraction）**
    
    - 阶码一致后，根据符号位执行尾数的**加法或减法**。
        
    - 注意：使用**原码加法规则**，需要注意符号位判断是否是加还是减。
        
    - 尾数部分默认带隐含的“1”（规格化数的隐藏位），如 1.xxxxx。
        
3. **规格化（Normalization）**
    
    - 运算结果可能不是规格化形式（即，尾数不是以“1.”开头）。
        
    - 若高位产生进位，则尾数右移一位，阶码加一。
        
    - 若高位为 0，则尾数左移，阶码减一，直到满足规格化要求（最高位为1）。
        
    - 特殊情况：若最终阶码过小，可能是**下溢**。
        
4. **舍入（Rounding）**
    
    - 将尾数保留到规定的有效位数（如 IEEE754 单精度 23 位小数部分），多出的部分根据舍入规则处理。
        
    - 常用舍入方式：向最接近值舍入（round to nearest, even）。
        
    - 舍入可能再次引起尾数进位 → 需再次规格化。
        
5. **溢出/下溢判断（Overflow / Underflow Check）**
    
    - 若结果阶码超出可表示范围：
        
        - 阶码过大为**上溢（overflow）**，结果置为 ±∞（IEEE754）或报错。
            
        - 阶码过小为**下溢（underflow）**，若小于最小规格化数 → 表示为“非规格化数”或置 0。
            

---

## 408考研注意点总结（补充）

- 重点理解“对阶”与“规格化”中的移位方向及其影响。
    
- 明确加/减法实际操作的是尾数，符号位仅决定加/减而非运算符。
    
- 掌握常见陷阱：如**对阶时尾数精度损失**、**舍入后引发规格化**等。
    
- 熟悉 IEEE 754 浮点数结构（符号位 + 阶码 + 尾数）及其表示范围。
    
- 下溢在考试中常用于考查对非规格化数和“0”的处理。
    
