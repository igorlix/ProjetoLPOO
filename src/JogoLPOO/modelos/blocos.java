package JogoLPOO.modelos;
public class blocos 
{
	private int valor;
	private boolean verdade;


	public blocos(int numero) 
	{
		this.verdade = (numero == 0) ? true : false;
	}

	public int getValor() 
	{
		return valor;
	}

	public boolean getVerdade() 
	{ 
		return verdade;
	}

	public void setValor(int valor) 
	{
		   if(valor > 0 && valor < 10) 
		   {
		    this.valor = valor;
		   }
		   
	}

	public void setVerdade(boolean verdade) 
	{
			this.verdade = verdade;
	}
}
