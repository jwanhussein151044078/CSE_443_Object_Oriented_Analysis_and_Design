/**
 * interface MyObserver .
 */
public interface MyObserver {
    /**
     * This method is called whenever the observed object is changed. An application calls an Observable object's notifyObservers method to have all the object's observers notified of the change.
     * @param w the Website object.
     * @param C the content that have been updated .
     * @param arg the actual value of the content .
     */
    public void update(WebSite w, Contents C , Object arg);
}
