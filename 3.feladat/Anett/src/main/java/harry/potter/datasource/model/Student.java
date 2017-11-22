package harry.potter.datasource.model;

public class Student extends Entities {


    private Long id;
    private Integer age;

    public Student(Long id, Integer age, String character, String name) {
        super(character, name);
        this.age = age;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
