package com.workshop.refactoring;

import java.util.*;

public class QuestionDeck {
  private final Category pop;
  private final Category science;
  private final Category sports;
  private final Category rock;

  public QuestionDeck() {
    pop = new Category(Arrays.asList(0, 4, 8));
    science = new Category(Arrays.asList(1, 5, 9));
    sports = new Category(Arrays.asList(2, 6, 10));
    rock = new Category(Arrays.asList(3, 7, 11));
  }

  void fillQuestions() {
    for (int i = 0; i < 50; i++) {
      pop.addQuestion(createIndexedQuestion(i, "Pop"));
      science.addQuestion(createIndexedQuestion(i, "Science"));
      sports.addQuestion(createIndexedQuestion(i, "Sports"));
      rock.addQuestion(createIndexedQuestion(i, "Rock"));
    }
  }

  private String createIndexedQuestion(int i, final String category) {
    return category + " Question " + i;
  }

  String categoryForPlace(int place) {
    if(pop.isPlacedOn(place)) return "Pop";
    if(science.isPlacedOn(place)) return "Science";
    if(sports.isPlacedOn(place)) return "Sports";
    if(rock.isPlacedOn(place)) return "Rock";

    return "Rock";
  }

  Object askQuestionForCategory(String category) {
    Object question = null;
    if (Objects.equals(category, "Pop")) question = pop.nextQuestion();
    if (Objects.equals(category, "Science")) question = science.nextQuestion();
    if (Objects.equals(category, "Sports")) question = sports.nextQuestion();
    if (Objects.equals(category, "Rock")) question = rock.nextQuestion();
    return question;
  }
}
