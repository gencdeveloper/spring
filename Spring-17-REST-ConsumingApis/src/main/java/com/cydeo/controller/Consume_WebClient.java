package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.entity.Genre;
import com.cydeo.entity.MovieCinema;
import com.cydeo.repository.GenreRepository;
import com.cydeo.repository.MovieCinemaRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class Consume_WebClient{



        private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();

        //we are trying to do with reactive way!
        private final MovieCinemaRepository movieCinemaRepository;
        private final GenreRepository genreRepository;

        public Consume_WebClient(MovieCinemaRepository movieCinemaRepository, GenreRepository genreRepository) {
                this.movieCinemaRepository = movieCinemaRepository;
                this.genreRepository = genreRepository;
        }

        //------------- Reactive Way---------------
        @GetMapping("/flux-movie-cinemas")
        public Flux<MovieCinema> readAllCinemaFlux(){
                return Flux.fromIterable(movieCinemaRepository.findAll());
        }

        @GetMapping("/mono-movie-cinema/{id}")
        public Mono<MovieCinema> readById(@PathVariable("id") Long id) {
                return Mono.just(movieCinemaRepository.findById(id).get());
        }


        @PostMapping("/create-genre")
        public Mono<Genre> createGenre(@RequestBody Genre genre){
                Genre createdGenre = genreRepository.save(genre);

                return Mono.just(createdGenre);
        }


        @DeleteMapping("/delete/genre/{id}")
        public Mono<Void> deleteGenre(@PathVariable("id") Long id){
                genreRepository.deleteById(id);
                return Mono.empty();
        }


        //Test for myself with different examples
        @GetMapping("/mono-movie-cinema/wrapper/{id}")
        public Mono<ResponseWrapper> readByIdWithResponseWrapper(@PathVariable("id") Long id) {
                return Mono.fromSupplier(() -> {
                        MovieCinema movieCinema = movieCinemaRepository.findById(id).orElse(null);
                        return new ResponseWrapper("Successfully retrieved", movieCinema);
                });
        }

        @GetMapping("/mono-movie-cinema/responseEntity/{id}")
        public ResponseEntity<Mono<MovieCinema>> readByIdwithResponseEntity(@PathVariable("id") Long id) {
                return ResponseEntity.ok(Mono.just(movieCinemaRepository.findById(id).get()));
        }



        //------------------WEBCLIENT-------------

        @GetMapping("/flux")
        public Flux<MovieCinema> readWithWebClient(){

                return webClient
                        .get()
                        .uri("/flux-movie-cinemas")
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .retrieve()//every time you have to type this part
                        .bodyToFlux(MovieCinema.class); //then select bodyToFlux or Mono based on Object.
        }


        @GetMapping("/mono/{id}")
        public Mono<MovieCinema> readMonoWithWbClient(@PathVariable("id") Long id){

                return webClient
                        .get()
                        .uri("/mono-movie-cinema/{id}",id)
                        .retrieve()
                        .bodyToMono(MovieCinema.class);
        }

}
