import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment2_65050605_65051034 extends JPanel implements Runnable {
    protected Random random = new Random();

    protected double lastTime = System.currentTimeMillis();
    protected double currentTime, elapsedTime;

    public void run() {
        while (true) {
            // time initiate
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            // Display
            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Assignment2_65050605_65051034 m = new Assignment2_65050605_65051034();

        f.add(m);
        f.setTitle("Assignment2");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        (new Thread(m)).start();
        ;
    }

    @Override
    public void paintComponent(Graphics g) {
        BufferedImage buff = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = buff.createGraphics();

    }
}
