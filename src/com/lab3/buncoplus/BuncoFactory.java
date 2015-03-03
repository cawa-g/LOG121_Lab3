package com.lab3.buncoplus;

import com.lab3.diceframework.Dice;
import com.lab3.diceframework.Dices;
import com.lab3.diceframework.GameFactory;
import com.lab3.diceframework.Player;

/**
 * Crée une instance de jeu de Bunco
 */
public class BuncoFactory extends GameFactory {

    public BuncoFactory(int numberOfPlayers) {
        super(6, numberOfPlayers, new BuncoPlusScoreCalculator());
    }

    /**
     * Crée les dés pour un joueur
     * @return Les dés d'un joueur
     */
    @Override
    protected Dices createDicesForPlayer() {
        Dices dices = new Dices();

        for (int index = 0; index < 3; index++) {
            dices.add(new Dice(6));
        }

        return dices;
    }

    /**
     * Crée un joueur
     * @param dices Les dés du joueur
     * @return Un nouveau joueur
     */
    @Override
    protected Player createPlayer(Dices dices) {
        return new Player(dices);
    }
}
