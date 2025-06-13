public class Department {
    private int id;         // 部门编号
    private String name;    // 部门名称

    // 有参构造函数
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
