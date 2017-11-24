package harry.potter.model;

import java.util.List;

public class House {

    private Long id;
    private String crest;
    private String name;

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


    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", crest='" + crest + '\'' +
                ", name='" + name + '\'' + '}';
    }
}
