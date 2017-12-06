package harry.potter.model;

public class Character {
    private String name;
    private Integer Id;

    public Character(String name)
    {
        this.name=name;
    }
    public Character(Integer Id,String name)
    {
        this.Id=Id;
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    public Integer getId(){
        return this.Id;
    }


    @Override
    public String toString() {
        return this.name;
    }

}
