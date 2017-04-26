

public class CalcStub extends Calc {

	public CalcStub() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Injection de dépendance de l'engine
	 * @param pEngine
	 */
	
	public void setEngine(Engine pEngine)
	{
		_engine = pEngine;
	}

}
