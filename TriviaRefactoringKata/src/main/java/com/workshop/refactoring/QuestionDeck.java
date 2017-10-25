package com.workshop.refactoring;

import java.util.*;

public class QuestionDeck {
  private Deque popQuestions;
  private Deque scienceQuestions;
  private Deque sportsQuestions;
  private Deque rockQuestions;
  private final List<Integer> popPlaces;
  private final List<Integer> sciencePlaces;
  private final List<Integer> sportsPlaces;
  private final List<Integer> rockPlaces;

  public QuestionDeck() {
    popQuestions = new LinkedList();
    scienceQuestions = new LinkedList();
    sportsQuestions = new LinkedList();
    rockQuestions = new LinkedList();
    popPlaces = Arrays.asList(0, 4, 8);
    sciencePlaces = Arrays.asList(1, 5, 9);
    sportsPlaces = Arrays.asList(2, 6, 10);
    rockPlaces = Arrays.asList(3, 7, 11);
  }

  void fillQuestions() {
    for (int i = 0; i < 50; i++) {
      popQuestions.addLast(createIndexedQuestion(i, "Pop"));
      scienceQuestions.addLast(createIndexedQuestion(i, "Science"));
      sportsQuestions.addLast(createIndexedQuestion(i, "Sports"));
      rockQuestions.addLast(createIndexedQuestion(i, "Rock"));
    }
  }

  private String createIndexedQuestion(int i, final String category) {
    return category + " Question " + i;
  }

  String categoryForPlace(int place) {
    if (popPlaces.contains(place)) return "Pop";
    if (sciencePlaces.contains(place)) return "Science";
    if (sportsPlaces.contains(place)) return "Sports";
    if (rockPlaces.contains(place)) return "Rock";

    return "Rock";
  }

  Object askQuestionForCategory(String category) {
    Object question = null;
    if (Objects.equals(category, "Pop")) question = popQuestions.removeFirst();
    else if (Objects.equals(category, "Science")) question = scienceQuestions.removeFirst();
    else if (Objects.equals(category, "Sports")) question = sportsQuestions.removeFirst();
    else if (Objects.equals(category, "Rock")) question = rockQuestions.removeFirst();
    return question;
  }
}
