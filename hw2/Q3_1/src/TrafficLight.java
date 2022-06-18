/**
 * class TrafficLight
 */
public class TrafficLight {
    private State red ;
    private State green;
    private State yellow;

    private State state ;
    private int timeout ;

    /**
     * class constructor.
     */
    public TrafficLight(){
        this.red    = new RedState(this);
        this.yellow = new YellowState(this);
        this.green  = new GreenState(this);
        this.state = this.red ;
        this.timeout = 60;
    }

    /**
     * change the state to Red .
     */
    public void goToRed(){
        state.goToRed();
    }

    /**
     * change the state to green
     */
    public void goToGreen(){
        state.goToGreen();
    }

    /**
     * change the state to yellow
     */
    public void goToYellow(){
        state.goToYellow(this.timeout);
    }

    /**
     * set the state .
     * @param state
     */
    public void setState(State state){
        this.state = state ;
    }

    /**
     * returns the green state object .
     * @return the green state object .
     */
    public State getGreenState() {
        return this.green;
    }
    /**
     * returns the red state object .
     * @return the red state object .
     */
    public State getRedState() {
        return this.red;
    }
    /**
     * returns the yellow state object .
     * @return the yellow state object .
     */
    public State getYellowState() {
        return this.yellow;
    }
}
