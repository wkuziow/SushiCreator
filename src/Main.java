import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Main extends JPanel {


    private int points = 0;
    private int lifes = 5;
    private List<EIngridients> ingridientsList;
    private JLabel text;
    private ESushi randomised;

    public Main() {

        try {
            this.ingridientsList = new ArrayList<EIngridients>();
            setBackground(Color.white);
            setLayout(null);
            createKeysPanel();
            createTextPanel();
            createChechKey();
            createXKey();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createXKey() throws IOException {
        JLabel key = new JLabel();
        key.setIcon(new ImageIcon(ImageIO.read(new File("x.png"))));
        key.setBounds(580, 100, 100, 50);

        key.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ingridientsList.clear();
                repaint();
            }
        });

        add(key);
    }

    private void createChechKey() throws IOException {
        JLabel key = new JLabel();
        key.setIcon(new ImageIcon(ImageIO.read(new File("check.png"))));
        key.setBounds(530, 50, 200, 50);
        key.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Collections.sort(ingridientsList);
                Collections.sort(randomised.getIngridientsList());

                if (ingridientsList.equals(randomised.getIngridientsList())) {
                    points++;
                    ingridientsList.clear();
                    randomize();
                } else {
                    lifes--;
                    ingridientsList.clear();
                }
                repaint();
                isItOver();
            }

            private void isItOver() {
                if (lifes < 1) {
                    JOptionPane.showMessageDialog(null, "Twój wynik: " + points);
                    lifes = 5;
                    randomize();
                    points = 0;
                    repaint();
                }
            }
        });
        add(key);
    }

    private void createTextPanel() {
        text = new JLabel();
        text.setBounds(100, 35, 400, 80);
        Font font = new Font("Arial", Font.BOLD, 25);
        randomize();
        text.setFont(font);
        add(text);
    }

    private void randomize() {
        int index = (int) (Math.random() * ESushi.values().length);
        randomised = ESushi.values()[index];
        text.setText(randomised.getName());

    }

    private void createKeysPanel() throws IOException {
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        File heart = new File("serce.png");
        for (int i = 0; i < lifes; i++) {
            try {
                g.drawImage(ImageIO.read(heart), (i * 30) + (i + 1), 10, 20, 20, null);
            } catch (Exception e) {
            }
        }
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Punkty: " + points, 570, 30);
        for (int i = 0; i < ingridientsList.size(); i++) {
            try {
                g.drawImage(ImageIO.read(new File("Skladniki/" + ingridientsList.get(i) + ".png")),
                        50 * i, 120, 50, 50, null);
            } catch (Exception e) {
            }

        }
    }

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
