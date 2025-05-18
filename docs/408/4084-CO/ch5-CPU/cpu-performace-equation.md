

-   Time reference in a computer is provided by **a clock (system clock)**.
-   The discrete time events specified by the clock is known as **clock cycles**.
-   CPU time for a program
-   -   = CPU clock cycles for a program * Clock cycle time
    -   = CPU clock cycles for a program / Clock Rate
-   Clock cycle time == Period (Ex: 2ns)
-   Clock Rate == Frequency (Ex: 200MHz)

-   IC = Instruction Count of a program
-   CPI = CPU clock cycles for a program / IC
-   CPU Time = IC * CPI * Clock cycle Time
-   CPU Time = IC * CPI / Clock Rate
-   Thus the CPU performance is dependent on three components:
    -   IC = Instruction count of program
    -   CPI = Cycle per instruction
    -   Period = Clock cycle time