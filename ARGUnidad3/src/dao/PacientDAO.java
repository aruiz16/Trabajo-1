package dao;

import java.util.List;

import model.Pacient;

public interface PacientDAO {
	void createPacient(Pacient pacient);
	Pacient readPacient(Long id);
	List<Pacient> readAllPacients();
	void updatePacient(Pacient pacient);
	void deletePacient(Long id);
}
