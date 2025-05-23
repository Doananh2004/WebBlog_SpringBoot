package vn.trandoananh.SpringBoot_Blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import vn.trandoananh.SpringBoot_Blog.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
