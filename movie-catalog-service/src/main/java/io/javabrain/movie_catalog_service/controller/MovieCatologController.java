package io.javabrain.movie_catalog_service.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.javabrain.movie_catalog_service.model.Catolog;
import io.javabrain.movie_catalog_service.model.DbSettings;
import io.javabrain.movie_catalog_service.model.Movie;
import io.javabrain.movie_catalog_service.model.UserRating;
import io.javabrain.movie_catalog_service.service.MovieCatalogService;

@RestController
@RequestMapping("/api")
public class MovieCatologController {
	
	Logger logger = LogManager.getLogger(MovieCatologController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private WebClient.Builder webClientBuilder;

//	@Autowired
//	private DbSettings dbSettings;
//	
	@Autowired
	private MovieCatalogService movieCatalogService;
//
//	@Value("${my.greetings}")
//	private String getStringFromPropertyFile;

	@GetMapping("/hello")
	@CircuitBreaker(name = "movie-rating-service", fallbackMethod = "getFallbackMethod")
	public List<Catolog> requestMethodName() {

//		RestTemplate restTemplate = new RestTemplate();

		UserRating ratingsData = restTemplate.getForObject("http://movie-rating-service/ratingdata/ratings",
				UserRating.class);

		return ratingsData.getUserrating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://movie-info-service/movies/4", Movie.class);

//			Movie movie = webClientBuilder.
//					build().
//					get().
//					uri("http://localhost:8082/movies/4" + rating.getMovieId()).
//					retrieve().bodyToMono(Movie.class).
//					block();

			return new Catolog(movie.getMovieName(), "description", rating.getRating());
		}).collect(Collectors.toList());

//		return Collections.singletonList(new Catolog("transform", "test", 3));
	}

	public List<Catolog> getFallbackMethod(Throwable t) {
		return Arrays.asList(new Catolog("No Movies", "S", 0));
	}

//	@GetMapping("/")
//	public String home() {
//		return getStringFromPropertyFile;
//	}
//
//	@GetMapping("/greeting")
//	public String bindapplicationPropertiesfileToClass() {
//		return dbSettings.getConnection() + " " + dbSettings.getHost() + " " + dbSettings.getPort();
//	}
	
	@PostMapping("/splunk")
	public String postMethodName() {
		logger.info("MovieCatologController : postMethodName Method is started");
		movieCatalogService.Hello();
		logger.info("MovieCatalogService : postMethodName Method is Ended");
		return "splunk";
	}
	

}
