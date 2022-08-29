package JogoLPOO.interfaces;
import javax.swing.JFrame;

public class menus extends JFrame
{
	public menus()
	{
		setTitle("Puzzle-N");
		setSize(1024,728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
	}
	public static void main(String[] args)
	{
		new menus();
	}
	
}
