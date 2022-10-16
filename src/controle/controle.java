package controle;

import javax.swing.*;
import java.awt.*;


public class controle {
//Define os botoes
    public static void preferencias(JButton button, Color fColor, Color bColor, Font font) {
        button.setForeground(fColor);
        button.setBackground(bColor);
        button.setFont(font);
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public static void botoes(JPanel parent, JButton button, String text, boolean visible, int x, int y, int width, int height) {
        button.setText(text);
        button.setBounds(x, y, width, height);
        button.setVisible(visible);
        parent.add(button);

    }

} 