import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
	
	public static void main(String[] args) {
		
		int K = 5;
		int M =14;
		int[] A = new int[]{2,1,3,1,2,2,3,2};
		
		int[] lideres = new Solution().solution(K,M,A);
		
		System.out.print("Leaders are [ ");
		Arrays.stream(lideres).forEach(numero -> {
			System.out.print(numero+" ");
		});
		System.out.print("]");
	}

	public int[] solution(int K, int M, int[] A) {
		List<Integer> convertList = new ArrayList<Integer>();
		
		/*Este bucle recorre los elementos de la lista diviendo en sublistas de tamaño K
		 acaba cuando el tamaño de elementos restantes no pueda alcanzar el valor de K*/
		for(int puntero = 0; puntero <= (A.length - K); puntero++) {
			// Generamos un array auxiliar en cada iteracion que guarda los valores con +1
			int[] auxiliar = Arrays.copyOf(A, A.length);
			for(int i = puntero; i < puntero +K; i++) {
					auxiliar[i] = A[i] +1;
			}
			// Hacemos la llamada para evaluar posibles leaders y agregamos al resultado los resultantes
			convertList.addAll(leaders(auxiliar));
		}
		
		//Para ordenar la lista final y evitar duplicados, recorremos y limpiamos la lista
		convertList = convertList.stream().distinct().collect(Collectors.toList());
		Collections.sort(convertList);
		
		return convertList.stream().mapToInt(el -> el).toArray();		
	}
	
	//Metodo para detectar candidatos a leader y almacenarlos
	private List<Integer> leaders(int[] auxiliar) {
		
		int mitad = auxiliar.length % 2 == 0 ? auxiliar.length/2 : auxiliar.length/2+1;
		List<Integer> candidatos = new ArrayList<Integer>();
		List<Integer> listado  = Arrays.stream(auxiliar).boxed().collect(Collectors.toList());
		//Creamos un set a usar como leyenda para facilitar la forma de ver las apariciones de cada elemento distinto
		Set<Integer> leyenda = new HashSet<Integer>(listado);
		leyenda.stream().forEach(element -> {
			if(Collections.frequency(listado, element) >= mitad) {
				candidatos.add(element);
			}
		});
		
		return candidatos;
	}
}