package elementos;

import java.util.Objects;
import java.util.Random;

import logicaJuego.Constantes;

public class Coordenada {

	private int x;
	private int y;

	public Coordenada(int x, int y) {
		super();
		setX(x);
		setY(y);
	}

	public Coordenada() {
		super();
		this.x = random(Constantes.TAMANNO);
		this.y = random(Constantes.TAMANNO);
	}

	private void setX(int x) {
		if (x < 0 || x > Constantes.TAMANNO) {
			x = 0;
		}
		this.x = x;
	}

	private int random(int tamanno) {
		Random r = new Random();
		return r.nextInt(tamanno);
	}

	private void setY(int y) {
		if (y < 0 || y > Constantes.TAMANNO) {
			y = 0;
		}
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
		if (this.x != 1) {
			this.x -= 1;
			resultado = true;
		}
		return resultado;
	}

	public boolean goUp() {
		boolean resultado = false;
		if (this.y != 1) {
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

	public Coordenada clone() {
		return new Coordenada(this.x, this.y);
	}
}
