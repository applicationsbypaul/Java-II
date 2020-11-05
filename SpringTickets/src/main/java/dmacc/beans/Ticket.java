package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private String priority;
	private String status;
	@Autowired
	private Store store;
	public Ticket() {
		super();
		this.status = "IN QUEUE";
	}

	
	public Ticket(long id, String description, String priority, String status) {
		super();
		this.id = id;
		this.description = description;
		this.priority = priority;
		this.status = status;
	}

	public Ticket(String description, String priority, String status) {
		super();
		this.description = description;
		this.priority = priority;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", description=" + description + ", priority=" + priority + ", status=" + status
				+ ", store=" + store + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}
	
	

}