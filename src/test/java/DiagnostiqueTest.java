

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class DiagnostiqueTest {
	
	// Définitiion du Mock
	@Mock
	Acquisition oAcq ;
	
	@Spy
	@InjectMocks
	Diagnostique oDiag ;

	@Test
	public void testAnnotation() {
		
		Mockito.when(oAcq.getPressionLue(0)).thenReturn((float) 5.4);
		Mockito.when(oAcq.getPressionLue(1)).thenReturn((float) 5.4);
		Mockito.when(oAcq.getPressionLue(2)).thenReturn((float) 5.5);
		Mockito.when(oAcq.getPressionLue(3)).thenReturn((float) 5.5);
		Mockito.when(oAcq.getPressionLue(4)).thenReturn((float) 5.5);
	
		oDiag.setNbBuses(5);
		oDiag.LecturePressionBuses((float) 5.5);
		assertEquals((float)5.4, (float)oDiag._LstBuses.get(0).get_PressionLue(),0);
		assertEquals((float)5.4, (float)oDiag._LstBuses.get(1).get_PressionLue(),0);
		assertEquals((float)5.5, (float)oDiag._LstBuses.get(2).get_PressionLue(),0);
		assertEquals((float)5.5, (float)oDiag._LstBuses.get(3).get_PressionLue(),0);
		
	}
	@Test
	public void test() {
		
		Mockito.when(oAcq.getPressionLue(0)).thenReturn((float) 5.5);
		Mockito.when(oAcq.getPressionLue(1)).thenReturn((float) 5.5);
		Mockito.when(oAcq.getPressionLue(2)).thenReturn((float) 5.5);
		Mockito.when(oAcq.getPressionLue(3)).thenReturn((float) 5.5);
		Mockito.when(oAcq.getPressionLue(4)).thenReturn((float) 5.5);
	
		oDiag.setNbBuses(5);
		oDiag.LecturePressionBuses((float) 5.5);
		assertEquals(true, oDiag._etat);
		
	}

}
