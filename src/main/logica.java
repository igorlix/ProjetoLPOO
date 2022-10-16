package main;


import javax.swing.*;

import controle.controle;
import controle.movimento;
import modelos.blocos;
import modelos.tabuleiro;


import java.awt.*;


public class logica extends JPanel {

    public static int PANEL_WIDTH = 600;
    public static int PANEL_HEIGHT = 600;
    private final tabuleiro tabuleiro;

    static {
        PANEL_WIDTH += blocos.WIDTH;
        PANEL_HEIGHT += blocos.HEIGHT;
    }

    public logica(int difficulty) {
        tabuleiro = new tabuleiro(difficulty);
        loadPreferences();
        addActionListeners();

    }

    final void loadPreferences() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.gray);
        this.setFocusable(true);
        this.setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        drawGrid(g);
        loadbloco();
    }

    private void drawGrid(Graphics g) {

        g.setColor(Color.gray);
        Graphics2D g2 = (Graphics2D) g;

        for (int i = 0; i <= tabuleiro.getN(); i++) {
            g2.drawLine(blocos.WIDTH / 2 + i * blocos.WIDTH, blocos.HEIGHT / 2, blocos.WIDTH / 2 + i * blocos.WIDTH, PANEL_HEIGHT - blocos.HEIGHT / 2);
        }

        for (int i = 0; i <= tabuleiro.getN(); i++) {
            g2.drawLine(blocos.WIDTH / 2, blocos.HEIGHT / 2 + blocos.HEIGHT * i, PANEL_WIDTH - blocos.WIDTH / 2, blocos.WIDTH / 2 + blocos.WIDTH * i);
        }
    }

    private void addActionListeners() {
        for (blocos[] bloco : tabuleiro.getBoard()) {
            for (blocos blocos : bloco) {
                blocos.addActionListener(e -> {
                    if (moveblocos(blocos))
                        repaint();
                    if (checkWinCondition()){
                      
                        JOptionPane.showMessageDialog(null, "Vençeu", "Parabéns", JOptionPane.INFORMATION_MESSAGE);
                    }
                });
            }
        }
    }

    private void loadbloco() {

        for (int i = 0; i < tabuleiro.getN(); i++) {
            for (int j = 0; j < tabuleiro.getN(); j++) {
                blocos blocos = tabuleiro.getBoard()[i][j];
                controle.botoes(this,
                        blocos,
                        blocos.getValue(),
                        !blocos.isEmptyBlocos(),
                        blocos.getX(),
                        blocos.getY(),
                        modelos.blocos.WIDTH * 9 / 10,
                        modelos.blocos.HEIGHT * 9 / 10);
            }
        }
    }

    public void debug(blocos blocos) {

        int x1 = (modelos.blocos.HEIGHT / 2 + blocos.getY()) / modelos.blocos.HEIGHT - 1;
        int y1 = (blocos.getX() + modelos.blocos.WIDTH / 2) / modelos.blocos.WIDTH - 1;

        System.out.println("[" + x1 + "][" + y1 + "]" + " with value " + tabuleiro.getBoard()[x1][y1].getValue() + " ==? " +
                "blocos at position " + "(" + blocos.getX() + "," + blocos.getY() + ")" + " with value " + blocos.getValue());

    }

    public boolean moveblocos(blocos blocos) {

        if (!hasNeighbourEmptyBlocos(blocos)) {
            System.out.println(blocos.getValue() + "Nao há um espaço vazio próximo");
            return false;
        }

        blocos EmptyBlocos = determineEmptyBlocos();

       movimento.movimentoBlocos(blocos, EmptyBlocos, this);

        swapWith(blocos);

        return true;
    }

    public blocos determineEmptyBlocos() {
        for (blocos[] bloco : tabuleiro.getBoard()) {
            for (blocos blocos : bloco) {
                if (blocos.isEmptyBlocos())
                    return blocos;
            }
        }
        return null;
    }

    public void swapWith(blocos clickedblocos) {
        blocos EmptyBlocos = determineEmptyBlocos();

        int x1 = (blocos.HEIGHT / 2 + clickedblocos.getY()) / blocos.HEIGHT - 1;
        int y1 = (clickedblocos.getX() + blocos.WIDTH / 2) / blocos.HEIGHT - 1;


        int x2 = (blocos.HEIGHT / 2 + EmptyBlocos.getY()) / blocos.HEIGHT - 1;
        int y2 = (EmptyBlocos.getX() + blocos.WIDTH / 2) / blocos.HEIGHT - 1;

        blocos temp = tabuleiro.getBoard()[x1][y1];
        tabuleiro.getBoard()[x1][y1] = tabuleiro.getBoard()[x2][y2];
        tabuleiro.getBoard()[x2][y2] = temp;

    }

    public boolean hasNeighbourEmptyBlocos(blocos blocos) {

        int x1 = (modelos.blocos.HEIGHT / 2 + blocos.getY()) / modelos.blocos.HEIGHT - 1;
        int y1 = (blocos.getX() + modelos.blocos.WIDTH / 2) / modelos.blocos.WIDTH - 1;


        blocos[][] board = tabuleiro.getBoard();

        try {
            if (board[x1][y1 + 1].isEmptyBlocos()) 
                return true;
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        try {
            if (board[x1][y1 - 1].isEmptyBlocos()) 
                return true;
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[x1 - 1][y1].isEmptyBlocos()) 
                return true;

        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
        try {
            if (board[x1 + 1][y1].isEmptyBlocos())
                return true;

        } catch (ArrayIndexOutOfBoundsException ignored) {
        }

        return false;
    }


    public boolean checkWinCondition() {
        StringBuilder currentPattern = new StringBuilder();
        for (blocos[] bloco : tabuleiro.getBoard()) {
            for (blocos blocos : bloco) {
                currentPattern.append(blocos.getValue());
            }
        }
        return currentPattern.toString().equals(generateWinPattern());
    }

    private String generateWinPattern() {
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < tabuleiro.getN() * tabuleiro.getN(); i++) {
            pattern.append(i + 1);
        }
        return pattern.toString();
    }

}
