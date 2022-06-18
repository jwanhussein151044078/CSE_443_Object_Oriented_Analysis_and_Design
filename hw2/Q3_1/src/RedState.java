/**
 * class RedState
 */
public class RedState implements State{
    private TrafficLight trafficLight ;

    /**
     * class constructor .
     * @param trafficLight
     */
    public RedState(TrafficLight trafficLight){
        this.trafficLight = trafficLight ;
    }

    /**
     * cannot change the state from red to red
     * unimplemented method .
     */
    @Override
    public void goToRed() {
        System.out.println("can not go from state red to state red !!");
    }

    /**
     * switches to GREEN after 15 seconds.
     */
    @Override
    public void goToGreen() {
        System.out.println("red ==> green");
        for(int i = 0 ; i < 15 ; i++){
            System.out.print("\rremaining ="+String.format("%3d",15-i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\rremaining = 0\n");
        this.trafficLight.setState(this.trafficLight.getGreenState());
    }

    /**
     * cannot change the state from red to yellow
     * unimplemented method .
     * @param timeout timeout
     */
    @Override
    public void goToYellow(int timeout) {
        System.out.println("can not go from state red to state yellow !!");
    }
}
