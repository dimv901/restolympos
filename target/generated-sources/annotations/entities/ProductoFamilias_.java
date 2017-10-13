package entities;

import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(ProductoFamilias.class)
public class ProductoFamilias_ { 

    public static volatile SingularAttribute<ProductoFamilias, String> descripcion;
    public static volatile SingularAttribute<ProductoFamilias, Date> fechaCreacion;
    public static volatile SingularAttribute<ProductoFamilias, Date> fechaActualizacion;
    public static volatile ListAttribute<ProductoFamilias, Productos> productosList;
    public static volatile SingularAttribute<ProductoFamilias, Integer> id;

}