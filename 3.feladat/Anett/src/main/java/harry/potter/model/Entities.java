package harry.potter.model;

public abstract class Entities {

    private String character;
    private String name;

    public Entities(String name) {
        this.name = name;
        this.character = "semleges";
    }
    public Entities(String name,String character) {
        this.name = name;
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}