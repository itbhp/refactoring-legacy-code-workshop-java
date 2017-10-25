package com.workshop.refactoring;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.*;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class QuestionDeckTest {

  @Test
  public void placeWithCategory() throws Exception {
    Map<String, List<Integer>> board = new HashMap<String, List<Integer>>() {{
      put("foo", Arrays.asList(555));
    }};
    final QuestionDeck deck = new QuestionDeck(board);
    assertThat(deck.categoryForPlace(555), is("foo"));
  }

  @Test
  @Parameters({
    "12", "123", "" + Integer.MAX_VALUE,
    "-1", "-57", "" + Integer.MIN_VALUE
  })
  public void placeWithoutCategory(Integer expectedPlace) throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    assertThat(deck.categoryForPlace(expectedPlace), is("Rock"));
  }

  @Test
  public void firstQuestionForCategory() throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    deck.addQuestion("foo", "qualsiasi stringa");
    assertThat(deck.askQuestionForCategory("foo"), is( "qualsiasi stringa"));
  }

  @Test
  public void unknownCategory() throws Exception {
    final QuestionDeck deck = new QuestionDeck();
    assertThat(deck.askQuestionForCategory("unknown"), is(nullValue()));
  }
}
