package com.graniteam.gameview.data;
import com.graniteam.gameview.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}