public class TestEmployee {
    public static void main(String[] args) {
        // 创建一个部门对象
        Department dept = new Department(101, "研发部");

        // 创建一个职工对象
        Employee emp = new Employee(10001L, "李四", 30, 13800138000l, dept);

        // 测试方法
        System.out.println("年龄：" + emp.getAge());
        System.out.println("电话：" + emp.getPhone());
        System.out.println(emp.toString());
    }
}
