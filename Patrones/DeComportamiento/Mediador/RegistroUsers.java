package DeComportamiento.Mediador;

import java.util.HashMap;

public class RegistroUsers {
	private HashMap<String, User> registro;
	
	public RegistroUsers() {
		registro = new HashMap<>();
	}
	
	public User getUser(String u) {
		if(!registro.containsKey(u)) {
			return null;
		}
		return registro.get(u);
	}
	
	public void putUser(String k, User c) {
		registro.put(k, c);
	}
	
}
