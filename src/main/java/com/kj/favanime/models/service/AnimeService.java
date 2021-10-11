package com.kj.favanime.models.service;

import com.kj.favanime.models.AnimeList;
import com.kj.favanime.models.exceptions.animeNotFoundException;
import com.kj.favanime.models.repo.AnimeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

// Added this comment
@Service
public class AnimeService {
    private final AnimeRepo animeRepo;

    @Autowired
    public AnimeService(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    public AnimeList addAnimeList(AnimeList animeList) {
        return animeRepo.save(animeList);
    }

    public List<AnimeList> getAnimeList() {
        return animeRepo.findAll();
    }

    public AnimeList updateAnimeList(AnimeList animeList) {
        return animeRepo.save(animeList);
    }

    public AnimeList findAnimeListById(Long mal_id) {
        return animeRepo.findAnimeListById(mal_id).orElseThrow(() -> new animeNotFoundException("Anime with the id "+ mal_id +" not found"));

    }

    @Transactional
    public void deleteAnimeList(Long id) {
        animeRepo.deleteAnimeListById(id);
    }

    @Transactional
    public void deleteAllAnimeList() {
        animeRepo.deleteAll();
    }

}
