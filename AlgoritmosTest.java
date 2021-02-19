

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;


// TODO: Auto-generated Javadoc
/**
 * The Class AlgoritmosTest.
 */

/**
 * @author jiio2
 *18/02/2021 - 11:39:53
 * 
 */
public class AlgoritmosTest {
	
	/** The test. */
	// instanciamos una clase de tipo Algoritmos() para hacer las pruebas
	private Algoritmos test = new Algoritmos();
	
	/** The data. */
	// declaramos la variable con la cuál se realizaran los purebas
	int data[] = {3,5,1,7};
	
	/** The respuesta. */
	// declaramos la respuesta
	int respuesta[] = {1,3,5,7};
	
	/**
	 * Instantiates a new algoritmos test.
	 */
	// Hacemos el constructor
	public AlgoritmosTest() {
    }
	
    /**
     * Sets the up class.
     */
    public static void setUpClass() {
    }
    
    /**
     * Tear down class.
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     * Sets the up.
     */
    @Before
    public void tearDown() {
    }

	/**
	 * Selectiontest.
	 */
    // probamos el algoritmo selección sort
	@Test
	public void Selectiontest() {
		
		int clon1[] = data.clone();
		test.selectionSort(clon1);
		
		assertArrayEquals(respuesta, (int[]) clon1);
		
		
	}
	
	/**
	 * Mergetest.
	 */
	// probamos el algoritmo Merge sort
	@Test
	public void Mergetest() {
		
		int clon2[] = data.clone();
		test.MergeSort(clon2, 0, clon2.length - 1);
		
		assertArrayEquals(respuesta, (int[]) clon2);

	}
	
	/**
	 * Quick sort.
	 */
	// probamos el algoritmo Quick sort
	@Test
	public void QuickSort(){
		
		int clon3[] = data.clone();
		
		test.quickSort(clon3, 0, clon3.length - 1);
	
		assertArrayEquals( respuesta,  clon3);
		
	}
	
	/**
	 * Radix sort.
	 */
	// probamos el algoritmo Radix sort
	@Test
	public void RadixSort(){
		
		int clon4[] = data.clone();
		
		test.radixsort(clon4, clon4.length);
	
		assertArrayEquals(respuesta, (int[]) clon4);
		
	}
	
	/**
	 * Gnome sort.
	 */
	// probamos el algoritmo Gnome sort
	@Test
	public void GnomeSort(){
		
		int clon5[] = data.clone();
		
		test.gnomeSort(clon5,clon5.length);
	
		assertArrayEquals(respuesta, (int[]) clon5);
		
	}
	
	
}


