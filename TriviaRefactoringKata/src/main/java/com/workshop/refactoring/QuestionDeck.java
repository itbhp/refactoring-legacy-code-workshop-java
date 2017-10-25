package com.workshop.refactoring;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class QuestionDeck {
  private final Map<String, Category> categoriesByName;

  public QuestionDeck() {
    categoriesByName = new HashMap<>();
  }

  public QuestionDeck(Map<String, List<Integer>> board) {
    categoriesByName = board.entrySet().stream()
      .collect(Collectors.toMap(i -> i.getKey(), i -> new Category(i.getValue())));
  }

  void fillQuestions() {
    categoriesByName.put("Pop", new Category(Arrays.asList(0, 4, 8)));
    categoriesByName.put("Science", new Category(Arrays.asList(1, 5, 9)));
    categoriesByName.put("Sports", new Category(Arrays.asList(2, 6, 10)));
    categoriesByName.put("Rock", new Category(Arrays.asList(3, 7, 11)));

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

  public void addQuestion(String categoryName, String question) {
    //FIXME non dovrei entrarci mai, ma devo fare in modo che non ci entri mai
    if(!categoriesByName.containsKey(categoryName)){
      categoriesByName.put(categoryName, new Category(Collections.emptyList()));
    }

    categoriesByName.get(categoryName).addQuestion(question);
  }
}
