import javax.swing.*;
import java.awt.*;

public class Assignment2_65050605_65051034 extends JPanel implements Runnable {
    private Color startColor = Color.decode("#71B3EC");
    private Color targetColor = Color.decode("#08253E");
    private float blendRatio = 0.0f;
    private float blendStep = 0.002f;
    double circleMove = 0;
    double circleVelocity = 100.0;

    public static void main(String[] args) {
        Assignment2_65050605_65051034 m = new Assignment2_65050605_65051034();
        JFrame f = new JFrame();
        f.add(m);
        f.setTitle("FROM BABIES TO ...");
        f.setSize(600, 600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        (new Thread(m)).start();
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;
        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            // Move 50 pixel per second
            circleMove += circleVelocity * elapsedTime / 1000.0;
            // Check if the circle hits the edge
            if (circleMove >= 600 - 100) {
                circleMove = 600 - 100;
                circleVelocity = -circleVelocity;
            } else if (circleMove <= 0) {
                circleMove = 0;
                circleVelocity = -circleVelocity;
            }

            // เปลี่ยนสีเมื่อ blendRatio ถึง 1.0
            if (blendRatio >= 1.0f) {
                blendRatio = 0.0f;
            }
            repaint();
            blendRatio += blendStep;
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int red, green, blue;
        if (blendRatio < 0.5f) {
            red = (int) (startColor.getRed() * (1 - blendRatio * 2) + targetColor.getRed() * blendRatio * 2);
            green = (int) (startColor.getGreen() * (1 - blendRatio * 2) + targetColor.getGreen() * blendRatio * 2);
            blue = (int) (startColor.getBlue() * (1 - blendRatio * 2) + targetColor.getBlue() * blendRatio * 2);
        } else {
            red = (int) (targetColor.getRed() * (1 - (blendRatio - 0.5f) * 2)
                    + startColor.getRed() * (blendRatio - 0.5f) * 2);
            green = (int) (targetColor.getGreen() * (1 - (blendRatio - 0.5f) * 2)
                    + startColor.getGreen() * (blendRatio - 0.5f) * 2);
            blue = (int) (targetColor.getBlue() * (1 - (blendRatio - 0.5f) * 2)
                    + startColor.getBlue() * (blendRatio - 0.5f) * 2);
        }
        Color blendedColor = new Color(red, green, blue);
        g2d.setColor(blendedColor);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        g2d.setColor(Color.yellow);
        g2d.translate(circleMove, 10);
        g2d.drawOval(0, 0, 100, 100);
        g2d.translate(-circleMove, 10);
    }
}
