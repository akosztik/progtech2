package harry.potter.controller.service;

import harry.potter.controller.datasource.CreatureDatasource;
import harry.potter.model.Creature;

public class CreatureService {
    CreatureDatasource cd;

    public void addCreature(Creature creature) {
        cd = new CreatureDatasource();
        cd.addCreature(creature.getName(),creature.getCharacter());
    }
}
