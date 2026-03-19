package logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import logica.Mascotas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2026-03-19T11:28:38", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Duenio.class)
public class Duenio_ { 

    public static volatile ListAttribute<Duenio, Mascotas> mascotas;
    public static volatile SingularAttribute<Duenio, String> telefono;
    public static volatile SingularAttribute<Duenio, String> nombre;
    public static volatile SingularAttribute<Duenio, Integer> id_duenio;

}