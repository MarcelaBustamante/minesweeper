package metodos;

public class Utilidades {
    /**
     * Esta función recibe la matriz de visitados (las casillas tienen valor 1) y no visitados(las casillas tienen valor
     * 0) y devuelve la cantidad de los no visitados
     * @param ubicaciones
     * @return cant
     */
    public  int cantNoVisitados(int[][] ubicaciones) {
        int cant=0;
        for (int i = 0; i < ubicaciones.length; i++) {
            for (int j = 0; j < ubicaciones[i].length; j++) {
                if(ubicaciones[i][j]==0){
                    cant++;
                }
            }
        }
        return cant;
    }
    
    public static void mostrarTablero(int[][] tablero) {
		for(int[] x : tablero){
			for(int y : x){
				System.out.print(y + " ");
			}
			System.out.println();
		}

    }

    public  void destapaAdyacentes(int[][] tablero, int[][] visitados, int fila, int columna) {
    	



    }

	/**
	 * calcula el máximo entre dos número
	 */
	public  int max(int num1,int num2){
		return ((num1>num2)?num1:num2);
	}

	public int min(int num1,int num2){
		return ((num1<num2)?num1:num2);
	}
}
