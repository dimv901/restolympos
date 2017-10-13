package entities;

import entities.Proveedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Paises.class)
public class Paises_ { 

    public static volatile SingularAttribute<Paises, String> descripcion;
    public static volatile SingularAttribute<Paises, String> abreviatura;
    public static volatile ListAttribute<Paises, Proveedores> proveedoresList;
    public static volatile SingularAttribute<Paises, Date> fechaCreacion;
    public static volatile SingularAttribute<Paises, Date> fechaActualizacion;
    public static volatile SingularAttribute<Paises, Integer> id;

}