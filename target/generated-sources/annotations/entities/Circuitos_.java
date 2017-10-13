package entities;

import entities.Clientes;
import entities.Vendedores;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Circuitos.class)
public class Circuitos_ { 

    public static volatile SingularAttribute<Circuitos, String> descripcion;
    public static volatile SingularAttribute<Circuitos, String> codigo;
    public static volatile ListAttribute<Circuitos, Vendedores> vendedoresList;
    public static volatile ListAttribute<Circuitos, Clientes> clientesList;
    public static volatile SingularAttribute<Circuitos, Date> fechaCreacion;
    public static volatile SingularAttribute<Circuitos, Date> fechaActualizacion;
    public static volatile SingularAttribute<Circuitos, Integer> id;

}