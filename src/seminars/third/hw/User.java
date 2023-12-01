package seminars.third.hw;

//Разработайте класс User с методом аутентификации по логину и паролю.
// Метод должен возвращать true, если введенные логин и пароль корректны, иначе false.
public class User {

    String name;
    String password;
    boolean isAdmin;
    boolean isAuthenticate = false;


    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.isAdmin = false;
    }

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public boolean authenticate(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)) {
            isAuthenticate = true;
            return true;
        }
        else {
            isAuthenticate = false;
            return false;
        }
    }
}