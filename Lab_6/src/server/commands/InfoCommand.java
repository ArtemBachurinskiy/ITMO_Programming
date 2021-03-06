package server.commands;

import general.request.Request;
import general.response.Response;
import server.collection.CollectionManager;

/**
 * Класс команды info.
 * Описание команды: вывести в стандартный поток вывода информацию о коллекции
 * (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand implements ServerCommand {
    private CollectionManager collectionManager;

    /**
     * @param collectionManager менеджер коллекции
     */
    InfoCommand (CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    @Override
    public Response execute(Request request) {
        String message = "Информация о данной коллекции :" +
                '\n' + "Тип : " + collectionManager.getCollectionType() +
                '\n' + "Дата иниацилизации : " + collectionManager.getCollectionCreationDate() +
                '\n' + "Количество элементов : " + collectionManager.getCollectionSize();
        return new Response(request.getCommand(), message);
    }

    public String getDescription() {
        return "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
