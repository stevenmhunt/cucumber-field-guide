import io.cucumber.java.es.Cuando;

public class MisPasos {
    @Cuando("el usuario {string} inicia sesión")
    public void when_the_user_string_logs_in(String user) {
        Session.performLogin(user);
    }
}