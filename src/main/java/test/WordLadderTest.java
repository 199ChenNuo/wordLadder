package test;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/** 
* WordLadder Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 10, 2018</pre> 
* @version 1.0 
*/ 
public class WordLadderTest { 
   static WordLadder wl;
@Before
public void before() throws Exception {
} 

@After
public void after() throws Exception {
   System.out.println(WordLadder.w1);
   System.out.println(WordLadder.w2);
   Set<String> dic = WordLadder.dic;
   Scanner sc = WordLadder.sc;
} 

/** 
* 
* Method: main(String[] args) 
* 
*/ 
@Test
public void testMain() throws Exception { 
//TODO: Test goes here...
   wl = new WordLadder();
} 

/** 
* 
* Method: getKeyWords() 
* 
*/ 
@Test
public void testGetKeyWords() throws Exception { 
//TODO: Test goes here...
   String data =  ".\\src\\dictionary.txt";
   String input;
   InputStream stdin = System.in;
   try{
      System.setIn(new ByteArrayInputStream(data.getBytes()));
      WordLadder.getKeyWords();
   }finally {
      System.setIn(stdin);
   }
} 

/** 
* 
* Method: getWords() 
* 
*/ 
@Test
public void testGetWords() throws Exception { 
//TODO: Test goes here...

} 

/** 
* 
* Method: getLadder() 
* 
*/ 
@Test
public void testGetLadder() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: getNeighbor(String w) 
* 
*/ 
@Test
public void testGetNeighbor() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: printLadder(Stack<String> stack) 
* 
*/ 
@Test
public void testPrintLadder() throws Exception { 
//TODO: Test goes here...
  // assert("this", WordLadder().printLadder((Stack<String>)"this");
} 


} 
