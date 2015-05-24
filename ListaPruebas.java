// Pruebas realizadas por Daniel López Fernández (Github: danilopezf10)


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import prListaDoblementeEnlazada_Con_pruebas.ListaDobleEnlazada;

public class ListaPruebas {
	public ListaDobleEnlazada lista;
	
	@Before
	public void inicializa(){
		lista = new ListaDobleEnlazada();
	}
	
	@Test
	public void listaInicialmenteVacia(){
		assertEquals(null, lista.first);
		assertEquals(null, lista.last);	
	}
	
	@Test
	public void listaInicialmenteVaciaConIsEmpty(){
		
		assertEquals(true, lista.isEmpty());
	}
	
/*	@Test
	public void listaNoVacia(){
		int numero = 4;
		lista.insertBeginning(numero);
		assertFalse(lista.isEmpty());
	}
	*/
	
	@Test
	public void elementoAñadidoCorrectamente(){
		int numero = 4;
		lista.insertBeginning(numero);
		assertEquals(numero, lista.first.data);
	}
	
	@Test
	public void alAñadirElementoListaYaNoEstaVacia(){
		lista.insertBeginning(4);
		assertFalse(lista.isEmpty());
	}
	
	@Test
	public void firstYLastIgualesEnListaDeUnElemento(){
		lista.insertBeginning(4);
		assertEquals(lista.first, lista.last);
	}
	
	@Test
	public void insertaElementoAlPrincipioCorrectamente(){
		lista.insertBeginning(1);
		lista.insertBeginning(2);
		lista.insertBeginning(3);
		
		assertEquals(3, lista.first.data);
		assertEquals(2, lista.first.next.data);
		assertEquals(1, lista.last.data);
	}
	
	@Test
	public void insertaElementoAlFinalCorrectamente(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		lista.insertEnd(3);
		
		assertEquals(1, lista.first.data);
		assertEquals(2, lista.first.next.data);
		assertEquals(3, lista.last.data);
	}
	
	@Test
	public void borrarDatoInexistente(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		
		assertFalse(lista.deleteData(3));
	}
	
	@Test
	public void borrarUltimoDato(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		lista.insertEnd(3);
		
		assertEquals(true, lista.deleteData(3));
	}
	
	@Test
	public void borrarPrimerDato(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		lista.insertEnd(3);
		
		assertEquals(true, lista.deleteData(1));
	}
	
	@Test
	public void borrarDatoIntermedio(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		lista.insertEnd(3);
		
		assertEquals(true, lista.deleteData(2));
	}
	
	@Test
	public void insertarEnMedio(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		
		lista.insertSubsequently(3, lista.first);
		
		assertEquals(lista.first.next.data, 3);
		assertEquals(lista.last.prev.data, 3);
	}
	
	@Test
	public void insertarEnMedio2(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		lista.insertSubsequently(3, lista.last);
		
		assertEquals(3, lista.last.data);
	}
	
	@Test
	public void insertarEnMedio3(){
		lista.insertEnd(1);
		lista.insertEnd(2);
		lista.insertPreviously(3, lista.last);
		
		assertEquals(3, lista.last.prev.data);
	}
}
