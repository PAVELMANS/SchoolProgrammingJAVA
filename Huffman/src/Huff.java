
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */

class TComp implements Comparator {
    public int compare(Object a, Object b) {
        Map.Entry ma, mb;
        ma = (Map.Entry) a;
        mb = (Map.Entry) b;
        int aVert = (Integer) ma.getValue();
        int bVert = (Integer) mb.getValue();
        return aVert-bVert;
    }
}

public class Huff {
    
    private static Map<Character, Integer> buildTree(String s) {
        Map<Character, Integer> tree = new TreeMap<>(new TComp());
        for (char c : s.toCharArray()) {
            if (tree.containsKey(c)) tree.put(c, tree.get(c) + 1);
            else tree.put(c, 1);
        }
        return tree;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        Map<Character, Integer> tree = buildTree(s);
        tree.forEach((k, v) -> System.out.println(k + " " + v));
    }
    
}
