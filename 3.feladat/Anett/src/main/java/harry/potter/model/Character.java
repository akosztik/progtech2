package harry.potter.model;

public class Character {

    private String name;
    private Integer Id;
    /**
     * Ezekkel a konstruktorral peldanyositunk Charactert.
     */
    public Character(String name)
    {
        this.name=name;
    }
    public Character(Integer Id,String name)
    {
        this.Id=Id;
        this.name=name;
    }
    /**
     * Ezekkel a fuggvenyekkel a Character nevet, illetve id-ját kapjuk vissza.
     */

    public String getName(){

        return this.name;
    }
    public Integer getId(){
        return this.Id;
    }

    /**
     * Illetve a toString metodussal a Character nevet.
     */
    @Override
    public String toString() {
        return this.name;
    }

}
