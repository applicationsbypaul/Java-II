package dmacc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dmacc.beans.Store;
import dmacc.beans.Ticket;
import dmacc.controller.BeanConfiguration;
import dmacc.repository.TicketRepository;


@SpringBootApplication
public class SpringTicketsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringTicketsApplication.class, args);
		
	}
	
	@Autowired
	TicketRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		ApplicationContext appContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		Ticket t = appContext.getBean("ticket",Ticket.class);
		t.setDescription("ROOF ON FIRE");
		repo.save(t);
		
		Ticket t2 = appContext.getBean("ticket",Ticket.class);
		t2.setDescription("NEED A PRINTER");
		t2.setStatus("LOW");
		repo.save(t2);
		
		Store s = new Store("5660", "AMES 4", "555-555-4454");
		Store s2 = new Store("1449", "WES DES MOINES", "563-146-7875");
		
		t.setStore(s);
		t.setStore(s2);
		repo.save(t);
		repo.save(t2);
		
		List<Ticket> allMyTickets = repo.findAll();
		for(Ticket ti: allMyTickets) {
			System.out.println(ti.toString());
		}
	}
}
