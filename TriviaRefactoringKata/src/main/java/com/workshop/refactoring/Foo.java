package com.workshop.refactoring;

import java.util.LinkedList;

public class Foo {
  private LinkedList popQuestions;
  private LinkedList scienceQuestions;
  private LinkedList sportsQuestions;
  private LinkedList rockQuestions;

  public Foo() {
    popQuestions = new LinkedList();
    scienceQuestions = new LinkedList();
    sportsQuestions = new LinkedList();
    rockQuestions = new LinkedList();
  }

  void fillQuestion() {
      for (int i = 0; i < 50; i++) {
          popQuestions.addLast("Pop Question " + i);
          scienceQuestions.addLast(("Science Question " + i));
          sportsQuestions.addLast(("Sports Question " + i));
          rockQuestions.addLast("Rock Question " + i);
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

  void askQuestionForCategory(String category) {
      if (category == "Pop")
          System.out.println(popQuestions.removeFirst());
      if (category == "Science")
          System.out.println(scienceQuestions.removeFirst());
      if (category == "Sports")
          System.out.println(sportsQuestions.removeFirst());
      if (category == "Rock")
          System.out.println(rockQuestions.removeFirst());
  }
}
