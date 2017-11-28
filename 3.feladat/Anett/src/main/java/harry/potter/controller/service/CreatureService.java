package harry.potter.controller.service;

import harry.potter.controller.datasource.CreatureDatasource;
import harry.potter.model.Creature;

public class CreatureService {

    CreatureDatasource cd = new CreatureDatasource();

    /**
     * Ezekkel a metodussal a CreatureDatasource metodusanak adjuk at a creature nevet, karakteret.
     * parametere: a creature, a Creature osztaly egy peldanya.
     */

    public void addCreature(Creature creature) {
        cd.addCreature(creature.getName(),creature.getCharacter());
    }
}
