/**
 * class Turkey_phone_Part_Factory_IflasDeluxe_Line .
 * responsible for produce components for the IflasDeluxe model in turkey .
 */
public class Turkey_phone_Part_Factory_IflasDeluxe_Line implements Phone_Parts_Factory {
    @Override
    public Display produce_Display() {
        return new phone_Display(screenSize._5_3,screenBit._32);
    }

    @Override
    public Battery produce_Battery() {
        return new phone_Battery(Battery_type.Lithium_Boron,Battery_cap._2800,Battery_time._20);
    }

    @Override
    public CPU_RAM produce_CPU_RAM() {
        return new phone_CPU_RAM(phoneCPU._2_2,phoneRAM._6,phoneCORE._8);
    }

    @Override
    public Storage produce_Storage() {
        return new phoneStorage(phoneSupport._32 , phoneMAXsupport._128);
    }

    @Override
    public Camera produce_Camera() {
        return new phoneCamera(phoneFrontcam._12 , phoneRearcam._5,phoneCamZoom._4);
    }

    @Override
    public Case produce_Case() {
        return new phoneCase(phoneCaseMaterial.aluminum ,phoneCaseSize._149x73x7_7 ,true , false , 200 );
    }
}
