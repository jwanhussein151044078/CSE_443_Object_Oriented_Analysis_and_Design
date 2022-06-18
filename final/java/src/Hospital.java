import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * class Hospital
 */
public class Hospital {
    private LinkedList<Indivisual> list ;
    private Mediator mediator ;
    private Lock lock ;
    private Condition empty ;
    private Condition full ;

    /**
     * counstructor
     * @param mediator
     * @param lock
     * @param full
     * @param empty
     */
    public Hospital(Mediator mediator , Lock lock  , Condition full , Condition empty){
        this.list = new LinkedList<>();
        this.mediator = mediator;
        this.lock = lock ;
        this.empty = empty ;
        this.full = full ;
    }

    /**
     * return the number of patient .
     * @return
     */
    public int getSize(){
        return list.size();
    }

    /**
     * insert an individual .
     * @param indivisual the individual to be inserted .
     */
    public void offer(Indivisual indivisual){
        this.list.offer(indivisual);
    }

    /**
     *
     * @return the patient that removed from the hospital .
     */
    public Indivisual poll(){
        Indivisual indivisual ;
        this.lock.lock();
        while (list.size() == 0){
            try {
                this.full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        indivisual = list.poll();
        this.empty.signalAll();
        this.lock.unlock();
        return indivisual;
    }


}
