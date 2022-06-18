public class Main {

    public static void main(String[] args) {

        Discrete_transform ft = new Discrete_Fourier_Transform();
        Discrete_transform ct = new Discrete_Cosine_Transform();
        if(args.length != 1 ){
            System.out.println("command line argument error !!");
            return ;
        }

        ft.caculate(args[0],"src/outputFourier.txt");

        System.out.println("\n\n\n");
        ct.caculate(args[0],"src/outputConsine.txt");
    }
}
