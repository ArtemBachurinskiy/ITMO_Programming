package client.response;

import client.connect.ClientConnectionManager;
import general.response.Response;
import java.io.IOException;

/**
 * Клиентский класс, предназначенный для получения ответа от сервера.
 */
public class ClientResponseReceiver {
    private ClientConnectionManager clientConnectionManager;

    /**
     * @param clientConnectionManager клиентский менеджер установки соединения
     */
    public ClientResponseReceiver(ClientConnectionManager clientConnectionManager) {
        this.clientConnectionManager = clientConnectionManager;
    }

    /**
     * Метод, который получает ответ от сервера.
     * @return ответ сервера (объект типа Response) или null, если произошло какое либо иключение.
     */
    public Response receiveResponseFromServer() {
        try {
            return (Response) clientConnectionManager.getObjectInputStream().readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
}
}
