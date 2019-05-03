import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrintRinda {
public static void main(String[] args){
    Queue<PrintObjekts> rinda=new LinkedList();
    rinda.add(new PrintObjekts("referats.doc",1));
    rinda.add(new PrintObjekts("atskaite.doc",2));
    rinda.add(new PrintObjekts("tabula.xls",1));
    rinda.add(new PrintObjekts("rikojums.doc",3));
    rinda.add(new PrintObjekts("saraksts.txt",2));
    Collections.sort((LinkedList<PrintObjekts>)rinda,new ComparePrior());
    while(!rinda.isEmpty()){
    System.out.println(rinda.remove().getName());
    }
    Queue<PrintObjektsC> rinda1=new PriorityQueue();
    rinda1.add(new PrintObjektsC("referats.doc",1));
    for(int i=0;i<1000000;i++);
    rinda1.add(new PrintObjektsC("atskaite.doc",2));
        for(int i=0;i<1000000;i++);
    rinda1.add(new PrintObjektsC("tabula.xls",1));
        for(int i=0;i<1000000;i++);
    rinda1.add(new PrintObjektsC("rikojums.doc",3));
        for(int i=0;i<1000000;i++);
    rinda1.add(new PrintObjektsC("saraksts.txt",2));
    while(!rinda1.isEmpty()){
    System.out.println(rinda1.remove().getName());
}    
}
}
