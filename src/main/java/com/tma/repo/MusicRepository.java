package com.tma.repo;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tma.model.Music;

@Repository
public interface MusicRepository extends MongoRepository<Music, String> {
	// o day em dang de ID la String
	// va mongo no hok co ho tro autoIncrement cho int type, em muon tang so'
	// len thi phai lam bang tay
	// bth` thi khi em insert neu hok truyen Id vo mongo no se tu sinh ra id voi
	// kieu la ObjectId
	// kieu objectId nay co the convert qua String dc nen em cu dung String hoac
	// objectId cho mongo Id

	// search
	@Query("{ 'nameMusic' : ?0 }")
	List<Music> findByName(String nameMusic);

	// search by regex
	@Query("{'$query' : {'nameMusic':{'$regex': 'h', '$options': 'i'}}, '$orderby' : {'lastUpdate':-1}}")
	List<Music> findByNameRegex(String nameMusic);
	
	
	//Search and sort

	//Update
	@Query("{'id':?0}")
	Music findById(String id);
	
	
}
