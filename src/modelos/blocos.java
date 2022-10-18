package modelos;
import javax.swing.*;

import controle.controle;
import interfaces.menus;
import main.logica;

import java.awt.*;

public class blocos extends JButton {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int WIDTH = logica.PANEL_WIDTH / menus.BOARD_SIZE;
    public static int HEIGHT = logica.PANEL_HEIGHT / menus.BOARD_SIZE;

    private int x, y;
    private final boolean EmptyBlocos;
    private final String value;


    public blocos(int x, int y, String value, Boolean EmptyBlocos) {
        super();
        this.x = x;
        this.y = y;
        this.value = value;
        this.EmptyBlocos = EmptyBlocos;
        initBlocos();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public boolean isEmptyBlocos() {
        return EmptyBlocos;
    }

    private void initBlocos() {
        controle.preferencias(this,
                Color.black,
                Color.white,
                new Font("SansSerif", Font.BOLD, blocos.WIDTH / 4));
    }


}