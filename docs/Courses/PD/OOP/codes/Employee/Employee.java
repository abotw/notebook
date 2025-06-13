public class Employee {
    private long id;            // 职工号
    private String name;        // 姓名
    private int age;            // 年龄
    private String phone;       // 联系电话
    private Department dept;    // 所属部门

    // 无参构造函数
    public Employee() {
        // 可设置默认值，也可留空
    }

    // 有参构造函数
    public Employee(long i, String n, int a, long p, Department d) {
        this.id = i;
        this.name = n;
        this.age = a;
        // this.phone = String.valueOf(p);  // long 转 String
        this.phone = p + "";
        this.dept = d;
    }

    // 获取年龄
    public int getAge() {
        return this.age;
    }

    // 获取联系电话（返回 long）
    public long getPhone() {
        return Long.parseLong(this.phone);  // Long.parseLong(longString)
    }

    // 返回字符串信息
    @Override
    public String toString() {
        return "姓名：" + name + "，联系电话：" + phone;
    }

}
