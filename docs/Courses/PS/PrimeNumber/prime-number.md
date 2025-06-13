
# Prime Number | 质数 | 素数

- if n is less than 2, than n is not prime
- divisor
	- worse: $[2, \frac{n}{2}]$
	- better: $[2, \sqrt{n}]$
		- `Math.sqrt(n)`

## isPrime()

```java
public static boolean isPrime(int n) {
	if (n < 2) return false;
	for (int i = 2; i <= Math.sqrt(n); i++) {
		if (n % i == 0) return false;
	}
	return true;
}
```

## Daniel21-Java12

```java
// https://liveexample.pearsoncmg.com/liang/intro12e/html/PrimeNumber.html

public class PrimeNumber {
  public static void main(String[] args) {
    final int NUMBER_OF_PRIMES = 50; // Number of primes to display
    final int NUMBER_OF_PRIMES_PER_LINE = 10; // Display 10 per line
    int count = 0; // Count the number of prime numbers
    int number = 2; // A number to be tested for primeness

    System.out.println("The first 50 prime numbers are \n");

    // Repeatedly find prime numbers
    while (count < NUMBER_OF_PRIMES) {
      // Assume the number is prime
      boolean isPrime = true; // Is the current number prime?

      // Test if number is prime
      for (int divisor = 2; divisor <= number / 2; divisor++) {
        if (number % divisor == 0) { // If true, number is not prime
          isPrime = false; // Set isPrime to false          
          break; // Exit the for loop
        }
      }

      // Print the prime number and increase the count
      if (isPrime) {
        count++; // Increase the count

        if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
          // Print the number and advance to the new line
          System.out.println(number);
        }
        else
          System.out.print(number + " ");
      }

      // Check if the next number is prime
      number++;
    }
  }
}
```