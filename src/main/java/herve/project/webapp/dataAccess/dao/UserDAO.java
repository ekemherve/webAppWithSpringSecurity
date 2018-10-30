package herve.project.webapp.dataAccess.dao;

import herve.project.webapp.dataAccess.entity.UserEntity;
import herve.project.webapp.dataAccess.repository.UserRepository;
import herve.project.webapp.dataAccess.utils.ProviderConverter;
import herve.project.webapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserDAO {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        List<UserEntity> userEntities = userRepository.findAll();

        return userEntities.stream().
                map(userEntity -> ProviderConverter.userEntityToUserModel(userEntity)).
                collect(Collectors.toList());
    }

    public User save(User user) {

        return ProviderConverter.userEntityToUserModel(userRepository.save(ProviderConverter.userModelToUserEntity(user)));
    }

    public boolean isValidUser(User user) {

        if(user != null) {
            User foundedUser = ProviderConverter.userEntityToUserModel(userRepository.findById(user.getName()).get());
            if(!user.getName().equals(foundedUser.getName()))
                return true;
        }
        return false;
    }
}
