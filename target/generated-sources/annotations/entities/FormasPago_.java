package entities;

import entities.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(FormasPago.class)
public class FormasPago_ { 

    public static volatile SingularAttribute<FormasPago, String> descripcion;
    public static volatile SingularAttribute<FormasPago, Date> fechaActalizacion;
    public static volatile ListAttribute<FormasPago, Clientes> clientesList;
    public static volatile SingularAttribute<FormasPago, Date> fechaCreacion;
    public static volatile SingularAttribute<FormasPago, Integer> id;

}