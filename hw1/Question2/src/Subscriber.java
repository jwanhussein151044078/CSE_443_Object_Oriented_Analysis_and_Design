
import java.util.HashMap;
import java.util.Set;

/**
 * Subscriber class .
 */
public class Subscriber implements MyObserver {
    private int id ;
    private HashMap<WebSite,HashMap<Contents,Object>> observables ;

    /**
     * class constructor .
     * @param id the id of the subscriber .
     */
    public Subscriber(int id){
        this.id = id ;
        observables = new HashMap<WebSite,HashMap<Contents,Object>>();
    }

    /**
     * class constructor .
     * @param id the id of the subscriber .
     * @param map
     */
    public Subscriber(int id , HashMap<WebSite,HashMap<Contents,Object>> map ){
        this.id = id ;
        this.observables = map ;
    }

    /**
     * class constructor .
     * @param id the id of the subscriber .
     * @param o
     */
    public Subscriber(int id , WebSite o ){
        this.id = id ;
        observables = new HashMap<WebSite,HashMap<Contents,Object>>();
        observables.put(o,new HashMap<Contents,Object>());
    }

    /**
     * class constructor .
     * @param id the id of the subscriber .
     * @param arr
     */
    public Subscriber(int id , WebSite[] arr ){
        this.id = id ;
        observables = new HashMap<WebSite,HashMap<Contents,Object>>();
        int L = arr.length;
        for(int i = 0 ; i<L ; i++){
            observables.put(arr[i],new HashMap<Contents,Object>());
        }
    }

    /**
     * returns a set of the Websites that has been subscribed .
     * @return returns a set of the Websites that has been subscribed .
     */
    public Set<WebSite> GetWebsites(){
        return this.observables.keySet();
    }

    /**
     * return the last version of the contents of the Website .
     * @param w the Website .
     * @return return the last version of the contents of the Website .
     */
    public HashMap<Contents,Object> GetcontentOf(WebSite w){
        return this.observables.get(w);
    }



    @Override
    public void update(WebSite w,Contents C, Object arg) {
        System.out.println(String.format("Subscriber {%s} has been notified from {%15s} about the update of the contents {%15s}\t new content : {%s}",this,w.GetName(),C,arg ));
        if(this.observables.containsKey(w)){
            this.observables.get(w).put(C,arg);
        }else{
            HashMap<Contents,Object> temp = new HashMap<Contents,Object>();
            temp.put(C,arg);
            this.observables.put(w,temp);
        }
    }

    public String toString(){
        return (String.format("id : %05d",this.id));
    }
}
