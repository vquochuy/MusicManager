package com.tma.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Music")
public class Music {

	// annotation de phia tren nha e
	@Id
	private String id;
	private String nameMusic;
	private String genre;
	private String path;
	private String lastUpdate;

	public Music() {
		Date date = new Date();
		this.setLastUpdate(date.toString());
	}

	public Music(String nameMusic, String genre, String path) {
		this.nameMusic = nameMusic;
		this.genre = genre;
		this.path = path;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNameMusic() {
		return nameMusic;
	}

	public void setNameMusic(String nameMusic) {
		this.nameMusic = nameMusic;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
