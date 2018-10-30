package herve.project.webapp.dataAccess.repository;

import herve.project.webapp.dataAccess.entity.RoleEntity;
import herve.project.webapp.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface RoleRepository extends JpaRepository<RoleEntity, RoleEnum> {
}
