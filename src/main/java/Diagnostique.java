

import java.util.ArrayList;
import java.util.List;

public class Diagnostique {

	protected Boolean _etat=false;
	protected List<DiagBuses> _LstBuses;
	private Acquisition  _Acquisition;
	
	public Diagnostique() {
		// TODO Auto-generated constructor stub
	}

	public void LecturePressionBuses(float pPression)
	{
		// Appel à la classe d'acquisition
		
		for (int i =0; i<_LstBuses.size(); i++)
		{
			_LstBuses.get(i).set_PressionLue(_Acquisition.getPressionLue(i));
		}
		//calcul de l'etat
		int nbBuseEnDefaut = 0;
		for (int i =0; i<_LstBuses.size(); i++)
		{
			if (( _LstBuses.get(i).get_PressionLue())<(pPression *.95) ||
				( _LstBuses.get(i).get_PressionLue())>(pPression *1.05))
				{
					nbBuseEnDefaut++;
				}
		}
		
		if (nbBuseEnDefaut > _LstBuses.size()*0.1)
		{
			_etat = false;
		}
		else
		{
			_etat = true;
		}
		
	}//LecturePressionBuses
	
	public void setNbBuses(Integer pNbBuses)
	{
		_LstBuses = new ArrayList<DiagBuses>();
		for (int i=0; i< pNbBuses; i++)
		{
			_LstBuses.add(new DiagBuses());
		}
	}
	
	// Injection de dépendance
	public void setAcquisition(Acquisition pAcq)
	{
		_Acquisition = pAcq;
	}
}
