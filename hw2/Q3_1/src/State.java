/**
 * interface State
 */
public interface State {
    /**
     * switches to RED after 3 seconds.
     */
    public void goToRed();

    /**
     * switches to GREEN after 15 seconds.
     */
    public void goToGreen();

    /**
     * switches to YELLOW after 60 seconds (timeout_X).
     * @param timeout timeout
     */
    public void goToYellow(int timeout);
}
