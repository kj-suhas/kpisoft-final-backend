package com.kj.favanime;

import com.kj.favanime.models.AnimeList;
import com.kj.favanime.models.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeResource {
    private final AnimeService animeService;

    public AnimeResource(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnimeList>> getAllAnimeList() {
        List<AnimeList> animes = animeService.getAnimeList();
        return new ResponseEntity<>(animes, HttpStatus.OK);
    }

    @GetMapping("/find/{mal_id}")
    public ResponseEntity<AnimeList> getAnimeListById(@PathVariable("mal_id") Long mal_id) {
        AnimeList anime = animeService.findAnimeListById(mal_id);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<AnimeList> addAnime(@RequestBody AnimeList animeList) {
        AnimeList anime = animeService.addAnimeList(animeList);
        return new ResponseEntity<>(anime, HttpStatus.CREATED);

    }

    @PutMapping("/")
    public ResponseEntity<AnimeList> updateAnimeList(@RequestBody AnimeList animeList) {
        AnimeList anime = animeService.updateAnimeList(animeList);
        return new ResponseEntity<>(anime, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAnimeList(@PathVariable("id") Long id) {
        animeService.deleteAnimeList(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAll() {
        animeService.deleteAllAnimeList();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
