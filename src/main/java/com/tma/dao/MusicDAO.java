package com.tma.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tma.model.Music;

public interface MusicDAO {
	public void insert(Music music);

	public void update(String id, Music music);

	public List<Music> search(String name);

	public void delete(String id);

	//public List<Music> paging();

	public Page<Music> page();
}
