//package bridge;


import java.io.Serializable;

public class Species implements Serializable {

	private static final long serialVersionUID = 1L;
	private String _name;
	private int _averageLife;
	
	public Species(String name, int averageLife) {
		_name = name;
		_averageLife = averageLife;
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public int getAverageLife() {
		return _averageLife;
	}
	public void setAverageLife(int averageLife) {
		this._averageLife = averageLife;
	}
	
	public String toString() {
		String res = "Name : "+getName()+", "
				+"AverageLife : "+getAverageLife();
		return res;
	}
	
}
