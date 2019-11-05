package metodos;

import java.util.ArrayList;
import java.util.List;



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
    
	public  void buscamina(int[][] tablero,int[][] visitados,int etapa, int cantMinas, int fila, int columna, List<Punto> solucion,List<Punto> resultado,int m ,int n){

		int fin = n*m;
		Punto pto = new Punto();
		
		while(etapa <= fin) {
			int contenidoCasilla = tablero[fila][columna];
			if (contenidoCasilla != -1) {
				if (cantNoVisitados(visitados) == cantMinas) {
					if(resultado.lastIndexOf(null) < solucion.lastIndexOf(null)) {
						solucion = copySolucion(resultado);
					}
				} else {
					if(visitados[fila][columna] == 0) {
						destapaAdyacentes(tablero,visitados,fila,columna,m,n);
						pto.setFila(fila);
						pto.setColumna(columna);
						resultado.add(pto);
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
					buscamina(tablero,visitados,etapa,cantMinas,fila,columna,solucion,resultado,m,n);
				}
			}
			etapa++;
			//resultado = new ArrayList<Punto>();
			visitados[fila][columna] = 0;
			fila = pto.getFila();
			columna = pto.getColumna();
			if(visitados[fila][columna] != 0) {
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
			}
			if(tablero[fila][columna] == -1) {
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
			}
			pto = new Punto();
			eliminar(resultado,visitados);
			columna=this.getJ();
			fila=this.getI();
		}
	}
	
	public static void muestraResultado(List<Punto> pto) {
		int i=0;
		while(pto !=null) {
			System.out.println(pto.get(i).toString());
			i++;
		}	
	}

	/**
	 * devuelve resultado =null visitados lo pasa
	 * tode a 0 y setea fila y columna en la siguiente posición
	 * para comenzar una nueva etápa desde el comienzo del arbol
	 * es el que da el crecimiento horizontal
	 * @param resultado, col,fil,visitados
	 * @return void
	 */
	 public void eliminar(List<Punto> resultado,int[][] visitados){
		resultado=null;

		//manejo el seteo de los pares que voy proponiendo para empezar
		if(this.getJ() < visitados[0].length-1) {
			this.setJ(this.getJ() + 1);
		} else {
			if(this.getI() < visitados.length-1) {
				this.setI(this.getI() + 1);
				this.setJ(0);
			} else {
				this.setI(0);
				this.setJ(0);
			}
		}
		//seteo la matríz
		this.setVisitados(visitados);
	}

	//seteo la matríz visitada en cero para que queden nuevamente sin visitar
	public void setVisitados(int[][] vist){
		for(int i = 0; i < vist.length; i++){
			for(int j = 0; j < vist[i].length; j++){
				vist[i][j]=0;
			}
		}
	}

	@SuppressWarnings("null")
	public static List<Punto> copySolucion(List<Punto> o){
		List<Punto> resultado = null;
		int i=0;
		while(!o.isEmpty()) {
			resultado.add(o.get(i));
			i++;
		}
		return resultado;
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
            visitados[fila][columna] = 1;
            if (tablero[fila][columna] == 0) {
                for (fila2 = max(0, fila - 1); fila2 < min(m,fila +1) ;fila2++ ) {
                    for (columna2 = max(0, columna - 1); columna2 < min(n,columna +1) ;columna2++) {
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
