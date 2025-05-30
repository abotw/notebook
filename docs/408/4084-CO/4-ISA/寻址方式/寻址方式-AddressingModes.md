---
aliases:
  - 寻址方式
  - Addressing Modes
---

![[470L22W24-27.png]]
![[李曦2025-指令系统-19.png]]

## Immediate, 立即寻址 (literal)

```
#n
```
## Direct, 直接寻址 (absolute)

```
M[#n]
```

## 隐含寻址

- 堆栈
- ACC

## Indirect, 间接寻址

1. 1次间接寻址
2. n次间接寻址

## Register, 寄存器寻址

## Register direct, 寄存器直接寻址

```
Ri
```

### Register indirect, 寄存器间接寻址

```
M[Ri]
```

## Displacement, 基址寻址

专用、通用寄存器

```
M[Ri + #n]
```

## 变址寻址

```
M[Ri++/-- + #n]

Autoincrement
M[Ri++]

Autodecrement
M[Ri--]
```

## PC相对寻址

PC + offset

## 堆栈寻址

SP, Stack Pointer

