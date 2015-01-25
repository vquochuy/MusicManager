package com.tma.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.tma.model.Music;
import com.tma.repo.MusicRepository;

@Component
public class MusicDAOImpl implements MusicDAO {

	@Autowired
	private MusicRepository repo;

	// Insert Music to Database
	@Override
	public void insert(Music music) {
		repo.save(music);

	}

	// Update Music to Database by Id
	@Override
	public void update(String id, Music music) {
		repo.findById(id);
	}

	// Search Music by name
	@Override
	public List<Music> search(String name) {
		List<Music> listMusic = repo.findByNameRegex(name);
		return listMusic;
	}

	@Override
	public void delete(String id) {
		
		repo.delete(id);
	}

	// @Override
	// public List<Music> paging() {
	// Page<Music> musics = repo.findAll(new PageRequest(0, 10));
	// return (List<Music>) musics;
	// }

	@Override
	public Page<Music> page() {
		Page<Music> musics = repo.findAll(new PageRequest(0, 10));
		return musics;
	}

}
