import java.time.LocalTime;
public class PrintObjektsC implements Comparable{
    private String docName;
    private int prior;
    private LocalTime time;
    public PrintObjektsC(String name, int pr){
        docName=name;
        prior=pr;
        time = LocalTime.now();
    }
    public void setPrior(int pr){
        prior=pr;
    }
    
    public String getName(){
        return docName;
    }
    public int getPrior(){
        return prior;
    }
    public LocalTime getTime(){
        return time;
    }
@Override
    public int compareTo(Object o) {
        PrintObjektsC prO=(PrintObjektsC)o; 
        int p=prO.getPrior();    
        if(p>prior)return 1;
        if(p<prior)return -1;
        return time.compareTo(prO.getTime());
    }
    
}