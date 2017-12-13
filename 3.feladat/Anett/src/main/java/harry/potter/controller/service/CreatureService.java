package harry.potter.controller.service;

import harry.potter.controller.datasource.CreatureDatasource;
import harry.potter.model.Creature;

import java.util.ArrayList;
import java.util.List;

public class CreatureService {

    CreatureDatasource cd = new CreatureDatasource();

    /**
     * Ezekkel a metodussal a CreatureDatasource metodusanak adjuk at a creature nevet, karakteret.
     * parametere: a creature, a Creature osztaly egy peldanya.
     */

    public void addCreature(Creature creature) {
        cd.addCreature(creature.getName(),creature.getCharacter());
    }
    /**
     * Ezzel a metodussal CreatureDatasource
     * azonos nevu metodusat hivjuk meg es arrayListet kapunk.
     */
    public List<Creature> listCreatures() {
        List<Creature> creatures = cd.listCreatures();
        return creatures;
    }
    /**
     * Ezzel a metodussal listabol string arrayt allitunk elo.
     * parametere: ArrayList
     */
    public String[] toArray(List<Creature> creatureList){
        String[] list=new String[creatureList.size()];
        for (int i =0;i<creatureList.size();i++ ){
            list[i]=creatureList.get(i).getName();
        }
        return list;
    }
    /**
     * Ezzel a metodussal a CreatureDataSource getCreatureByName metodusat
     * hivjuk meg mely egy leny peldanyt ad vissza.
     * parameterei egy string.
     */
    public Creature getCreatureByName(String name){
        Creature creature= cd.getCreatureByName(name);
        return creature;
    }
    /**
     * Ezzel a metodussal a CreatureDataSource adott jellemet valtoztato metodusat hivja meg
     * ugyanazokkal a parameterekkel.
     */
    public void changeCharacter(String name, String character){
        cd.changeCharacter(name,character);
    }
    /**
     * Ezzel a metodussal meghivom a CreatureDataSource adott metodusat ami updateli a
     * leny elso talalkozasi datumat.
     * parametere 2string egy nev es egy string formatumu datum : YYMMDD
     */
    public void updateCreature(String name, String date){
        cd.updateCreature(name, date);
    }
}
