package com.workshop.refactoring;

import org.junit.Test;

import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SpikeTests {
  @Test
  public void name() throws Exception {
    Path path = Paths.get("game-output3.txt");
    System.setOut(new PrintStream(path.toFile()));
    GameRunner.main(new String[0]);
  }
}
