package vn.trandoananh.SpringBoot_Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.trandoananh.SpringBoot_Blog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long>{

}
