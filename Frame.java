import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JFrame;


public class Frame extends JFrame {
    private Image raster;
    private Graphics rGraphics;
    private int width;
    private int height;
    ArrayList<Pendulum> plist = new ArrayList<>();
    ArrayList<ArrayList <Pendulum>> pmatrix = new ArrayList<>();



    Frame(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setup(){
        raster = this.createImage(width, height);
        rGraphics = raster.getGraphics();
    }

    //The following methods are used to print 10,000 pendulums

    public void make_rainbow_pendulums() {
        Pendulum p;
        double theta = 0;
        int colour = 0;
        for(int i = 1; i<=10000; i++){
            if (i %  (10000/(4*255)) == 0 && i > 10)
                colour ++;
            theta += 0.0000001;
            p = new Pendulum(2,1,120,2,1,120+theta,colour);
            plist.add(p);
        }
    }

    public void draw_rainbow_pends(){
        while(true)
        {
            drawBG();  //draws background
            drawPend();
            runPends();
            getGraphics().drawImage(raster,0,0,getWidth(),getHeight(),null);

            try{Thread.sleep(1);}catch(Exception e){}

        }
    }

    private void drawBG(){
        rGraphics.setColor(new Color(255, 255, 255));
        rGraphics.fillRect(0,0,width,height);
    }

    private  void drawPend(){
        for(int i = 0; i<10000;i++)
            plist.get(i).drawPendulum(rGraphics);
    }

    private void runPends(){
        for(int i = 0; i<10000;i++)
            plist.get(i).move_runge_kutta();
    }

    //The following methods are use to make a map of all rotational kinetic energies.

    public void make_map(){
        Pendulum p;
        ArrayList<Pendulum> p_list;
        double theta1;
        double theta2 = 180;

        for(int i = 0; i<1000;i++) {
            p_list = new ArrayList<>();
            theta2 -=  0.36;
            theta1 = -180;
            for (int j = 0; j < 1000; j++) {
                theta1 += 0.36;
                p = new Pendulum(1,1,theta1,1,1,theta2);
                p_list.add(p);
            }
            pmatrix.add(p_list);
        }
    }



    public void draw_map(){
        while(true){

            draw_all_points();
            run_all_pends();
            getGraphics().drawImage(raster,0,0,getWidth(),getHeight(),null);
            try{Thread.sleep(1);}catch(Exception e){}

        }
    }

    private void draw_all_points() {
        Color c;
        for(int i = 0; i<1000; i++)
            for(int j = 0; j<1000;j++){
                c = pmatrix.get(i).get(j).get_Color();
                rGraphics.setColor(c);
                rGraphics.fillRect(j,i,1,1);
            }
    }

    private void run_all_pends(){
        for(int i = 0; i<1000;i++)
            for (int j = 0; j<1000;j++)
                pmatrix.get(i).get(j).move_euler();
    }

}
