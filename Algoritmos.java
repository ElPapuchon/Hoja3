import static java.lang.Math.abs;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Algoritmos.
 */

/**
 * @author jiio2
 *17/02/2021 - 00:30:06
 * 
 */
public class Algoritmos {
	
	/**
	 * Selection sort.
	 *
	 * @param data the data
	 */
	// sort que escogimos como pareja (Selection Sort)
	public static void selectionSort(int data[]) {
		
		int numUnsorted = data.length; // la cantidad de números a ordenar
		int index; // el indice
		int min; // el mínimo indice de la lista
		
		while(numUnsorted > 0) { // hacemos un ciclo while
			min = 0; // lo definimos como 0
			
			for(index = 1; index < numUnsorted; index++) { // ciclo for para comparar
				
				if(data[min]< data[index]) min = index; // hacemos las comparaciones de los números
			
			}
			swap(data, min, numUnsorted - 1); // utilizamoos la función swap que los cambia de lugar
			numUnsorted--; // reducimos en uno el ciclo while
			
		}
	}
	
	/**
	 * Merge.
	 *
	 * @param arr the arr
	 * @param l the l
	 * @param m the m
	 * @param r the r 
	 *definimos esta función auxiliar para realizar el algoritmo Merge
	 */
	public void merge(int arr[], int l, int m, int r)	{
        // encotramos el tamaño de los subarreglos
        int n1 = m - l + 1; 
        int n2 = r - m;
 
        // creamos los temp 
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // copiamos la data en los temp 
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // juntamos los temp
 
        // iniciamos los indices del primer y segundo arreglo
        int i = 0, j = 0;
 
        // indice inicial de los subarrays
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // copiamos los elementos restantes de L[], si los hay
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // copiamos los elementos restantes de R[], si los hay
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // definimos la función que ejecuta el algoritmo Merge
    /**
     * Merge sort.
     *
     * @param arr the arr
     * @param l the l
     * @param r the r
     */
    public void MergeSort(int arr[], int l, int r)
    {
        if (l < r) {
            // encontramos la mitad
            int m =l+ (r-l)/2;
 
            // Sorteamos las mitades
            MergeSort(arr, l, m);
            MergeSort(arr, m + 1, r);
 
            // unimos las mitades
            merge(arr, l, m, r);
        }
    }
    
    /**
     * Partition.
     *
     * @param arr the arr
     * @param begin the begin
     * @param end the end
     * @return the int
     * definimos esta función auxiliar que nos ayuda a ejecutar el Quick sort
     */
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end]; // encotremos el pivote (puede ser el largo del array)
        int i = (begin-1); // este es el indice
        
        // ejecutamos un ciclor for para intercambiar los números del array
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                
                //aquí se intercambian los números
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }
        
        // repetimos el ciclo
        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }
    
    /**
     * Quick sort.
     *
     * @param arr the arr
     * @param begin the begin
     * @param end the end
     */
    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
        	//ejecutamos la función auxiliar
            int partitionIndex = partition(arr, begin, end);
            
            //aplicamos el algoritmo en las dos partes que generamos
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    
 /**
  * Gets the max.
  *
  * @param arr the arr
  * @param n the n
  * @return the max
  */
 // esta función nos permite encontrar el vamor más alto en un array
    // nos servirá como función auxiliar para el algoritmo Radix
   public static int getMax(int arr[], int n) 
    { 
        int mx = arr[0]; 
        // vamos comparando en el array cúal es el valor más alto
        for (int i = 1; i < n; i++) 
            if (arr[i] > mx) 
            	// lo guardamos en nuestra variable 
                mx = arr[i]; 
        return mx; // regresamos ese valor 
    } 
  

    /**
     * Count sort.
     *
     * @param arr the arr
     * @param n the n
     * @param exp the exp
     */
   	// para hacer counting sort en un array
   // nos servirá para el algoritmo radix
    static void countSort(int arr[], int n, int exp) 
    { 
        int output[] = new int[n]; // creamos un array de salida
        int i; 
        int count[] = new int[10]; 
        Arrays.fill(count, 0); 
  
        // contamos los ocurrencias y las guardamos en el array
        for (i = 0; i < n; i++) 
            count[(arr[i] / exp) % 10]++; 
  
        // hacemos que se qcontenga la posición de los dígitosde output
        for (i = 1; i < 10; i++) 
            count[i] += count[i - 1]; 
  
        // rellenamos el output
        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; 
            count[(arr[i] / exp) % 10]--; 
        } 
  
        // copiamos output en el array arr para que este ahora tenga los números con las posiciones sorteadas
        for (i = 0; i < n; i++) 
            arr[i] = output[i]; 
    } 
   
    /**
     * Radixsort.
     *
     * @param arr the arr
     * @param n the n
     */
    static void radixsort(int arr[], int n) 
    { 
        // encontramos el máximo 
        int m = getMax(arr, n); 
        
        // hacemos el counting sort para todo los digitos
        for (int exp = 1; m / exp > 0; exp *= 10) 
            countSort(arr, n, exp); 
    } 
    
    /**
     * Gnome sort.
     *
     * @param arr the arr
     * @param n the n
     */
    public static void gnomeSort(int arr[], int n) // n es el largo del array
    { 
        int index = 0; //iniciamos el indice
  
        while (index < n) { // hacemos un ciclo while
            if (index == 0) 
                index++; 
            if (arr[index] >= arr[index - 1]) 
                index++; // evaluamos que los números sean menor o igual
            else { 
                int temp = 0; // en otro caso se intercambian de lugar
                temp = arr[index]; 
                arr[index] = arr[index - 1]; 
                arr[index - 1] = temp; 
                index--; 
            } 
        } 
    }
	
    /**
     * Swap.
     *
     * @param data the data
     * @param max the max
     * @param i the i
     * función auxiliar para ejecutar el selection sort
     */
	private static void swap(int[] data, int max, int i) {
		// TODO Auto-generated method stub
		
		//intercambia los números de lugar
		int temp = data[max];
		data[max] = data[i];
		data[i] = temp;
		
	}

	/**
	 * Prints the array.
	 *
	 * @param data the data
	 * definimos esta función en la fase pruebas de los algoritmos para ver si 
	 * estaban funcionando bien. En el programa final ya no se utiliza
	 * solo imprime los arrays de forma ordenada
	 */
	public void printArray(int data[]) { 
        int n = data.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(data[i]+" "); 
        System.out.println(); 
    } 
        
        /**
         * Rand.
         *
         * @param l the l
         * @return the int[
         * creamos una función para generar los números aleatoriamente ]
         */
        public int[] rand(int l){
        Random rd = new Random(); // instanciamos la calse random
      int[] arr = new int[l];
      for (int i = 0; i < arr.length; i++) {
         arr[i] = abs(rd.nextInt()); // revolvemos los números en el array
      }
      return arr;
    }
}



