/**
 * camera interface
 */
public interface Camera {
    /**
     * returns the resolution of the front camera .
     * @return returns the resolution of the front camera .
     */
    public phoneFrontcam getFrontCam();

    /**
     * returns the resolution of the rear camera .
     * @return returns the resolution of the rear camera .
     */
    public phoneRearcam  getrearCam ();

    /**
     * returns the Opt. zoom .
     * @return returns the Opt. zoom .
     */
    public phoneCamZoom  getZoom ();
}
