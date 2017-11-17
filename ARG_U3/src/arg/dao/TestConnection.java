package arg.dao;

import arg.model.Launch;

public class TestConnection {
	public static void main(String[] args) {
		LaunchDAOImpl launchDAOImpl = new LaunchDAOImpl();
		launchDAOImpl.createLaunch(new Launch(1L, "La Boa", "La Ropa", 10));
	}
}
