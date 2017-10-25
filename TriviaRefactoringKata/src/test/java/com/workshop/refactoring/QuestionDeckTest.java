package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class QuestionDeckTest {

  @Test
  @Parameters({
               "0, Pop","4, Pop","8, Pop",
               "1, Science","5, Science","9, Science",
               "2, Sports","6, Sports","10, Sports",
               "3, Rock","7, Rock","11, Rock",
              })
  public void placeForCategory(Integer expectedPlace, String expectedCategory) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    assertThat(deck.currentCategoryForPlaces(expectedPlace), is(expectedCategory));
  }
}
