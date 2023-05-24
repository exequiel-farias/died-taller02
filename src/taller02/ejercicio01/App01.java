package taller02.ejercicio01;

import java.util.List;

public class App01 {

	// TODO: crear las instancias necesarias para probar los 3 items anteriores y el manejo de excepciones apropiado
	public static void main(String[] args) {
		Arbol<Integer> a1 = new ArbolBinarioBusqueda<Integer>(4);
		Arbol<Integer> a2 = new ArbolBinarioBusqueda<Integer>(6);
		Arbol<Integer> a3 = new ArbolBinarioBusqueda<Integer>(5,a1,a2);
		System.out.println("Es un nodo hoja?: "+a3.esHoja());
		System.out.println("Cantidad de nodos del arbol a3: "+a3.cantidadNodos());
		System.out.println("Es zurdo el arbol a3: "+a3.esZurdo());
		
		Arbol<Integer> a4 = new ArbolBinarioBusqueda<Integer>(8);
		Arbol<Integer> a5 = new ArbolBinarioBusqueda<Integer>(9,a4,new ArbolVacio<Integer>());
		Arbol<Integer> a6 = new ArbolBinarioBusqueda<Integer>(10,a5,new ArbolVacio<Integer>());
		System.out.println("Es un nodo hoja?: "+a6.esHoja());
		System.out.println("Cantidad de nodos del arbol a6: "+a6.cantidadNodos());
		System.out.println("Es zurdo el arbol a6: "+a6.esZurdo());
		
		Arbol<Integer> a7 = new ArbolBinarioBusqueda<Integer>(7);
		a7.agregar(6);
		a7.agregar(1);
		a7.agregar(2);
		a7.agregar(3);
		a7.agregar(4);
		a7.agregar(5);
		
		List<Integer> lista = a7.posOrden();
		System.out.println("Recorrido en posOrden:");
		for(Integer valor : lista)
			System.out.print(valor + " ");
		System.out.println();
	}

}
