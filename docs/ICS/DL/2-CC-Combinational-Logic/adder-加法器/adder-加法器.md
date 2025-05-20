---
wiki: https://en.wikipedia.org/wiki/Adder_(electronics)
---

## Half Adder

**Definition**:  
A half adder is a basic combinational circuit that performs the addition of two single-bit binary numbers.

**Inputs**:
- A (1-bit)
- B (1-bit)

**Outputs**:
- **Sum (S)** = A ⊕ B (XOR)
- **Carry (C)** = A · B (AND)

**Truth Table**:

|A|B|Sum|Carry|
|---|---|---|---|
|0|0|0|0|
|0|1|1|0|
|1|0|1|0|
|1|1|0|1|

**Use**:  
Half adders are the building blocks of full adders, which can add multi-bit binary numbers.

## Full Adder

**Definition**:  
A full adder is a combinational circuit that adds three 1-bit binary numbers: two **significant bits (操作数)** and **an input carry (来自低位的进位)**.

**Inputs**:

- A (1-bit)
- B (1-bit)
- Cin (Carry-in)

**Outputs**:

- **Sum (S)** = A ⊕ B ⊕ Cin
- **Carry-out (Cout)** = (A · B) + (B · Cin) + (A · Cin)

**Truth Table**:

|A|B|Cin|Sum|Cout|
|---|---|---|---|---|
|0|0|0|0|0|
|0|0|1|1|0|
|0|1|0|1|0|
|0|1|1|0|1|
|1|0|0|1|0|
|1|0|1|0|1|
|1|1|0|0|1|
|1|1|1|1|1|

**Use**:  
Full adders are used to build multi-bit binary adders (like 4-bit or 8-bit adders) by chaining multiple full adders together.
