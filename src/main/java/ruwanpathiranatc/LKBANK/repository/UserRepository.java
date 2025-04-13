package ruwanpathiranatc.LKBANK.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ruwanpathiranatc.LKBANK.entity.User;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameIgnoringCase(String userName);

}
