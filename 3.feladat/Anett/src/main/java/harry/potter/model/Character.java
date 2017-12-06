package harry.potter.model;

public class Character {
    String name;
    /**
     * Ezzel a konstruktorral peldanyositunk Charactert.
     */
    public Character(String name)
    {
        this.name=name;
    }

    @Override

    /**
     * Ezekkel a fuggvenyekkel a Character nevet kapjuk vissza.
     * Illetve a toString metodussal a Character nevet.
     */
    public String toString() {
        return this.name;
    }
    public String getName(){
        return this.name;
    }
}
