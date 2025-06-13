public class Student {
    // 属性
    private int id;
    private String name;
    private boolean sex;  // true 表示男，false 表示女
    private float score;

    // 有参构造函数
    public Student(int i, String n, boolean s, float sc) {
        this.id = i;
        this.name = n;
        this.sex = s;
        this.score = sc;
    }

    // 获取性别
    public boolean getSex() {
        return this.sex;
    }

    // 获取成绩
    public float getScore() {
        return this.score;
    }

    // 返回字符串信息
    @Override
    public String toString() {
        return "姓名：" + name;
    }

    // 测试主函数
    public static void main(String[] args) {
        // 创建学生对象
        Student stu = new Student(1001, "张三", true, 89.5f);

        // 测试 getSex
        System.out.println("性别：" + (stu.getSex() ? "男" : "女"));

        // 测试 getScore
        System.out.println("成绩：" + stu.getScore());

        // 测试 toString
        System.out.println(stu.toString());
    }
}
