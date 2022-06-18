/**
 * class phoneCamera
 */
public class phoneCamera implements Camera {
    private phoneFrontcam Front ;
    private phoneRearcam Rear ;
    private phoneCamZoom Zoom ;

    /**
     * class constructor .
     * @param Front front camera resolution .
     * @param Rear rear camera resolution .
     * @param Zoom opt. zoom .
     */
    public phoneCamera(phoneFrontcam Front , phoneRearcam Rear , phoneCamZoom Zoom ){
        this.Rear = Rear ;
        this.Front = Front ;
        this.Zoom = Zoom ;
    }

    @Override
    public phoneFrontcam getFrontCam() {
        return this.Front;
    }

    @Override
    public phoneRearcam getrearCam() {
        return this.Rear;
    }

    @Override
    public phoneCamZoom getZoom() {
        return this.Zoom;
    }
}
