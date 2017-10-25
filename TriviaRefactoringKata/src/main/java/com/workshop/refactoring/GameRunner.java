package com.workshop.refactoring;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class GameRunner {

    private static boolean notAWinner;

    public static void main(String[] args) {
        run(new Random());
    }

    public static void run(Random rand) {
        Game aGame = new Game(new HashMap<String, List<Integer>>() {{
          put("History", Arrays.asList(0, 4, 8));
          put("Science", Arrays.asList(1, 5, 9));
          put("Sports", Arrays.asList(2, 6, 10));
          put("Rock", Arrays.asList(3, 7, 11));
        }});

        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");


        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }


        } while (notAWinner);
    }
}
