package com.workshop.refactoring;

import org.junit.Test;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SpikeTests {
  @Test
  public void name() throws Exception {
    Path path = Paths.get("game-output.txt");
    System.setOut(new PrintStream(path.toFile()));
    new TestableGameRunner().run();

    String expected = String.valueOf(Files.readAllLines(Paths.get("expected-game-output.txt")));
    String actual = String.valueOf(Files.readAllLines(Paths.get("game-output.txt")));

    assertThat(actual, is(expected));
  }


  private class TestableGameRunner extends GameRunner{
   @Override
   protected Random createRandom() {
     return new Random(10);
   }
  }
}
