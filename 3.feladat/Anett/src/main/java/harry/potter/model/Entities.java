package harry.potter.model;

public abstract class Entities {

    private String character;
    private String name;

    /**
     * A tulterhelt kostruktorok:
     *kulonbozo esetben peldanyositjak az Entities osztalyt.
     */

    public Entities(String name) {
        this.name = name;
        this.character = "semleges";
    }

    public Entities(String name, String character) {
        this.name = name;
        this.character = character;
    }

    /**
     * Az osztaly getterei es setterei:
     * karakterlancot adnak vissza,
     * vagy az Entities characterevel vagy a nevevel ternek vissza.
     */
    public String getCharacter() {
        return this.character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
