---
doc: https://docs.oracle.com/javase/8/docs/api/java/lang/System.html
---

# System

## getProperty

![](assets/getProperty.png)

|Key|Description of Associated Value|
|---|---|
|`java.version`|Java Runtime Environment version|
|`java.vendor`|Java Runtime Environment vendor|
|`java.vendor.url`|Java vendor URL|
|`java.home`|Java installation directory|
|`java.vm.specification.version`|Java Virtual Machine specification version|
|`java.specification.maintenance.version`|Java Runtime Environment specification maintenance version, may be interpreted as a positive integer _(optional, see below)_|
|`java.vm.specification.vendor`|Java Virtual Machine specification vendor|
|`java.vm.specification.name`|Java Virtual Machine specification name|
|`java.vm.version`|Java Virtual Machine implementation version|
|`java.vm.vendor`|Java Virtual Machine implementation vendor|
|`java.vm.name`|Java Virtual Machine implementation name|
|`java.specification.version`|Java Runtime Environment specification version|
|`java.specification.vendor`|Java Runtime Environment specification vendor|
|`java.specification.name`|Java Runtime Environment specification name|
|`java.class.version`|Java class format version number|
|`java.class.path`|Java class path|
|`java.library.path`|List of paths to search when loading libraries|
|`java.io.tmpdir`|Default temp file path|
|`java.compiler`|Name of JIT compiler to use|
|`java.ext.dirs`|Path of extension directory or directories **Deprecated.** _This property, and the mechanism which implements it, may be removed in a future release._|
|`os.name`|Operating system name|
|`os.arch`|Operating system architecture|
|`os.version`|Operating system version|
|`file.separator`|File separator ("/" on UNIX)|
|`path.separator`|Path separator (":" on UNIX)|
|`line.separator`|Line separator ("\n" on UNIX)|
|`user.name`|User's account name|
|`user.home`|User's home directory|
|`user.dir`|User's current working directory|

## in

![](assets/in.png)

### read

![](assets/read.png)

```java
(char)System.in.read();
```
## out

![](assets/out.png)

### println

![](assets/println.png)