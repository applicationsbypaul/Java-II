package dmacc.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;


@Entity
@Data
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String description;
	private String priority;
	private String status;
	@Autowired
	private Store store;

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

}