package com.tma.dao;

import java.util.List;

import org.springframework.data.domain.Page;

import com.tma.model.Music;
import com.tma.response.MusicResponse;

public interface MusicDAO {
	public MusicResponse insert(Music music);

	public MusicResponse update(String id, Music music);

	public MusicResponse search(String name);

	public MusicResponse delete(List<String> ids);

	public Page<Music> page();
}
