/**
 * class YellowState
 */
public class YellowState  implements State {
    private TrafficLight trafficLight ;
    /**
     * class constructor
     * @param trafficLight
     */
    public YellowState(TrafficLight trafficLight){
        this.trafficLight = trafficLight ;
    }

    /**
     * switches to RED after 3 seconds.
     */
    @Override
    public void goToRed() {
        System.out.println("yellow ==> red");
        for(int i = 0 ; i < 3 ; i++){
            System.out.print("\rremaining ="+String.format("%3d",3-i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print("\rremaining = 0\n");
        this.trafficLight.setState(this.trafficLight.getRedState());
    }
    /**
     * cannot change the state from yellow to green
     * unimplemented method .
     */
    @Override
    public void goToGreen() {
        System.out.println("can not go from state yellow to state green !!");
    }
    /**
     * cannot change the state from yellow to yellow
     * unimplemented method .
     * @param timeout timeout
     */
    @Override
    public void goToYellow(int timeout) {
        System.out.println("can not go from state yellow to state yellow !!");
    }
}
