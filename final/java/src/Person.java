import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * public class Person .
 */
public class Person extends Indivisual {

    private Mediator mediator ;
    private Direction direction = null;
    private int speed , socialDistance , id;
    private double mask ;
    private int socialTime ;
    private boolean infected ;
    private boolean inHospital;
    private boolean inColision;
    private boolean dead ;
    private JComponent comp ;
    private long t ;

    public Person(){
        Random random = new Random();
        this.comp = new JComponent() {
            /**
             * Calls the UI delegate's paint method, if the UI delegate
             * is non-<code>null</code>.  We pass the delegate a copy of the
             * <code>Graphics</code> object to protect the rest of the
             * paint code from irrevocable changes
             * (for example, <code>Graphics.translate</code>).
             * <p>
             * If you override this in a subclass you should not make permanent
             * changes to the passed in <code>Graphics</code>. For example, you
             * should not alter the clip <code>Rectangle</code> or modify the
             * transform. If you need to do these operations you may find it
             * easier to create a new <code>Graphics</code> from the passed in
             * <code>Graphics</code> and manipulate it. Further, if you do not
             * invoke super's implementation you must honor the opaque property, that is
             * if this component is opaque, you must completely fill in the background
             * in an opaque color. If you do not honor the opaque property you
             * will likely see visual artifacts.
             * <p>
             * The passed in <code>Graphics</code> object might
             * have a transform other than the identify transform
             * installed on it.  In this case, you might get
             * unexpected results if you cumulatively apply
             * another transform.
             *
             * @param g the <code>Graphics</code> object to protect
             * @see #paint
             */
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;
                if(isInHospital() || dead()){
                    return;
                }
                if(isInfected()){
                    g2.setColor(Color.red);
                }else if (isInColision()){
                    g2.setColor(Color.LIGHT_GRAY);
                }else{
                    g2.setColor(Color.green);
                }
                g2.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
        };
        this.comp.setSize(5,5);
        this.speed = random.nextInt(500)+1;
        this.socialDistance = random.nextInt(10);
        this.socialTime = random.nextInt(4)+1;
        this.infected = false ;
        this.inHospital= false ;
        this.inColision = false ;
        this.dead = false ;
        int temp = random.nextInt(2);
        if(temp %2 == 0){
            this.mask = 1.0 ;
        }else{
            this.mask = 0.2 ;
        }
        setDirection();
        t = System.currentTimeMillis();
    }
    /**
     * returns the direction .
     * @return returns the direction .
     */
    public Direction getDirection(){return this.direction;}
    /**
     * returns the id of the individual .
     * @return returns the id of the individual .
     */
    @Override
    public int getId(){return this.id;}
    /**
     * returns the speed .
     * @return returns the speed .
     */
    @Override
    public int getSpeed(){return this.speed;}
    /**
     * return the social distance .
     * @return return the social distance .
     */
    @Override
    public int getSocialDistance(){return this.socialDistance;}
    /**
     * returns the social time .
     * @return returns the social time .
     */
    @Override
    public int getSocialTime(){return this.socialTime;}
    /**
     * return 1 if the individual's mask is off , or 0.2 if the mask is on .
     * @return return 1 if the individual's mask is off , or 0.2 if the mask is on .
     */
    @Override
    public double getMask(){return this.mask;}
    /**
     * returns true if the individual is infected .
     * @return returns true if the individual is infected .
     */
    @Override
    public boolean isInfected(){return this.infected;}
    /**
     * return true if the individual is in the hospital .
     * @return return true if the individual is in the hospital .
     */
    @Override
    public boolean isInHospital(){return this.inHospital;}
    /**
     * return true if the individual is in a collision .
     * @return return true if the individual is in a collision .
     */
    @Override
    public boolean isInColision(){return this.inColision;}
    /**
     * set the mediator .
     * @param mediator the mediator .
     */
    @Override
    public void setMediator(Mediator mediator){this.mediator = mediator;}
    /**
     * set the direction of the individual randomly .
     */
    @Override
    public void setDirection(){this.direction = Direction.getDirection(this.getDirection());}
    /**
     * set the id of the individual .
     * this method is called by the mediator .
     */
    @Override
    public void setId(){
        this.id = mediator.getUniqueId(this);
    }
    /**
     * returns true if the individual is dead .
     * @return returns true if the individual is dead .
     */
    public boolean dead(){
        return this.dead;
    }
    /**
     * set the speed of the individual .
     * @param speed the speed .
     */
    @Override
    public void setSpeed(int speed){this.speed = speed;}
    /**
     * set the social distance .
     * @param socialDistance the social distance .
     */
    @Override
    public void setSocialDistance(int socialDistance){this.socialDistance = socialDistance;}
    /**
     * sets the social time .
     * @param socialTime the social time .
     */
    @Override
    public void setSocialTime(int socialTime){this.socialTime = socialTime;}
    /**
     * sets the helth status of the individual .
     * @param infected
     */
    @Override
    public void setInfected(boolean infected){
        this.infected = infected;
        if(infected){
            mediator.gotInfected(this);
        }else{
            mediator.healed(this);
        }
    }
    /**
     * setter
     * @param inHospital
     */
    @Override
    public void setInHospital(boolean inHospital){this.inHospital = inHospital;}
    /**
     * setter
     * @param inColision
     */
    @Override
    public void setInColision(boolean inColision){this.inColision = inColision;}
    /**
     * marks the individual as dead , cannot be undo .
     */
    public void setDead(){
        this.dead = true ;
        mediator.kill(this);
    }
    /**
     * make the individual to make step according to its speed and direction .
     * this method calls move() method of the mediator .
     */
    @Override
    public void move(){
        long temp = System.currentTimeMillis();

        if(temp-t >= 501-speed) {
            mediator.move(this);
            this.t = temp ;
        }
    }
    /**
     * returns the component of the individual .
     * @return returns the component of the individual .
     */
    @Override
    public JComponent getComponent(){return this.comp ;}

    @Override
    public String toString() {
        return String.format("pos(%d,%d)",comp.getX(),comp.getY());
    }

    /**
     * return the individual which id is @param id from the container , null is returned id the individual was not found .
     * @param id the id of the individual to be returned .
     * @return
     */
    @Override
    public Indivisual getIndvidual(int id) {
        if(id == this.id){
            return this;
        }else{
            return null;
        }
    }
}
