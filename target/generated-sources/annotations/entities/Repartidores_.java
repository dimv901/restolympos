package entities;

import entities.Moviles;
import entities.Repartos;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Repartidores.class)
public class Repartidores_ { 

    public static volatile SingularAttribute<Repartidores, String> cedula;
    public static volatile SingularAttribute<Repartidores, String> apellido;
    public static volatile SingularAttribute<Repartidores, Moviles> idMovil;
    public static volatile SingularAttribute<Repartidores, Date> fechaCreacion;
    public static volatile SingularAttribute<Repartidores, Date> fechaActualizacion;
    public static volatile ListAttribute<Repartidores, Repartos> repartosList;
    public static volatile SingularAttribute<Repartidores, Integer> id;
    public static volatile SingularAttribute<Repartidores, String> nombre;
    public static volatile SingularAttribute<Repartidores, Boolean> activo;

}