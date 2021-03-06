package movie;

import input.MovieReader;
import java.io.IOException;
import java.time.*;

/**
 * The class that builds a Movie entity from the console.
 */
public class ConsoleMovieBuilder implements MovieBuilder {
    private MovieReader movieReader;
    private PersonBuilder personBuilder;

    /**
     * @param movieReader A MovieReader entity
     * @param personBuilder A PersonBuilder entity
     */
    public ConsoleMovieBuilder(MovieReader movieReader, PersonBuilder personBuilder) {
        this.movieReader = movieReader;
        this.personBuilder = personBuilder;
    }

    @Override
    public Coordinates buildCoordinates() throws IOException {
        return new Coordinates(buildCoordinateX(), buildCoordinateY());
    }
    @Override
    public Integer buildCoordinateX() throws IOException {
        return movieReader.readCoordinateX();
    }
    @Override
    public Double buildCoordinateY() {
        return movieReader.readCoordinateY();
    }
    @Override
    public java.time.LocalDateTime buildCreationDate() {
        return LocalDateTime.now();
    }
    @Override
    public int buildOscarsCount() {
        return movieReader.readOscarsCount();
    }
    @Override
    public long buildGoldenPalmCount() {
        return movieReader.readGoldenPalmCount();
    }
    @Override
    public String buildTagline() throws IOException {
        return movieReader.readTagline();
    }
    @Override
    public MovieGenre buildGenre() {
        return movieReader.readGenre();
    }
    @Override
    public Movie buildMovie(int id, String name) throws IOException {
        return new Movie(id, name, buildCoordinates(), buildCreationDate(), buildOscarsCount(),
                buildGoldenPalmCount(), buildTagline(), buildGenre(), personBuilder.buildPerson());
    }
}
