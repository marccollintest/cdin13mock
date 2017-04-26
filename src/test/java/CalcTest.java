

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.Mockito;

public class CalcTest {

	@Test
	public void test1() {
		
		// Redefinition du Comportement de mon engine
		Engine oEngine = Mockito.mock(Engine.class);
		Mockito.when(oEngine.setCarac("1")).thenReturn(true);
		Mockito.when(oEngine.setCarac("E")).thenReturn(false);
		Mockito.when(oEngine.getAffichage()).thenReturn("1");

		// Injection de d�pendance d'un engine
		Calc oCalc = new CalcStub();
		((CalcStub)oCalc).setEngine(oEngine);
		
		oCalc.AppuieTouche("1");
		assertEquals("1",oCalc.lireAffichage());
		oCalc.AppuieTouche("E");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("1");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("ERREUR",oCalc.lireAffichage());
		
		
		// V�rification des appels aux m�thodes de engine
		Mockito.verify(oEngine,Mockito.atLeast(1)).setCarac(Mockito.anyString()); // La m�thode SetCarac a �t� appell� au moins 1 fois
		Mockito.verify(oEngine,Mockito.times(1)).setCarac("1"); // La m�thode SetCarac a �t� appell�e 1 fois avec 1
		Mockito.verify(oEngine,Mockito.times(1)).setCarac("E"); // La m�thode SetCarac a �t� appell�e 1 fois avec E

		Mockito.verify(oEngine,Mockito.times(1)).getAffichage(); // La m�thode SetCarac a �t� appell�e 1 fois avec E
	}

	@Test
	public void test2() {
		// on doit apeller 3 SetCarc et 2 Lire Affichage
		
		// Redefinition du Comportement de mon engine
		Engine oEngine = Mockito.mock(Engine.class);
		Mockito.when(oEngine.setCarac("1")).thenReturn(true);
		Mockito.when(oEngine.setCarac("2")).thenReturn(true);
		Mockito.when(oEngine.setCarac("E")).thenReturn(false);
		Mockito.when(oEngine.getAffichage()).thenReturn("1").thenReturn("12");

		// Injection de d�pendance d'un engine
		Calc oCalc = new CalcStub();
		((CalcStub)oCalc).setEngine(oEngine);
		
		oCalc.AppuieTouche("1");
		assertEquals("1",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("12",oCalc.lireAffichage());
		oCalc.AppuieTouche("E");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("1");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("ERREUR",oCalc.lireAffichage());
		
		// V�rification de l'appel aux m�thodes de l'objet Mock�
		Mockito.verify(oEngine,Mockito.times(3)).setCarac(Mockito.anyString()); // La m�thode SetCarac a �t� appell� au moins 1 fois
		Mockito.verify(oEngine,Mockito.times(1)).setCarac("1"); // La m�thode SetCarac a �t� appell�e 1 fois avec 1
		Mockito.verify(oEngine,Mockito.times(1)).setCarac("2"); // La m�thode SetCarac a �t� appell�e 1 fois avec 2
		Mockito.verify(oEngine,Mockito.times(1)).setCarac("E"); // La m�thode SetCarac a �t� appell�e 1 fois avec E

		Mockito.verify(oEngine,Mockito.times(2)).getAffichage(); // La m�thode SetCarac a �t� appell�e 1 fois avec E


	}
	@Test
	public void test3() {
		
		// Redefinition du Comportement de mon engine
		Engine oEngine = Mockito.mock(Engine.class);
		Mockito.when(oEngine.setCarac("1")).thenReturn(true);
		Mockito.when(oEngine.setCarac("2")).thenReturn(true);
		Mockito.when(oEngine.setCarac("E")).thenReturn(false);
		Mockito.when(oEngine.getAffichage()).thenReturn("1").thenReturn("12");

		// Injection de d�pendance d'un engine
		Calc oCalc = new CalcStub();
		((CalcStub)oCalc).setEngine(oEngine);
		
		oCalc.AppuieTouche("1");
		assertEquals("1",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("12",oCalc.lireAffichage());
		oCalc.AppuieTouche("E");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("1");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("ERREUR",oCalc.lireAffichage());

		Mockito.when(oEngine.getAffichage()).thenReturn("1").thenReturn("12");

		oCalc.reset();
		oCalc.AppuieTouche("1");
		assertEquals("1",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("12",oCalc.lireAffichage());
		oCalc.AppuieTouche("E");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("1");
		assertEquals("ERREUR",oCalc.lireAffichage());
		oCalc.AppuieTouche("2");
		assertEquals("ERREUR",oCalc.lireAffichage());

		// V�rification de l'appel aux m�thodes de l'objet Mock�
		Mockito.verify(oEngine,Mockito.times(6)).setCarac(Mockito.anyString()); // La m�thode SetCarac a �t� appell� au moins 1 fois
		Mockito.verify(oEngine,Mockito.times(2)).setCarac("1"); // La m�thode SetCarac a �t� appell�e 1 fois avec 1
		Mockito.verify(oEngine,Mockito.times(2)).setCarac("2"); // La m�thode SetCarac a �t� appell�e 1 fois avec 2
		Mockito.verify(oEngine,Mockito.times(2)).setCarac("E"); // La m�thode SetCarac a �t� appell�e 1 fois avec E

		Mockito.verify(oEngine,Mockito.times(4)).getAffichage(); // La m�thode SetCarac a �t� appell�e 1 fois avec E
	}
}
