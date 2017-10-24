package com.workshop.refactoring;

public class Foo {
  void fillQuestion(Game game) {
      for (int i = 0; i < 50; i++) {
          game.popQuestions.addLast("Pop Question " + i);
          game.scienceQuestions.addLast(("Science Question " + i));
          game.sportsQuestions.addLast(("Sports Question " + i));
          game.rockQuestions.addLast("Rock Question " + i);
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

  void askQuestionForCategory(String category, Game game) {
      if (category == "Pop")
          System.out.println(game.popQuestions.removeFirst());
      if (category == "Science")
          System.out.println(game.scienceQuestions.removeFirst());
      if (category == "Sports")
          System.out.println(game.sportsQuestions.removeFirst());
      if (category == "Rock")
          System.out.println(game.rockQuestions.removeFirst());
  }
}
