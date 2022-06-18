/**
 * class phone_Battery .
 */
public class phone_Battery implements Battery {
    private Battery_type TYPE ;
    private Battery_time TIME ;
    private Battery_cap  CAP ;

    /**
     * class constructor .
     * @param type the type of the battery .
     * @param cap the capacity of the battery .
     * @param time time per one charge .
     */
    public phone_Battery(Battery_type type , Battery_cap cap , Battery_time time){
        this.CAP = cap ;
        this.TYPE = type ;
        this.TIME = time ;
    }

    @Override
    public Battery_type getType() {
        return this.TYPE;
    }

    @Override
    public Battery_cap getCap() {
        return this.CAP;
    }

    @Override
    public Battery_time getTime() {
        return this.TIME;
    }
}
