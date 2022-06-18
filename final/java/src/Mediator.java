/**
 * public interface Mediator .
 */
public interface Mediator {
    /**
     * gets the individual to make a step .
     * @param individual the individual .
     */
    public void move(Indivisual individual);

    /**
     * adds the individual .
     * @param individual the individual to add .
     */
    public void registerIndividual(Indivisual individual);

    public void registerDisplay(Display display);
    public int getUniqueId(Indivisual individual);

    /**
     * adds the timer .
     * @param timer thie timer to regester .
     */
    public void registerTimer(myTimer timer);
    /**
     * creates the GUI .
     */
    public void show();

    /**
     * Pauses the simulator .
     */
    public void Stop();

    /**
     * resumes the simulator .
     */
    public void Continue();

    /**
     * return true is the simulator is paused , false if not .
     * @return
     */
    public boolean isPaused();

    /**
     * adjust the timer .
     * @param hour new hour.
     * @param minute new minutes .
     * @param second new second .
     */
    public void adjustTimer(int hour,int minute , int second);

    /**
     * called by an individual when got infected
     * set the labels of the frame
     * sets a timer to move the individual to the hospital
     * @param individual the individual which called the method .
     */
    public void gotInfected(Indivisual individual);

    /**
     * called by an individual in case if healed
     * set the labels of the frame
     * @param individual the individual which called the method .
     */
    public void healed(Indivisual individual);

    /**
     * kills the individual .
     * @param individual the individual .
     */
    public void kill(Indivisual individual);
}
