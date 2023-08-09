// package com.templateproject.api;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.servlet.config.annotation.CorsRegistry;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// import com.templateproject.api.service.AuthService;
// import com.templateproject.api.service.BuildingService;
// import com.templateproject.api.service.PlanetService;

// @SpringBootApplication
// public class ApiApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(ApiApplication.class, args);
// 	}

// 	@Bean
//     CommandLineRunner initWorldToTart(PlanetService planetService, BuildingService buildingService, AuthService authService){
//         return arg -> {
//             // //init 20 planets
//             // planetService.addNewPlanet("Cygnus", 1, 1, 100);
//             // planetService.addNewPlanet("Elysium", 2, 6, 500); 
//             // planetService.addNewPlanet("Nova Prime", 3, 17, 500); 
//             // planetService.addNewPlanet("Arkanis", 1, 12, 100); 
//             // planetService.addNewPlanet("Umbra", 4, 19, 50); 
//             // planetService.addNewPlanet("Nox", 5, 18, 50); 
//             // planetService.addNewPlanet("Eclipsia", 5, 16, 50); 
//             // planetService.addNewPlanet("Zephyria", 12, 19, 100); 
//             // planetService.addNewPlanet("Pandora", 17, 17, 500); 
//             // planetService.addNewPlanet("Aquilon", 20, 20, 100); 
//             // planetService.addNewPlanet("Alpha", 18, 14, 100); 
//             // planetService.addNewPlanet("Titanis", 13, 19, 500); 
//             // planetService.addNewPlanet("Titanis-9", 10, 19, 100); 
//             // planetService.addNewPlanet("Solaris", 8, 8, 100);
//             // planetService.addNewPlanet("Edenia", 2, 6, 500); 
//             // planetService.addNewPlanet("Xerion", 2, 3, 100); 
//             // planetService.addNewPlanet("Nereida", 5, 3, 50); 
//             // planetService.addNewPlanet("Aetheria", 6, 2, 500); 
//             // planetService.addNewPlanet("Lyra", 11, 2, 100); 
//             // planetService.addNewPlanet("Terra Nova", 12, 6, 500); 
//             // planetService.addNewPlanet("Rhea", 14, 6, 50); 
//             // planetService.addNewPlanet("Seren", 18, 1, 500);

//             // //init building Planets
//             // buildingService.add();

//             // //init ship on Planets
            

//             // //init 5 players
//             // authService.register("Max Steel", "max.steel@example.com", "1234", "1234");
//             // authService.register("LunaStar23",  "luna.star23@example.com", "azerty", "azerty");
//             // authService.register("RexHunter", "rex.hunter@example.com", "5678", "5678");
//             // authService.register("PixelNinja", "pixel.ninja@example.com", "azerty1", "azerty1");
//             // authService.register("AstroGamer", "astro.gamer@example.com", "4321", "4321");
            
//         };
//     }

// 	@Bean
// 	public WebMvcConfigurer corsConfigurer() {
// 		return new WebMvcConfigurer() {
// 			@Override
// 			public void addCorsMappings(CorsRegistry registry) {
// 				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
// 			}
// 		};
// 	}
// }


package com.templateproject.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:4200");
            }
        };
    }
}