import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.StringTokenizer;

public class javaFractalTree extends JFrame {

    public static void main(String[] args) {
        javaFractalTree treeMain = new javaFractalTree();
    }

    public javaFractalTree(){
        setupComponents();
    }

    public void setupComponents(){
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Fractal Tree");
        titleLabel.setForeground(Color.white);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(Color.black);

        titlePanel.add(titleLabel, BorderLayout.CENTER);
        
        this.getContentPane().setBackground(Color.black);
        this.add(new DrawingTool(), BorderLayout.CENTER);
        this.add(titlePanel, BorderLayout.NORTH);
        this.setVisible(true);
    }

    private class DrawingTool extends JComponent{
        public void paint(Graphics g){
            Graphics2D graphics = (Graphics2D) g;
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

            Shape line = new Line2D.Double(400,600,400,350);
            graphics.setColor(Color.GREEN);
            graphics.setStroke(new BasicStroke(7));
            graphics.draw(line);
        }
    }
}

