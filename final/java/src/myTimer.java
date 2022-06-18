import java.util.Timer;
import java.util.TimerTask;

/**
 * class myTimer
 */
public class myTimer extends Timer {
    private Mediator mediator ;
    private int hour , minute , second ;
    public myTimer(){
        super();
        this.hour = 0 ;
        this.minute = 0 ;
        this.second = 0 ;
        this.schedule(new TimerTask() {
            @Override
            public void run() {
                if(mediator != null){
                    if(!mediator.isPaused()){
                        second++;
                        if(second == 60){
                            second = 0 ;
                            minute++;
                        }
                        if(minute == 60){
                            minute = 0 ;
                            hour++;
                        }
                        mediator.adjustTimer(hour,minute,second);
                    }
                }
            }
        },1000,1000);
    }

    /**
     * sets the mediator .
     * @param mediator
     */
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }


}
