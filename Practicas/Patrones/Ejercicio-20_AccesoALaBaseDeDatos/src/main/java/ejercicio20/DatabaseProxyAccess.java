package ejercicio20;

import java.util.Collection;
import java.util.List;

public class DatabaseProxyAccess implements DatabaseAccess {
    private DatabaseAccess database;
    private Usuario user;

    public DatabaseProxyAccess(DatabaseAccess database, Usuario user) {
        this.database = database;
        this.user = user;
    }

    @Override
    public Collection<String> getSearchResults(String queryString) {
        if (!(user.estaAutenticado()))
            throw new UnauthorizedAccessException("No tiene permisos para buscar en la base de datos");
        return database.getSearchResults(queryString);
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (!(user.estaAutenticado()))
            throw new UnauthorizedAccessException("No tiene permisos para insertar en la base de datos");
        return database.insertNewRow(rowData);
    }
}
