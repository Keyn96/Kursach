package modelDB2;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelDB2.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-07T22:27:08")
@StaticMetamodel(Supplier.class)
public class Supplier_ { 

    public static volatile SingularAttribute<Supplier, String> telephoneNumber;
    public static volatile SingularAttribute<Supplier, String> name;
    public static volatile SingularAttribute<Supplier, Integer> id;
    public static volatile CollectionAttribute<Supplier, Orders> ordersCollection;

}