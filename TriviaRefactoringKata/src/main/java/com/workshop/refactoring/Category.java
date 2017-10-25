package com.workshop.refactoring;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Category {
  private final Deque<String> questions;
  private final List<Integer> places;

  public Category(List<Integer> places) {
    this.questions = new LinkedList<>();
    this.places = places;
  }

  public void addQuestion(String question) {
    questions.addLast(question);
  }

  public boolean isPlacedOn(int place) {
    return places.contains(place);
  }

  public String nextQuestion() {
    return questions.removeFirst();
  }
}
