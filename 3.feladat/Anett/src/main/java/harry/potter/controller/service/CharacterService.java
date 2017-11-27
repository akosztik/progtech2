package harry.potter.controller.service;

import harry.potter.controller.datasource.CharacterDatasource;
import harry.potter.model.Character;

public class CharacterService {
    CharacterDatasource chard;

    public void addCharacter(Character character) {
        chard = new CharacterDatasource();
        chard.addCharacter(character.getName());
    }
}
