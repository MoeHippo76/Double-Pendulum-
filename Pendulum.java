import java.awt.*;

public class Pendulum {
    double l1;
    double l2;
    double x1;
    double y1;
    double x2;
    double y2;
    double theta1;
    double theta2;
    double w1;
    double w2;
    double m1;
    double m2;
    double g = 9.8;
    Color c;



    Pendulum(double l1, double m1, double theta1, double l2, double m2, double theta2){
        this.l1 = l1;
        this.m1 = m1;
        this.theta1 = Math.toRadians(theta1);
        this.l2 = l2;
        this.m2 = m2;
        this.theta2 = Math.toRadians(theta2);
        c = new Color(215, 5, 5);
        toXAndY();
    }

    Pendulum(double l1, double m1, double theta1, double l2, double m2, double theta2,int colour){
        this.l1 = l1;
        this.m1 = m1;
        this.theta1 = Math.toRadians(theta1);
        this.l2 = l2;
        this.m2 = m2;
        this.theta2 = Math.toRadians(theta2);
        if(colour <=255)
            c = new Color(255, colour, 0);
        else if(colour <= 2*255) {
            colour = colour - 255;
            c = new Color(255- colour, 255, 0);
        }
        else if(colour <= 3*255) {
            colour = colour - 2*255;
            c = new Color(0, 255, colour);
        }
        else if(colour <= 4*255) {
            colour = colour - 3*255;
            c = new Color(0, 255 - colour, 255);
        }
        toXAndY();
    }


    public void move_euler(){
        double h = 0.005;


        w1 += h*dw1(w1);
        theta1 += w1*h;


        w2 += h*dw2(w2);
        theta2 += w2*h;

        toXAndY();
    }

    public void move_runge_kutta(){
        double h = 0.002;

        double k1;
        double k2;
        double k3;
        double k4;
        double k12;
        double k22;
        double k32;
        double k42;

        k1 = dw1(w1);
        k2 = dw1(w1+h*k1/2);
        k3 = dw1(w1+h*k2/2);
        k4 = dw1(w1+h*k3/2);

        w1 += h*(k1 + 2*k2 + 2*k3 + k4)/6;
        theta1 += w1*h;

        k12 = dw2(w2);
        k22 = dw2(w2+h*k12/2);
        k32 = dw2(w2+h*k22/2);
        k42 = dw2(w2+h*k32/2);

        w2 += h*(k12 + 2*k22 + 2*k32 + k42)/6;
        theta2 += w2*h;


        toXAndY();
    }

   private double dw1(double w1){
        double dw1;
        double den = 2*m1+m2-m2*Math.cos(2*theta1 - 2*theta2);
        double num1 = -g*(2*m1+m2)*Math.sin(theta1);
        double num2 = -m2*g*Math.sin(theta1-2*theta2);
        double num3 = -2*Math.sin(theta1-theta2)*m2;
        double num4 = w2*w2*l2 + w1*w1*l1*Math.cos(theta1-theta2);

        dw1 = (num1+num2+num3*num4)/(l1*den);

        return dw1;
    }

    private double dw2(double w2){
        double dw2;
        double den = 2*m1+m2-m2*Math.cos(2*theta1 - 2*theta2);
        double num1 = 2*Math.sin(theta1-theta2);
        double num2 = w1*w1*l1*(m1+m2);
        double num3 = g*(m1+m2)*Math.cos(theta1);
        double num4 = w2*w2*l2*m2*Math.cos(theta1-theta2);

        dw2 = num1*(num2+num3+num4)/(l2*den);

        return dw2;
    }

    private void  toXAndY(){
        x1 = 600 + 100*l1*Math.sin(theta1);
        y1 = 600 + 100*l1*Math.cos(theta1);
        x2 = x1 + 100*l2*Math.sin(theta2);
        y2 = y1 + 100*l2*Math.cos(theta2);
    }


    public void drawPendulum(Graphics g){
        g.setColor(c);
        g.drawLine(600,600,(int) x1,(int) y1);
        g.drawLine((int) x1,(int) y1,(int) x2,(int) y2);

    }

    public Color get_Color(){
        int e = (int) e_K();
        if(e <=5)
            c = new Color(12, 12, 12);
        else if(e <= 10) {
            c = new Color(119, 0, 255);
        }
        else if(e <= 15) {
            c = new Color(19, 2, 250);
        }
        else if(e <=20) {
            c = new Color(2, 171, 250);
        }
        else if(e <= 30){
            c = new Color(0, 255, 72);
        }
        else if(e<=50){
            c = new Color(255, 242, 0);
        }
        else if(e<=70){
            c = new Color(255, 100, 0);
        }
        else if(e<=90)
            c = new Color(255, 0, 0);

        else if(e <= 130)c = new Color(0xFF00AA);

        else c = new Color(0xFFFFFFFF, true);

        return c;
    }

    public double e_K(){
        double e_K;
        e_K = 0.5*m1*l1*l1*w1*w1 + 0.5*l2*l2*m2*w2*w2;
        return e_K;
    }


}
