package br.edu.atitus.paradigma.api_gateway_service.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

	
		@Bean
		RouteLocator getRoutes(RouteLocatorBuilder builder) {
			return builder.routes()
					.route(rota -> rota 
							.path("/get") 
							.filters(f -> f
									.addRequestHeader("Usuario", "Fulano")
									.addResponseHeader("Teste", "ResponseHeader"))
							.uri("http://httpbin.org"))
							
					.route(rota -> rota
							.path("/cambio-service/**")
							.filters(b -> b
									.addRequestHeader("Usuario", "Luis")
									.addResponseHeader("Teste", "ResponseHeader"))
							.uri("lb://cambio-service"))
					.route(rota -> rota
							.path("/produto-service/**")
							.filters(c -> c
									.addRequestHeader("Usuario", "Fernando")
									.addResponseHeader("Teste", "ResponseHeader"))
							.uri("lb://produto-service"))
					.route(rota -> rota
							.path("/saudacao-service/**")
							.filters(d -> d
									.addRequestHeader("Usuario", "Jonhjones")
									.addResponseHeader("Teste", "ResponseHeader"))
							.uri("lb://saudacao-service"))
					.build();
		}
}
