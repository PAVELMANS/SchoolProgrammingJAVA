/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pivanovs3
 */
public class Burts implements Comparable<Object> {

    int ch;
    int freq;
    Burts left, right;

    public Burts(char ch, int freq) {
        this.ch = (int) ch;
        this.freq = freq;
        this.left = this.right = null;
    }

    public Burts(Burts b1, Burts b2) {
        this.ch = 0;
        this.freq = b1.freq + b2.freq;
        if (b1.compareTo(b2) < 0) {
            this.left = b1;
            this.right = b2;
        } else {
            this.left = b2;
            this.right = b1;
        }
    }

//    public char getChar() {
//        return ch;
//    }
//    
//    public int getFrequency() {
//        return freq;
//    }
    @Override
    public int compareTo(Object o) {
        Burts b2 = (Burts) o;
        if (freq > b2.freq) {
            return 1;
        } else if (freq < b2.freq) {
            return -1;
        } else {
            return 0;
        }
    }

}
