package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class QuestionDeckTest {

  @Test
  @Parameters({
    "0, Pop", "4, Pop", "8, Pop",
    "1, Science", "5, Science", "9, Science",
    "2, Sports", "6, Sports", "10, Sports",
    "3, Rock", "7, Rock", "11, Rock",
  })
  public void placeForCategory(Integer expectedPlace, String expectedCategory) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    assertThat(deck.categoryForPlace(expectedPlace), is(expectedCategory));
  }

  @Test
  @Parameters({
    "12", "123", "" + Integer.MAX_VALUE,
    "-1", "-57", "" + Integer.MIN_VALUE
  })
  public void outOfBoard(Integer expectedPlace) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    assertThat(deck.categoryForPlace(expectedPlace), is("Rock"));
  }

  @Test
  @Parameters({"Pop", "Science", "Sports", "Rock"})
  public void firstQuestionForCategory(String category) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    deck.fillQuestions();
    assertThat(deck.askQuestionForCategory(category), is(category + " Question 0"));
  }

  @Test
  @Parameters({"Pop", "Science", "Sports", "Rock"})
  public void manyQuestionsForCategory(String category) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    deck.fillQuestions();
    assertThat(deck.askQuestionForCategory(category), is(category + " Question 0"));
    assertThat(deck.askQuestionForCategory(category), is(category + " Question 1"));
    assertThat(deck.askQuestionForCategory(category), is(category + " Question 2"));
  }

  @Test
  @Parameters({"Pop", "Science", "Sports", "Rock"})
  public void endOfQuestions(String category) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    deck.fillQuestions();
    for (int i = 0; i < 50; i++) {
      assertThat(deck.askQuestionForCategory(category), is(category + " Question " + i));
    }
    try {
      deck.askQuestionForCategory(category);
      fail("expected exception");
    } catch (Exception ex) {
      assertThat(ex, instanceOf(NoSuchElementException.class));
    }
  }

  @Test
  @Parameters({"Pop", "Science", "Sports", "Rock"})
  public void missingFill(String category) throws Exception {
    final QuestionDeck deck = new QuestionDeck();

    try {
      deck.askQuestionForCategory(category);
      fail("expected exception");
    } catch (Exception ex) {
      assertThat(ex, instanceOf(NoSuchElementException.class));
    }
  }

}
