import javax.swing.WindowConstants;

public class Simulation {
    public static void main(String[] args){
        int width;
        int height;
        boolean choice;

        choice = false; //change choice to false to run the map.

        if(choice){
            width  = 1200;
            height = 1200;
            Frame sim = new Frame(width,height);
            sim.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            sim.setSize(width,height);
            sim.setVisible(true);
            sim.setup();
            sim.make_rainbow_pendulums();
            sim.draw_rainbow_pends();
        }

        else {
            width = 1000;
            height = 1000;
            Frame map = new Frame(width,height);
            map.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            map.setSize(width,height);
            map.setVisible(true);
            map.setup();
            map.make_map();
            map.draw_map();
        }

    }

}
