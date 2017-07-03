package com.qainfotech.tap.training.snl.api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BoardModelTest {
	Board board;
	
  @BeforeMethod
  public void beforeMethod() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
	  board = new Board();
	  board.registerPlayer("vibhutigupta");
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }


  @Test
  public void data() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void getStep() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void init() {
    throw new RuntimeException("Test not implemented");
  }

  @Test
  public void save() {
    throw new RuntimeException("Test not implemented");
  }
}
