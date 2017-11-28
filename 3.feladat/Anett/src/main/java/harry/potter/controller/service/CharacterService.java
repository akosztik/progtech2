package harry.potter.controller.service;

import harry.potter.controller.datasource.CharacterDatasource;
import harry.potter.model.Character;

public class CharacterService {

    CharacterDatasource chard = new CharacterDatasource();
    /**
     * Ezekkel a metodussal a CharacterDatasource metódusanak adjuk at a character nevet.
     * parametere: a character, a Character osztaly egy peldanya.
     */
    public void addCharacter(Character character) {
        chard.addCharacter(character.getName());
    }
}
