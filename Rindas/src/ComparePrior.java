
import java.util.Comparator;

public class ComparePrior implements Comparator{
    
    @Override
    public int compare(Object o1, Object o2) {
        PrintObjekts prO1=(PrintObjekts)o1; 
        PrintObjekts prO2=(PrintObjekts)o2; 
        int p1=prO1.getPrior();    
        int p2=prO2.getPrior();
        if(p1>p2)return -1;
        if(p1<p2)return 1;
        return prO1.getTime().compareTo(prO2.getTime());
    }
    
}
