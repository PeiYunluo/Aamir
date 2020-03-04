package Aamir.repository;

import Aamir.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/2/29 9:34
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
