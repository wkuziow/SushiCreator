import javax.swing.*;
import java.awt.*;


public class Main extends JPanel{

    public Dimension getPreferredSize() {
        return new Dimension(770, 770);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("Kreator Sushi");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        window.add(new Main());

        window.pack();

    }
}
