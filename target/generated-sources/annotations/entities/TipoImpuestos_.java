package entities;

import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(TipoImpuestos.class)
public class TipoImpuestos_ { 

    public static volatile SingularAttribute<TipoImpuestos, String> descripcion;
    public static volatile SingularAttribute<TipoImpuestos, Double> valor;
    public static volatile SingularAttribute<TipoImpuestos, Date> fechaCreacion;
    public static volatile SingularAttribute<TipoImpuestos, Date> fechaActualizacion;
    public static volatile ListAttribute<TipoImpuestos, Productos> productosList;
    public static volatile SingularAttribute<TipoImpuestos, Integer> id;

}