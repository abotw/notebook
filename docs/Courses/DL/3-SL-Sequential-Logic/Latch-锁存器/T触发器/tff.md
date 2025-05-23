# T触发器（Toggle Flip-Flop）

- **功能**：当 T = 1 时翻转输出（Toggle），T = 0 时保持当前状态。
- **状态转换**：
    - T = 0 → Q(next) = Q (keep 不变)
    - T = 1 → Q(next) = ¬Q（toggle 翻转）
- **激励方程**：Q(next) = T ⊕ Q
	- 0 ⊕ Q = Q (keep)
	- 1 ⊕ Q = ¬Q (toggle)
- **用途**：常用于计数器（如二进制计数器）。