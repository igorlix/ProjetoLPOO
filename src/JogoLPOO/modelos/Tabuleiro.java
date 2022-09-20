package JogoLPOO.modelos;
import javax.swing;
    
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
			
public void embaralhar() {
	int[] bnum = new int [9];
	int i, j , verificadorDeLinhas;
	boolean flag = false;
	
	i = 1 ;
	
	do {
		Random rnd =  new Random () ;
		verificadorDeLinhas = rnd.nextInt ((8)+ 1);
		for (j=1 ; j <= i; j++) {
			if (bnum [j] == verificadorDeLinhas) {
				flag = true;
				break;	
			}
			if (flag == true) {
				flag = false;	
			}
			else {
				bnum[i] = verificadorDeLinhas;
				i = i + 1;
				
			}
		}
		while (i<=8);
			jbtnNum1.setText(integer.toString(bnum[1]));
			jbtnNum2.setText(integer.toString(bnum[2]));
			jbtnNum3.setText(integer.toString(bnum[3]));
			jbtnNum4.setText(integer.toString(bnum[4]));
			jbtnNum5.setText(integer.toString(bnum[5]));
			jbtnNum6.setText(integer.toString(bnum[6]));
			jbtnNum7.setText(integer.toString(bnum[7]));
			jbtnNum8.setText(integer.toString(bnum[8]));
			jbtnNum9.setText("");
	}
}
			
			
			
			
		}
		
	
	

	
		
	}
}
