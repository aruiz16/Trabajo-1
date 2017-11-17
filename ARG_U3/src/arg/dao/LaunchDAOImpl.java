package arg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sun.prism.ResourceFactoryListener;

import arg.model.Launch;

public class LaunchDAOImpl implements LaunchDAO{
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resulSet;
	
	public LaunchDAOImpl() {
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
	public void createLaunch(Launch launch) {
		if(connection!=null) {
				try {
					preparedStatement = connection.prepareStatement("INSERT INTO launches (name, destination, passengers) VALUES(?,?,?)");
					preparedStatement.setString(1, launch.getName());
					preparedStatement.setString(2, launch.getDestination());
					preparedStatement.setInt(3, launch.getPassengers());
					preparedStatement.execute();
				} catch(SQLException e) {
					e.printStackTrace();
				}
		}	
	}
	
	@Override
	public Launch readLaunch(Long id) {
		Launch launch = null;
		if(connection!=null) {
			try {
			preparedStatement = connection.prepareStatement("SELECT * FROM launches WHERE id=?;");
			preparedStatement.setLong(1, id);
			resulSet = preparedStatement.executeQuery();
			if(resulSet.next()) {
				launch = new Launch(
						resulSet.getLong(1),resulSet.getString(2),resulSet.getString(3),resulSet.getInt(4));
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return launch;
	}
	
	@Override
	public List<Launch> readAllLaunches() {
		List<Launch> launches = new ArrayList<Launch>();
		if(connection!=null) {
			try {
			preparedStatement = connection.prepareStatement("SELECT * FROM launches;");
			resulSet = preparedStatement.executeQuery();
			while(resulSet.next()) {
				Launch launch = new Launch(
						resulSet.getLong(1),resulSet.getString(2),resulSet.getString(3),resulSet.getInt(4));
				launches.add(launch);
			}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return launches;
	}
	@Override
	public void updateLaunch(Launch launch) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("UPDATE launches SET name = ?, destination = ?, passengers = ? WHERE id = ?;");
				preparedStatement.setString(1, launch.getName());
				preparedStatement.setString(2, launch.getDestination());
				preparedStatement.setInt(3, launch.getPassengers());
				preparedStatement.setLong(4, launch.getId());
				preparedStatement.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public void deleteLaunch(Long id) {
		if(connection!=null) {
			try {
				preparedStatement = connection.prepareStatement("DELETE FROM launches WHERE id = ?;");
				preparedStatement.setLong(1, id);
				preparedStatement.execute();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
