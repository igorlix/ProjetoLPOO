package JogoLPOO.interfaces;

import JogoLPOO.modelos.Tabuleiro;

public class inicio extends JFrame 
{
		private Tabuleiro tabuleiro;
		private Jogador jogador;

		public void IniciaJogo() {
			String JogadorNome = JOptionPane.showInputDialog("Digite seu nome:");
			jogador = new Jogador(JogadorNome);
			tabuleiro = new Tabuleiro();
		}
}
