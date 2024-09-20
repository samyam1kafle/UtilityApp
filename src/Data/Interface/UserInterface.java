package Data.Interface;

import Data.models.User;

/**
 * @Author : Samyam Kafle
 * @Portfolio : https://samyamkafle.com.np
 * @Project : UtilityApp
 * @CreatedDate : 20/09/2024, Friday
 **/
public interface UserInterface {
    User loginUser(String username, String password);
    User registerUser();
}
