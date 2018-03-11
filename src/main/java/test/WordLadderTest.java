package test;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import sun.java2d.opengl.WGLSurfaceData;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/** 
* WordLadder Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 10, 2018</pre> 
* @version 1.0 
*/ 
public class WordLadderTest {

@Before
public void before() throws Exception {
   testMain();
   System.out.println("before");
} 

@After
public void after() throws Exception {
} 

/** 
* 
* Method: main(String[] args) 
*
*/ 
@Test
public void testMain() throws Exception {
//TODO: Test goes here...
   testPrintLadder();
   testGetKeyWords();
   testGetLadder();
   testGetNeighbor();
   testGetWords();
}

/** 
* 
* Method: getKeyWords() 
* 
*/ 
@Test
public void testGetKeyWords() throws Exception { 
//TODO: Test goes here...
    WordLadder wl = new WordLadder();
   String data =  ".\\src\\main\\java\\test\\dictionary.txt\n";
   ByteArrayInputStream in = null;
   in = new ByteArrayInputStream(data.getBytes());
   System.setIn(in);
   assertEquals(data, wl.getKeyWords());
} 

/**
* 
* Method: getWords() 
* 
*/ 
@Test
public void testGetWords() throws Exception { 
//TODO: Test goes here...
    WordLadder wl = new WordLadder();
    String word = "bee\nbug\n";
    ByteArrayInputStream in = null;
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    wl.getWords();
} 

/** 
* 
* Method: getLadder() 
* 
*/ 
@Test
public void testGetLadder() throws Exception { 
//TODO: Test goes here..
    WordLadder wl = new WordLadder();
    assertEquals(true, wl.getLadder());
} 

/** 
* 
* Method: getNeighbor(String w) 
* 
*/ 
@Test
public void testGetNeighbor() throws Exception { 
//TODO: Test goes here...
    WordLadder wl = new WordLadder();
    String str = "bee";
    Set<String> neighbor = wl.getNeighbor(str);
    assertEquals(true, (!neighbor.contains(str)) && (neighbor.contains("beg")));
} 

/** 
* 
* Method: printLadder(Stack<String> stack) 
* 
*/ 
@Test
public void testPrintLadder() throws Exception { 
//TODO: Test goes here...
   WordLadder wl = new WordLadder();
   Stack<String> stack = new Stack<String>();
   stack.push("1");
   stack.push("2");
   stack.push("3");

   assertEquals(true, wl.printLadder(stack));

} 


} 
