package dao;

import model.Pacient;

public class TestConnection {
	public static void main(String[] args) {
		PacientDAOImpl pacientDAOImpl = new PacientDAOImpl();
		//pacientDAOImpl.createPacient(new Pacient(1L, "Duffy", "nose", "Macho","Perro"));
		pacientDAOImpl.createPacient(new Pacient(1L, "Axel", "nose", "Macho","asaa"));
		pacientDAOImpl.createPacient(new Pacient(1L, "Pedron", "nose", "Macho","Perro"));
		pacientDAOImpl.createPacient(new Pacient(1L, "Kitty", "nose", "Hembra","Gato"));
		pacientDAOImpl.createPacient(new Pacient(1L, "Camila", "nose", "Hembra","asas"));
	}
}
