package taller02.ejercicio01;

import java.util.List;

public abstract class Arbol<E extends Comparable<E>> {


	protected E valor;

	public abstract List<E> preOrden();

	public abstract List<E> inOrden();

	public abstract List<E> posOrden();

	public abstract boolean esVacio();

	public abstract E valor();

	public abstract Arbol<E> izquierdo();

	public abstract Arbol<E> derecho();
	
	public abstract boolean contiene(E unValor);

	public abstract boolean equals(Arbol<E> unArbol);
	
	public abstract void agregar(E a);

	public abstract int profundidad();

	public abstract int cuentaNodosDeNivel(int nivel);

	public abstract boolean esCompleto();

	public abstract boolean esLleno();
	
	/**
	 * Un arbol binario es HOJA si su subarbol izquierdo y su subarbol derecho son vacios.
	 * El arbol vacio no es hoja.  
	 * @return cantidad de nodos descendientes de un arbol
	 */
	public abstract boolean esHoja() ;
	
	/**
	 * Metodo que cuenta la cantidad de nodos de un arbol.
	 * Un arbol vacio no tiene nodos
	 * Un arbol binario de busqueda tiene la raíz, mas la cantidad de  de su subarbol izquierdo
	 * mas la cantidad de su subarbol derecho
	 * @return cantidad de nodos descendientes de un arbol
	 */
	public abstract int cantidadNodos() ;

	/**
	 * Un árbol binario es zurdo si 
	 *	a.	Es el árbol vacío 
     *  b.	Es una hoja
     *  c.	Es un árbol donde más de la mitad de sus descendientes están en el hijo izquierdo y además 
     *      tanto sus hijos izquierdos y como derecho son zurdos (es decir o son un árbol vacio, 
     *      o son un nodo hoja, o cumplen el punto c). 
	 */
	public abstract boolean esZurdo();
	
}