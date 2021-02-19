/**
 * 
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


// TODO: Auto-generated Javadoc
/**
 * The Class Main.
 *
 * @author jiio2
 * 17/02/2021 - 01:00:24
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) { 
            // instanciamos una objeto de tipo algoritmos
            Algoritmos ob = new Algoritmos(); 
            
            // creamos una matriz 10x2990
            long[][] out = new long[10][2990]; // creamos una matriz para guardar los tiempos
            //
            long init;// esto es para medir el tiempo de jecución (cuando empieza)
            long end; // cuando termina)
            
            for(int j = 10; j<3000;j++){
                int data[] = ob.rand(j); // generamos los úmeros aleatorios
                
                int[] data1 = data.clone(); // clonamos la data
                init = System.nanoTime();  // iniciamos el reloj
                ob.MergeSort(data1,0,j-1); // aplicamos el algoritmo Merge
                end = System.nanoTime()-init; // tomamos el tiempo que le tomó realizar el ordenamiento 
                out[0][j-10] = end; // lo guardamos en nuestra matriz
                init = System.nanoTime(); // volvemos a tomar el tiempo
                ob.MergeSort(data1,0,j-1); // aplicamos el algoritmo pero con los datos ya ordenados
                end = System.nanoTime()-init; // guardamos el tiempo que le tomó finalizar la acción
                out[5][j-10] = end; // lo guardamos en la matriz
                
                int[] data2 = data.clone(); // clonamos la data
                init = System.nanoTime(); // iniciamos el reloj
                ob.quickSort(data2,0,j-1); // aplicamos el algoritmo Quick
                end = System.nanoTime()-init; // tomamos el tiempo que le tomó realizar el ordenamiento
                out[1][j-10] = end; // lo guardamos en nuestra matriz
                init = System.nanoTime(); // volvemos a tomar el tiempo
                ob.quickSort(data2,0,j-1); // aplicamos el algoritmo pero con los datos ya ordenados
                end = System.nanoTime()-init; // guardamos el tiempo que le tomó finalizar la acción
                out[6][j-10] = end; // lo guardamos en la matriz
                
                int[] data3 = data.clone(); // clonamos la data
                init = System.nanoTime();  // iniciamos el reloj
                ob.radixsort(data3,j); // aplicamos el algoritmo Radix
                end = System.nanoTime()-init; // tomamos el tiempo que le tomó realizar el ordenamiento
                out[2][j-10] = end;  // lo guardamos en nuestra matriz
                init = System.nanoTime();  // volvemos a tomar el tiempo
                ob.radixsort(data3,j); // aplicamos el algoritmo pero con los datos ya ordenados
                end = System.nanoTime()-init; // guardamos el tiempo que le tomó finalizar la acción
                out[7][j-10] = end; // lo guardamos en la matriz
                
                int[] data4 = data.clone(); // clonamos la data
                init = System.nanoTime(); // iniciamos el reloj
                ob.gnomeSort(data4,j); // aplicamos el algoritmo Gnome
                end = System.nanoTime()-init; // tomamos el tiempo que le tomó realizar el ordenamiento
                out[3][j-10] = end; // lo guardamos en nuestra matriz
                init = System.nanoTime(); // volvemos a tomar el tiempo
                ob.gnomeSort(data4,j); // aplicamos el algoritmo pero con los datos ya ordenados
                end = System.nanoTime()-init; // guardamos el tiempo que le tomó finalizar la acción
                out[8][j-10] = end; // lo guardamos en la matriz
                
                init = System.nanoTime(); // iniciamos el reloj
                ob.selectionSort(data); // aplicamos el algoritmo Selection
                end = System.nanoTime()-init; // tomamos el tiempo que le tomó realizar el ordenamiento
                out[4][j-10] = end; // lo guardamos en nuestra matriz
                init = System.nanoTime(); // volvemos a tomar el tiempo
                ob.selectionSort(data); // aplicamos el algoritmo pero con los datos ya ordenados
                end = System.nanoTime()-init; // guardamos el tiempo que le tomó finalizar la acción
                out[9][j-10] = end; // lo guardamos en la matriz
                
            }
            
            
            FileWriter writer;
            try {
                writer = new FileWriter("JavaOut.csv"); // escribimos los resultados en un archivo .csv
                for (int j = 0; j < 2990; j++) {
                writer.append(String.valueOf(j)+","+String.valueOf(out[0][j])+","+String.valueOf(out[1][j])+","+String.valueOf(out[2][j])+","+String.valueOf(out[3][j])+","+String.valueOf(out[4][j]));
                writer.append("\n"); // los metemos con el formato estipulado
            }
            writer.close(); // cerramos el writer
  
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); // programación defensiva 
            }

            
	} 

}
