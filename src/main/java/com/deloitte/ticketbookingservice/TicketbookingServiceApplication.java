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
		 repository.deleteAll();
		 busBookingRepository.deleteAll();
		 List<Bus> busList = new ArrayList<Bus>();
		 busList.add(new Bus("AC", "Delhi", 0,"V Kaveri Travels", 
				 new Route("Delhi", "Mumbai", "04:00", "20:30", "2020-09-21"),1700));
		 busList.add(new Bus("AC", "Bangalore", 0, "SRS Travels", 
				 new Route("Bangalore", "Goa", "05:30", "15:00", "2020-09-21"),2000));
		 busList.add(new Bus("Non-AC", "Hydrabad", 0, "VRL Travels", 
				 new Route("Hydrabad", "Mumbai", "11:45", "21:00", "2020-09-21"),1800));
		 busList.add(new Bus("AC", "Mumbai", 0,"V Kaveri Travels", 
				 new Route("Delhi", "Mumbai", "13:00", "23:30", "2020-09-22"),1700));
		 busList.add(new Bus("AC", "Bangalore", 0, "SRS Travels", 
				 new Route("Bangalore", "Goa", "16:30", "22:00", "2020-09-22"),2000));
		 busList.add(new Bus("Non-AC", "Mumbai", 0, "VRL Travels", 
				 new Route("Hydrabad", "Mumbai", "07:45", "21:00", "2020-09-22"),1800));
		 busList.add(new Bus("AC", "Delhi", 0,"V Kaveri Travels", 
				 new Route("Delhi", "Mumbai", "04:00", "20:30", "2020-09-23"),1700));
		 busList.add(new Bus("AC", "Bangalore", 0, "SRS Travels", 
				 new Route("Bangalore", "Goa", "05:30", "15:00", "2020-09-23"),2000));
		 busList.add(new Bus("Non-AC", "Hydrabad", 0, "VRL Travels", 
				 new Route("Hydrabad", "Mumbai", "11:45", "21:00", "2020-09-23"),1800));
		 busList.add(new Bus("Sleeper", "Delhi", 0,"V Kaveri Travels", 
				 new Route("Delhi", "Mumbai", "04:00", "20:30", "2020-09-21"),1200));
		 busList.add(new Bus("Sleeper", "Bangalore", 0, "V Kaveri Travels", 
				 new Route("Bangalore", "Goa", "05:30", "15:00", "2020-09-21"),1500));
		 busList.add(new Bus("Sleeper", "Hydrabad", 0, "V Kaveri Travels", 
				 new Route("Hydrabad", "Mumbai", "11:45", "21:00", "2020-09-21"),1200));

		 return args -> {
	            busList.stream().forEach(bus -> {
	                repository.save(bus);
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
