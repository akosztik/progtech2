package harry.potter.model;

import java.util.List;

public class House {

    private Integer id;
    private String crest;
    private String name;

    public House() {
    }

    public House(String name, String crest) {
        this.crest = crest;
        this.name = name;
    }

    public House(Integer id, String name, String crest) {
        this.id = id;
        this.crest = crest;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
                ", crest='" + crest + '\'' +
                ", name='" + name + '\'' + '}';
    }
}
