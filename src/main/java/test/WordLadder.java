package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class WordLadder {
    public static void main(String[] args){
        Set<String> dic = new HashSet<String>();
        WordLadder wl = new WordLadder();
        wl.getKeyWords(dic);
        boolean flag = true;
        while (flag){
            flag = wl.getWords(dic);
            if(flag == false)
                break;;
        }
        System.out.println("Have a nice day.");
    }

    // initial dic and call fun to get word1, word2
    public String getKeyWords(Set<String> dic){
        //System.out.print("Dictionary file name?\n");
        Scanner sc1 = new Scanner(System.in);
        //String dicName = sc1.nextLine();
        String dicName = ".\\src\\main\\java\\test\\dictionary.txt";
        try{
            File dicFile = new File(dicName);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(dicName));
            BufferedReader br = new BufferedReader((reader));
            String line = "";
            line = br.readLine();
            while(line != null){
                line = br.readLine();
                dic.add(line);
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return dicName;
    }

    // get word1, word2(and check them), then call fun to find word ladder
    public boolean getWords(Set<String> dic){
        String w1 = null;
        String w2 = null;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Word #1 (or Enter to quit): ");
        w1 = sc2.nextLine();
        if(w1.length() == 0)// input 'Enter'
            return false;
        if(!dic.contains(w1)){// invalid word1
            System.out.println(w1 + " is not in the dictionary.");
            return true;
        }
        System.out.println("Word #2 (or Enter to quit): ");
        w2 = sc2.nextLine();
        if(w2.length() == 0)
            return false;
        if(!dic.contains(w2)){
            System.out.println(w2 + " is not in the dictionary.");
            return true;
        }
        if(w1.equals(w2)){
            System.out.println("The two words must be different.");
            return true;
        }
        w1.toLowerCase();
        w2.toLowerCase();
        getLadder(w1, w2, dic);
        return true;
    }

    public boolean getLadder(String w1, String w2, Set<String> dic){
        Set<String> usedWords=new HashSet<String>();// words that were used
        Queue<Stack<String>> tree=new LinkedList<Stack<String>>();
        Stack<String> firstStack=new Stack<String>();
        Set<String> neighbors=new HashSet<String>();
        Set<String> w2Neighbors=new HashSet<String>();
        w2Neighbors = getNeighbor(w2, dic);
        firstStack.push(w1);
        tree.offer(firstStack);
        while(tree.size() != 0){
            Stack<String> topStack = tree.poll();// get and delete topStack
            String topWord = topStack.peek();// get NOT delete topWord
            neighbors = getNeighbor(topWord, dic);
            if(neighbors.contains(w2)){// two words differ by one letter
                topStack.push(w2);
                printLadder(topStack);
                return true;
            }
            for(String neigh : neighbors){// for each String in neighbors
                if(!(usedWords.contains(neigh))){// if the word has been used, then it won't lead to the shortest path
                    if(w2Neighbors.contains(neigh)){// find the ladder
                        topStack.push(neigh);
                        topStack.push(w2);
                        printLadder(topStack);
                        return true;
                    }else{
                        Stack<String> newStack = (Stack<String>) topStack.clone();
                        newStack.push(neigh);
                        usedWords.add(neigh);
                        tree.offer(newStack);
                    }
                }
            }
        }
        System.out.println("No word ladder found from " + w1 + " back to " + w2);
        return false;
    }

    // find all valid neighbors of w, and return them in a Set<String>
    public Set<String> getNeighbor(String w, Set<String> dic){
        Set<String> neighbors = new HashSet<String>();
        int len = w.length();
        for(int i = 0; i < len; i++){
            String neighbor = w.substring(0, i) + w.substring(i+1);
            if(dic.contains(neighbor) && !(neighbor.equals(w)) && !(neighbors.contains(neighbor))){
                neighbors.add(neighbor);
            }
            for(char c='a'; c <= 'z'; c++){
                neighbor = w.substring(0, i) + c + w.substring(i);
                if(dic.contains(neighbor) && !(neighbor.equals(w)) && !(neighbors.contains(neighbor))){
                    neighbors.add(neighbor);
                }
                neighbor = w.substring(0, i) + c + w.substring(i + 1);
                if(dic.contains(neighbor) && !(neighbor.equals(w)) && !(neighbors.contains(neighbor))){
                    neighbors.add(neighbor);
                }
            }
        }
        return neighbors;
    }

    // print the ladder
    public boolean printLadder(Stack<String> stack){
        int len = stack.size();
        for(int i = 0; i < len - 1; i++){
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println( stack.pop());
        return true;
    }
}