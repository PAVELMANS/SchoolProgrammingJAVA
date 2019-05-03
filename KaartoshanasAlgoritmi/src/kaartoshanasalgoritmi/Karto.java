package kaartoshanasalgoritmi;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import javafx.util.converter.NumberStringConverter;

class Karto {

    int n = 100;
    int numbers[] = new int[n];
    int compare, exchange;
    int[] help = new int[numbers.length];

    public void init() {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = rand.nextInt(200);
        }
        compare = 0;
        exchange = 0;
    }

    public void output() {
        for (int i = 0; i < n; i++) {
            System.out.format("%4d", numbers[i]);
        }
        System.out.println();
    }

    public int min_place() {
        int place = 0;
        for (int i = 1; i < n; i++) {
            if (numbers[place] > numbers[i]) {
                place = i;
            }
        }
        return place;
    }

    public void swap(int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
        exchange++;
    }

    public void outputCE() {
        System.out.println("Nr of changes=" + exchange + " Nr of compares=" + compare);
    }

    public void naivais() {
        for (int j = 0; j < n - 1; j++) {
            int minVieta = j;
            for (int i = j + 1; i < n; i++) {
                if (numbers[minVieta] > numbers[i]) {
                    minVieta = i;
                }
                compare++;
            }
            swap(minVieta, j);
        }
    }

    public void burbulis() {
        exchange = 0;
        compare = 0;
        boolean sorted;
        int atstaat = 1;
        do {
            sorted = true;
            for (int i = 0; i < (n - atstaat); i++) {
                if (numbers[i] > numbers[i + 1]) {
                    sorted = false;
                    swap(i, i + 1);
                }
                compare++;
            }
            //n--;
            atstaat++;
        } while (!sorted);
    }

    public void mergeSort() {
        exchange = 0;
        compare = 0;
        sortM(0, numbers.length - 1);
    }

    private void merge(int low, int middle, int high) {

        for (int i = low; i <= high; i++) {
            help[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (help[i] <= help[j]) {
                numbers[k] = help[i];
                i++;
            } else {
                numbers[k] = help[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            numbers[k] = help[i];
            k++;
            i++;
        }

    }

    public void binS(int x) {
        boolean found = false;
        int start = 0;
        int end = numbers.length - 1;
        int middle;
        do {
            middle = (start + end) / 2;
            if (numbers[middle] == x) {
                found = true;
            } else if (numbers[middle] > x) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        } while ((start < end) && (!found));
        if (found) {
            start = middle;
            end = middle;
            while (numbers[start] == x) {
                start--;
            }
            start++;
            while (numbers[end] == x) {
                end++;
            }
            end--;
            System.out.println("The " + x + " is found from " + start + " till " + end + " positions.");
        } else {
            System.out.println(x + " IS NOT FOUND");
        }
    }

    public void sortM(int L, int R) {
        if (L < R) {
            int middle = (L + R) / 2;
            //if ((R - L) > 1) {
            sortM(L, middle);
            sortM(middle + 1, R);
            //}
            merge(L, middle, R);
        }
    }

    public void makeItHoar() {
        exchange = 0;
        compare = 0;
        hoar(0, numbers.length - 1);
    }

    public void hoar(int l, int r) { //pievienot skaitītājus - pievienoti
        int i = l;
        int j = r;
        boolean uzKreisi = false;
        while (i < j) {
            if (numbers[i] > numbers[j]) {
                swap(i, j);
                uzKreisi = !uzKreisi;
            }
            compare++;
            if (uzKreisi) {
                i++;
            } else {
                j--;
            }
        }
        if ((i - 1) > l) {
            hoar(l, i - 1);
        }
        if ((i + 1) < r) {
            hoar(i + 1, r);
        }
    }

    public static void main(String args[]) {
        Karto karto = new Karto();
        karto.init();
        karto.output();

        //karto.naivais();
        //karto.burbulis();
        karto.mergeSort();
        //karto.makeItHoar();
        karto.output();
        karto.outputCE();
        karto.binS(29);
    }
}
