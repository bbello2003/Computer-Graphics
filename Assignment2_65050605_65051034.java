import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Assignment2_65050605_65051034 extends JPanel implements Runnable {
    private Color startColor = Color.decode("#71B3EC");
    private Color targetColor = Color.decode("#08253E");
    private float blendRatio = 0.0f;
    private float blendStep = 0.002f;
    double circleMove = 0;
    double circleVelocity = 100.0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Assignment2_65050605_65051034 m = new Assignment2_65050605_65051034();
            JFrame f = new JFrame();
            f.add(m);
            f.setTitle("FROM BABIES TO ...");
            f.setSize(600, 600);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
            (new Thread(m)).start();
        });
    }

    @Override
    public void run() {
        double lastTime = System.currentTimeMillis();
        double currentTime, elapsedTime;
        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            // Move 50 pixels per second
            circleMove += circleVelocity * elapsedTime / 1000.0;
            // Check if the circle hits the edge
            if (circleMove >= 600 - 100) {
                circleMove = 600 - 100;
                circleVelocity = -circleVelocity;
            } else if (circleMove <= 0) {
                circleMove = 0;
                circleVelocity = -circleVelocity;
            }

            // Change color when blendRatio reaches 1.0
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

        // Soil
        int x = 190;
        int y = 360;
        int width = 200;
        int height = 75;
        GeneralPath soilPath = new GeneralPath();
        soilPath.moveTo(x + 20, y + height / 2);
        soilPath.curveTo(x, y + height / 2, x, y, x + width / 4, y);
        soilPath.curveTo(x + width / 2 - 20, y, x + width / 2 - 20, y + height / 2 - 30, x + width / 2, y + height / 2 - 30);
        soilPath.curveTo(x + width / 2 + 20, y + height / 2 - 30, x + width / 2 + 20, y, x + width * 3 / 4, y);
        soilPath.curveTo(x + width, y, x + width, y + height / 2, x + width - 20, y + height / 2);
        g2d.setColor(Color.decode("#867052"));
        g2d.fill(soilPath);
        g2d.setColor(Color.decode("#867052"));
        g2d.draw(soilPath);

        // Shadow under the plant pot
        g2d.setColor(Color.GRAY);
        Ellipse2D.Float ovalshadow = new Ellipse2D.Float(135, 494, 300, 15);
        g2d.fill(ovalshadow);

        // Plant pot
        Color plantpotColor = Color.decode("#ec8865");
        g2d.setColor(plantpotColor);
        int[] xPoints = { 400, 175, 195, 380 };
        int[] yPoints = { 400, 400, 500, 500 };
        int numPoints = 4;
        Polygon polygon = new Polygon(xPoints, yPoints, numPoints);
        g2d.fillPolygon(polygon);

        //ขอบกระถาง
        int xRect1 = 166;
        int yRect1 = 390;
        int widthRect1 = 245;
        int heightRect1 = 20;
        int arcWidth1 = 5;
        int arcHeight1 = 5;
        RoundRectangle2D rect1 = new RoundRectangle2D.Double(xRect1, yRect1, widthRect1, heightRect1, arcWidth1, arcHeight1);
        g2d.setColor(Color.decode("#ec8865"));
        g2d.fill(rect1);

        //เงาขอบกระถาง
        Color shadowColor = Color.decode("#d7785c");
        g2d.setColor(shadowColor);
        int[] x1Points = { 400, 175, 195, 380 };
        int[] y1Points = { 410, 410, 420, 420 };
        int num1Points = 4;
        Polygon polygon1 = new Polygon(x1Points, y1Points, num1Points);
        g2d.fillPolygon(polygon1);
    }
}
