public class Main {

    public static void main(String[] args) {
        WebSite site1 = new WebSite("google");
        WebSite site2 = new WebSite("youtube");

        Subscriber s1 = new Subscriber(1 );
        Subscriber s2 = new Subscriber(2 );
        Subscriber s3 = new Subscriber(3 );
        Subscriber s4 = new Subscriber(4 );
        Subscriber s5 = new Subscriber(5 );
        Subscriber s6 = new Subscriber(6 );
        Subscriber s7 = new Subscriber(7 );
        Subscriber s8 = new Subscriber(8 );
        Subscriber s9 = new Subscriber(9 );


        site1.AddContent(Contents.Text,"this is a text from google");
        site1.AddContent(Contents.Audio,"this is an audio from google");
        site2.AddContent(Contents.Text,"this is a text from youtube");
        site2.AddContent(Contents.Photograph,"this is an Photograph from youtube");
        /* adding subscriber to the Website */
        Contents[] array = {Contents.Text , Contents.Audio};
        site1.addObserver(s1,Contents.Audio);
        site1.addObserver(s2,array);
        site1.addObserver(s3,Contents.Audio);
        /* make change in the Website content */
        site1.SetContent(Contents.Audio,"this is audio from google , V2");
        System.out.println();
        site1.SetContent(Contents.Text,"this is Text from google , V2");
        /* removing an subscriber */
        System.out.println();
        site1.deleteObserver(s1);
        /* make change in the Website content */
        site1.SetContent(Contents.Audio,"this is audio from google , V3");
        System.out.println();
        site1.SetContent(Contents.Text,"this is Text from google , V3");


        /* adding subscriber to the Website */
        System.out.println();
        Contents[] array2 = {Contents.Text , Contents.Photograph};
        site2.addObserver(s4,array2);
        site2.addObserver(s3,Contents.Photograph);
        site2.addObserver(s5,Contents.Photograph);
        site2.addObserver(s2,Contents.Text);

        site2.SetContent(Contents.Photograph,"this is an Photograph from youtube ,V2");
        System.out.println();
        /* deleting all observers */
        site2.deleteObserver();
        site2.SetContent(Contents.Photograph,"this is an Photograph from youtube ,V3");
        System.out.println();
        /* adding observer again */
        site2.addObserver(s7,array2);
        site2.SetContent(Contents.Photograph,"this is an Photograph from youtube ,V4");
        System.out.println();

        site1.AddContent(Contents.Photograph,"this is a photograph from google ,V1");
        site1.addObserver(s7,Contents.Photograph);
        site1.addObserver(s2,Contents.Photograph);

        site1.SetContent(Contents.Photograph,"this is an Photograph from youtube ,V2");
        System.out.println();





    }
}
