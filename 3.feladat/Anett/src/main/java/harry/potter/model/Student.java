package harry.potter.model;

public class Student extends Entities {

    private Integer id;
    private Integer age;
    private Integer houseId;

    /**
     * A tulterhelt kostruktorok:
     *kulonbozo esetben peldanyositjak a Student osztalyt.
     */

    public Student(Integer age, String name) {
        super(name);
        this.age = age;
    }

    public Student(Integer id, Integer age, String character, String name, Integer houseId) {
        super(name, character);
        this.id = id;
        this.age = age;
        this.houseId = houseId;
    }

    public Student(Integer age, String character, String name, Integer houseId) {
        super(name, character);
        this.age = age;
        this.houseId = houseId;
    }

    /**
     * Az osztaly getterei es setterei:
     * egeszet adnak vissza,
     * vagy az Student Id , house id, eletkoraval ternek vissza
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    /**
     * A feluldefinialt toString metodus egy karakterlancot ad vissza.
     */

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                '}';
    }
}
