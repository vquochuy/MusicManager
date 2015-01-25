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

@Controller
@RequestMapping("/api/music")
public class MusicController {

	@Autowired
	private MusicDAOImpl musidao;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Page<Music> getMusic() {
//		Music music = new Music("Hello", "POP", "D:/music");
//		return music;
		return musidao.page();
	}

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void addMusic(@RequestBody Music music) {
		musidao.insert(music);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Music> searchMusic(@RequestParam("nameMusic") String name) {
		List<Music> musics = musidao.search(name);
		return musics;
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.GET, produces ="appication/json")
	@ResponseBody
	public String deleteMusic(@RequestParam("id") String id){
		musidao.delete(id);
		return "Delete OK";
	}
}
