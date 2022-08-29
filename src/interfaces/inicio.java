package interfaces;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class inicio extends JFrame 
{
		private Tabuleiro tabuleiro;
		private Jogador jogador;

		public void IniciaJogo() 
		{
			String JogadorNome = JOptionPane.showInputDialog("Digite seu nome:");
			jogador = new Jogador(JogadorNome);
			tabuleiro = new Tabuleiro();
		}
}
