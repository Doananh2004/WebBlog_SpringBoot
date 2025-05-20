package vn.trandoananh.SpringBoot_Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.trandoananh.SpringBoot_Blog.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
}
