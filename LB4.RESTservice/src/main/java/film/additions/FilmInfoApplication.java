package film.additions;

import film.service.FilmServiceRestImpl;
import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class FilmInfoApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();

        classes.add(FilmServiceRestImpl.class);

        return classes;
    }
}
