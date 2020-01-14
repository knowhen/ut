package when.ut.servlet.auth;

public interface AuthenticationService {
    boolean auth(String username, String password);
}
