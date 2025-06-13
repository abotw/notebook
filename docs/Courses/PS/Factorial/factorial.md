
# Factorial | 阶乘

## Daniel21-Java12

### ComputeFactorial

```java
// https://liveexample.pearsoncmg.com/liang/intro12e/html/ComputeFactorial.html

import java.util.Scanner; 

public class ComputeFactorial {
  /** Main method */
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a non-negative integer: ");
    int n = input.nextInt();
    
    // Display factorial
    System.out.println("Factorial of " + n + " is " + factorial(n));
  }

  /** Return the factorial for a specified number */
  public static long factorial(int n) {
    if (n == 0) // Base case
      return 1;
    else
      return n * factorial(n - 1); // Recursive call
  }
}
```

### LargeFactorial

```java
// https://liveexample.pearsoncmg.com/liang/intro12e/html/LargeFactorial.html

import java.util.Scanner;
import java.math.*;

public class LargeFactorial {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter an integer: ");
    int n = input.nextInt();
    System.out.println(n + "! is \n" + factorial(n));
  }

  public static BigInteger factorial(long n) {
    BigInteger result = BigInteger.ONE; // Assign 1 to result
    for (int i = 1; i <= n; i++) // Multiply each i
      result = result.multiply(new BigInteger(i+""));

    return result;
  }
}
```