package com.tma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tma.dao.MusicDAOImpl;
import com.tma.model.Music;
import com.tma.response.MusicResponse;

@Controller
@RequestMapping("/api/music")
public class MusicController {

	@Autowired
	private MusicDAOImpl musidao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Page<Music> getMusic() {
		return musidao.page();
	}
//	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
//	@ResponseBody
//	public Music getMusics() {
//		Music music = new Music("Hello", "POP", "D:/music");
//		return music;
//	
//	}
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public MusicResponse addMusic(@RequestBody Music music) {
		return musidao.insert(music);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public MusicResponse searchMusic(@RequestParam("nameMusic") String name) {
		return musidao.search(name);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public MusicResponse updateMusic(@RequestParam("id") String id, @RequestBody Music music) {
		return musidao.update(id, music);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public MusicResponse deleteMusic(@RequestBody List<String> ids) {
		return musidao.delete(ids);
	}
}
