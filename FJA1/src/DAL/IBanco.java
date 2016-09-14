/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;

/**
 *
 * @author solaris
 */
public interface IBanco {
    
    public void Create(Object o);
    public void Read(Object o);
    public void Update(Object o);
    public void Delete(Object o);
    public ResultSet Select(); 
    
}
