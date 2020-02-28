import javax.swing.*;
import java.awt.*;

public class javaFractalTree extends JFrame {

    private int angleStep = 46;

    public static void main(String[] args) {
        javaFractalTree treeMain = new javaFractalTree();
    }

    public javaFractalTree() {
        setupComponents();
    }

    public void setupComponents() {
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel titleLabel = new JLabel("Fractal Tree");
        titleLabel.setForeground(Color.white);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.black);

        titlePanel.add(titleLabel, BorderLayout.CENTER);

        this.getContentPane().setBackground(Color.black);
        this.add(titlePanel, BorderLayout.NORTH);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponents(g);
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        startDrawing(g, this.getWidth(), this.getHeight());
    }

    private void startDrawing(Graphics g, int width, int height) {
        Point init = new Point(width/2 ,height);
        g.setColor(Color.WHITE);
        drawTree(g, init, -90,16, 12);
    }

    private void drawTree(Graphics g, Point p, double angle, double length, int times) {
        if (times == 0){
            return;
        }
        double nextLength = length*.67;

        //left branch
        Point nextPointL = getNextPoint(p, angle, length);
        drawBranch(g, p, nextPointL, length);
        drawTree(g, nextPointL, angle - angleStep, nextLength, times-1);

        //right branch
        Point nextPointR = getNextPoint(p, angle, length);
        drawBranch(g, p, nextPointR, length);
        drawTree(g, nextPointR, angle + angleStep, nextLength, times-1);
    }

    private Point getNextPoint(Point p, double angle, double length){
        Point nextPoint;
        double x1 = p.getX(), y1 = p.getY();
        double x2 = x1 + Math.cos(Math.toRadians(angle)) * length * 10;
        double y2 = y1 + Math.sin(Math.toRadians(angle)) * length * 10;
        nextPoint = new Point((int) (x2), (int) (y2));

        return nextPoint;
    }

    private void drawBranch(Graphics g, Point p, Point p2, double length){
        int x1 = (int) p.getX(), y1 = (int) p.getY(), x2 = (int) p2.getX(), y2 = (int) p2.getY();
        g.drawLine(x1, y1, x2, y2);
    }
}

