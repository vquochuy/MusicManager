package com.tma.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.tma.model.Music;
import com.tma.repo.MusicRepository;
import com.tma.response.MusicResponse;
import com.tma.response.Response;

@Component
public class MusicDAOImpl implements MusicDAO {

	@Autowired
	private MusicRepository repo;

	// Insert Music to Database
	@Override
	public MusicResponse insert(Music music) {
		repo.save(music);
		return new MusicResponse(new Response("200", "Successful",
				"Create New Music"), music);
	}

	// Update Music to Databasse by Id
	@Override
	public MusicResponse update(String id, Music musicUpdate) {
		Music music = repo.findById(id);
		List<Music> mus = new ArrayList<Music>();

		if (music == null) {
			repo.save(musicUpdate);
			return new MusicResponse(new Response("200", "Successful",
					"Create New Music"), null);
		} else {
			if (musicUpdate.getGenre() != null) {
				music.setGenre(musicUpdate.getGenre());
			}
			if (musicUpdate.getNameMusic() != null) {
				music.setNameMusic(musicUpdate.getNameMusic());
			}
			if (musicUpdate.getPath() != null) {
				music.setPath(musicUpdate.getPath());
			}
			mus.add(music);
			repo.save(music);
			return new MusicResponse(new Response("200", "Successful",
					"Update Music Successful"), mus);
		}

	}

	// Search Music by name
	@Override
	public MusicResponse search(String name) {
		//PageRequest pageRequest = new PageRequest(0, 5, Sort.Direction.DESC, "lastUpdate");
		List<Music> listMusic = repo.findByNameRegex(name);
		//Page<Music> musics = repo.findAll((Predicate) listMusic, pageRequest);
		return new MusicResponse(new Response("200", "Successfull",
				"Search Music Successfull"), listMusic);
	}

	@Override
	public MusicResponse delete(List<String> ids) {
		List<Music> listMusic = new ArrayList<Music>();

		for (String id : ids) {
			listMusic.add(repo.findById(id));
			repo.delete(id);
		}
		return new MusicResponse(new Response("200", "Successfull",
				"Delete Music Successful"), listMusic);
	}

	@Override
	public Page<Music> page() {
		Page<Music> musics = repo.findAll(new PageRequest(0, 5,
				Sort.Direction.DESC, "lastUpdate"));
		return musics;
	}

}
