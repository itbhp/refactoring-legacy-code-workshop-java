package com.workshop.refactoring;

import java.util.*;
import java.util.stream.IntStream;

public class QuestionDeck {
  private final Map<String, Category> categoriesByName;

  public QuestionDeck() {
    categoriesByName = new HashMap<>();
    categoriesByName.put("Pop", new Category(Arrays.asList(0, 4, 8)));
    categoriesByName.put("Science", new Category(Arrays.asList(1, 5, 9)));
    categoriesByName.put("Sports", new Category(Arrays.asList(2, 6, 10)));
    categoriesByName.put("Rock", new Category(Arrays.asList(3, 7, 11)));
  }

  void fillQuestions() {
    categoriesByName.forEach((key, value) ->
      IntStream.rangeClosed(0, 50).forEach(i -> value.addQuestion(createIndexedQuestion(i, key))));
  }

  private String createIndexedQuestion(int i, final String category) {
    return category + " Question " + i;
  }

  String categoryForPlace(int place) {
    return categoriesByName.entrySet().stream()
      .filter(item -> item.getValue().isPlacedOn(place))
      .map(Map.Entry::getKey)
      .findFirst().orElse("Rock");
  }

  Object askQuestionForCategory(String category) {
    return categoriesByName.entrySet().stream()
      .filter(i -> i.getKey().equals(category))
      .map(i -> i.getValue().nextQuestion())
      .findFirst().orElse(null);
  }
}
