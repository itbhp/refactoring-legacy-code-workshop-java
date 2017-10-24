package com.workshop.refactoring;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GoldenMasterTest {
  @Test
  public void name() throws Exception {
    runMultipleTimes(1000);

    assertThat(readOutput(), is(readExpectedOutput()));
  }

  private String readOutput() throws IOException {
    return readContent("game-output.txt");
  }

  private String readExpectedOutput() throws IOException {
    return readContent("expected-game-output.txt");
  }

  private String readContent(String fileName) throws IOException {
    return String.valueOf(Files.readAllLines(Paths.get(fileName)));
  }

  private void runMultipleTimes(int times) throws FileNotFoundException {
    Path path = Paths.get("game-output.txt");
    System.setOut(new PrintStream(path.toFile()));

    for(int i = 1; i < times; i++) {
      GameRunner.run(new Random(i));
    }
  }
}
