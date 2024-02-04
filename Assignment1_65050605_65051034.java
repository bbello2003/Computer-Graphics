import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Polygon;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;
import java.awt.geom.RoundRectangle2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assignment1_65050605_65051034 extends JPanel {
        public static void main(String[] args) {
                Assignment1_65050605_65051034 m = new Assignment1_65050605_65051034();
                JFrame f = new JFrame();
                f.add(m);
                f.setTitle("NEW YEAR");
                f.setSize(600, 600);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setVisible(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // setBackground(Color.decode("#EDBE32"));
                Color startColor = Color.decode("#ffe566");
                Color endColor = Color.decode("#ff9500");
                GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, 0, getHeight(), endColor);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(gradientPaint);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // เส้นขอบ
                g2d.setColor(Color.decode("#5C1A00"));
                bresenhamLine(g2d, 15, 30, 585, 30);
                bresenhamLine(g2d, 570, 15, 570, 555);
                bresenhamLine(g2d, 30, 15, 30, 555);
                bresenhamLine(g2d, 15, 540, 585, 540);

                bresenhamLine(g2d, 45, 45, 45, 15);
                bresenhamLine(g2d, 45, 45, 15, 45);
                bresenhamLine(g2d, 15, 15, 30, 15);
                bresenhamLine(g2d, 15, 15, 15, 30);
                bresenhamLine(g2d, 15, 60, 15, 45);
                bresenhamLine(g2d, 15, 60, 30, 60);
                bresenhamLine(g2d, 60, 15, 45, 15);
                bresenhamLine(g2d, 60, 15, 60, 30);

                bresenhamLine(g2d, 555, 45, 555, 15);
                bresenhamLine(g2d, 555, 45, 585, 45);
                bresenhamLine(g2d, 540, 15, 555, 15);
                bresenhamLine(g2d, 540, 15, 540, 30);
                bresenhamLine(g2d, 585, 15, 570, 15);
                bresenhamLine(g2d, 585, 15, 585, 30);
                bresenhamLine(g2d, 585, 60, 585, 45);
                bresenhamLine(g2d, 585, 60, 570, 60);

                bresenhamLine(g2d, 45, 525, 15, 525);
                bresenhamLine(g2d, 45, 525, 45, 555);
                bresenhamLine(g2d, 15, 510, 30, 510);
                bresenhamLine(g2d, 15, 510, 15, 525);
                bresenhamLine(g2d, 15, 555, 15, 540);
                bresenhamLine(g2d, 15, 555, 30, 555);
                bresenhamLine(g2d, 60, 555, 60, 540);
                bresenhamLine(g2d, 60, 555, 45, 555);

                bresenhamLine(g2d, 555, 525, 585, 525);
                bresenhamLine(g2d, 555, 525, 555, 555);
                bresenhamLine(g2d, 585, 510, 570, 510);
                bresenhamLine(g2d, 585, 510, 585, 525);
                bresenhamLine(g2d, 585, 555, 585, 540);
                bresenhamLine(g2d, 585, 555, 570, 555);
                bresenhamLine(g2d, 540, 555, 540, 540);
                bresenhamLine(g2d, 540, 555, 555, 555);

                // ตัวมังกร
                Color greenColor = Color.decode("#880015");
                g2d.setColor(greenColor);
                int[] xPoints = { 200, 400, 480, 120 };
                int[] yPoints = { 360, 360, 599, 599 };
                int numPoints = 4;
                Polygon polygon = new Polygon(xPoints, yPoints, numPoints);
                g.fillPolygon(polygon);

                // ท้องมังกร
                Color yellowColor = Color.decode("#D1710B");
                g2d.setColor(yellowColor);
                int[] xPointsOverlap = { 240, 360, 430, 170 };
                int[] yPointsOverlap = { 410, 410, 599, 599 };
                int numPointsOverlap = 4;
                Polygon polygonOverlap = new Polygon(xPointsOverlap, yPointsOverlap, numPointsOverlap);
                g2d.fillPolygon(polygonOverlap);

                // คาง
                Color arcColor = Color.decode("#880015");
                g2d.setColor(arcColor);
                int xArc = 240;
                int yArc = 345;
                int widthArc = 120;
                int heightArc = 130;
                int startAngle = 0;
                int arcAngle = -180;
                g2d.fillArc(xArc, yArc, widthArc, heightArc, startAngle, arcAngle);

                // ปาก
                Color blackColor = Color.BLACK;
                g2d.setColor(blackColor);
                int xArcBlack = 265;
                int yArcBlack = 370;
                int widthArcBlack = 70;
                int heightArcBlack = 80;
                int startAngleBlack = 180;
                int arcAngleBlack = 180;
                g2d.fillArc(xArcBlack, yArcBlack, widthArcBlack, heightArcBlack, startAngleBlack, arcAngleBlack);

                // ริ้วท้อง 1
                int xRect1 = 230;
                int yRect1 = 500;
                int widthRect1 = 140;
                int heightRect1 = 10;
                int arcWidth1 = 20;
                int arcHeight1 = 20;
                RoundRectangle2D rect1 = new RoundRectangle2D.Double(xRect1, yRect1, widthRect1, heightRect1, arcWidth1,
                                arcHeight1);
                g2d.setColor(Color.decode("#B5630B"));
                g2d.fill(rect1);

                // ริ้วท้อง 2
                int xRect2 = 230;
                int yRect2 = 530;
                int widthRect2 = 140;
                int heightRect2 = 10;
                int arcWidth2 = 20;
                int arcHeight2 = 20;
                RoundRectangle2D rect2 = new RoundRectangle2D.Double(xRect2, yRect2, widthRect2, heightRect2, arcWidth2,
                                arcHeight2);
                g2d.setColor(Color.decode("#B5630B"));
                g2d.fill(rect2);

                // เขี้ยวสีขาว ซ้าย
                g2d.setColor(Color.WHITE);
                int[] xWhiteTriangle = { 280, 270, 290 };
                int[] yWhiteTriangle = { 430, 415, 415 };
                int numPointsWhiteTriangle = 3;
                Polygon whiteTriangle = new Polygon(xWhiteTriangle, yWhiteTriangle, numPointsWhiteTriangle);
                g2d.fillPolygon(whiteTriangle);

                // เขี้ยวสีขาว ขวา
                g2d.setColor(Color.WHITE);
                int[] xWhiteTriangle2 = { 320, 310, 330 };
                int[] yWhiteTriangle2 = { 430, 415, 415 };
                int numPointsWhiteTriangle2 = 3;
                Polygon whiteTriangle2 = new Polygon(xWhiteTriangle2, yWhiteTriangle2, numPointsWhiteTriangle2);
                g2d.fillPolygon(whiteTriangle2);

                // ลิ้น
                int xCircle = 300;
                int yCircle = 455;
                int radius = 25;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillOval(xCircle - radius, yCircle - radius, 2 * radius, 2 * radius);

                // คางชั้นที่ 2 ทับลิ้นที่เกินมา
                float thickness = 25.0f;
                BasicStroke basicStroke = new BasicStroke(thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
                g2d.setStroke(basicStroke);
                g2d.setColor(Color.decode("#880015"));
                g2d.drawArc(255, 370, 90, 95, 180, 180);

                // ส่วนบนของปาก
                int xRectangle = 225;
                int yRectangle = 400;
                int widthRectangle = 150;
                int heightRectangle = 16;
                int arcWidth = 20;
                int arcHeight = 20;
                g2d.setColor(Color.decode("#D1710B"));
                RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(xRectangle, yRectangle, widthRectangle,
                                heightRectangle, arcWidth, arcHeight);
                g2d.fill(roundedRectangle);

                // สันจมูก
                int xJumookRectangle = 260;
                int yJumookRectangle = 335;
                int widthJumookRectangle = 85;
                int heightJumookRectangle = 65;
                g2d.setColor(Color.BLACK);
                g2d.fillRect(xJumookRectangle, yJumookRectangle, widthJumookRectangle, heightJumookRectangle);

                // ต้นจมูก สามเหลี่ยม
                int[] xPointsTriangle1 = { 300, 258, 340 };
                int[] yPointsTriangle1 = { 300, 336, 336 };
                int numPointsTriangle1 = 3;
                g2d.setColor(Color.BLACK);
                g2d.fillPolygon(xPointsTriangle1, yPointsTriangle1, numPointsTriangle1);

                // ริ้วจมูก 1
                int xRect4 = 285;
                int yRect4 = 330;
                int widthRect4 = 30;
                int heightRect4 = 7;
                int arcWidth4 = 10;
                int arcHeight4 = 10;
                RoundRectangle2D rect3 = new RoundRectangle2D.Double(xRect4, yRect4, widthRect4, heightRect4, arcWidth4,
                                arcHeight4);
                g2d.setColor(Color.decode("#4A4A4A"));
                g2d.fill(rect3);

                // ริ้วจมูก 2
                int xRect5 = 285;
                int yRect5 = 346;
                int widthRect5 = 30;
                int heightRect5 = 7;
                int arcWidth5 = 10;
                int arcHeight5 = 10;
                RoundRectangle2D rect4 = new RoundRectangle2D.Double(xRect5, yRect5, widthRect5, heightRect5, arcWidth5,
                                arcHeight5);
                g2d.setColor(Color.decode("#4A4A4A"));
                g2d.fill(rect4);

                // ริ้วจมูก 3
                int xRect6 = 285;
                int yRect6 = 361;
                int widthRect6 = 30;
                int heightRect6 = 7;
                int arcWidth6 = 10;
                int arcHeight6 = 10;
                RoundRectangle2D rect5 = new RoundRectangle2D.Double(xRect6, yRect6, widthRect6, heightRect6, arcWidth6,
                                arcHeight6);
                g2d.setColor(Color.decode("#4A4A4A"));
                g2d.fill(rect5);

                // จมูกซ้าย
                int xBottomArc = 259;
                int yBottomArc = 381;
                int widthBottomArc = 40;
                int heightBottomArc = 40;
                int startAngleBottomArc = 0;
                int arcAngleBottomArc = 180;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillArc(xBottomArc, yBottomArc, widthBottomArc, heightBottomArc, startAngleBottomArc,
                                arcAngleBottomArc);

                // จมูกขวา
                int xOverlapBottomArc = 299;
                int yOverlapBottomArc = 381;
                int widthOverlapBottomArc = 40;
                int heightOverlapBottomArc = 40;
                int startAngleOverlapBottomArc = 0;
                int arcAngleOverlapBottomArc = 180;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillArc(xOverlapBottomArc, yOverlapBottomArc, widthOverlapBottomArc, heightOverlapBottomArc,
                                startAngleOverlapBottomArc, arcAngleOverlapBottomArc);

                // รูจมูกซ้าย
                int xJumookLeft = 266;
                int yJumookLeft = 387;
                int widthJumookLeft = 26;
                int heightJumookLeft = 25;
                int startAngleJumookLeft = 0;
                int arcAngleJumookLeft = 180;
                g2d.setColor(Color.BLACK);
                g2d.fillArc(xJumookLeft, yJumookLeft, widthJumookLeft, heightJumookLeft, startAngleJumookLeft,
                                arcAngleJumookLeft);

                // รูจมูกขวา
                int xJumookRight = 306;
                int yJumookRight = 387;
                int widthJumookRight = 26;
                int heightJumookRight = 25;
                int startAngleJumookRight = 0;
                int arcAngleJumookRight = 180;
                g2d.setColor(Color.BLACK);
                g2d.fillArc(xJumookRight, yJumookRight, widthJumookRight, heightJumookRight, startAngleJumookRight,
                                arcAngleJumookRight);

                // หงอนสีเหลืองล่างซ้าย
                int[] xPointsPolygon1 = { 260, 245, 215, 260 };
                int[] yPointsPolygon1 = { 400, 400, 365, 365 };
                int numPointsPolygon1 = 4;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillPolygon(xPointsPolygon1, yPointsPolygon1, numPointsPolygon1);

                // หงอนสีเหลืองล่างขวา
                int[] xPointsPolygon2 = { 340, 355, 385, 340 };
                int[] yPointsPolygon2 = { 400, 400, 365, 365 };
                int numPointsPolygon2 = 4;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillPolygon(xPointsPolygon2, yPointsPolygon2, numPointsPolygon2);

                // หงอนสีเหลืองบนซ้าย
                int[] xPointsPolygon3 = { 260, 245, 215, 260 };
                int[] yPointsPolygon3 = { 370, 370, 335, 335 };
                int numPointsPolygon3 = 4;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillPolygon(xPointsPolygon3, yPointsPolygon3, numPointsPolygon3);

                // หงอนสีเหลืองบนขวา
                int[] xPointsPolygon4 = { 340, 355, 385, 340 };
                int[] yPointsPolygon4 = { 370, 370, 335, 335 };
                int numPointsPolygon4 = 4;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillPolygon(xPointsPolygon4, yPointsPolygon4, numPointsPolygon4);

                // หงอนสีเขียวล่างซ้าย
                int[] xPointsPolygon5 = { 205, 190, 160, 205 };
                int[] yPointsPolygon5 = { 400, 400, 365, 365 };
                int numPointsPolygon5 = 4;
                g2d.setColor(Color.decode("#880015"));
                g2d.fillPolygon(xPointsPolygon5, yPointsPolygon5, numPointsPolygon5);

                // หงอนสีเขียวล่างขวา
                int[] xPointsPolygon6 = { 390, 410, 440, 390 };
                int[] yPointsPolygon6 = { 400, 400, 365, 365 };
                int numPointsPolygon6 = 4;
                g2d.setColor(Color.decode("#880015"));
                g2d.fillPolygon(xPointsPolygon6, yPointsPolygon6, numPointsPolygon6);

                // หงอนสีเขียวบนซ้าย
                int[] xPointsPolygon7 = { 241, 190, 160, 215 };
                int[] yPointsPolygon7 = { 365, 365, 335, 335 };
                int numPointsPolygon7 = 4;
                g2d.setColor(Color.decode("#880015"));
                g2d.fillPolygon(xPointsPolygon7, yPointsPolygon7, numPointsPolygon7);

                // หงอนสีเขียวบนขวา
                int[] xPointsPolygon8 = { 359, 410, 440, 385 };
                int[] yPointsPolygon8 = { 365, 365, 335, 335 };
                int numPointsPolygon8 = 4;
                g2d.setColor(Color.decode("#880015"));
                g2d.fillPolygon(xPointsPolygon8, yPointsPolygon8, numPointsPolygon8);

                // หงอนสีเหลืองบนซ้ายหงอนเขียว
                int[] xPointsPolygon9 = { 260, 190, 160, 232 };
                int[] yPointsPolygon9 = { 335, 335, 305, 305 };
                int numPointsPolygon9 = 4;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillPolygon(xPointsPolygon9, yPointsPolygon9, numPointsPolygon9);

                // หงอนสีเหลืองบนขวาหงอนเขียว
                int[] xPointsPolygon10 = { 340, 407, 440, 367 };
                int[] yPointsPolygon10 = { 335, 335, 305, 305 };
                int numPointsPolygon10 = 4;
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fillPolygon(xPointsPolygon10, yPointsPolygon10, numPointsPolygon10);

                // บริเวณตาสี่เหลี่ยมเขียวซ้าย
                int[] xPointsPolygon11 = { 250, 210, 260, 300 };
                int[] yPointsPolygon11 = { 245, 280, 336, 300 };
                int numPointsPolygon11 = 4;
                g2d.setColor(Color.decode("#880015"));
                g2d.fillPolygon(xPointsPolygon11, yPointsPolygon11, numPointsPolygon11);

                // บริเวณตาสี่เหลี่ยมเขียวขวา
                int[] xPointsPolygon12 = { 350, 391, 340, 300 };
                int[] yPointsPolygon12 = { 245, 280, 336, 300 };
                int numPointsPolygon12 = 4;
                g2d.setColor(Color.decode("#880015"));
                g2d.fillPolygon(xPointsPolygon12, yPointsPolygon12, numPointsPolygon12);

                // ตาด้านซ้าย
                int leftradiusEye = 5;
                int lefteyeX = 264;
                int lefteyeY = 300;
                Ellipse2D.Double lefteye = new Ellipse2D.Double(lefteyeX - leftradiusEye, lefteyeY - leftradiusEye,
                                2 * leftradiusEye, 2 * leftradiusEye);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.draw(lefteye);
                g2d.setColor(Color.decode("#361D03"));
                g.fillOval(254, 290, 21, 21);

                // ตาด้านขวา
                int rightradiusEye = 5;
                int righteyeX = 334;
                int righteyeY = 300;
                Ellipse2D.Double righteye = new Ellipse2D.Double(righteyeX - rightradiusEye, righteyeY - rightradiusEye,
                                2 * rightradiusEye, 2 * rightradiusEye);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.draw(righteye);
                g2d.setColor(Color.decode("#361D03"));
                g.fillOval(324, 290, 21, 21);

                // สามเหลี่ยมเหลืองเล็กซ้าย ข้างรอบตาสีเหลี่ยมเขียว
                // int triangleSize1 = 20;
                int[] xtrianglePoints1 = { 210, 232, 190 };
                int[] ytrianglePoints1 = { 280, 305, 305 };
                Polygon triangle1 = new Polygon(xtrianglePoints1, ytrianglePoints1, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle1);

                // สามเหลี่ยมเหลืองเล็กขวา ข้างรอบตาสีเหลี่ยมเขียว
                // int triangleSize2 = 20;
                int[] xtrianglePoints2 = { 390, 368, 410 };
                int[] ytrianglePoints2 = { 280, 305, 305 };
                Polygon triangle2 = new Polygon(xtrianglePoints2, ytrianglePoints2, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle2);

                // เขาสีดำซ้าย
                int[] xPointsPolygon13 = { 145, 145, 190, 210 };
                int[] yPointsPolygon13 = { 212, 260, 305, 280 };
                int numPointsPolygon13 = 4;
                g2d.setColor(Color.decode("#010201"));
                g2d.fillPolygon(xPointsPolygon13, yPointsPolygon13, numPointsPolygon13);

                // เขาสีดำขวา
                int[] xPointsPolygon14 = { 455, 455, 410, 390 };
                int[] yPointsPolygon14 = { 212, 260, 305, 280 };
                int numPointsPolygon14 = 4;
                g2d.setColor(Color.decode("#010201"));
                g2d.fillPolygon(xPointsPolygon14, yPointsPolygon14, numPointsPolygon14);

                // สามเหลี่ยมเหลืองเล็กซ้าย ข้างเขา
                // int triangleSize3 = 20;
                int[] xtrianglePoints3 = { 210, 252, 176 };
                int[] ytrianglePoints3 = { 280, 245, 245 };
                Polygon triangle3 = new Polygon(xtrianglePoints3, ytrianglePoints3, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle3);

                // สามเหลี่ยมเหลืองเล็กขวา ข้างเขา
                // int triangleSize4 = 20;
                int[] xtrianglePoints4 = { 390, 348, 424 };
                int[] ytrianglePoints4 = { 280, 245, 245 };
                Polygon triangle4 = new Polygon(xtrianglePoints4, ytrianglePoints4, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle4);

                // สามเหลี่ยมเหลืองกลางหน้าผาก
                // int triangleSize5 = 20;
                int[] xtrianglePoints5 = { 300, 250, 350 };
                int[] ytrianglePoints5 = { 300, 245, 245 };
                Polygon triangle5 = new Polygon(xtrianglePoints5, ytrianglePoints5, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle5);

                // หูน้ำเงินซ้าย
                // int triangleSize6 = 20;
                int[] xtrianglePoints6 = { 176, 252, 176 };
                int[] ytrianglePoints6 = { 180, 245, 245 };
                Polygon triangle6 = new Polygon(xtrianglePoints6, ytrianglePoints6, 3);
                g2d.setColor(Color.decode("#361D03"));
                g2d.fill(triangle6);

                // หูน้ำเงินขวา
                // int triangleSize7 = 20;
                int[] xtrianglePoints7 = { 424, 348, 424 };
                int[] ytrianglePoints7 = { 180, 245, 245 };
                Polygon triangle7 = new Polygon(xtrianglePoints7, ytrianglePoints7, 3);
                g2d.setColor(Color.decode("#361D03"));
                g2d.fill(triangle7);

                // หงอนเหลืองซ้าย บนหัว
                // int triangleSize8 = 5;
                int[] xtrianglePoints8 = { 278, 300, 252 };
                int[] ytrianglePoints8 = { 220, 246, 246 };
                Polygon triangle8 = new Polygon(xtrianglePoints8, ytrianglePoints8, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle8);

                // หงอนเหลืองซ้าย บนหัว
                // int triangleSize9 = 5;
                int[] xtrianglePoints9 = { 324, 300, 348 };
                int[] ytrianglePoints9 = { 220, 246, 246 };
                Polygon triangle9 = new Polygon(xtrianglePoints9, ytrianglePoints9, 3);
                g2d.setColor(Color.decode("#D1710B"));
                g2d.fill(triangle9);

                // มือซ้าย
                g2d.setColor(Color.decode("#950017"));
                int xPoly8[] = { 170, 170, 104, 104, 80, 80 };
                int yPoly8[] = { 505, 599, 599, 555, 555, 505 };
                Polygon poly8 = new Polygon(xPoly8, yPoly8, xPoly8.length);
                g2d.fillPolygon(poly8);

                int widthHandLeft4 = 55;
                int heightHandLeft4 = 40;
                int xHandLeft4 = 80;
                int yHandLeft4 = 499 + heightHandLeft4 - 6;
                int startAngleHandLeft4 = 180;
                int arcAngleHandLeft4 = 90;
                g2d.fillArc(xHandLeft4, yHandLeft4, widthHandLeft4, heightHandLeft4, startAngleHandLeft4,
                                arcAngleHandLeft4);

                // เล็บซ้าย 2
                g2d.setColor(Color.black);
                int widthHandLeft = 60;
                int heightHandLeft = 40;
                int xHandLeft = 110;
                int yHandLeft = 505 - (heightHandLeft / 2);
                int startAngleHandLeft = 90;
                int arcAngleHandLeft = 90;
                g2d.fillArc(xHandLeft, yHandLeft, widthHandLeft, heightHandLeft, startAngleHandLeft, arcAngleHandLeft);

                // เล็บซ้าย 3
                g2d.setColor(Color.black);
                int widthHandLeft2 = 60;
                int heightHandLeft2 = 40;
                int xHandLeft2 = 140;
                int yHandLeft2 = 505 - (heightHandLeft2 / 2);
                int startAngleHandLeft2 = 90;
                int arcAngleHandLeft2 = 90;
                g2d.fillArc(xHandLeft2, yHandLeft2, widthHandLeft2, heightHandLeft2, startAngleHandLeft2,
                                arcAngleHandLeft2);

                // เล็บซ้าย 1
                g2d.setColor(Color.black);
                int widthHandLeft3 = 60;
                int heightHandLeft3 = 40;
                int xHandLeft3 = 80;
                int yHandLeft3 = 505 - (heightHandLeft3 / 2);
                int startAngleHandLeft3 = 90;
                int arcAngleHandLeft3 = 90;
                g2d.fillArc(xHandLeft3, yHandLeft3, widthHandLeft3, heightHandLeft3, startAngleHandLeft3,
                                arcAngleHandLeft3);

                // แก้วน้ำ
                g2d.setColor(Color.decode("#003C61"));
                int xPoly1[] = { 450, 436, 521, 507 };
                int yPoly1[] = { 599, 465, 465, 599 };
                Polygon poly1 = new Polygon(xPoly1, yPoly1, xPoly1.length);
                g2d.fillPolygon(poly1);

                // ฝาแก้วน้ำชั้นล่าง
                g2d.setColor(Color.white);
                int xPoly3[] = { 429, 431, 526, 528 };
                int yPoly3[] = { 465, 445, 445, 465 };
                Polygon poly3 = new Polygon(xPoly3, yPoly3, xPoly3.length);
                g2d.fillPolygon(poly3);

                // ฝาแก้วน้ำชั้นบน + ริ้วเทา
                g2d.setColor(Color.white);
                int xPoly4[] = { 439, 439, 518, 518 };
                int yPoly4[] = { 445, 431, 431, 445 };
                Polygon poly4 = new Polygon(xPoly4, yPoly4, xPoly4.length);
                g2d.fillPolygon(poly4);

                g2d.setColor(Color.decode("#DBDBDB"));
                int xPoly5[] = { 439, 439, 518, 518 };
                int yPoly5[] = { 445, 439, 439, 445 };
                Polygon poly5 = new Polygon(xPoly5, yPoly5, xPoly5.length);
                g2d.fillPolygon(poly5);

                // เล็บขวา 1
                g2d.setColor(Color.black);
                int widthHandRight = 40;
                int heightHandRight = 60;
                int xHandRight = 465;
                int yHandRight = 485 - (heightHandRight / 2);
                int startAngleHandRight = 180;
                int arcAngleHandRight = 90;
                g2d.fillArc(xHandRight, yHandRight, widthHandRight, heightHandRight, startAngleHandRight,
                                arcAngleHandRight);

                // เล็บขวา 2
                g2d.setColor(Color.black);
                int widthHandRight2 = 40;
                int heightHandRight2 = 60;
                int xHandRight2 = 465;
                int yHandRight2 = 515 - (heightHandRight2 / 2);
                int startAngleHandRight2 = 180;
                int arcAngleHandRight2 = 90;
                g2d.fillArc(xHandRight2, yHandRight2, widthHandRight2, heightHandRight2, startAngleHandRight2,
                                arcAngleHandRight2);

                // เล็บขวา 3
                g2d.setColor(Color.black);
                int widthHandRight3 = 40;
                int heightHandRight3 = 60;
                int xHandRight3 = 465;
                int yHandRight3 = 545 - (heightHandRight3 / 2);
                int startAngleHandRight3 = 180;
                int arcAngleHandRight3 = 90;
                g2d.fillArc(xHandRight3, yHandRight3, widthHandRight3, heightHandRight3, startAngleHandRight3,
                                arcAngleHandRight3);

                // มือขวา
                g2d.setColor(Color.decode("#950017"));
                int xPoly2[] = { 485, 510, 510, 485 };
                int yPoly2[] = { 485, 485, 575, 575 };
                Polygon poly2 = new Polygon(xPoly2, yPoly2, xPoly2.length);
                g2d.fillPolygon(poly2);

                int widthHandRight4 = 90;
                int heightHandRight4 = 90;
                int xHandRight4 = 465;
                int yHandRight4 = 485;
                int startAngleHandRight4 = 270;
                int arcAngleHandRight4 = 180;
                g2d.fillArc(xHandRight4, yHandRight4, widthHandRight4, heightHandRight4, startAngleHandRight4,
                                arcAngleHandRight4);

                // ข้าวปั้น
                g2d.setColor(Color.white);
                g2d.fillOval(115, 401, 22, 21);
                int xPoly9[] = { 70, 180, 136, 116 };
                int yPoly9[] = { 473, 473, 407, 407 };
                Polygon poly9 = new Polygon(xPoly9, yPoly9, xPoly9.length);
                g2d.fillPolygon(poly9);

                g2d.setColor(Color.decode("#1C7360"));
                g2d.fillOval(160, 466, 20, 20);
                int xPoly7[] = { 111, 171, 180, 152 };
                int yPoly7[] = { 486, 486, 473, 431 };
                Polygon poly7 = new Polygon(xPoly7, yPoly7, xPoly7.length);
                g2d.fillPolygon(poly7);

                g2d.setColor(Color.decode("#115958"));
                g2d.fillOval(70, 466, 20, 20);
                int xPoly6[] = { 70, 80, 141, 99 };
                int yPoly6[] = { 473, 486, 486, 431 };
                Polygon poly6 = new Polygon(xPoly6, yPoly6, xPoly6.length);
                g2d.fillPolygon(poly6);

                // ริ้วข้าวปั้น เหลือง #175E4E
                g2d.setColor(Color.decode("#0E4948"));
                int xRect3 = 89;
                int yRect3 = 460;
                int widthRect3 = 40;
                int heightRect3 = 5;
                int arcWidth3 = 6;
                int arcHeight3 = 6;
                RoundRectangle2D rect6 = new RoundRectangle2D.Double(xRect3, yRect3, widthRect3, heightRect3, arcWidth3,
                                arcHeight3);
                AffineTransform oldTransform = g2d.getTransform();
                g2d.rotate(Math.toRadians(54), xRect3 + widthRect3 / 2.0, yRect3 + heightRect3 / 2.0);
                g2d.fill(rect6);
                g2d.setTransform(oldTransform);

                int xRect7 = 83;
                int yRect7 = 465;
                int widthRect7 = 30;
                int heightRect7 = 5;
                int arcWidth7 = 6;
                int arcHeight7 = 6;
                RoundRectangle2D rect7 = new RoundRectangle2D.Double(xRect7, yRect7, widthRect7, heightRect7, arcWidth7,
                                arcHeight7);
                g2d.rotate(Math.toRadians(54), xRect7 + widthRect7 / 2.0, yRect7 + heightRect7 / 2.0);
                g2d.fill(rect7);
                g2d.setTransform(oldTransform);

                int xRect8 = 78;
                int yRect8 = 470;
                int widthRect8 = 17;
                int heightRect8 = 5;
                int arcWidth8 = 6;
                int arcHeight8 = 6;
                RoundRectangle2D rect8 = new RoundRectangle2D.Double(xRect8, yRect8, widthRect8, heightRect8, arcWidth8,
                                arcHeight8);
                g2d.rotate(Math.toRadians(54), xRect8 + widthRect8 / 2.0, yRect8 + heightRect8 / 2.0);
                g2d.fill(rect8);
                g2d.setTransform(oldTransform);

                // ริ้วข้าวปั้น ส้ม
                g2d.setColor(Color.decode("#175E4E"));
                int xRect = 130;
                int yRect = 455;
                int widthRect = 30;
                int heightRect = 5;
                int arcWidth0 = 6;
                int arcHeight0 = 6;
                RoundRectangle2D rect = new RoundRectangle2D.Double(xRect, yRect, widthRect, heightRect, arcWidth0,
                                arcHeight0);
                g2d.rotate(Math.toRadians(133), xRect + widthRect / 2.0, yRect + heightRect / 2.0);
                g2d.fill(rect);
                g2d.setTransform(oldTransform);

                int xRect0 = 140;
                int yRect0 = 464;
                int widthRect0 = 25;
                int heightRect0 = 5;
                int arcWidth9 = 6;
                int arcHeight9 = 6;
                RoundRectangle2D rect0 = new RoundRectangle2D.Double(xRect0, yRect0, widthRect0, heightRect0, arcWidth9,
                                arcHeight9);
                g2d.rotate(Math.toRadians(133), xRect0 + widthRect0 / 2.0, yRect0 + heightRect0 / 2.0);
                g2d.fill(rect0);
                g2d.setTransform(oldTransform);

                int xRecti = 151;
                int yRecti = 471;
                int widthRecti = 20;
                int heightRecti = 5;
                int arcWidthi = 6;
                int arcHeighti = 6;
                RoundRectangle2D recti = new RoundRectangle2D.Double(xRecti, yRecti, widthRecti, heightRecti, arcWidthi,
                                arcHeighti);
                g2d.rotate(Math.toRadians(133), xRecti + widthRecti / 2.0, yRecti + heightRecti / 2.0);
                g2d.fill(recti);
                g2d.setTransform(oldTransform);

                // HAPPY NEWYEAR 2024 สลับสี
                g2d.setFont(new Font("Impact", Font.BOLD, 72));
                g2d.setColor(Color.decode("#361D03"));
                g2d.drawString("HAPPY", 85, 115);

                g2d.setFont(new Font("Impact", Font.BOLD, 120));
                g2d.setColor(Color.decode("#922D05"));
                g2d.drawString("   " + String.valueOf(0) + "   " + String.valueOf(4), 285, 155);

                g2d.setColor(Color.decode("#361D03"));
                g2d.drawString(String.valueOf(2), 285, 155);
                g2d.drawString(String.valueOf(2), 415, 155);

                g2d.setFont(new Font("Impact", Font.BOLD, 47));
                g2d.setColor(Color.decode("#922D05"));
                g2d.drawString("NEW YEAR", 85, 155);
        }

        private void bresenhamLine(Graphics g, int x1, int y1, int x2, int y2) {
                int dx = Math.abs(x2 - x1);
                int dy = Math.abs(y2 - y1);
                int sx = (x1 < x2) ? 1 : -1;
                int sy = (y1 < y2) ? 1 : -1;
                boolean isSwap = false;
                if (dy > dx) {
                        int temp = dx;
                        dx = dy;
                        dy = temp;
                        isSwap = true;
                }
                float D = 2 * dy - dx;
                int x = x1;
                int y = y1;
                for (float i = 1; i <= dx; i++) {
                        plot(g, x, y);
                        if (D >= 0) {
                                if (isSwap)
                                        x += sx;
                                else
                                        y += sy;
                                D -= 2 * dx;
                        }
                        if (isSwap)
                                y += sy;
                        else
                                x += sx;
                        D += 2 * dy;
                }
        }

        private void plot(Graphics g, int x, int y) {
                g.fillRect(x, y, 3, 3);
        }
}