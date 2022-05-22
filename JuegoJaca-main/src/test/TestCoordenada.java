package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Coordenada;

class TestCoordenada {

	@Test
	public void coordenadaIncorrecta1() {
		Coordenada c1=new Coordenada(-1,1);
		Coordenada expected=new Coordenada(0,0);
		assertEquals(expected, c1);
	}
	@Test
	public void coordenadaIncorrecta2() {
		Coordenada c1=new Coordenada(1,-1);
		Coordenada expected=new Coordenada(0,0);
		assertEquals(expected, c1);
	}

	@Test 
	public void goDownIncorrecto() {
		Coordenada c1=new Coordenada(1,9);
		assertFalse(c1.goDown());
	}
	@Test 
	public void goDownCorrecto() {
		Coordenada c1=new Coordenada(1,1);
		assertTrue(c1.goDown());
	}
	@Test 
	public void goRightCorrecto() {
		Coordenada c1=new Coordenada(1,1);
		assertTrue(c1.goRight());
	}
	@Test
	public void goRightIncorrecto() {
		Coordenada c1=new Coordenada(9,0);
		assertFalse(c1.goRight());
	}
	@Test
	public void goLeftCorrecto() {
		Coordenada c1=new Coordenada(1,1);
		assertTrue(c1.goLeft());
	}
	@Test
	public void goLeftIncorrecto() {
		Coordenada c1=new Coordenada(0,0);
		assertFalse(c1.goLeft());
	}
	@Test
	public void goUpCorrecto() {
		Coordenada c1=new Coordenada(1,1);
		assertTrue(c1.goUp());
	}
	@Test
	public void goUpIncorrecto() {
		Coordenada c1=new Coordenada(1,0);
		assertFalse(c1.goUp());
	}

}
