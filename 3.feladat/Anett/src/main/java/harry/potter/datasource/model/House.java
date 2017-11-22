package harry.potter.datasource.model;

import java.util.List;

public class House {

    private Long id;
    private String crest;
    private String name;
    private Integer numberOfStudents;
    private List<Student> students;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrest() {
        return crest;
    }

    public void setCrest(String crest) {
        this.crest = crest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(Integer numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", crest='" + crest + '\'' +
                ", name='" + name + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", students=" + students +
                '}';
    }
}
