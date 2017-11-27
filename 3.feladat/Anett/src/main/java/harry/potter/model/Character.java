package harry.potter.model;

public class Character {
    String name;
    public Character(String name)
    {
        this.name=name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    public String getName(){
        return this.name;
    }
}
