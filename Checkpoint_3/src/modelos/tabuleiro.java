package modelos;

import javax.swing.JButton;
import javax.swing.JFrame;

public abstract class tabuleiro extends JFrame 
{
	private int tamanho;
	private int n;
	boolean x0 = false;
	JButton[] bt = new JButton [9];
	//formação do tabuleiro.
	public abstract void tabuleiro () 
	{
		//aba do tabuleiro.
		setVisible (true);
		//nome que ficará visivel na aba, indicando o nome do jogo.
		setTitle ("Puzzle-n");
		setLayout (null);
		//dimensão da aba
		setBounds (350,100,700,500);
		int cont = 0;
		for (int i=0 ; i<3 ; i++) 
		{
			for (int j=0; j<3; j++) 
			{
				bt[cont] = new JButton();
				add (bt[cont]);
				//dimensão da do quadradinho do puzzle.
				bt[cont].setBounds((100*i)+50,(100*j)+50,80,80);
				
				
			}
		}
		private boolean isMovimentoValido(Bloco a) throws Exception 
		{
			boolean check = (a != null && a.getVerdade());
			if (!check)
				throw new MovimentoInvalido();
			return check;
		}
		try {
			if (x < 0 || y < 0)
				throw new MovimentoInvalido();

			switch () {//contnuar para cada caso
	}
	
	
	//Teste no arquivo Main //
	
}