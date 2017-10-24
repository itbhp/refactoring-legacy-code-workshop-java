package com.workshop.refactoring;

import org.junit.Test;

import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SpikeTests {
  @Test
  public void name() throws Exception {
    Path path = Paths.get("game-output.txt");
    System.setOut(new PrintStream(path.toFile()));
    GameRunner.main(new String[0]);
    String expected = String.valueOf(Files.readAllLines(Paths.get("expected-game-output.txt")));
    String actual = String.valueOf(Files.readAllLines(Paths.get("game-output.txt")));

    assertThat(expected, is(actual));
  }
}
