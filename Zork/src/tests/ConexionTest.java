package tests;
import org.junit.Test;
import Ubicacion.Conexion;
import Ubicacion.Ubicacion;

public class ConexionTest {

	@Test
	public void test() {
		Ubicacion u1 = new Ubicacion("pieza",'F');
		Ubicacion u2 = new Ubicacion("baño",'M');
		Conexion c1 = new Conexion(u1,"norte");
		Conexion c2 = new Conexion(u2,"sur","Fantasma");		
	}

}
