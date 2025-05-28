java.base/ → java/ → util/ → Date()

# 导入

```java
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
```

# 使用

```java
import java.util.Date;

System.out.println(new Date());
```

```java
import java.util.Date;

System.out.println(new Date(0));
System.out.println(new Date(1 * 1000));

// Thu Jan 01 08:00:00 CST 1970
// Thu Jan 01 08:00:01 CST 1970
```

```java
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
System.out.println(dateFormat.format(date));
```

- `java.text.DateFormat` **`public abstract class** DateFormat **extends** Format`
    - 方法：**`public final** String format(Date date)`
        
        ```java
        		/**
             * Formats a {@link Date} into a date-time string.
             *
             * @param date the time value to be formatted into a date-time string.
             * @return the formatted date-time string.
             */
            public final String format(Date date)
            {
                return format(date, new StringBuffer(),
                              DontCareFieldPosition.INSTANCE).toString();
            }
        ```
        
    - 子类：`java.text.SimpleDateFormat` **`public class** SimpleDateFormat **extends** DateFormat`