package Lab3;
import javax.swing.*;
import java.awt.*;

public class ColorCircle extends JFrame {

    private Color circleColor = null;               // null = circle is clear (no fill)
    private JTextField output = new JTextField(10); // text output field

    // Panel that draws the circle
    private JPanel circlePanel = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (circleColor != null) {
                g.setColor(circleColor);
                g.fillOval(50, 30, 200, 200);
            }
            g.setColor(Color.BLACK);
            g.drawOval(50, 30, 200, 200);
        }
    };

    public ColorCircle() {
        setTitle("Lab 3 - GUI");

        String[] names = {"Select a color", "Red", "Blue", "Green"};
        Color[] colors = {null, Color.RED, Color.BLUE, Color.GREEN};

        // Dropdown entry box
        JComboBox<String> colorBox = new JComboBox<>(names);
        output.setEditable(false);

        // When a color is selected, fill the circle and show its name
        colorBox.addActionListener(e -> {
            int i = colorBox.getSelectedIndex();
            circleColor = colors[i];
            output.setText(i == 0 ? "" : names[i]);
            circlePanel.repaint();
        });

        JPanel top = new JPanel();
        top.add(new JLabel("Choose color:"));
        top.add(colorBox);

        JPanel bottom = new JPanel();
        bottom.add(new JLabel("Selected color:"));
        bottom.add(output);

        circlePanel.setPreferredSize(new Dimension(300, 260));

        add(top, BorderLayout.NORTH);
        add(circlePanel, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ColorCircle().setVisible(true));
    }
}