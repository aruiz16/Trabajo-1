package arg.model;

import java.io.Serializable;

public class Launch implements Serializable {
	private Long id;
	private String name;
	private String destination;
	private int passengers;
	
	public Launch(Long id, String name, String destination, int passengers) {
		super();
		this.id = id;
		this.name = name;
		this.destination = destination;
		this.passengers = passengers;
	}

	public Launch() {
		this(0L,"","",0);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	@Override
	public String toString() {
		return "Launch [id=" + id + ", name=" + name + ", destination=" + destination + ", passengers=" + passengers
				+ "]";
	}
}
