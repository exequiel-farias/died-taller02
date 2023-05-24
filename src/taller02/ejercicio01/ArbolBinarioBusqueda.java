package taller02.ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioBusqueda<E extends Comparable<E>> extends Arbol<E> {

	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;

	public ArbolBinarioBusqueda() {
		this.valor = null;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
	}

	public ArbolBinarioBusqueda(E e) {
		this.valor = e;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
	}

	public ArbolBinarioBusqueda(E e, Arbol<E> i, Arbol<E> d) {
		this.valor = e;
		this.izquierdo = i;
		this.derecho = d;
	}

	@Override
	public List<E> preOrden() {
		List<E> lista = new ArrayList<E>();
		lista.add(this.valor);
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		return lista;
	}

	@Override
	public List<E> inOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.inOrden());
		lista.add(this.valor);
		lista.addAll(this.derecho.inOrden());
		return lista;
	}

	@Override
	public List<E> posOrden() {
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.posOrden());
		lista.addAll(this.derecho.posOrden());
		lista.add(this.valor);
		return lista;

	}

	@Override
	public boolean esVacio() {
		return false;
	}

	@Override
	public E valor() {
		return this.valor;
	}

	@Override
	public Arbol<E> izquierdo() {
		return this.izquierdo;
	}

	@Override
	public Arbol<E> derecho() {
		return this.derecho;
	}

	@Override
	public void agregar(E a) {
		if (this.valor.compareTo(a) < 0) {
			if (this.derecho.esVacio())
				this.derecho = new ArbolBinarioBusqueda<E>(a);
			else
				this.derecho.agregar(a);
		} else {
			if (this.izquierdo.esVacio())
				this.izquierdo = new ArbolBinarioBusqueda<E>(a);
			else
				this.izquierdo.agregar(a);
		}
	}

	@Override
	public boolean equals(Arbol<E> unArbol) {
		return this.valor.equals(unArbol.valor()) && this.izquierdo.equals(unArbol.izquierdo())
				&& this.derecho.equals(unArbol.derecho());
	}

	@Override
	public boolean contiene(E unValor) {
		// TODO 1.a
		return this.valor.equals(unValor) || this.izquierdo.contiene(unValor) || this.derecho.contiene(unValor);
	}

	@Override
	public int profundidad() {
		// TODO 1.b
		return Math.max(izquierdo.profundidad(), derecho.profundidad()) + 1;
	}

	@Override
	public int cuentaNodosDeNivel(int nivel) {
		if (nivel == 0)
			return 1;
		else
			return izquierdo.cuentaNodosDeNivel(nivel - 1) + derecho.cuentaNodosDeNivel(nivel - 1);
	}

	@Override
	public boolean esCompleto() {
		if (this.izquierdo.esVacio() && this.derecho.esVacio())
			return true;
		System.out.println("izq prof: " + izquierdo.profundidad() + " == der prof: " + derecho.profundidad());
		System.out.println("izq lleno: " + izquierdo.esLleno() + " === der comp: " + derecho.esCompleto());
		if (izquierdo.profundidad() == derecho.profundidad())
			return izquierdo.esLleno() && derecho.esCompleto();
		if (izquierdo.profundidad() == derecho.profundidad() + 1)
			return izquierdo.esCompleto() && (derecho.esLleno() || derecho.esVacio());
		return false;
	}

	@Override
	public boolean esLleno() {
		if (this.izquierdo.esVacio() && this.derecho.esVacio())
			return true;
		if (this.izquierdo.profundidad() != this.derecho.profundidad())
			return false;
		else
			return derecho.esLleno() && izquierdo.esLleno();
	}
	
	/**
	 * TODO: retorna verdadero si el nodo es un nodo hoja. 
	 * El árbol binario vacío no es un nodo hoja. 
	 * El arbolbinarioDeBusqueda es un nodo hoja, cuando el subárbol izquierdo y el subárbol derecho es un árbol vacío.
	 */
	@Override
	public boolean esHoja() {
		return izquierdo.esVacio() && derecho.esVacio();
	}

	/**
	 * TODO: retorna la cantidad de nodos que tiene un árbol, esto es, la raíz, mas la cantidad de nodos del 
	 * subárbol izquierdo y la cantidad de nodos del subárbol derecho. El árbol vacio tiene 0 nodos.
	 */
	@Override
	public int cantidadNodos() {
		if(esHoja()) return 1;
		else {
			if(!izquierdo.esVacio() && !derecho.esVacio()) {
				return 1 + izquierdo.cantidadNodos() + derecho.cantidadNodos();
			}else {
				if(!izquierdo.esVacio() && derecho.esVacio()) {
					return 1 + izquierdo.cantidadNodos();
				}else {
					return 1 + derecho.cantidadNodos();
				}
			}
		}
	}
	
	/**
	 * TODO: Un árbol binario es zurdo si
	 * a.	Es el árbol vacío 
	 * b.	Es una hoja
	 * c.	Es un árbol donde más de la mitad de sus descendientes están en el hijo izquierdo y además 
	 * tanto sus hijos izquierdos y como derecho son zurdos (es decir o son un árbol vacio, o son un 
	 * nodo hoja, o cumplen el punto c).  
	 */
	@Override
	public boolean esZurdo() {
		if(esHoja()) {
			return true;
		}else {
			if(izquierdo.cantidadNodos() > ((cantidadNodos()-1) / 2)) {
				return izquierdo.esZurdo() && derecho.esZurdo(); 
			}
			return false;
		}
	}
}