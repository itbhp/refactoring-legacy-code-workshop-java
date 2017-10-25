package com.workshop.refactoring;

import java.util.*;

public class Game {

  private final QuestionDeck questionDeck;

  ArrayList players = new ArrayList();
  int[] places = new int[6];
  int[] purses = new int[6];
  boolean[] inPenaltyBox = new boolean[6];

  int currentPlayer = 0;
  boolean isGettingOutOfPenaltyBox;

  public Game() {
    Map<String, List<Integer>> categoriesPlaces = new HashMap<String, List<Integer>>() {{
      put("History", Arrays.asList(0, 4, 8));
      put("Science", Arrays.asList(1, 5, 9));
      put("Sports", Arrays.asList(2, 6, 10));
      put("Rock", Arrays.asList(3, 7, 11));
    }};
    questionDeck = new QuestionDeck(categoriesPlaces);
    for (Map.Entry<String, List<Integer>> item : categoriesPlaces.entrySet()) {
      for (int i = 0; i < 50; i++) {
        questionDeck.addQuestion(item.getKey(), createIndexedQuestion(i, item.getKey()));
      }

    }
//    questionDeck.fillQuestions();
  }

  private String createIndexedQuestion(int i, final String category) {
    return category + " Question " + i;
  }

  public boolean isPlayable() {
    return (howManyPlayers() >= 2);
  }

  public boolean add(String playerName) {

    players.add(playerName);
    places[howManyPlayers()] = 0;
    purses[howManyPlayers()] = 0;
    inPenaltyBox[howManyPlayers()] = false;

    System.out.println(playerName + " was added");
    System.out.println("They are player number " + players.size());
    return true;
  }

  public int howManyPlayers() {
    return players.size();
  }

  public void roll(int roll) {
    System.out.println(players.get(currentPlayer) + " is the current player");
    System.out.println("They have rolled a " + roll);

    if (inPenaltyBox[currentPlayer]) {
      if (roll % 2 != 0) {
        isGettingOutOfPenaltyBox = true;

        System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

        System.out.println(players.get(currentPlayer)
          + "'s new location is "
          + places[currentPlayer]);
        System.out.println("The category is " + currentCategory());
        askQuestion();
      } else {
        System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
        isGettingOutOfPenaltyBox = false;
      }

    } else {

      places[currentPlayer] = places[currentPlayer] + roll;
      if (places[currentPlayer] > 11) places[currentPlayer] = places[currentPlayer] - 12;

      System.out.println(players.get(currentPlayer)
        + "'s new location is "
        + places[currentPlayer]);
      System.out.println("The category is " + currentCategory());
      askQuestion();
    }

  }

  private void askQuestion() {
    Object question = questionDeck.askQuestionForCategory(currentCategory());
    System.out.println(question);
  }


  private String currentCategory() {
    int currentPlace = places[currentPlayer];
    return questionDeck.categoryForPlace(currentPlace);
  }

  public boolean wasCorrectlyAnswered() {
    if (inPenaltyBox[currentPlayer]) {
      if (isGettingOutOfPenaltyBox) {
        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(players.get(currentPlayer)
          + " now has "
          + purses[currentPlayer]
          + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;
      } else {
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
      }


    } else {

      System.out.println("Answer was corrent!!!!");
      purses[currentPlayer]++;
      System.out.println(players.get(currentPlayer)
        + " now has "
        + purses[currentPlayer]
        + " Gold Coins.");

      boolean winner = didPlayerWin();
      currentPlayer++;
      if (currentPlayer == players.size()) currentPlayer = 0;

      return winner;
    }
  }

  public boolean wrongAnswer() {
    System.out.println("Question was incorrectly answered");
    System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
    inPenaltyBox[currentPlayer] = true;

    currentPlayer++;
    if (currentPlayer == players.size()) currentPlayer = 0;
    return true;
  }


  private boolean didPlayerWin() {
    return !(purses[currentPlayer] == 6);
  }
}
