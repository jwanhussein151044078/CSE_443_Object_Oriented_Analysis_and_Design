
public class Main {

    public static void main(String[] args) {
        simulator(1,0.6,400);

    }

    public static void simulator(double R , double Z , int P){

        Mediator mediator = new IMediator(R,Z,P);
        Display display = new Display();
        myTimer timer = new myTimer();

        mediator.registerDisplay(display);
        mediator.registerTimer(timer);
        display.createGUI();

        Person p = new Person();
        mediator.registerIndividual(p);

        p.setInfected(true);

        People group1 = new People();
        People group2 = new People();


        for (int i = 1 ; i < P/2 ; i++){
            group1.addIndividual(new Person());
        }

        for (int i = P/2 ; i < P ; i++){
            group2.addIndividual(new Person());
        }

        group1.addIndividual(group2);

        mediator.registerIndividual(group1);
        while(true){
            group1.move();
            p.move();

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
