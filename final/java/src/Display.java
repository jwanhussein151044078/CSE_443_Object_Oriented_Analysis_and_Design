import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * class Display
 */
public class Display extends JFrame {

    private Mediator mediator ;
    private JButton button;

    /**
     * class constructor .
     */
    public Display(){
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1500,800);
        this.setResizable(false);
        button = new JButton("Pause");
        button.setSize(300,50);
        button.setLocation(50,250);
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button.getText().equals("Pause")){
                    button.setText("Continue");
                    mediator.Stop();
                }else if(button.getText().equals("Continue")){
                    button.setText("Pause");
                    mediator.Continue();
                }
            }
        });
    }

    /**
     * create the graphical user interface .
     */
    public void createGUI(){
        mediator.show();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.setFont(new Font("SansSerif", Font.BOLD, 30));
        g2.drawString("Canvas",900 , 95);
    }

    /**
     * sets the mediator .
     * @param mediator the mediator .
     */
    public void setMediator(Mediator mediator){
        this.mediator = mediator;
    }




}
