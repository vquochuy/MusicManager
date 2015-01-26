package com.tma.response;

import java.util.List;

import com.tma.model.Music;

public class MusicResponse {
	private Response response;
	private List<Music> musics;
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public List<Music> getMusics() {
		return musics;
	}
	public void setMusics(List<Music> musics) {
		this.musics = musics;
	}
	@Override
	public String toString() {
		return "MusicResponse [response=" + response + ", musics=" + musics
				+ "]";
	}
	
	public MusicResponse() {
	}
	public MusicResponse(Response response, List<Music> musics) {
		this.response = response;
		this.musics = musics;
	}
	
	
}
