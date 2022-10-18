package main;

import javax.swing.SwingUtilities;

import interfaces.inicio;

public class rodar
{
	public static void main(String[] args) {
        newOptionsScreen();

    }
    

    public static void newOptionsScreen() {
        SwingUtilities.invokeLater(() -> new inicio().setVisible(true));
    }

}