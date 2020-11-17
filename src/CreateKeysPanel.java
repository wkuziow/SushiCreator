import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.Container;

public class CreateKeysPanel extends JPanel{

    public void createKeysPanel(List<EIngridients> ingridientsList) throws IOException {
        JPanel keysPanel = new JPanel();
        keysPanel.setLayout(new GridLayout(3, 4));
        File[] graphs = new File("Skladniki/").listFiles();

        for (File f : graphs) {
            JLabel key = new JLabel();

            key.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    ingridientsList.add(EIngridients.valueOf(f.getName().substring(0, f.getName().length() - 4)));
                    repaint();
                }
            });

            key.setIcon(new ImageIcon(ImageIO.read(f)));
            keysPanel.add(key);
        }
        keysPanel.setBounds(0, 170, 800, 600);
        add(keysPanel);

    }
}
