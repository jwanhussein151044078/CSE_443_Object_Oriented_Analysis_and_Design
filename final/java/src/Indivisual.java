import javax.swing.*;


public abstract class Indivisual {
    /**
     * returns the direction .
     * @return returns the direction .
     */
    public Direction getDirection(){throw  new UnsupportedOperationException();}

    /**
     * returns the id of the individual .
     * @return returns the id of the individual .
     */
    public int getId(){throw  new UnsupportedOperationException();}

    /**
     * returns the speed .
     * @return returns the speed .
     */
    public int getSpeed(){throw  new UnsupportedOperationException();}

    /**
     * return the social distance .
     * @return return the social distance .
     */
    public int getSocialDistance(){throw  new UnsupportedOperationException();}

    /**
     * returns the social time .
     * @return returns the social time .
     */
    public int getSocialTime(){throw  new UnsupportedOperationException();}

    /**
     * return 1 if the individual's mask is off , or 0.2 if the mask is on .
     * @return return 1 if the individual's mask is off , or 0.2 if the mask is on .
     */
    public double getMask(){throw  new UnsupportedOperationException();}

    /**
     * returns true if the individual is infected .
     * @return returns true if the individual is infected .
     */
    public boolean isInfected(){throw  new UnsupportedOperationException();}

    /**
     * return true if the individual is in the hospital .
     * @return return true if the individual is in the hospital .
     */
    public boolean isInHospital(){throw  new UnsupportedOperationException();}

    /**
     * return true if the individual is in a collision .
     * @return return true if the individual is in a collision .
     */
    public boolean isInColision(){throw  new UnsupportedOperationException();}

    /**
     * returns true if the individual is dead .
     * @return returns true if the individual is dead .
     */
    public boolean dead(){throw  new UnsupportedOperationException();}

    /**
     * set the mediator .
     * @param mediator the mediator .
     */
    public void setMediator(Mediator mediator){throw  new UnsupportedOperationException();}

    /**
     * set the direction of the individual randomly .
     */
    public void setDirection(){throw  new UnsupportedOperationException();}

    /**
     * set the id of the individual .
     * this method is called by the mediator .
     */
    public void setId(){throw  new UnsupportedOperationException();}

    /**
     * set the speed of the individual .
     * @param speed the speed .
     */
    public void setSpeed(int speed){throw  new UnsupportedOperationException();}

    /**
     * set the social distance .
     * @param socialDistance the social distance .
     */
    public void setSocialDistance(int socialDistance){throw  new UnsupportedOperationException();}

    /**
     * sets the social time .
     * @param socialTime the social time .
     */
    public void setSocialTime(int socialTime){throw  new UnsupportedOperationException();}

    /**
     * sets the helth status of the individual .
     * @param infected
     */
    public void setInfected(boolean infected){throw  new UnsupportedOperationException();}

    /**
     * setter
     * @param inHospital
     */
    public void setInHospital(boolean inHospital){throw  new UnsupportedOperationException();}

    /**
     * setter
     * @param inColision
     */
    public void setInColision(boolean inColision){throw  new UnsupportedOperationException();}

    /**
     * marks the individual as dead , cannot be undo .
     */
    public void setDead(){throw  new UnsupportedOperationException();}

    /**
     * Appends the specified individual to the end of this container.
     * @param indivisual the individual to be added .
     */
    public void addIndividual(Indivisual indivisual){throw  new UnsupportedOperationException();}

    /**
     * Removes the specified individual from this container
     * @param indivisual the individual to be removed .
     */
    public void removeIndividual(Indivisual indivisual){throw  new UnsupportedOperationException();}

    /**
     * make the individual to make step according to its speed and direction .
     * this method calls move() method of the mediator .
     */
    public void move(){throw  new UnsupportedOperationException();}

    /**
     * return the individual which id is @param id from the container , null is returned id the individual was not found .
     * @param id the id of the individual to be returned .
     * @return
     */
    public Indivisual getIndvidual(int id){throw  new UnsupportedOperationException();}

    /**
     * returns the component of the individual .
     * @return returns the component of the individual .
     */
    public JComponent getComponent(){throw  new UnsupportedOperationException();}
}
