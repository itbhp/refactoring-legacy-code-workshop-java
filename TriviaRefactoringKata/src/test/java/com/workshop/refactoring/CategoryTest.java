package com.workshop.refactoring;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CategoryTest {

  @Test
  public void nextQuestion() throws Exception {
    final Category category =  new Category(Collections.emptyList());
    category.addQuestion("a");
    category.addQuestion("b");

    assertThat(category.nextQuestion(), is("a"));
    assertThat(category.nextQuestion(), is("b"));
  }

  @Test
  public void noQuestions() throws Exception {
    final Category category =  new Category(Collections.emptyList());

     try{
       category.nextQuestion();
       fail("expected exception");
     }catch (Exception ex) {
       assertThat(ex, instanceOf(NoSuchElementException.class));
     }
  }

  @Test
  public void noMoreQuestions() throws Exception {
    final Category category =  new Category(Collections.emptyList());
    category.addQuestion("a");

    assertThat(category.nextQuestion(), is("a"));

    try{
      category.nextQuestion();
      fail("expected exception");
    }catch (Exception ex) {
      assertThat(ex, instanceOf(NoSuchElementException.class));
    }
  }

  @Test
  public void checkMinePosition() throws Exception {
    Category category = new Category(Arrays.asList(1, 100));
    assertTrue(category.isPlacedOn(1));
    assertTrue(category.isPlacedOn(100));
  }

  @Test
  public void checkNotMinePosition() throws Exception {
    Category category = new Category(Arrays.asList(1, 100));
    assertFalse(category.isPlacedOn(11));
  }
}
