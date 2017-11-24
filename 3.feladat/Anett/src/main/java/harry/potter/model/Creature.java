package harry.potter.model;

import java.util.Date;

public class Creature extends Entities {

    private Long id;
    private Date firstMate;

    public Creature(String character, String name, Date firstMate) {
        super(character, name);
        this.firstMate = firstMate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFirstMate() {
        return firstMate;
    }

    public void setFirstMate(Date firstMate) {
        this.firstMate = firstMate;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "id=" + id +
                ", firstMate=" + firstMate +
                '}';
    }
}
