/**
 * class phoneStorage .
 */
public class phoneStorage implements Storage {
    private phoneMAXsupport MAX ;
    private phoneSupport Support;

    /**
     * class constructor .
     * @param Support
     * @param MAX
     */
    public phoneStorage(phoneSupport Support ,phoneMAXsupport MAX ){
        this.MAX = MAX ;
        this.Support = Support ;
    }
    @Override
    public phoneMAXsupport getMAX() {
        return this.MAX;
    }

    @Override
    public phoneSupport getSupport() {
        return this.Support;
    }
}
