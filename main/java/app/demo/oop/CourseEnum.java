package app.demo.oop;

/**
 * @author steve
 */
public enum CourseEnum {
    ENGLISH(1),
    MATH(2, "Math");

    public int id;
    public String name;

    CourseEnum(int id) {
        this.id = id;
    }

    CourseEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static class A {
        public String id;

        public A(String id) {
            this.id = id;
        }
    }
}