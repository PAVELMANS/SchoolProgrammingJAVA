
import java.time.LocalTime;

public class PrintObjekts {
    private String docName;
    private int prior;
    private LocalTime time;
    public PrintObjekts(String name, int pr){
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
}
