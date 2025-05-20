Here’s a clear comparison between **Mealy** and **Moore** machines in digital logic and automata theory:

|Aspect|Mealy Machine|Moore Machine|
|---|---|---|
|**Output depends on**|Current state **and** current input|Only the current state|
|**Output changes**|Immediately with input changes (without waiting for next state transition)|Only after a state transition|
|**State diagram**|Outputs are shown on transitions (edges)|Outputs are shown inside states|
|**Number of states**|Typically **fewer** states needed|May require **more** states|
|**Design complexity**|Slightly more complex because output logic depends on both state and input|Simpler to design because output depends only on state|
|**Reaction speed**|Faster (output can change without waiting for a clock edge)|Slower (output changes after state change)|
|**Typical use case**|When fast reaction to input is important|When stable outputs are important|

---

**Simple examples:**

- **Mealy:**
    
    ```
    If input = 1 while in state A → output = 0, move to state B
    If input = 0 while in state A → output = 1, stay in A
    ```
    
- **Moore:**
    
    ```
    In state A → output = 1
    In state B → output = 0
    Transitions depend on input, but outputs are tied to states only.
    ```
    
---

### 1. **Mealy Machine (Output on Transition)**

```
(State A) --[input=0 / output=1]--> (State B)
   | 
  [input=1 / output=0]
   |
   v
(State C)
```

- **Transition label**: `[input / output]`
    
- Output happens **during** the transition (depends on both input and state).
    

---

### 2. **Moore Machine (Output on State)**

```
(State A) output=1
    |
   [input=0]
    |
    v
(State B) output=0
    |
   [input=1]
    |
    v
(State C) output=1
```

- **State label**: `StateName (output)`
    
- Output depends **only on the state**, not on the input directly.
    

---

### Key Difference in diagrams:

- In **Mealy**, output is written on the arrows (transitions).
    
- In **Moore**, output is written inside the circles (states).
    