package ejercicio2;

import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProxyAccess implements DatabaseAccess {
    private static final Logger logger = Logger.getLogger(DatabaseProxyAccess.class.getName());

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
        logger.log(Level.INFO, "Buscando resultados de " + queryString);
        return database.getSearchResults(queryString);
    }

    @Override
    public int insertNewRow(List<String> rowData) {
        if (!(user.estaAutenticado()))
            throw new UnauthorizedAccessException("No tiene permisos para insertar en la base de datos");
        logger.log(Level.WARNING, "Filas que quieren agregarse: \n" + rowData);
        return database.insertNewRow(rowData);
    }
}
