package com.lab3.buncoplus;

import com.lab3.diceframework.Dice;
import com.lab3.diceframework.Player;
import com.lab3.diceframework.ScoreCalculatorStrategy;

/**
 * Created by francistoupin on 15-03-02.
 */
public class BuncoPlusScoreCalculator implements ScoreCalculatorStrategy {

    @Override
    public int calculateScore(Player player, final int round) {
        int score = 0;
        int roundOccurence = 0;
        boolean isBunco = false;

        do {
            Iterable<Dice> dices = player.rollDices();

            roundOccurence = getRoundOccurenceInRolledDices(dices,round);
            Dice dice1 = dices.iterator().next();

            //todo : revoir le calcul avec les règles.
            if(roundOccurence != 3){
                score += roundOccurence;
            } else if(dice1.getValue() == round) {
                score += 21;
                isBunco = true;
            } else{
                score += 5;
            }

        } while(roundOccurence != 0 && !isBunco);

        return score;
    }

    private boolean keepsHand(int round, Iterable<Dice> dices){
        return false;
    }

    private int getRoundOccurenceInRolledDices(Iterable<Dice> dices, int round){
        int roundOccurenceInDices = 0;
        for (Dice dice : dices){
            if(dice.equals(round)){
                roundOccurenceInDices++;
            }
        }

        return roundOccurenceInDices;
    }
}
