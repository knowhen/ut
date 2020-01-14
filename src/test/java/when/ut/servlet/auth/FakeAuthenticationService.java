package when.ut.servlet.auth;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: when
 * @create: 2020-01-14  15:46
 **/
public class FakeAuthenticationService implements AuthenticationService {
    private Map<String, String> users = new HashMap<>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    @Override
    public boolean auth(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
