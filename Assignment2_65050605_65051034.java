import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;

import java.awt.*;

public class Assignment2_65050605_65051034 extends JPanel implements Runnable {
    int i = 0,cnt = 0;
    double velocityArc = 5;
    double x = 0,y=500;
    double velocityX = 100.0;
    double velocityY = 150.0;
    double velocity = 150.0;
    double angle = -60.0;
    
    // double squareRotate = 5;
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Assignment2_64050605_64051034 m = new Assignment2_64050605_64051034();

        f.add(m);
        f.setTitle("Assignment2");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();;
    }
     @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime,elapsedTime;
        // velocityX = velocity * Math.cos(Math.toRadians(angle));
        // velocityY = velocity * Math.sin(Math.toRadians(angle));
        while(true){
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime =currentTime;
            if(velocityArc<360) {
                velocityArc += 20 * elapsedTime / 1000.0;
                System.out.println(velocityArc);
            }
            x += velocityX * elapsedTime / 1000.0;
            y += velocityY * elapsedTime / 1000.0;

            if(x>=600 - 75){
                x = 600 - 75;
                velocityX = -velocityX;
            }
            if(x<=75){
                x = 75;
                velocityX = -velocityX;
            }
            if(y >= 600 - 75){
                y = 600 - 75;
                velocityY = -velocityY;
            }
            if(y <= 75){
                y = 75;
                velocityY = -velocityY;
            }
            
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buff = new BufferedImage(601,601,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buff.createGraphics();
        
