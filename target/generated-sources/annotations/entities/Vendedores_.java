package entities;

import entities.Circuitos;
import entities.PedidosCabecera;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-08-08T20:20:26")
@StaticMetamodel(Vendedores.class)
public class Vendedores_ { 

    public static volatile SingularAttribute<Vendedores, String> cedula;
    public static volatile SingularAttribute<Vendedores, String> apellido;
    public static volatile SingularAttribute<Vendedores, Boolean> android;
    public static volatile SingularAttribute<Vendedores, Date> fechaCreacion;
    public static volatile SingularAttribute<Vendedores, Date> fechaActualizacion;
    public static volatile SingularAttribute<Vendedores, Integer> id;
    public static volatile SingularAttribute<Vendedores, Circuitos> idCircuito;
    public static volatile SingularAttribute<Vendedores, String> telefonoContacto;
    public static volatile SingularAttribute<Vendedores, String> nombre;
    public static volatile ListAttribute<Vendedores, PedidosCabecera> pedidosCabeceraList;
    public static volatile SingularAttribute<Vendedores, Boolean> activo;

}