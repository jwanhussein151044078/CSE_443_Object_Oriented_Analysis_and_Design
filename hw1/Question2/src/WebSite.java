import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Website class which is representing the Observable .
 */
public class WebSite {
    private String name ;
    private HashMap<Contents,Object[]> content ;
    private HashMap<MyObserver,ArrayList<Contents>> observers ;

    /**
     * class Constructor .
     * @param name the name of the website .
     */
    public WebSite(String name){
        this.name = name;
        content = new HashMap<Contents,Object[]>();
        observers = new HashMap<MyObserver,ArrayList<Contents>>();
    }

    /**
     * class Constructor .
     * @param name the name of the website .
     * @param content a map object representing the contents of the website and their values .
     */
    public WebSite(String name,HashMap<Contents,Object[]> content){
        this.name = name;
        this.content = content ;
        observers = new HashMap<MyObserver,ArrayList<Contents>>();
    }

    /**
     * returns the content of the type content indicated by the param .
     * @param content type of content to be returned .
     * @return returns the content of the type content indicated by the param , or null if the website contain no such a content .
     */
    public Object GetContent(Contents content){
        if(this.content.containsKey(content)) {
            return this.content.get(content)[1];
        }
        return null;
    }

    /**
     * returns the name of the Website .
     * @return returns the name of the Website .
     */
    public String GetName(){
        return this.name;
    }

    /**
     * add a new content to the Website .
     * if the content to be added is already existed then no change will happen .
     * @param content the content to be added .
     * @param o the actual value of the content .
     * @return returns an array of the Website contents .
     */
    public Object[] AddContent(Contents content , Object o){
        if(this.content.containsKey(content)){
            System.out.println(this.name+" already has "+content+" content object!!");
            return this.content.get(content);
        }
        Boolean obj = Boolean.FALSE;
        Object[] arr = {obj,o};
        return this.content.put(content,arr);
    }

    /**
     * update a content of the Website and notify all Subscribers who are interested in this content .
     * @param content the content to be updated .
     * @param o the new  value .
     */
    public void SetContent(Contents content , Object o){
        if(!this.content.containsKey(content)){
            System.out.println(this.name+" has no "+content+" content object!!");
            return;
        }
        Boolean obj = Boolean.TRUE;
        Object[] arr = {obj,o};
        Object ret = this.content.put(content,arr);
        this.notifyObservers(content);
    }

    /**
     * adds the observer to the map , associates the observer with the contents array indicated by the parameter .
     * if the Website has no such a content then the request is ignored .
     * @param o the observer .
     * @param contents array of contents .
     */
    public void addObserver(MyObserver o , Contents[] contents){
        int L = contents.length;
        for(int i = 0 ; i < L ; i++){
            this.addObserver(o,contents[i]);
        }
    }

    /**
     * adds the observer to the map , associates the observer with the content indicated by the parameter .
     * if the Website has no such a content then the request is ignored .
     * @param o the observer .
     * @param content the content .
     */
    public void addObserver(MyObserver o , Contents content){

        if(this.content.containsKey(content)) {
            if(!observers.containsKey(o)){
                ArrayList<Contents> arr = new ArrayList<Contents>();
                arr.add(content);
                observers.put(o,arr);
            }else{
                if(!this.observers.get(o).contains(content)){
                    this.observers.get(o).add(content);
                }
            }
        }else{
            System.out.printf("%s can not add Observer {%s}, the site has no content named %s , the request is ignored\n",this.name,o,content);
        }
    }

    /**
     * delete the observer from the map .
     * will not be notified of any updates any more .
     * @param o the observer .
     */
    public void deleteObserver(MyObserver o){
        observers.remove(o);
    }

    /**
     * delete all observers .
     */
    public void deleteObserver(){
        observers.clear();
    }

    /**
     * returns the number of the observers .
     * @return returns the number of the observers .
     */
    public int countObservers(){
        return observers.size();
    }

    /**
     * returns true if the content indicated by the parameter has been changed .
     * @param content the content to be checked .
     * @return returns true if the content indicated by the parameter has been changed .
     */
    public boolean hasChanged(Contents content){
        if(this.content.containsKey(content)){
            if(this.content.get(content).length == 2){
                return this.content.get(content)[0] == Boolean.TRUE ;
            }
        }
        return false ;
    }

    /**
     * set the flag of the content indicated by the parameter to true .
     * means that the content has been modified .
     * @param content the content .
     */
    protected void setChanged(Contents content){
        if(this.content.containsKey(content)){
            this.content.get(content)[0] = Boolean.TRUE;
        }
    }

    /**
     * set the flag of all contents of the Website to true .
     */
    protected void setChanged(){
        HashSet<Contents> set = new HashSet<Contents>(this.content.keySet());
        Iterator<Contents> it = set.iterator();
        while (it.hasNext()){
            this.content.get(content)[0] = Boolean.TRUE;
        }
    }

    /**
     * Indicates that this content has no longer changed, or that it has already notified all of its observers of its most recent change, so that the hasChanged method will now return false. This method is called automatically by the notifyObservers methods.
     * @param content
     */
    protected void clearChanged(Contents content){
        if(this.content.containsKey(content)){
            this.content.get(content)[0] = Boolean.FALSE;
        }
    }

    /**
     * Indicates that this object has no longer changed, or that it has already notified all of its observers of its most recent change, so that the hasChanged method will now return false.
     */
    protected void clearChanged(){
        HashSet<Contents> set = new HashSet<Contents>(this.content.keySet());
        Iterator<Contents> it = set.iterator();
        while (it.hasNext()){
            this.content.get(it.next())[0] = Boolean.FALSE;
        }
    }


    /**
     * If this object has changed, as indicated by the hasChanged method, then notify all of its observers whose subscribed the content indicated by the parameter and then call the clearChanged method to indicate that this object has no longer changed.
     * @param content the content .
     */
    public void notifyObservers(Contents content){
        if(hasChanged(content)){
            HashSet<MyObserver> obs = new HashSet<MyObserver>(this.observers.keySet());
            Iterator<MyObserver> it = obs.iterator();
            while(it.hasNext()){
                MyObserver ob = it.next();
                ArrayList<Contents> temp = this.observers.get(ob);
                if(temp.indexOf(content) != -1 ){
                    ob.update(this,content,this.content.get(content)[1]);
                }
            }
            this.clearChanged(content);
        }
    }
}
