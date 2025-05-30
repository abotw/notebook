
# Exceptions

## Handling Exceptions

```java
try {
	codes to try;
	possibly throw an exception;
	more codes;
} catch (ExceptionClassName exception) {
	process;
}
```

```java
throw new ExceptionClassName(optArguments);
```

```java
try {
	statements;
} catch (Exception ex) {
	handling ex;
} finally {
	final statements;
}

statements;
```

## The Java Exception Hierarchy

![](assets/yihong-ExceptionHandling-21.png)

## Checked Exceptions vs. Unchecked Exceptions

![](assets/yihong-ExceptionHandling-22.png)

### Unchecked Exceptions

![](assets/yihong-ExceptionHandling-23.png)

### The finally Bolck

![](assets/yihong-ExceptionHandling-24.png)

