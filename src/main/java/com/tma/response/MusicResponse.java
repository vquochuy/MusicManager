package com.tma.response;

import java.util.List;

import com.tma.model.Music;

public class MusicResponse {
	private Response response;
	private Object musics;

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Object getMusics() {
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
		super();

	}

	public MusicResponse(Response response, Object musics) {
		this.response = response;
		this.musics = musics;
	}

}
