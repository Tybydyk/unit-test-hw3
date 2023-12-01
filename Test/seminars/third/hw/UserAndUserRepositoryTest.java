package seminars.third.hw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//Разработайте класс User с методом аутентификации по логину и паролю.
// Метод должен возвращать true, если введенные логин и пароль корректны, иначе false.
// Протестируйте все методы

public class UserAndUserRepositoryTest {

    User user;
    UserRepository userRepository;

    @BeforeEach
    void setup(){
        user = new User("new_user", "Pa$$w0rd");
        userRepository = new UserRepository();
    }

    @Test
    void createUserTrue() {
        assertTrue(user.authenticate("new_user", "Pa$$w0rd"));
    }

    @Test
    void createAdminTrue() {
        User admin = new User("admin", "Pa$$w0rd", true);
        assertTrue(admin.isAdmin);
    }

    @Test
    void createUserFalse() {
        assertFalse(user.authenticate("new_user", "password"));

    }

//    Добавьте класс UserRepository для управления пользователями.
//    В этот класс должен быть включен метод addUser, который добавляет пользователя в систему,
//    если он прошел аутентификацию. Покройте тестами новую функциональность

    @Test
    void findUserByCorrectNameTrue() {
        user.authenticate("new_user", "Pa$$w0rd");
        userRepository.addUser(user);
        assertTrue(userRepository.findByName(user.name));
    }

    @Test
    void findUserByNotCorrectNameFalse() {
        user.authenticate("new_user", "Pa$$w0rd");
        userRepository.addUser(user);
        assertFalse(userRepository.findByName("NotCorrectName"));
    }


    @Test
    void addAuthenticUserTrue() {
        user.authenticate("new_user", "Pa$$w0rd");
        userRepository.addUser(user);
        assertTrue(userRepository.findByName(user.name));
    }

    @Test
    void addNotAuthenticUserFalse() {
        userRepository.addUser(user);
        assertFalse(userRepository.findByName(user.name));
    }
}
