package edu.uafs.view;

import java.util.List;

public interface UADataAccess<UATYPE>{
    
    public List < UATYPE > getAllItemsFromDatabase () ;
    
    public UATYPE getItem (int key ) ;

    public void update ( UATYPE item ) ;

    public void delete ( UATYPE item ) ;

    public void insert ( UATYPE item ) ;
}
