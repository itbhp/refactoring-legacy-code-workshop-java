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
}
