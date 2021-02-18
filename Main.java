/**
 * 
 */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author jiio2
 *17/02/2021 - 01:00:24
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String args[]) { 
            
            Algoritmos ob = new Algoritmos(); 
            long[][] out = new long[10][2990];
            long init;
            long end;
            
            for(int j = 10; j<3000;j++){
                int data[] = ob.rand(j);
                
                int[] data1 = data.clone();
                init = System.nanoTime();
                ob.MergeSort(data1,0,j-1);
                end = System.nanoTime()-init;
                out[0][j-10] = end;
                init = System.nanoTime();
                ob.MergeSort(data1,0,j-1);
                end = System.nanoTime()-init;
                out[5][j-10] = end;
                
                int[] data2 = data.clone();
                init = System.nanoTime();
                ob.quickSort(data2,0,j-1);
                end = System.nanoTime()-init;
                out[1][j-10] = end;
                init = System.nanoTime();
                ob.quickSort(data2,0,j-1);
                end = System.nanoTime()-init;
                out[6][j-10] = end;
                
                int[] data3 = data.clone();
                init = System.nanoTime(); 
                ob.radixsort(data3,j);
                end = System.nanoTime()-init;
                out[2][j-10] = end;
                init = System.nanoTime(); 
                ob.radixsort(data3,j);
                end = System.nanoTime()-init;
                out[7][j-10] = end;
                
                int[] data4 = data.clone();
                init = System.nanoTime();
                ob.gnomeSort(data4,j);
                end = System.nanoTime()-init;
                out[3][j-10] = end;
                init = System.nanoTime();
                ob.gnomeSort(data4,j);
                end = System.nanoTime()-init;
                out[8][j-10] = end;
                
                init = System.nanoTime();
                ob.selectionSort(data);
                end = System.nanoTime()-init;
                out[4][j-10] = end;
                init = System.nanoTime();
                ob.selectionSort(data);
                end = System.nanoTime()-init;
                out[9][j-10] = end;
                
            }
            
            
            FileWriter writer;
            try {
                writer = new FileWriter("JavaOut.csv");
                for (int j = 0; j < 2990; j++) {
                writer.append(String.valueOf(j)+","+String.valueOf(out[0][j])+","+String.valueOf(out[1][j])+","+String.valueOf(out[2][j])+","+String.valueOf(out[3][j])+","+String.valueOf(out[4][j]));
                writer.append("\n");
            }
            writer.close();
  
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            
	} 

}
