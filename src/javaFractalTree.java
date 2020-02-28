import javax.swing.*;
import java.awt.*;

public class javaFractalTree extends JFrame {

    public static void main(String[] args) {
        javaFractalTree treeMain = new javaFractalTree();
    }

    public javaFractalTree(){
        setupComponents();
    }

    public void setupComponents(){
        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        JPanel backPanel = new JPanel();
        backPanel.setBackground(Color.black);

        JLabel titleLabel = new JLabel("Fractal Tree");
        titleLabel.setForeground(Color.white);
        backPanel.add(titleLabel);


        this.add(backPanel);
        this.setVisible(true);
    }
}
