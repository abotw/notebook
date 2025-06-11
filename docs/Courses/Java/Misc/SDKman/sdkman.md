
# SDKman

在 **macOS** 上安装多个版本的 Java 并实现良好的版本管理，最推荐的方法是使用 **[SDKMAN!](https://sdkman.io/)**。

---

## 一、为什么选择 SDKMAN？

|优点|描述|
|---|---|
|🎛️ 支持多版本切换|可以安装和管理多个 JDK 版本（如 Java 8, 11, 17, 21 等）|
|🧼 不污染系统环境|不直接覆盖 macOS 系统 Java|
|📦 包含其他工具|除 Java 外还可管理 Maven、Gradle、Kotlin 等|
|🖥️ 命令行操作简单|一条命令安装和切换，非常干净利落|

---

## 二、安装 SDKMAN 并配置多版本 Java

### 1. 安装 SDKMAN

在终端执行：

```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

安装成功后，输入：

```bash
sdk version
```

如果输出版本号，说明安装成功。

---

### 2. 安装多个 Java 版本

列出所有可用版本：

```bash
sdk list java
```

常见选择示例：

|版本|推荐候选|
|---|---|
|Java 8|`8.0.392-tem`|
|Java 11|`11.0.22-tem`|
|Java 17|`17.0.10-tem`|
|最新版|例如 `21.0.2-tem`|

安装 Java 8：

```bash
sdk install java 8.0.452-kona
```

---

### 3. 设置默认版本和临时切换

#### 全局设置默认版本

```bash
sdk default java 8.0.452-kona
```

#### 当前终端会话临时使用

```bash
sdk use java 8.0.452-kona
```

#### 检查当前使用的版本

```bash
java -version
```

---

## 每个项目独立配置

在项目根目录执行：

```bash
sdk env init
```

会生成 `.sdkmanrc` 文件，设置 Java 版本：

```bash
java=8.0.452-kona
```

每次进入该目录时运行：

```bash
sdk env
```

即可自动切换。

---

## 四、与 macOS 自带 Java 共存

- SDKMAN 安装的 Java 会修改 `PATH` 和 `JAVA_HOME`，**不会影响系统自带版本**。
    
- 若使用 `java -version` 显示的是 SDKMAN 安装的版本，即表示配置成功。
    

---

## 总结

|操作|命令|
|---|---|
|安装 SDKMAN|`curl -s "[https://get.sdkman.io](https://get.sdkman.io/)"|
|安装 Java 8|`sdk install java 8.0.392-tem`|
|切换版本|`sdk use java <版本>`|
|设置默认版本|`sdk default java <版本>`|
|查看版本|`java -version`|
