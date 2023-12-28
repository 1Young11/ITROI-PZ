package ua.nure.film.server.client;

import ua.nure.film.service.FilmService;
import ua.nure.film.service.Film;

import java.net.MalformedURLException;
import java.net.URL;

public class ServiceProvider {
	private static FilmService films;
	private static String url;
	
	protected ServiceProvider() {}
	
	private static FilmService getDefaultFilm() {
		Film port = new Film();
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getFilmPort();
	}
	
	private static FilmService getFilms(String url) throws MalformedURLException {
		Film port = new Film(new URL(url));
//		port.setHandlerResolver(portInfo -> List.of(new SecurityHandler()));
		return port.getFilmPort();
	}
	
	public static synchronized FilmService getInstance(String url) {
		if (films == null) {
			if (url == null) {
				films = getDefaultFilm();
			} else {
				try {
					films = getFilms(url);
				} catch (MalformedURLException e) {
					films = null;
				}
			}
		} else if (!url.equals(ServiceProvider.url)) {
			try {
				films = getFilms(url);
				ServiceProvider.url = url;
			} catch (MalformedURLException e) {
				ServiceProvider.url = null;
				films = null;
			}
		}
		return films;
	}
}
