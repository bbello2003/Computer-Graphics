import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class Assignment2_65050605_65051034 extends JPanel implements Runnable {
    private Color startColor = Color.decode("#71B3EC");
    private Color moonStartColor = Color.decode("#F9403D");
    private Color targetColor = Color.decode("#08253E");
    private Color moonTargetColor = Color.decode("#F9C43D");
    private float blendRatio = 0.0f;
    private float blendStep = 0.002f;
    private double soilPathYOffset = 0;
    private double soilPathYVelocity = -0.3; // ความเร็วของการขยับดิน
    private double bambooY = 700;
    private double bambooVelocity = 20;
    private double circleMove = 0;
    private double circleVelocity = 100.0;

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
        double starTime = lastTime;
        double currentTime, elapsedTime;
        while (true) {
            currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - lastTime;
            lastTime = currentTime;

            circleMove += circleVelocity * elapsedTime / 1000.0;

            // Change color when blendRatio reaches 1.0
            if (blendRatio >= 1.0f) {
                blendRatio = 0.0f;
            }
            if (blendRatio == 0.0f) {
                circleMove = 0;
            }

            // Move soilPath up (Y offset by soilPathYOffset)
            soilPathYOffset += soilPathYVelocity;
            if (soilPathYOffset < -35) {
                soilPathYVelocity = 0; // หยุดการเคลื่อนที่เมื่อดินขยับถึงจุดที่กำหนด
            }

            if (bambooY <= 450)
                bambooVelocity = 0;
            if (currentTime - starTime >= 2000)
                bambooY -= bambooVelocity * elapsedTime / 1000.0;

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

        // Calculate the color blend ratio based on background color change
        float moonBlendRatio;
        if (blendRatio < 0.5f) {
            moonBlendRatio = blendRatio * 2; // Increase blend ratio linearly for moon
        } else {
            moonBlendRatio = 1.0f - (blendRatio - 0.5f) * 2; // Decrease blend ratio linearly for moon
        }

        // Calculate moon color based on blend ratio
        int moonRed = (int) (moonStartColor.getRed() * (1 - moonBlendRatio)
                + moonTargetColor.getRed() * moonBlendRatio);
        int moonGreen = (int) (moonStartColor.getGreen() * (1 - moonBlendRatio)
                + moonTargetColor.getGreen() * moonBlendRatio);
        int moonBlue = (int) (moonStartColor.getBlue() * (1 - moonBlendRatio)
                + moonTargetColor.getBlue() * moonBlendRatio);
        Color moonColor = new Color(moonRed, moonGreen, moonBlue);
        int moonY = (int) (50 + Math.sin((circleMove / 600 * Math.PI) + Math.PI) * 50);

        g2d.setColor(moonColor);
        g2d.translate(circleMove, moonY);
        g2d.fillOval(-100, 0, 100, 100);
        g2d.translate(-circleMove, -moonY);

        // Bamboo
        int bambooHeight = 300;
        Color bambooColor = Color.decode("#9FC72E");
        int bambooX = 279;
        int bambooWidth = 23;
        Bamboo bamboo = new Bamboo(bambooX, (int) (bambooY), bambooWidth, bambooHeight, bambooColor);
        bamboo.draw(g2d);

        // Soil
        double x = 185;
        double y = 395 + soilPathYOffset; // ปรับตำแหน่ง Y ด้วย soilPathYOffset
        int width = 210;
        int height = 80;
        GeneralPath soilPath = new GeneralPath();
        soilPath.moveTo(x + 20, y + height / 2);
        soilPath.curveTo(x, y + height / 2, x, y, x + width / 4, y);
        soilPath.curveTo(x + width / 2 - 20, y, x + width / 2 - 20, y + height / 2 - 30, x + width / 2,
                y + height / 2 - 30);
        soilPath.curveTo(x + width / 2 + 20, y + height / 2 - 30, x + width / 2 + 20, y, x + width * 3 / 4, y);
        soilPath.curveTo(x + width, y, x + width, y + height / 2, x + width - 20, y + height / 2);
        g2d.setColor(Color.decode("#746249"));
        g2d.fill(soilPath);
        g2d.setColor(Color.decode("#746249"));
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

        // Pot border
        int xRect1 = 166;
        int yRect1 = 390;
        int widthRect1 = 245;
        int heightRect1 = 20;
        int arcWidth1 = 5;
        int arcHeight1 = 5;
        RoundRectangle2D rect1 = new RoundRectangle2D.Double(xRect1, yRect1, widthRect1, heightRect1, arcWidth1,
                arcHeight1);
        g2d.setColor(Color.decode("#ec8865"));
        g2d.fill(rect1);

        // Pot shadow
        Color shadowColor = Color.decode("#d7785c");
        g2d.setColor(shadowColor);
        int[] x1Points = { 400, 175, 195, 380 };
        int[] y1Points = { 410, 410, 420, 420 };
        int num1Points = 4;
        Polygon polygon1 = new Polygon(x1Points, y1Points, num1Points);
        g2d.fillPolygon(polygon1);
    }

    public class Bamboo {
        private int x, y, width, height;
        private Color color;

        public Bamboo(int x, int y, int width, int height, Color color) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.color = color;
        }

        public void draw(Graphics2D g2d) {
            // วาดลำต้น
            g2d.setColor(color);
            g2d.fillRect(x, y - height, width, height);

            // วาดปล้อง
            int widthPot = 29;
            int heightPot = 7;
            int xPot = x + width / 8 - 5;
            int yPot = y - height - heightPot;
            int arcWidth = 6;
            int arcHeight = 6;

            RoundRectangle2D bambooPot = new RoundRectangle2D.Double(xPot, yPot, widthPot, heightPot, arcWidth,
                    arcHeight);
            g2d.fill(bambooPot);

            bambooPot = new RoundRectangle2D.Double(xPot, yPot + 60, widthPot, heightPot, arcWidth, arcHeight);
            g2d.fill(bambooPot);

            bambooPot = new RoundRectangle2D.Double(xPot, yPot + 120, widthPot, heightPot, arcWidth, arcHeight);
            g2d.fill(bambooPot);

            bambooPot = new RoundRectangle2D.Double(xPot, yPot + 180, widthPot, heightPot, arcWidth, arcHeight);
            g2d.fill(bambooPot);

            bambooPot = new RoundRectangle2D.Double(xPot, yPot + 240, widthPot, heightPot, arcWidth, arcHeight);
            g2d.fill(bambooPot);

            // เงาปล้อง
            g2d.setColor(color.darker());
            int[] x1Points = { xPot + 2, xPot + 27, xPot + 24, xPot + 5 };
            int[] y1Points = { yPot + 7, yPot + 7, yPot + 10, yPot + 10 };
            Polygon polygon = new Polygon(x1Points, y1Points, x1Points.length);
            g2d.fillPolygon(polygon);

            int[] x1Points2 = { xPot + 2, xPot + 27, xPot + 24, xPot + 5 };
            int[] y1Points2 = { yPot + 67, yPot + 67, yPot + 70, yPot + 70 };
            polygon = new Polygon(x1Points2, y1Points2, x1Points2.length);
            g2d.fillPolygon(polygon);

            int[] x1Points3 = { xPot + 2, xPot + 27, xPot + 24, xPot + 5 };
            int[] y1Points3 = { yPot + 127, yPot + 127, yPot + 130, yPot + 130 };
            polygon = new Polygon(x1Points3, y1Points3, x1Points3.length);
            g2d.fillPolygon(polygon);

            int[] x1Points4 = { xPot + 2, xPot + 27, xPot + 24, xPot + 5 };
            int[] y1Points4 = { yPot + 187, yPot + 187, yPot + 190, yPot + 190 };
            polygon = new Polygon(x1Points4, y1Points4, x1Points4.length);
            g2d.fillPolygon(polygon);

            int[] x1Points5 = { xPot + 2, xPot + 27, xPot + 24, xPot + 5 };
            int[] y1Points5 = { yPot + 247, yPot + 247, yPot + 250, yPot + 250 };
            polygon = new Polygon(x1Points5, y1Points5, x1Points5.length);
            g2d.fillPolygon(polygon);

            // วาดใบ
            int leafWidth = width * 3 / 2;
            int leafHeight = height * 3 / 4;
            int leafX = x - (leafWidth - width) / 2;
            int leafY = y - height - leafHeight;
            g2d.setColor(new Color(0, 128, 0)); // เลือกสีเขียวสว่าง
            // g2d.fillOval(leafX, leafY, leafWidth, leafHeight);
        }
    }
}