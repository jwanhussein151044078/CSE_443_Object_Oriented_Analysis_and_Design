import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.Timer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IMediator implements Mediator {
    private Indivisual people ;
    private Display display ;
    private JPanel panel ;
    private JLabel healthy , infected , hospitalized , dead , ltimer ;
    private int healthyNum , infectedNum , hospitalizedNum , deadNum ;
    private boolean isPaused ;
    private int unique ;
    private myTimer timer ;
    private Timer collisonTimer , movingToHospitalTimer , gettingFromHosptalTimer , killTimer;
    private double R , Z  , P ;
    private Hospital hospital ;

    private final Lock lock = new ReentrantLock();
    private final Condition empty = lock.newCondition();
    private final Condition full = lock.newCondition();

    private HashMap<Integer,Location> table ;
    public IMediator(double R , double Z , int P){
        this.people = new People();
        this.healthyNum = 0 ;
        this.infectedNum = 0 ;
        this.hospitalizedNum = 0 ;
        this.deadNum = 0 ;
        this.isPaused = false ;
        this.unique = 0 ;
        this.R = R ;
        this.Z = Z ;
        this.P = P ;
        this.table = new HashMap<>();
        this.hospital = new Hospital(this , lock ,full , empty);
        this.collisonTimer = new Timer();
        this.movingToHospitalTimer  = new Timer();
        this.gettingFromHosptalTimer = new Timer();
        this.killTimer = new Timer();
    }
    /**
     * gets the individual to make a step .
     * @param indivisual the individual .
     */
    @Override
    public void move(Indivisual indivisual) {
        int collision = 0 ;
        int x = indivisual.getComponent().getX();
        int y = indivisual.getComponent().getY();
        if(!isPaused){
            if(!indivisual.isInColision() && !indivisual.isInHospital() && !indivisual.dead()){
                Direction Dir = indivisual.getDirection();
                collision = isCollision(x,y,Dir);
                if(collision != -1){
                    Indivisual ind ;
                    ind = people.getIndvidual(collision);
                    if(ind == null){
                        System.out.println("this is an error");
                    }else if (!ind.isInColision()){
                        ind.setInColision(true);
                        indivisual.setInColision(true);
                        ind.getComponent().repaint();
                        indivisual.getComponent().repaint();
                        setTimer(ind,indivisual);
                    }else{
                        indivisual.setDirection();
                        move(indivisual);
                        return;
                    }

                    return;
                }
                switch (Dir){
                    case North:
                        if(y <= 0){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x,y-1);
                                indivisual.getComponent().setLocation(x,y-1);
                            }
                        }break;
                    case South:
                        if(y >=595){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x,y+1);
                                indivisual.getComponent().setLocation(x,y+1);
                            }
                        }break;
                    case East:
                        if(x >= 995){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x+1,y);
                                indivisual.getComponent().setLocation(x+1,y);
                            }
                        }break;
                    case West:
                        if(x <= 0){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x-1,y);
                                indivisual.getComponent().setLocation(x-1,y);
                            }
                        }break;
                    case NorthEast:
                        if(y <= 0 || x >= 995){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x+1,y-1);
                                indivisual.getComponent().setLocation(x+1,y-1);
                            }
                        }break;
                    case NorthWest:
                        if(y <= 0 || x <= 0){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x-1,y-1);
                                indivisual.getComponent().setLocation(x-1,y-1);
                            }
                        }break;
                    case SouthEast:
                        if(y >= 595 || x >= 995){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x+1,y+1);
                                indivisual.getComponent().setLocation(x+1,y+1);
                            }
                        }break;
                    case SouthWest:
                        if(y >= 595 || x <= 0){
                            indivisual.setDirection();
                            move(indivisual);
                            return;
                        }else{
                            int id = indivisual.getId();
                            Location cur = table.get(id);
                            if(cur == null){
                                System.out.println("this should not happen");
                            }else{
                                cur.setLocation(x-1,y+1);
                                indivisual.getComponent().setLocation(x-1,y+1);
                            }
                        }break;
                }
            }
        }

    }
    /**
     * adds the individual .
     * @param indivisual the individual to add .
     */
    @Override
    public void registerIndividual(Indivisual indivisual) {
        indivisual.setMediator(this);
        this.people.addIndividual(indivisual);
        panel.add(indivisual.getComponent());
        indivisual.setId();
    }

    @Override
    public void registerDisplay(Display display) {
        display.setMediator(this);
        this.display = display;
    }

    public void registerTimer(myTimer timer){
        timer.setMediator(this);
        this.timer = timer ;
    }
    /**
     * creates the GUI .
     */
    @Override
    public void show(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(442,71,1000,600);
        panel.setBackground(Color.darkGray);
        this.display.add(panel);

        healthy = new JLabel(String.format("Healthy          : %10d",this.healthyNum));
        healthy.setFont(new Font("Serif", Font.BOLD, 25));
        healthy.setSize(250,100);
        healthy.setLocation(50,0);
        display.add(healthy);

        infected = new JLabel(String.format("Infected          : %10d",this.infectedNum));
        infected.setFont(new Font("Serif", Font.BOLD, 25));
        infected.setSize(250,100);
        infected.setLocation(50,35);
        display.add(infected);

        hospitalized = new JLabel(String.format("Hospitalized  : %10d",hospitalizedNum));
        hospitalized.setFont(new Font("Serif", Font.BOLD, 25));
        hospitalized.setSize(250,100);
        hospitalized.setLocation(50,70);
        display.add(hospitalized);

        dead = new JLabel( String.format("Dead               : %10d",this.deadNum));
        dead.setFont(new Font("Serif", Font.BOLD, 25));
        dead.setSize(250,100);
        dead.setLocation(50,105);
        display.add(dead);


        ltimer = new JLabel( "Timer             :   00:00:00");
        ltimer.setFont(new Font("Serif", Font.BOLD, 25));
        ltimer.setSize(350,100);
        ltimer.setLocation(50,140);
        display.add(ltimer);


        display.repaint();
    }
    /**
     * Pauses the simulator .
     */
    @Override
    public void Stop(){
        this.isPaused = true ;
    }
    /**
     * resumes the simulator .
     */
    @Override
    public void Continue(){
        this.isPaused = false ;
    }

    @Override
    public int getUniqueId(Indivisual indivisual){
        unique++ ;
        Random rand = new Random();
        int x = rand.nextInt(995);
        int y = rand.nextInt(595);
        while (!isValid(y,x)){
            x = rand.nextInt(995);
            y = rand.nextInt(595);
        }

        indivisual.getComponent().setLocation(x,y);
        table.put(unique,new Location(x,y));
        if(indivisual.isInfected()){
            this.infectedNum++;
            infected.setText(String.format("Infected          : %10d",this.infectedNum));
        }else{
            this.healthyNum++;
            healthy.setText(String.format("Healthy          : %10d",this.healthyNum));
        }
        return unique;
    }
    /**
     * return true is the simulator is paused , false if not .
     * @return
     */
    public boolean isPaused(){
        return isPaused ;
    }
    /**
     * adjust the timer .
     * @param hour new hour.
     * @param minute new minutes .
     * @param second new second .
     */
    public void adjustTimer(int hour,int minute , int second){
        ltimer.setText(String.format("Timer             :   %02d:%02d:%02d",hour,minute,second));
    }

    private boolean isValid(int x , int y){
        Iterator<Location> it = table.values().iterator();
        while (it.hasNext()){
            if(it.next().distance(x,y) <= 7.071068 ){
                return false;
            }
        }
        return true;
    }
    private int isCollision(int x , int y , Direction direction){
        switch (direction){
            case North:
                for(int i = -5 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x+i,y-5))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+i,y-5)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case South:
                for(int i = -5 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x+i,y+5))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+i,y+5)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case East:
                for(int i = -5 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x+5,y+i))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+5,y+i)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case West:
                for(int i = -5 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x-5,y+i))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x-5,y+i)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case NorthEast:
                for(int i = -4 ; i < 7 ; i++){
                    if(table.containsValue(new Location(x+i,y-5))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+i,y-5)) == 0){
                                return id ;
                            }
                        }
                    }
                }
                for(int i = -6 ; i < 5 ; i++){
                    if(table.containsValue(new Location(x+5,y+i))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+5,y+i)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case NorthWest:
                for(int i = -6 ; i < 5 ; i++){
                    if(table.containsValue(new Location(x+i,y-5))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+i,y-5)) == 0){
                                return id ;
                            }
                        }
                    }
                }
                for(int i = -6 ; i < 4 ; i++){
                    if(table.containsValue(new Location(x-5,y+i))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x-5,y+i)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case SouthEast:
                for(int i = -4 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x+i,y+5))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+i,y+5)) == 0){
                                return id ;
                            }
                        }
                    }
                }
                for(int i = -5 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x+5,y+i))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+5,y+i)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
            case SouthWest:
                for(int i = -6; i < 5 ; i++){
                    if(table.containsValue(new Location(x+i,y+5))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x+i,y+5)) == 0){
                                return id ;
                            }
                        }
                    }
                }
                for(int i = -4 ; i < 6 ; i++){
                    if(table.containsValue(new Location(x-5,y+i))){
                        Iterator<Integer> it = table.keySet().iterator();
                        while (it.hasNext()){
                            Integer id = it.next();
                            if(table.get(id).compareTo(new Location(x-5,y+i)) == 0){
                                return id ;
                            }
                        }
                    }
                }break;
        }
        return -1 ;
    }
    private void setTimer(Indivisual indivisual1 , Indivisual indivisual2){
        collisonTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                separate(indivisual1,indivisual2);
            }
        },this.max(indivisual1.getSocialTime()*1000,indivisual2.getSocialTime()*1000));
    }
    private int max(int a , int b){
        if(a > b){
            return a ;
        }return b ;
    }
    private int min(int a , int b){
        if(a>b){
            return b;
        }return a ;
    }
    private void separate(Indivisual indivisual1 , Indivisual indivisual2){
        int maxC = max(indivisual1.getSocialTime(),indivisual2.getSocialTime());
        int minD = min(indivisual1.getSocialDistance(),indivisual2.getSocialDistance());
        int p    = min((int)(R*(1+(maxC/10))*indivisual1.getMask()*indivisual2.getMask()*(1-(minD/10))),1);
        indivisual1.setDirection();
        indivisual2.setDirection();
        indivisual1.setInColision(false);
        indivisual2.setInColision(false);
        if(p > 0) {
            if (indivisual1.isInfected() && !indivisual2.isInfected()) {
                indivisual2.setInfected(true);

            }else if(!indivisual1.isInfected() && indivisual2.isInfected()){
                indivisual1.setInfected(true);

            }
        }
    }
    private void moveToHospital(Indivisual indivisual){
        lock.lock();
        while (hospital.getSize() == (int)this.P/100){
            try {
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(!indivisual.dead()) {
            hospital.offer(indivisual);
        }
        gettingFromHosptalTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                getFromHospital();
            }
        },10000);
        full.signalAll();
        lock.unlock();

        this.table.remove(indivisual.getId());
        indivisual.setInHospital(true);
    }

    /**
     * called by an individual when got infected
     * set the labels of the frame
     * sets a timer to move the individual to the hospital
     * @param indivisual the individual which called the method .
     */
    public void gotInfected(Indivisual indivisual){
        healthyNum--;
        infectedNum++;
        healthy.setText(String.format("Healthy          : %10d",this.healthyNum));
        infected.setText(String.format("Infected          : %10d",this.infectedNum));
        indivisual.getComponent().repaint();
        movingToHospitalTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(!indivisual.dead()) {
                    moveToHospital(indivisual);
                }
            }
        },25000);

        killTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(indivisual.isInfected() && !indivisual.isInHospital()){
                    indivisual.setDead();
                }
            }
        },(int)(100*(1-Z))*1000);
    }
    /**
     * called by an individual in case if healed
     * set the labels of the frame
     * @param indivisual the individual which called the method .
     */
    public void healed(Indivisual indivisual){
        healthyNum++;
        infectedNum--;
        hospitalizedNum++;
        healthy.setText(String.format("Healthy          : %10d",this.healthyNum));
        infected.setText(String.format("Infected          : %10d",this.infectedNum));
        hospitalized.setText(String.format("Hospitalized  : %10d",this.hospitalizedNum));
        indivisual.getComponent().repaint();
    }

    private void getFromHospital(){
        Indivisual indivisual = hospital.poll();
        indivisual.setInHospital(false);
        indivisual.setInfected(false);
        this.table.put(indivisual.getId(),new Location(indivisual.getComponent().getX(),indivisual.getComponent().getY()));

    }
    /**
     * kills the individual .
     * @param indivisual the individual .
     */
    @Override
    public void kill(Indivisual indivisual) {
        this.deadNum++;
        this.infectedNum--;
        infected.setText(String.format("Infected          : %10d",this.infectedNum));
        dead.setText(String.format("Dead               : %10d",this.deadNum));
        this.table.remove(indivisual.getId());

    }
}
