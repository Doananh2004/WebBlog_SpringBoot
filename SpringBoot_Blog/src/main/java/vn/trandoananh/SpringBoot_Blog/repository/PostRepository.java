package vn.trandoananh.SpringBoot_Blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vn.trandoananh.SpringBoot_Blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
	@Query("SELECT p.category.name, COUNT(p) FROM Post p GROUP BY p.category.name")
	List<Object[]> countPostsByCategory();

}
