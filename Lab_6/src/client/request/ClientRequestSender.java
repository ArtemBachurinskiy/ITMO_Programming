package client.request;

import client.connect.ClientConnectionManager;
import client.movie.Movie;
import general.output.OutputManager;
import general.request.Request;
import java.io.IOException;

/**
 * Клиентский класс, предназначенный для отпраки запросов серверу.
 */
public class ClientRequestSender {
    private ClientConnectionManager clientConnectionManager;
    private OutputManager outputManager;

    /**
     * Конструктор ClientRequestSender.
     * @param clientConnectionManager клиентский менеджер установки соединения
     * @param outputManager менеджер вывода данных
     */
    public ClientRequestSender(ClientConnectionManager clientConnectionManager, OutputManager outputManager) {
        this.clientConnectionManager = clientConnectionManager;
        this.outputManager = outputManager;
    }

    /**
     * Метод, который посылает запрос серверу.
     * @param request посылаемый запрос
     * @return true если запрос успешно отправлен,
     *         false если не удалось отправить запрос.
     */
    public boolean sendRequestToServer(Request request) {
        try {
            clientConnectionManager.getObjectOutputStream().writeObject(request);
            return true;
        } catch (IOException e) {
            outputManager.printlnErrorMessage("Не удалось послать запрос серверу ...");
            clientConnectionManager.closeConnection();
            return false;
        }
    }

    /**
     * Метод, предназначенный для создания нового запроса.
     * @param command команда, входящая в запрос.
     * @param argument аргумент, входящий в запрос.
     * @param movie объект типа Movie, входящий в запрос.
     * @return новый запрос (объект типа Request)
     */
    public Request createRequest (String command, String argument, Movie movie) {
        return new Request(command, argument, movie);
    }
}
