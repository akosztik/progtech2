package harry.potter.model;

public class Student extends Entities {

    private Integer age;
    private Integer houseId;


    public Student( Integer age, String name) {
        super(name);
        this.age = age;
    }

    public Student( Integer age,String character, String name,Integer houseId) {
        super(name,character);
        this.age = age;
        this.houseId= houseId;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(final Integer houseId) {
        this.houseId = houseId;
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
