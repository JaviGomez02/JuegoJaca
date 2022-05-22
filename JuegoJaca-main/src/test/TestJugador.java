package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import elementos.Jugador;
import elementos.JugadorException;
import elementos.PlayerType;
import logicaJuego.Constantes;

class TestJugador {
	@Test
	public void FuerzaParaLucharElfo() {
		for (int i = 0; i <= 50; i++) {
			Jugador j = new Jugador(PlayerType.ELFO);
			assertTrue(j.getFuerzaParaLuchar() >= 0 && j.getFuerzaParaLuchar() <= Constantes.ELFO_FUERZA);
		}

	}

	@Test
	public void FuerzaParaLucharOgro() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.OGRO);
			assertTrue(j.getFuerzaParaLuchar() >= 0 && j.getFuerzaParaLuchar() <= Constantes.OGRO_FUERZA);
		}
	}

	@Test
	public void FuerzaParaLucharGuerrero() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getFuerzaParaLuchar() >= 0 && j.getFuerzaParaLuchar() <= Constantes.GUERRERO_FUERZA);
		}

	}

	@Test
	public void FuerzaParaLucharMago() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			assertTrue(j.getFuerzaParaLuchar() >= 0 && j.getFuerzaParaLuchar() <= Constantes.MAGO_FUERZA);
		}

	}

	@Test
	public void VelocidadParaLucharElfo() {
		for (int i = 0; i <= 50; i++) {
			Jugador j = new Jugador(PlayerType.ELFO);
			assertTrue(j.getVelocidadParaLuchar() >= 0 && j.getVelocidadParaLuchar() <= Constantes.ELFO_VELOCIDAD);
		}

	}

	@Test
	public void VelocidadParaLucharOgro() {
		for (int i = 0; i <= 50; i++) {
			Jugador j = new Jugador(PlayerType.OGRO);
			assertTrue(j.getVelocidadParaLuchar() >= 0 && j.getVelocidadParaLuchar() <= Constantes.OGRO_VELOCIDAD);
		}

	}

	@Test
	public void VelocidadParaLucharGuerrero() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getVelocidadParaLuchar() >= 0 && j.getVelocidadParaLuchar() <= Constantes.GUERRERO_VELOCIDAD);
		}

	}

	@Test
	public void VelocidadParaLucharMago() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			assertTrue(j.getVelocidadParaLuchar() >= 0 && j.getVelocidadParaLuchar() <= Constantes.MAGO_VELOCIDAD);
		}

	}

	@Test
	public void MagiaParaLucharElfo() {
		for (int i = 0; i <= 50; i++) {
			Jugador j = new Jugador(PlayerType.ELFO);
			assertTrue(j.getMagiaParaLuchar() >= 0 && j.getMagiaParaLuchar() <= Constantes.ELFO_MAGIA);
		}
	}

	@Test
	public void MagiaParaLucharOgro() {
		for (int i = 0; i <= 50; i++) {
			Jugador j = new Jugador(PlayerType.OGRO);
			assertTrue(j.getMagiaParaLuchar() >= 0 && j.getMagiaParaLuchar() <= Constantes.OGRO_MAGIA);
		}

	}

	@Test
	public void MagiaParaLucharGuerrero() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.GUERRERO);
			assertTrue(j.getMagiaParaLuchar() >= 0 && j.getMagiaParaLuchar() <= Constantes.GUERRERO_MAGIA);
		}
	}

	@Test
	public void MagiaParaLucharMago() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			assertTrue(j.getMagiaParaLuchar() >= 0 && j.getMagiaParaLuchar() <= Constantes.MAGO_MAGIA);
		}
	}

	@Test
	public void setDineroIncorrecto1() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setDinero(3);
			fail("Error si no salta la exception");
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setDineroIncorrecto2() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setDinero(-1);
			fail("Error si no salta la exception");
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setDineroCorrecto1() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setDinero(2);
			assertEquals(2, j.getDinero());
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setDineroCorrecto2() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setDinero(0);
			assertEquals(0, j.getDinero());
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesIncorrecto1() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setPociones(4);
			fail("Error si no salta la exception");
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesIncorrecto2() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setPociones(-1);
			fail("Error si no salta la exception");
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesCorrecto1() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setPociones(3);
			assertEquals(3, j.getPociones());
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setPocionesCorrecto2() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setPociones(0);
			assertEquals(0, j.getPociones());

		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasIncorrecto1() {
		Jugador j = new Jugador(PlayerType.MAGO);

		try {
			j.setGemas(6);
			fail("Error si no salta la exception");
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasIncorrecto2() {
		Jugador j = new Jugador(PlayerType.MAGO);

		try {
			j.setGemas(-1);
			fail("Error si no salta la exception");
		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasCorrecto1() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setGemas(5);
			assertEquals(5, j.getGemas());

		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void setGemasCorrecto2() {
		Jugador j = new Jugador(PlayerType.MAGO);
		try {
			j.setGemas(0);
			assertEquals(0, j.getGemas());

		} catch (JugadorException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void encuentraGema() {
		Jugador j = new Jugador(PlayerType.MAGO);
		j.encuentraGema();
		assertEquals(1, j.getGemas());
	}

	@Test
	public void encuentraDinero() {
		Jugador j = new Jugador(PlayerType.MAGO);
		j.encuentraDinero();
		assertEquals(1, j.getDinero());
	}

	@Test
	public void rompeRocaConGema() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			j.encuentraGema();
			assertEquals(Constantes.ROMPE_ROCA_CON_GEMA, j.encuentraRoca());
		}
	}

	@Test
	public void rompeRocaResultado() {
		for (int i = 0; i < 50; i++) {
			Jugador j = new Jugador(PlayerType.MAGO);
			int resultado = j.encuentraRoca();
			assertTrue(resultado == Constantes.GANA_A_LA_ROCA || resultado == Constantes.PIERDE_A_LA_ROCA);
		}
	}
}