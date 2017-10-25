package com.workshop.refactoring;

import java.util.*;

public class QuestionDeck {

  private Map<String, LinkedList> questions = new HashMap<>();

  public QuestionDeck() {
    questions.put("Pop", new LinkedList());
    questions.put("Science", new LinkedList());
    questions.put("Sports", new LinkedList());
    questions.put("Rock", new LinkedList());
  }

  void fillQuestions() {
    for (int i = 0; i < 50; i++) {
      for (String type : questions.keySet()) {
        questions.get(type).addLast(type + " Question " + i);
      }
    }
  }

  String currentCategoryForPlaces(int place) {
    if (place == 0) return "Pop";
    if (place == 4) return "Pop";
    if (place == 8) return "Pop";
    if (place == 1) return "Science";
    if (place == 5) return "Science";
    if (place == 9) return "Science";
    if (place == 2) return "Sports";
    if (place == 6) return "Sports";
    if (place == 10) return "Sports";
    return "Rock";
  }

  Object askQuestionForCategory(String category) {
    Object question = null;
    if (questions.containsKey(category)) {
      question = questions.get(category).removeFirst();
      System.out.println(question);
    }
    return question;
  }
}
