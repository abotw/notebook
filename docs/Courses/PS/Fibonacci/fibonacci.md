
# Fibonacci | 斐波那契数列

## Daniel21-Java12

### ComputeFibonacci

```java
// https://liveexample.pearsoncmg.com/liang/intro12e/html/ComputeFibonacci.html

import java.util.Scanner;

public class ComputeFibonacci {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an index for a Fibonacci number: ");
    int index = input.nextInt();

    // Find and display the Fibonacci number
    System.out.println("The Fibonacci number at index "  
      + index + " is " + fib(index));
  }

  /** The method for finding the Fibonacci number */
  public static long fib(long index) {
    if (index == 0) // Base case
      return 0;
    else if (index == 1) // Base case
      return 1;
    else  // Reduction and recursive calls
      return fib(index - 1) + fib(index - 2);
  }
}
```

### ImprovedFibonacci

```java
// https://liveexample.pearsoncmg.com/liang/intro12e/html/ImprovedFibonacci.html

import java.util.Scanner;

public class ImprovedFibonacci {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an index for the Fibonacci number: ");
    int index = input.nextInt();
    
    // Find and display the Fibonacci number
    System.out.println(
      "Fibonacci number at index " + index + " is " + fib(index));
  }
  
  /** The method for finding the Fibonacci number */
  public static long fib(long n) {   
    long f0 = 0; // For fib(0)
    long f1 = 1; // For fib(1)
    long f2 = 1; // For fib(2)
    
    if (n == 0) 
      return f0;
    else if (n == 1) 
      return f1;
    else if (n == 2) 
      return f2;

    for (int i = 3; i <= n; i++) {
      f0 = f1;
      f1 = f2;
      f2 = f0 + f1;
    }
    
    return f2;
  }
}
```