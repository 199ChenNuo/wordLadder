import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class wordLadder {
    static Set<String> dic =new HashSet<String>();
    static Scanner sc = new Scanner(System.in);
    static String w1=null;
    static String w2=null;
    public static void main(String[] args){
        getKeyWords();
        System.out.println("Hava a nice day.");
    }

    public static void getKeyWords(){

        String dicName = getDicName();
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
        boolean flag = true;
        while (flag){
            flag = getWords();
            if(flag == false)
                break;;
        }
    }

    public static String getDicName(){

        System.out.println("Dictionary file name?");
        String dicName = sc.nextLine();
        return dicName;
    }

    public static boolean getWords(){
        System.out.println("Word #1 (or Enter to quit): ");
        w1 = sc.nextLine();
        if(w1 == "\n")
            return false;

        System.out.println("Word #2 (or Enter to quit): ");
        w2 = sc.nextLine();
        if(w2 == "\n")
            return false;

        w1.toLowerCase();
        w2.toLowerCase();

        getLadder();

        return true;
    }

    public static void getLadder(){
        Set<String> usedWords=new HashSet<String>();
        Queue<Stack<String>> tree=new LinkedList<Stack<String>>();
        Stack<String> firstStack=new Stack<String>();
        Set<String> neighbors=new HashSet<String>();
        Set<String> w2Neighbors=new HashSet<String>();
        w2Neighbors = getNeighbor(w2);
        firstStack.push(w1);
        tree.offer(firstStack);
        while(tree.size() != 0){
            Stack<String> topStack = tree.poll();
            String topWord = topStack.peek();
            neighbors = getNeighbor(topWord);
            if(neighbors.contains(w2)){
                topStack.push(w2);
                printLadder(topStack);
                return;
            }
            Iterator<String> it = neighbors.iterator();
            while(it.hasNext()){
                String neigh = it.next();
                if(!(usedWords.contains(neigh))){
                    if(w2Neighbors.contains(neigh)){
                        topStack.push(neigh);
                        topStack.push(w2);
                        printLadder(topStack);
                        return;
                    }else{
                        Stack<String> newStack = new Stack<String>();
                        for(String str : topStack){
                            newStack.push(str);
                        }
                        newStack.push(neigh);
                        usedWords.add(neigh);
                        tree.offer(newStack);
                    }
                }
            }
        }
        System.out.println("No word ladder found from " + w1 + " back to " + w2);
    }

    public static Set<String> getNeighbor(String w){
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

    public static void printLadder(Stack<String> stack){
        int len = stack.size();
        for(int i = 0; i < len - 1; i++){
            System.out.print(stack.pop() + " -> ");
        }
        System.out.println(stack.pop());
    }
}
