package test;

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import sun.java2d.opengl.WGLSurfaceData;

import static org.junit.Assert.assertEquals;

import java.io.*;
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
   //testMain();
   //System.out.println("before");
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
    WordLadder wl = new WordLadder();
    String data =  "apple\n\n";
    ByteArrayInputStream in = null;
    in = new ByteArrayInputStream(data.getBytes());
    System.setIn(in);
   wl.main(null);
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
   Set<String> dic = new HashSet<String>();
   String data =  "apple\nkeep\n";//error, lack '.txt'
   ByteArrayInputStream in = null;
   in = new ByteArrayInputStream(data.getBytes());
   System.setIn(in);
   assertEquals(".\\src\\main\\java\\test\\dictionary.txt", wl.getKeyWords(dic));
} 

/**
* 
* Method: getWords() 
* 
*/ 
@Test
public void testGetWords() throws Exception { 
//TODO: Test goes here...
    // initial
    WordLadder wl = new WordLadder();
    Set<String> dic = new HashSet<String>();
    File dicFile = new File(".\\src\\main\\java\\test\\dictionary.txt");
    InputStreamReader reader = new InputStreamReader(new FileInputStream(dicFile));
    BufferedReader br = new BufferedReader((reader));
    String line = "";
    line = br.readLine();
    while(line != null){
        line = br.readLine();
        dic.add(line);
    }
    br.close();
    // normal
    System.out.println("testGetWords() normal case:");
    String word = "bee\nbug\n";
    ByteArrayInputStream in = null;
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(true, wl.getWords(dic));

    // word1 is ENTER
    System.out.println("\ntestGetWords() word1 == 'ENTER' exit");
    word = "\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(false, wl.getWords(dic));

    //word2 is ENTER
    System.out.println("\ntestGetWords() word2 == 'ENTER' exit");
    word = "apple\n\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(false, wl.getWords(dic));

    // word1 is invalid
    System.out.println("\ntestGetWords() word1 invalid");
    word = "aaaaaaaa\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(true, wl.getWords(dic));

    // word2 is invalid
    System.out.println("\ntestGetWords() word1 invalid");
    word = "apple\naaaaaaaa\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(true, wl.getWords(dic));

    // word1 == word2
    System.out.println("\ntestGetWords() word1 equals word2");
    word = "apple\napple\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(true, wl.getWords(dic));

    // word1 and word2 differ by one letter
    System.out.println("\ntestGetWords() word1 differs word2 by one letter");
    word = "beg\nbee\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(true, wl.getWords(dic));

    // no word ladder
    System.out.println("\nno word ladder");
    word = "programmer\ngirlfriend\n";
    in = new ByteArrayInputStream(word.getBytes());
    System.setIn(in);
    assertEquals(true, wl.getWords(dic));
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
    Set<String> dic = new HashSet<String>();
    File dicFile = new File(".\\src\\main\\java\\test\\dictionary.txt");
    InputStreamReader reader = new InputStreamReader(new FileInputStream(dicFile));
    BufferedReader br = new BufferedReader((reader));
    String line = "";
    line = br.readLine();
    while(line != null){
        line = br.readLine();
        dic.add(line);
    }
    br.close();
    assertEquals(true, wl.getLadder("bee", "bug", dic));
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
    Set<String> dic = new HashSet<String>();
    File dicFile = new File(".\\src\\main\\java\\test\\dictionary.txt");
    InputStreamReader reader = new InputStreamReader(new FileInputStream(dicFile));
    BufferedReader br = new BufferedReader((reader));
    String line = "";
    line = br.readLine();
    while(line != null){
        line = br.readLine();
        dic.add(line);
    }
    br.close();
    Set<String> neighbor = wl.getNeighbor(str, dic);
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
}


} 
