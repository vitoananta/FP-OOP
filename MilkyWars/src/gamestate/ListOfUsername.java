package gamestate;

public class ListOfUsername<T> {
	T name;

	public void add(T name) {
		this.name = name;
	}

	public T get() {
		return name;
	}
}
