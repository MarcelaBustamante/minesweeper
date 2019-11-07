package metodos;

import java.util.*;


public class Utilidades {
	private int i=0;
	private int j=0;
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
    
	public List<Punto> buscamina(int[][] tablero,int[][] visitados, int cantMinas, int fila, int columna, List<Punto> resultado,List<Punto> solucion, int m ,int n){

		boolean fin = false;
		Punto pto = new Punto();

 //este agrega la profundidad del arbol
		while(!fin) {

				if (cantNoVisitados(visitados) == cantMinas) {
					System.out.println("Parcial: " + resultado);
					if(!resultado.isEmpty() && (resultado.size() < solucion.size() || solucion.isEmpty())) {
						solucion.clear();
						solucion.addAll(resultado);

					}
					eliminar(resultado,visitados);
				} else {
					if(visitados[fila][columna] == 0) {
						destapaAdyacentes(tablero,visitados,fila,columna,m,n);
						if(tablero[fila][columna]!=-1){
							pto.setFila(fila);
							pto.setColumna(columna);
							resultado.add(pto);
						}

					}
					if(columna < m-1) {
						columna++;
					} else {
						if(fila < n-1) {
							fila++;
							columna = 0;
						} else {
							fila = 0;
							columna = 0;
						}
					}
					buscamina(tablero,visitados,cantMinas,fila,columna,resultado,solucion,m,n);
				}

			fin = chequearFinal(visitados);
			columna=this.getJ();
			fila=this.getI();
		}
		return solucion;
	}


	/**
	 * devuelve resultado =null visitados lo pasa
	 * tode a 0 y setea fila y columna en la siguiente posición
	 * para comenzar una nueva etápa desde el comienzo del arbol
	 * es el que da el crecimiento horizontal
	 * @param resultado, col,fil,visitados
	 * @return void
	 */
	 public void eliminar(List<Punto> resultado, int[][] visitados){
		resultado.clear();
		 //seteo la matríz
		this.setVisitados(visitados);
	}

	private boolean chequearFinal(int[][] visitados) {
		//manejo el seteo de los pares que voy proponiendo para empezar
		if(this.getJ() < visitados[0].length-1) {
			this.setJ(this.getJ() + 1);
		} else {
			if(this.getI() < visitados.length-1) {
				this.setI(this.getI() + 1);
				this.setJ(0);
			}else{
				return true;
			}
		}
		return false;
	}

	//seteo la matríz visitada en cero para que queden nuevamente sin visitar
	public void setVisitados(int[][] vist){
		for(int i = 0; i < vist.length; i++){
//			for(int j = 0; j < vist[i].length; j++){
//				vist[i][j]=0;
//			}
			Arrays.fill(vist[i], 0);
		}
	}


    
    public static void mostrarTablero(int[][] tablero) {
		for(int[] x : tablero){
			for(int y : x){
				System.out.print(y + " ");
			}
			System.out.println();
		}

    }

    public  void destapaAdyacentes(int[][] tablero, int[][] visitados, int fila, int columna,int m,int n) {
    	int fila2,columna2;

        //si es una casilla que se puede destapar
        if (visitados[fila][columna] == 0) {
            if(tablero[fila][columna]!= -1){
            	visitados[fila][columna] = 1;
			}
            if (tablero[fila][columna] == 0) {
                for (fila2 = max(0, fila - 1); fila2 <= min(m-1,fila +1) ;fila2++ ) {
                    for (columna2 = max(0, columna - 1); columna2 <= min(n-1,columna +1) ;columna2++) {
                        if (tablero[fila2][columna2] != (-1)){
                            destapaAdyacentes(tablero,visitados,fila2,columna2,m,n);
                        }
                    }
                }
            }
        }
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

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}
}
