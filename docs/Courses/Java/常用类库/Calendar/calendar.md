---
doc: https://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html
---

# Calendar

![](assets/cal.png)

## constants

![](assets/constants.png)

## getInstance

```java
Calendar cal = Calendar.getInstance();
```

![](assets/getInstance.png)

## get

![](assets/get.png)

```java
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH) + 1; // 0 for January
int day = cal.get(Calendar.DATE);
```

