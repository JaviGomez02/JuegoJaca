package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;

public class Coordenada {

	private int x;
	private int y;
	private Random r = new Random();

	public Coordenada(int x, int y) {
		super();
		setXY(x, y);
	}

	public Coordenada() {
		super();
		this.x = r.nextInt(Constantes.TAMANNO);
		this.y = r.nextInt(Constantes.TAMANNO);
	}

	private void setXY(int x, int y) {
		if (x < 0 || x > Constantes.TAMANNO || y < 0 || y > Constantes.TAMANNO) {
			x = 0;
			y = 0;
		}
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordenada other = (Coordenada) obj;
		return x == other.x && y == other.y;
	}

	@Override
	public String toString() {
		return "Coordenada [x=" + x + ", y=" + y + "]";
	}

	public boolean goRight() {
		boolean resultado = false;
		if (this.x != (Constantes.TAMANNO - 1)) {
			this.x += 1;
			resultado = true;
		}

		return resultado;
	}

	public boolean goLeft() {
		boolean resultado = false;
		if (this.x != 0) {
			this.x -= 1;
			resultado = true;
		}
		return resultado;
	}

	public boolean goUp() {
		boolean resultado = false;
		if (this.y != 0) {
			this.y -= 1;
			resultado = true;
		}
		return resultado;
	}

	public boolean goDown() {
		boolean resultado = false;
		if (this.y != (Constantes.TAMANNO - 1)) {
			this.y += 1;
			resultado = true;
		}
		return resultado;
	}

	public Coordenada clonar() {
		return new Coordenada(this.x, this.y);
	}
}
