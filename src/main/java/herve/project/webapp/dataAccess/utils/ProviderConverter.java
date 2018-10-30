package herve.project.webapp.dataAccess.utils;

import herve.project.webapp.dataAccess.entity.UserEntity;
import herve.project.webapp.model.User;

public class ProviderConverter {


    public static User userEntityToUserModel(UserEntity userEntity) {

        return  new User(userEntity.getName(), userEntity.getAge(), userEntity.getMale(), userEntity.getHobby());

    }

    public static UserEntity userModelToUserEntity(User user) {

        return  new UserEntity(user.getName(), user.getAge(), user.getMale(), user.getHobby());

    }
}
