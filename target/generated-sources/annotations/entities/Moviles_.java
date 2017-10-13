package entities;

import entities.Repartidores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Moviles.class)
public class Moviles_ { 

    public static volatile SingularAttribute<Moviles, String> marca;
    public static volatile ListAttribute<Moviles, Repartidores> repartidoresList;
    public static volatile SingularAttribute<Moviles, String> matricula;
    public static volatile SingularAttribute<Moviles, Date> fechaCreacion;
    public static volatile SingularAttribute<Moviles, Date> fechaActualizacion;
    public static volatile SingularAttribute<Moviles, Integer> id;
    public static volatile SingularAttribute<Moviles, String> modelo;

}