# 导入

```java
import java.util.Calendar;
```

**`public abstract class** Calendar **implements** Serializable, Cloneable, Comparable<Calendar> {}`

**`public static** Calendar getInstance() {}`

# 字段

```java
public static final int ERA = 0;
public static final int YEAR = 1;
public static final int MONTH = 2;
public static final int WEEK_OF_YEAR = 3;
public static final int WEEK_OF_MONTH = 4;
public static final int DATE = 5;
public static final int DAY_OF_MONTH = 5;
public static final int DAY_OF_YEAR = 6;
public static final int DAY_OF_WEEK = 7;
public static final int DAY_OF_WEEK_IN_MONTH = 8;
public static final int AM_PM = 9;
public static final int HOUR = 10;
public static final int HOUR_OF_DAY = 11;
public static final int MINUTE = 12;
public static final int SECOND = 13;
public static final int MILLISECOND = 14;
```

# 使用

```java
import java.util.Calendar;

Calendar calendar = Calendar.getInstance();
int year = calendar.get(Calendar.YEAR);
System.out.println(year);
```