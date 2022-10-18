package interfaces;

import javax.swing.*;

import controle.controle;
import main.logica;

import java.awt.*;

public class menus extends JFrame {

    public static int BOARD_SIZE;

    logica logica;
    JButton botaoReiniciar;
    JButton botaoSair;
    JButton botaoMenu;

    private final int dificuldade;

    public menus(int dificuldade) {
        this.dificuldade = dificuldade;
        novoJogo(dificuldade);
        loadPreferencias();
    }
    final void loadPreferencias() {

        this.setTitle("Puzzle-N");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);

    }

    public void novoJogo(int dificuldade) {

        logica = new logica(dificuldade);
        this.add(logica);

        botaoReiniciar = new JButton();
        botaoSair = new JButton();
        botaoMenu = new JButton();


        loadInGameButton(botaoReiniciar, "Reiniciar", main.logica.PANEL_WIDTH - 330, main.logica.PANEL_HEIGHT - 50, 190, false);
        loadInGameButton(botaoSair, "Sair", main.logica.PANEL_WIDTH - 130, main.logica.PANEL_HEIGHT - 50, 120, false);
        loadInGameButton(botaoMenu, "Menu", 0, main.logica.PANEL_HEIGHT - 50, 200, true);

        botaoReiniciar.addActionListener(e -> restart());
        botaoSair.addActionListener(e -> System.exit(0));
        botaoMenu.addActionListener(e -> {
            inicio.botaoAtivado = true;
            this.dispose();
            inicio.newOptionsScreen();
        });

    }

    public void restart() {
        this.remove(logica);
        novoJogo(dificuldade);
        SwingUtilities.updateComponentTreeUI(this);
    }

    private void loadInGameButton(JButton botao, String texto, int x, int y, int largura, boolean voltar) {
        Font inGameButtonFont = voltar ? new Font("SansSerif", Font.PLAIN, 25) : new Font("SansSerif", Font.PLAIN, 25);
        controle.preferencias(botao, Color.white, Color.DARK_GRAY, inGameButtonFont);
        controle.botoes(logica, botao, texto, true, x, y, largura, 50);

    }


}