

public class Calc {

	protected Engine _engine;
	protected boolean _etat;
	public Calc() {
		_etat = true;
	}

	public void AppuieTouche(String pCar)
	{
		if (_etat)
		{
			_etat = _engine.setCarac(pCar);
		}
	}
	
	public String lireAffichage()
	{
		if (_etat)
		{
			return _engine.getAffichage();
		}
		else
		{
			return "ERREUR";
		}
	}
	
	public void reset()
	{
		_etat = true;
	}
	
}
