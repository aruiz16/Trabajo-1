package arg.dao;

import java.util.List;

import arg.model.Launch;

public interface LaunchDAO {
	void createLaunch(Launch launch);
	Launch readLaunch(Long id);
	List<Launch> readAllLaunches();
	void updateLaunch(Launch launch);
	void deleteLaunch(Long id);
}
