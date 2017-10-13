package entities;

import entities.Clientes;
import entities.Departamentos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Ciudades.class)
public class Ciudades_ { 

    public static volatile SingularAttribute<Ciudades, String> descripcion;
    public static volatile SingularAttribute<Ciudades, Departamentos> idDepartamento;
    public static volatile ListAttribute<Ciudades, Clientes> clientesList;
    public static volatile SingularAttribute<Ciudades, Date> fechaCreacion;
    public static volatile SingularAttribute<Ciudades, Date> fechaActualizacion;
    public static volatile SingularAttribute<Ciudades, Integer> id;

}