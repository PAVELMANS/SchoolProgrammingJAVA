
import java.util.BitSet;
import java.util.HashMap;
import java.util.PriorityQueue;
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
public class Huffman {

    private String s;
    private HashMap<Character, Integer> freq = new HashMap<>();
    private PriorityQueue<Burts> burti = new PriorityQueue<>();
    private TreeMap<Character, String> kodi = new TreeMap<>();

    public Huffman(String s) {
        this.s = s;
    }

    public Burts getRoot() {
        return burti.peek();
    }

    public void traverse(Burts b, String s) {
        if (b.ch == 0) {
            traverse(b.left, s + "0");
            traverse(b.right, s + "1");
        } else {
            kodi.put((char) b.ch, s);
        }
    }

    private void getFrequencies() {
        for (char ch : s.toCharArray()) {
            if (freq.containsKey(ch)) {
                freq.put(ch, freq.get(ch) + 1);
            } else {
                freq.put(ch, 1);
            }
        }
//        freq.forEach((k, v) -> System.out.println("'" + k + "': " + v));
    }

    private void buildHuffmanTree() {
        freq.forEach((k, v) -> {
            Burts b = new Burts(k, v);
            burti.add(b);
        });
        while (burti.size() > 1) {
            burti.add(new Burts(burti.poll(), burti.poll()));
        }
    }

    public String saspiez() {
        String notBits = "";
        for (char ch : s.toCharArray()) {
            notBits += kodi.get((char) ch);
        }
        BitSet bits = new BitSet();
        for (int j = 0; j < notBits.length(); j++) {
            if (notBits.charAt(j) == '1') {
                bits.set(j);
            }
        }
        byte[] bytes = bits.toByteArray();
        return bytes.toString();
    }

    public String atspiez(String a) {
        byte[] bytes = a.getBytes();
        BitSet bits = BitSet.valueOf(bytes);
        String atsp = "";
        Burts t = getRoot();
        for (int i = 0; i < bits.length(); i++) {
            if (i == 1) {
                t = t.right;
            } else {
                t = t.left;
            }
            if (t.ch != 0) {
                atsp += (char) t.ch;
                t = getRoot();
            }
        }
        return atsp;
    }

    public static void main(String args[]) {
        String s = "this is an example of a huffman tree";
        Huffman huff = new Huffman(s);
        huff.getFrequencies();
        huff.buildHuffmanTree();
        huff.traverse(huff.getRoot(), "");
        String sasp = huff.saspiez();
        System.out.println("oriģinālteksts: " + s);
        System.out.println("saspiests: " + sasp);
        System.out.println("atspiests: " + huff.atspiez(sasp));
    }

}
