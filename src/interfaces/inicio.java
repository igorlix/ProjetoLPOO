package interfaces;
import javax.swing.*;

import controle.controle;
import controle.movimento;
import main.logica;
import modelos.blocos;

import java.awt.*;
import java.util.Iterator;

public class inicio extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static boolean botaoAtivado = false;
    JPanel painel;
    private final ButtonGroup dificuldades;
    JButton iniciar;
    private JButton facil;
    private JButton medio;
    private JButton dificil;
    private JButton maluco;

    public inicio() {
        dificuldades = new ButtonGroup();
        painel = new JPanel();
        this.add(painel);

        loadPanel();
        loadPreferencias();

        instantiateAllButtons();
        loadAllButtons();

        controle.botoes(painel, iniciar, "Iniciar", true, 250, 600, 310, 50);
        controle.preferencias(iniciar, Color.white, Color.black, new Font("SansSerif", Font.BOLD, 25));

        iniciar.addActionListener(e -> {
            try {
                jogo(botaoselecionado().getText());
            } catch (NullPointerException x) {
                JOptionPane.showMessageDialog(null,
                        "Erro!",
                        "Escolha uma dificuldade", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    final void loadPanel() {

        painel.setPreferredSize(new Dimension(800, 800));
        painel.setBackground(Color.ORANGE);
        painel.setFocusable(true);
        painel.setLayout(null);
      //  background = new JLabel("", new ImageIcon("imagens/background.gif"),JLabel.CENTER);
        //background.setBounds(0,0,width,height);
     //  background.setLayout(background);
    }

    public void loadButton(JButton botao, String texto, int x, int y, int largura, int altura) {
        dificuldades.add(botao);
        botao.setBorder(BorderFactory.createRaisedBevelBorder());
        controle.preferencias(botao, Color.white, Color.DARK_GRAY, new Font("SansSerif", Font.BOLD, 25));
        controle.botoes(painel, botao, texto, true, x, y, largura, altura);

        botao.addActionListener(e -> {
            botao.setBorderPainted(true);
            botao.setBackground(Color.red);
            limparselecao(botao);
        });

    }

    public int selecionado() {
        int count = 0;
        for (Iterator<AbstractButton> it = dificuldades.getElements().asIterator(); it.hasNext(); ) {

            AbstractButton botao = it.next();
            if (botao.getBackground() == Color.red)
                count++;
        }
        return count;
    }

    final void loadPreferencias() {

        this.setTitle("In??cio");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public AbstractButton botaoselecionado() {
        for (Iterator<AbstractButton> it = dificuldades.getElements().asIterator(); it.hasNext(); ) {

            AbstractButton botao = it.next();
            if (botao.getBackground() == Color.red)
                return botao;
        }
        return null;
    }

    private void jogo(String dificuldades) {
        switch (dificuldades) {
            case "F??cil":
                this.dispose();
                novoJogo(2);
                break;
            case "M??dio":
                this.dispose();
                novoJogo(3);
                break;
            case "Dif??cil":
                this.dispose();
                novoJogo(4);
                break;
            case "Puzzle-N Maluco":
                this.dispose();
                novoJogo(5);
                break;
        }
    }

    public void novoJogo(int dificuldade) {

        if (botaoAtivado) {
        	ajusteTamanho(dificuldade);
        }

        menus.BOARD_SIZE = dificuldade; // define o tamanho do tabuleiro

        SwingUtilities.invokeLater(() -> new menus(dificuldade).setVisible(true));
    }

    public static void ajusteTamanho(int dificuldade) {
        //ajusta a quantidade de blocos dependendo da dificuldade
        logica.PANEL_WIDTH -= blocos.WIDTH;
        logica.PANEL_HEIGHT -= blocos.HEIGHT;
        blocos.WIDTH = logica.PANEL_WIDTH / menus.BOARD_SIZE;
        blocos.HEIGHT = logica.PANEL_HEIGHT / menus.BOARD_SIZE;
       movimento.larg = blocos.WIDTH;
        logica.PANEL_WIDTH += logica.PANEL_WIDTH / dificuldade;
        logica.PANEL_HEIGHT += logica.PANEL_HEIGHT / dificuldade;
    }

    private void limparSelecionado(AbstractButton exceptSelecionado) {
        for (Iterator<AbstractButton> it = dificuldades.getElements().asIterator(); it.hasNext(); ) {

            AbstractButton botao = it.next();
            if (!botao.equals(exceptSelecionado))
                botao.setBackground(Color.DARK_GRAY);
        }
    }

    private void limparselecao(AbstractButton botao) {
        if (selecionado() > 1)
        	limparSelecionado(botao);
    }
          //posicao dos botoes
    private void loadAllButtons() {
        loadButton(facil, "F??cil", 250, 200, 310, 50);
        loadButton(medio, "M??dio", 250, 300, 310, 50);
        loadButton(dificil, "Dif??cil", 250, 400, 310, 50);
        loadButton(maluco, "Puzzle-N Maluco", 250, 500, 310, 50);
    }

    private void instantiateAllButtons() {
        facil = new JButton();
        medio = new JButton();
        dificil = new JButton();
        maluco = new JButton();
        iniciar = new JButton();

    }

}