package com.qainfotech.tap.training.snl.api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.json.JSONException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class BoardTest {
	
	Board board;
  @BeforeClass
  public void beforeClass() {
  }

  @BeforeMethod
  public void beforeMethod() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption {
	  board = new Board();
	 
  }
  


  @Test
  public void Board() {
    throw new RuntimeException("Test not implemented");
  }

  @Test(expectedExceptions = MaxPlayersReachedExeption.class)
  public void MaxPlayersReached() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption{
	    //board = new Board();
	    // board.registerPlayer("vibhutigupta");
	     //board.registerPlayer("vanika");
	  	 board.registerPlayer("varsha");
	  	 board.registerPlayer("abc");
	  	 board.registerPlayer("def");
	  	 Assert.assertEquals(board.getData().getJSONArray("players").length(), 4);
	  
  }
  
  
  
  @Test(expectedExceptions = PlayerExistsException.class)
  public void PlayerExistsException() throws FileNotFoundException, UnsupportedEncodingException, com.qainfotech.tap.training.snl.api.PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException{
	  board.registerPlayer("varsha");
	  	 board.registerPlayer("abc");
	  	 board.registerPlayer("def");
	  	 
	  	Object name= board.getData().getJSONArray("players").getJSONObject(0).get("name");
	  	board.registerPlayer("varsha");
	  
	  
  }
  
  @Test(expectedExceptions =  InvalidTurnException.class)
  public void InvalidTurnException() throws FileNotFoundException, UnsupportedEncodingException, com.qainfotech.tap.training.snl.api.PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, com.qainfotech.tap.training.snl.api.InvalidTurnException{
	  board.registerPlayer("varsha");
	  	 board.registerPlayer("abc");
	  	 board.registerPlayer("def");
	  	 UUID u = (UUID) board.getData().getJSONArray("players").getJSONObject(1).get("uuid");
	  	 board.rollDice(u);
	  	 
	  	 
  }
  

  @Test(expectedExceptions = GameInProgressException.class)
  public void GameInProgress() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, InvalidTurnException {
	     board = new Board();
	     board.registerPlayer("vibhutigupta");
	     board.registerPlayer("vanika");
	  	 board.registerPlayer("varsha");
	  	// board.registerPlayer("abc");
	  	
	  	UUID u= (UUID) board.getData().getJSONArray("players").getJSONObject(0).get("uuid");
	  	 board.rollDice(u);
	  	 board.registerPlayer("abc");
	  
  }
  
  
  @Test
  public void deletePlayer() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, NoUserWithSuchUUIDException {
    //throw new RuntimeException("Test not implemented");
	  board = new Board();
	  
		 board.registerPlayer("vibhutigupta");
	     board.registerPlayer("vanika");
	  	 board.registerPlayer("varsha");
	  	 board.registerPlayer("abc");
	  	 
	  	 UUID u = (UUID) board.getData().getJSONArray("players").getJSONObject(0).get("uuid");
	  	Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(0).get("uuid").equals(u), true);
	  	board.deletePlayer(u);
  }


  @Test
  public void registerPlayer() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException {
    //throw new RuntimeException("Test not implemented");
	  board = new Board();
	
	  board.registerPlayer("vibhutigupta");
      board.registerPlayer("vanika");
  	  board.registerPlayer("varsha");
  	  board.registerPlayer("abc");
	  Assert.assertEquals(board.getData().getJSONArray("players").length(), 4);
	 
	  Assert.assertEquals(board.getData().getJSONArray("players").getJSONObject(0).get("name").equals("vibhutigupta"), true);
  }

  @Test
  public void rollDice() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException, JSONException, InvalidTurnException {
   // throw new RuntimeException("Test not implemented");
	  board = new Board();
	  board.registerPlayer("vibhutigupta");
     // board.registerPlayer("vanika");
  	  //board.registerPlayer("varsha");
  	  //board.registerPlayer("abc");
  	  
  	 UUID u = (UUID) board.getData().getJSONArray("players").getJSONObject(0).get("uuid");
  	 //Integer turn = (Integer) board.getData().getJSONArray("players").getJSONObject(0).get("turn");
     Integer pos = (Integer) board.data.getJSONArray("players").getJSONObject(0).get("position");
     System.out.println(pos);
     Integer dice = board.rollDice(u).getInt("dice");
     System.out.println(dice);
     Integer pos_a = board.data.getJSONArray("players").getJSONObject(0).getInt("position");
     System.out.println(pos_a);
     Integer pos_e = pos+dice;
     System.out.println(pos_e);
     Integer target = (Integer) board.data.getJSONArray("steps").getJSONObject(dice).get("target");
     System.out.println(target);
     
    // Assert.assertEquals(pos_e, pos_a);
     Assert.assertTrue(dice<=6);
    
	
     Integer type = (Integer) board.data.getJSONArray("steps").getJSONObject(dice).get("type");
     if(type==0)
	  {
		  Assert.assertEquals(pos_e, target);
		  System.out.println(" nothing");
	  }
	  if(type==1)
	  {
		  Assert.assertTrue(pos_e>target);
		  System.out.println("snake");
	  }
	  if(type==2)
	  {
		  Assert.assertTrue(pos_e<target);
	  System.out.println("ladder");
	
}
    
  
	  
  }
     
     
     
     
     
    
  }

  //@Test
  //public void toString() {
    //throw new RuntimeException("Test not implemented");
  //}

