package herve.project.webapp.dataAccess.repository;

import herve.project.webapp.dataAccess.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, String> {

    Set<UserEntity> findByNameNotContains(String name);
    UserEntity findByName(String name);
}
