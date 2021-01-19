package asdum.uz.repositroy;

import asdum.uz.entity.enums.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository <User,String> {
    Optional<User> findBySid(String sid);
}
