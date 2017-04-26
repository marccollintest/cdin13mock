import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import net.bytebuddy.implementation.bind.MethodDelegationBinder.ParameterBinding.Anonymous;


public class usertest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//MockitoAnnotations.initMocks(this);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		User myUser = new User();
		
		myUser.set_Login("Marc");
		assertEquals("Marc", myUser.get_Login());
		
//		User userMock = Mockito.mock(User.class);
		User userMock = Mockito.mock(User.class);

		// V�rification que les m�thodes n'appelle rien par d�faut
		userMock.set_Login("Marc");
		//assertEquals("Marc", userMock.get_Login());	
		assertNull(userMock.get_Login());
		
		// je dis � mockito de rendre "Ibra" lorsque l'on appelle la methode get_Login
		Mockito.when(userMock.get_Login()).thenReturn("Ibra");
		userMock.set_Login("Marc");
		assertEquals("Ibra", userMock.get_Login());	
		
		Mockito.doCallRealMethod().when(userMock).get_Login();
		Mockito.when(userMock.get_Login()).thenCallRealMethod(); // M�thode non void
		Mockito.doCallRealMethod().when(userMock).set_Login("Marc"); // Methode void
		//Mockito.when(userMock.set_login("Marc")).thenCallRealMethod();

		userMock.set_Login("Marc");
		assertEquals("Marc", userMock.get_Login());	
		userMock.set_Login("Ibra"); // Le Set_Login ne fait rien 
		assertEquals("Marc", userMock.get_Login());	
		
		// On ne peut pas inventer une m�hode
		//Mockito.when(userMock.m1()).thenReturn("Rien");
		
	}

	@Test
	public void test2() {
		
	
		User userMock = Mockito.mock(User.class);

//		Mockito.when(userMock.get_Login()).thenReturn("Marc").thenReturn("Ibra").thenReturn("Franck");
		Mockito.when(userMock.get_Login()).thenReturn("Marc","Ibra","Franck");

		assertEquals("Marc",userMock.get_Login());
		assertEquals("Ibra",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());
		assertEquals("Franck",userMock.get_Login());

		Mockito.when(userMock.get_Login()).thenReturn("Marc").thenReturn("Ibra").thenCallRealMethod();
		assertEquals("Marc",userMock.get_Login());
		assertEquals("Ibra",userMock.get_Login());
		assertNull(userMock.get_Login());
		assertNull(userMock.get_Login());
	}
	
	@Test
	public void testSpy()
	{
		// Cr�ation d'un objet Normal
		User userNormal = new User();
		//utilisation des m�thodes normales
		userNormal.set_Login("Marc");
		assertEquals("Marc",userNormal.get_Login());

		//Spy d'un objet r�el
		User userSpy = Mockito.spy(userNormal);
		// V�rification de l'utilisation des m�thodes r�elles
		userSpy.set_Login("Ibra");
		assertEquals("Ibra",userSpy.get_Login());

		// Mock de get_Login()
		Mockito.when(userSpy.get_Login()).thenReturn("Marc");
		userSpy.set_Login("Ibra");
		// V�rification de l'appel du mock
		assertEquals("Marc",userSpy.get_Login());
	
		// get_login => retour au r�el
		Mockito.when(userSpy.get_Login()).thenCallRealMethod();
		// V�rification de l'appel du mock
		assertEquals("Ibra",userSpy.get_Login());

		// Mock du set_login("Marc") => Rien
		Mockito.doNothing().when(userSpy).set_Login("Marc");
		userSpy.set_Login("Marc");
		// V�rification de l'�tat de d�part
		assertEquals("Ibra",userSpy.get_Login());
		
	}
	
	@Test
	public void testVerifyMock()
	{
		
		User oUser = Mockito.mock(User.class);
		
		oUser.set_Login("Marc");
		assertNull(oUser.get_Login());
		
		
		Mockito.verify(oUser,Mockito.times(1)).get_Login(); // V�rification de l'appel de Get_login
		
		Mockito.verify(oUser,Mockito.times(1)).set_Login("Marc"); // V�rif de,l'appe de set_login avec un param
		Mockito.verify(oUser,Mockito.never()).set_Login("Ibra");
		
		// Verif de l'appel avec n'importe quel param�tre
		Mockito.verify(oUser,Mockito.atLeastOnce()).set_Login(Mockito.anyString());
		
		
	}//TestverifyMock

	@Test
	public void testVerifySpy()
	{
		
		User oUser = Mockito.spy(new User());
		//User oUser = Mockito.mock(User.class);
		
		oUser.set_Login("Marc");
		assertEquals("Marc",oUser.get_Login());
		
		
		Mockito.verify(oUser,Mockito.times(1)).get_Login(); // V�rification de l'appel de Get_login
		
		Mockito.verify(oUser,Mockito.times(1)).set_Login("Marc"); // V�rif de,l'appe de set_login avec un param
		Mockito.verify(oUser,Mockito.never()).set_Login("Ibra");
		
		// Verif de l'appel avec n'importe quel param�tre
		Mockito.verify(oUser,Mockito.atLeastOnce()).set_Login(Mockito.anyString());
		
		
	}//TestverifyMock
}



