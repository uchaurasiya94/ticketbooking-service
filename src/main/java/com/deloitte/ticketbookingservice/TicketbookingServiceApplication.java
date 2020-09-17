package com.deloitte.ticketbookingservice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.deloitte.ticketbookingservice.model.Bus;
import com.deloitte.ticketbookingservice.model.Route;
import com.deloitte.ticketbookingservice.repositories.IBusBookingRepository;
import com.deloitte.ticketbookingservice.repositories.IBusRepository;
import com.deloitte.ticketbookingservice.services.IBusBookingService;

@EnableDiscoveryClient
@SpringBootApplication
public class TicketbookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketbookingServiceApplication.class, args);
	}
	
	 @Bean
	    ApplicationRunner init(IBusRepository repository, IBusBookingRepository busBookingRepository) throws ParseException {
		 //repository.deleteAll();
		 //busBookingRepository.deleteAll();
		 List<Bus> busList = new ArrayList<Bus>();
		 busList.add(new Bus("AC", "Hyderabad", 0,"V Kaveri Travels", new Route("Delhi", "Mumbai", "04:00", "20:30", "2020-09-18"),1700));
		 busList.add(new Bus("AC", "Bangalore", 0, "SRS Travels", new Route("Bangalore", "Goa", "05:30", "15:00", "2020-09-20"),2000));
		 busList.add(new Bus("NonAC", "Goa", 0, "VRL Travels", new Route("Hydrabad", "Mumbai", "11:45", "21:00", "2020-10-15"),1800));
		 busList.add(new Bus("AC", "Hyderabad", 0,"V Kaveri Travels", new Route("Delhi", "Mumbai", "13:00", "23:30", "2020-09-21"),1700));
		 busList.add(new Bus("AC", "Bangalore", 0, "SRS Travels", new Route("Bangalore", "Goa", "16:30", "22:00", "2020-09-17"),2000));
		 busList.add(new Bus("NonAC", "Goa", 0, "VRL Travels", new Route("Hydrabad", "Mumbai", "07:45", "21:00", "2020-10-20"),1800));
		 busList.add(new Bus("AC", "Hyderabad", 0,"V Kaveri Travels", new Route("Delhi", "Mumbai", "04:00", "20:30", "2020-10-18"),1700));
		 busList.add(new Bus("AC", "Bangalore", 0, "SRS Travels", new Route("Bangalore", "Goa", "05:30", "15:00", "2020-10-20"),2000));
		 busList.add(new Bus("NonAC", "Goa", 0, "VRL Travels", new Route("Hydrabad", "Mumbai", "11:45", "21:00", "2020-10-05"),1800));
		 return args -> {
	            busList.stream().forEach(bus -> {
	                //repository.save(bus);
	            });
	            repository.findAll().forEach(System.out::println);
	        };
	 }
	
	@Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
