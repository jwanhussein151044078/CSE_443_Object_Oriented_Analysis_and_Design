import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * public class People .
 */
public class People extends Indivisual {
    private ArrayList<Indivisual> people;
    private JComponent comp ;

    /**
     * constructor
     */
    public People(){
        this.people = new ArrayList<>();
        this.comp = new JComponent() {};
        comp.setSize(1000,600);
    }
    /**
     * set the mediator .
     * @param mediator the mediator .
     */
    @Override
    public void setMediator(Mediator mediator) {
        Iterator<Indivisual> it = people.iterator();
        while(it.hasNext()){
            it.next().setMediator(mediator);
        }
    }
    /**
     * returns the component of the individual .
     * @return returns the component of the individual .
     */
    public JComponent getComponent(){
        return comp ;
    }
    /**
     * Appends the specified individual to the end of this container.
     * @param indivisual the individual to be added .
     */
    public void addIndividual(Indivisual indivisual){
        this.comp.add(indivisual.getComponent());
        this.people.add(indivisual);
    }
    /**
     * Removes the specified individual from this container
     * @param indivisual the individual to be removed .
     */
    public void removeIndividual(Indivisual indivisual){
        this.people.remove(indivisual);
        this.comp.remove(indivisual.getComponent());
    }
    /**
     * make the individual to make step according to its speed and direction .
     * this method calls move() method of the mediator .
     */
    public void move(){
        Iterator<Indivisual> it = people.iterator();
        while (it.hasNext()){
            it.next().move();
        }
    }

    /**
     * sets the id of all individual inside the container
     */
    @Override
    public void setId() {
        Iterator<Indivisual> it = people.iterator();
        while (it.hasNext()){
            it.next().setId();
        }
    }

    @Override
    public String toString() {
        String str = "";
        Iterator<Indivisual> it = people.iterator();
        while(it.hasNext()){
            str += it.next().toString();
        }
        return str ;
    }
    /**
     * return the individual which id is @param id from the container , null is returned id the individual was not found .
     * @param id the id of the individual to be returned .
     * @return
     */
    @Override
    public Indivisual getIndvidual(int id) {
        Iterator<Indivisual> it = people.iterator();
        while(it.hasNext()){
            Indivisual ind = it.next();
            if(ind.getIndvidual(id)!=null){
                return ind.getIndvidual(id) ;
            }
        }
        return null;
    }
}
