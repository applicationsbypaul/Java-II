package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Store;
import dmacc.beans.Ticket;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public Ticket ticket() {
		Ticket bean = new Ticket();
		bean.setDescription("My store is down!!!");
		bean.setPriority("EMERGENCY");
		bean.setStatus("IN PROGRESS");
		return bean;
	}
	
	@Bean
	public Store store() {
		Store bean = new Store("5330","AMES2", "515-332-5487");
		return bean;
	}
}