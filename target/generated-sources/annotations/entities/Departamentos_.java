package entities;

import entities.Ciudades;
import entities.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Departamentos.class)
public class Departamentos_ { 

    public static volatile SingularAttribute<Departamentos, String> descripcion;
    public static volatile ListAttribute<Departamentos, Clientes> clientesList;
    public static volatile SingularAttribute<Departamentos, Date> fechaCreacion;
    public static volatile SingularAttribute<Departamentos, Date> fechaActualizacion;
    public static volatile SingularAttribute<Departamentos, Integer> id;
    public static volatile ListAttribute<Departamentos, Ciudades> ciudadesList;

}