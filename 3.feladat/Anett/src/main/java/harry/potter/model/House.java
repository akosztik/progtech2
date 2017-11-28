package harry.potter.model;

import java.util.List;

public class House {

    private Integer id;
    private String crest;
    private String name;

    /**
     * A tulterhelt kostruktorok:
     *kulonbozo esetben peldanyositjak a House osztalyt.
     */

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
    /**
     * A getId Integert ad vissza,
     * mig a setIdval megadhato
     * az osztaly Idja.
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Az osztaly getterei es setterei:
     * karakterlancot adnak vissza,
     * vagy a House nevevel vagy cimerevel ternek vissza.
     */

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

    /**
     * A feluldefinialt toString metodus egy karakterlancot ad vissza.
     */
    @Override
    public String toString() {
        return "House{" +
                ", crest='" + crest + '\'' +
                ", name='" + name + '\'' + '}';
    }
}
