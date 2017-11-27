package harry.potter.model;

import java.util.List;

public class House {

    private String crest;
    private String name;

    public House(String name, String crest){
        this.crest=crest;
        this.name=name;
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
