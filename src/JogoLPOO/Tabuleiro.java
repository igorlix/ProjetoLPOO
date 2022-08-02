package JogoLPOO;
import javax.swing.*;
     //OBS: até hoje, 01/08, não conseguimos incluir a biblioteca java.swing*, problema será resolvido com a monitoria.
public class Tabuleiro extends JFrame {
	private int tamanho;
	private int n;
	boolean x0 = false;
	Jbutton[] bt = new Jbutton [9];
	//formação do tabuleiro.
	public Tabuleiro () {
		//aba do tabuleiro.
		setVisible (true);
		//nome que ficará visivel na aba, indicando o nome do jogo.
		setTitle ("Puzzle-n");
		setLayout (null);
		//dimensão da aba
		setBounds (350,100,700,500);
		int cont = 0;
		for (int i=0 ; i<3 ; i++) {
			for (int j=0; j<3; j++) {
				bt[cont] = new JButton();
				add (bt[cont]);
				//dimensão da do quadradinho do puzzle.
				bt[cont].setBounds((100*i)+50,(100*j)+50,80,80);
				
				
			}
		}
	
	

	
		
	}
}