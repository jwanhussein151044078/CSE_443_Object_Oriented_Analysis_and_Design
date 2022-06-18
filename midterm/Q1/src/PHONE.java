/**
 * abstract class PHONE .
 */
public abstract class PHONE {
    phone_Model model;
    Display display;
    Battery battery;
    CPU_RAM cpu_ram;
    Storage storage;
    Camera _cam;
    Case _case;

    /**
     * prepare the phone .
     * each child of the the class should overwrite this method .
     * this method will be call by the orderphone(1) method from the store .
     */
    public abstract void prepare();

    /**
     * returns the model of the phone .
     * @return returns the model of the phone .
     */
    public phone_Model getModel() {
        return this.model;
    }

    /**
     * attaching CPU and RAM .
     */
    public void attach_CPU_RAM() {
        if (cpu_ram != null) {
            System.out.println("attaching CPU and RAM :specs ::  " + cpu_ram.getCPU() + " , " + cpu_ram.getRAM() + " , " + cpu_ram.getCORE());
        }
    }

    /**
     * attaching Display.
     */
    public void attach_Display() {
        if (display != null){
            System.out.println("attaching Display :specs :: " + display.getInches() + " , " + display.getBit());
        }
    }

    /**
     * attaching Battery.
     */
    public void attach_Battery() {
        if (battery != null) {
            System.out.println("attaching Battery :specs :: " + battery.getType() + " , " + battery.getCap() + " , " + battery.getTime());
        }
    }

    /**
     * attaching Storage .
     */
    public void attach_Storage() {
        if (storage != null) {
            System.out.println("attaching Storage :specs :: " + storage.getSupport() + " , " + storage.getMAX());
        }
    }

    /**
     * attaching Cameras .
     */
    public void attach_Camera() {
        if (_cam != null) {
            System.out.println("attaching Cameras :specs :: " + _cam.getFrontCam() + " , " + _cam.getrearCam() + " , " + _cam.getZoom());
        }
    }

    /**
     * enclosing phone case .
     */
    public void enclose_Phone_Case(){
        if (_case != null) {
            System.out.println("enclosing phone case :specs :: " + _case.getSize() + " , " + _case.getMaterial());
            if (_case.iswaterproof()) {
                System.out.println("\t\t\t\t\t\t\t   waterproof up to " + _case.waterproofUpTo());
            }
            if (_case.isDustproof()) {
                System.out.println("\t\t\t\t\t\t\t   dustproof");
            }
        }
    }

    public void setModel(phone_Model model) {
        this.model = model;
    }
}
