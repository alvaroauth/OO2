package ejercicio2;

import javax.naming.AuthenticationException;
import java.util.Collection;
import java.util.List;

public interface DatabaseAccess {
    Collection<String> getSearchResults(String queryString);
    int insertNewRow(List<String> rowData);
}