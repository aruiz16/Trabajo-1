package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.ResourceFactoryListener;

import model.Pacient;

public class PacientDAOImpl implements PacientDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resulSet;
	
	public PacientDAOImpl() {
		getConnection();
	}
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/testdb","utng","mexico");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	@Override
	public void createPacient(Pacient pacient) {
		if(connection!=null) {
				try {
					preparedStatement = connection.prepareStatement("INSERT INTO pacients (nombre, apellidos, sexo, raza) VALUES(?,?,?,?)");
					preparedStatement.setString(1, pacient.getNombre());
					preparedStatement.setString(2, pacient.getApellidos());
					preparedStatement.setString(3, pacient.getSexo());
					preparedStatement.setString(4, pacient.getRaza());
					preparedStatement.execute();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}	
	}
	
	@Override
	public Pacient readPacient(Long id) {
		Pacient pacient = null;
		if(connection!=null) {
			try {
			preparedStatement = connection.prepareStatement("SELECT * FROM pacients WHERE id=?;");
			preparedStatement.setLong(1, id);
			resulSet = preparedStatement.executeQuery();
			if(resulSet.next()) {
				pacient = new Pacient(
						resulSet.getLong(1),resulSet.getString(2),resulSet.getString(3),resulSet.getString(4),resulSet.getString(5));
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return pacient;
	}
	
	@Override
	public List<Pacient> readAllPacients() {
		List<Pacient> pacients = new ArrayList<Pacient>();
		if(connection!=null) {
			try {
			preparedStatement = connection.prepareStatement("SELECT * FROM pacients;");
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()) {
				Pacient pacient = new Pacient(
						resulSet.getLong(1),resulSet.getString(2),resulSet.getString(3),resulSet.getString(4),resulSet.getString(5));
				pacients.add(pacient);
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return pacients;
	}
	@Override
	public void updatePacient(Pacient pacient) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("UPDATE pacients SET nombre = ?, apellidos = ?, sexo = ?, raza = ?  WHERE id = ?;");
				preparedStatement.setString(1, pacient.getNombre());
				preparedStatement.setString(2, pacient.getApellidos());
				preparedStatement.setString(3, pacient.getSexo());
				preparedStatement.setString(4, pacient.getRaza());
				preparedStatement.setLong(5, pacient.getId());
				preparedStatement.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void deletePacient(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM pacients WHERE id = ?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
