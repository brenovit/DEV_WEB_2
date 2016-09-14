package MODEL;

import DTO.Produto;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author Breno
 */
public interface IBanco {
    
    public boolean Create(Object o);
    public Produto Read(Object o);
    public boolean Update(Object o);
    public boolean Delete(Object o);
    public List<Produto> Select(); 
    
}
