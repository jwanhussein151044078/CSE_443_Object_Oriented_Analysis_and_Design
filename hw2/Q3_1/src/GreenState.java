/**
 * class GreenState
 */
public class GreenState  implements State {

    private TrafficLight trafficLight ;

    /**
     * class constructor
     * @param trafficLight
     */
    public GreenState(TrafficLight trafficLight){
        this.trafficLight = trafficLight ;
    }

    /**
     * cannot change the state from green to red
     * unimplemented method .
     */
    @Override
    public void goToRed() {
        System.out.println("can not go from state green to state red !!");
    }
    /**
     * cannot change the state from green to green
     * unimplemented method .
     */
    @Override
    public void goToGreen() {
        System.out.println("can not go from state green to state green !!");
    }
    /**
     * switches to YELLOW after 60 seconds (timeout_X).
     * @param timeout timeout
     */
    @Override
    public void goToYellow(int timeout) {
        System.out.println("green ==> yellow");
        for(int i = 0 ; i < timeout ; i++){
            System.out.print("\rremaining ="+String.format("%3d",timeout-i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\rremaining = 0\n");
        this.trafficLight.setState(this.trafficLight.getYellowState());
    }
}
