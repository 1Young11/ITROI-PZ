package app;

import app.additions.ReturnsAtomic;
import app.entity.*;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Invocation.Builder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import shop.service.Constants;
import shop.service.rest.JAXBContextProvider;
import shop.service.rest.JSONMessageBodyReader;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class FilmsRestClient extends Application {

    private static final URI BASE_URI = URI.create(Constants.SERVICE_BASE_URL);

    private static void printMenu() {
        System.out.println("1. Add Films\n" +
                "2. Add ticket\n" +
                "3. Get list films\n" +
                "4. Get ticket\n" +
                "5. Remove film\n" +
                "6. Exit\n");
    }

    private static void listFilms(Client client) throws Exception {
        WebTarget target = client.target(BASE_URI + "/listFilms");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var films = resp.readEntity(Film[].class);
            for (Film film : films) {
                System.out.println(film.toString());
            }
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addFilm(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);
        var film = new Film();

        System.out.println("Enter film title: ");
        String title = scanner.nextLine();
        System.out.println("Enter film duration: ");
        String duration = scanner.nextLine();
        System.out.println("Enter film show type: ");
        String showType = scanner.nextLine();
        film.setFilmTitle(title);
        film.setDuration(duration);
        film.setShowType(showType);

        WebTarget target = client.target(BASE_URI + "/addFilm");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Film> payload = jakarta.ws.rs.client.Entity.json(film);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void addTicket(Client client) throws Exception {
        Scanner scanner = new Scanner(System.in);
        var ticket = new Ticket();
        System.out.println("Enter ticket number: ");
        String title = scanner.nextLine();
        System.out.println("Enter film duration: ");
        String duration = scanner.nextLine();
        System.out.println("Enter film show type: ");
        String showType = scanner.nextLine();


        WebTarget target = client.target(BASE_URI + "/addTicket");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Ticket> payload = jakarta.ws.rs.client.Entity.json(ticket);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body1 = resp.readEntity(ReturnsAtomic.class);
            System.out.println("id = " + body1.getItem());
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void getTicket(Client client, Scanner scanner) throws Exception {
        System.out.println("Enter ticket number: ");
        String ticketNumber = scanner.nextLine();
        WebTarget target = client.target(BASE_URI).path("search").queryParam("pattern", ticketNumber);
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        Response resp = request.get();
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            var body = resp.readEntity(Film[].class);
            for (Film article : body) {
                System.out.println(article.toString());
            }
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    private static void removeFilm(Client client, Scanner scanner) throws Exception {
        System.out.println("Enter film ID: ");
        int filmId = Integer.parseInt(scanner.nextLine());
        WebTarget target = client.target(BASE_URI + "/removeFilm");
        Builder request = target.request()
                .accept(MediaType.APPLICATION_JSON);
        jakarta.ws.rs.client.Entity<Integer> payload = jakarta.ws.rs.client.Entity.json(filmId);
        Response resp = request.post(payload);
        if (Response.Status.OK.getStatusCode() == resp.getStatus()) {
            System.out.println("remove successful");
        } else {
            throw new Exception("Error with code " + resp.getStatus());
        }
    }

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        client
            .register(JSONMessageBodyReader.class)
            .register(JAXBContextProvider.class);

        Scanner sc = new Scanner(System.in);
        printMenu();
        while (true) {
            int choise = Integer.valueOf(sc.nextLine());
            try {
                switch (choise) {
                    case 1 -> {
                        addFilm(client);
                        break;
                    }
                    case 2 -> {
                        addTicket(client);
                        break;
                    }
                    case 3 -> {
                        listFilms(client);
                        break;
                    }
                    case 4 -> {
                        getTicket(client, sc);
                        break;
                    }
                    case 5 -> {
                        removeFilm(client, sc);
                        break;
                    }

                    case 6 -> {
                        return;
                    }
                    default -> {
                        System.out.println("Invalid option");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("[Error] " + e.getMessage());
                e.printStackTrace();
            }
            printMenu();
        }
    }

    private static GregorianCalendar convertToGregorianCalendar(String dateString) throws ParseException, DatatypeConfigurationException {
        SimpleDateFormat dateFormat;

        if (dateString.length() <= 10) { // If input contains only date (without time)
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        } else {
            dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        Date date = dateFormat.parse(dateString);

        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        return cal;
    }

    private static XMLGregorianCalendar convertToXMLGregorianCalendar(GregorianCalendar calendar) throws DatatypeConfigurationException {
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar);
    }
}
