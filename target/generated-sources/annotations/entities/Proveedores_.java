package entities;

import entities.Paises;
import entities.Productos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> descripcion;
    public static volatile SingularAttribute<Proveedores, String> ruc;
    public static volatile SingularAttribute<Proveedores, Paises> idPais;
    public static volatile SingularAttribute<Proveedores, Date> fechaActuaizacion;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile SingularAttribute<Proveedores, Date> fechaCreacion;
    public static volatile ListAttribute<Proveedores, Productos> productosList;
    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> email;

}