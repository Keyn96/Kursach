package modelDB2;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelDB2.Orders;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-07T22:27:09")
@StaticMetamodel(Materialorder.class)
public class Materialorder_ { 

    public static volatile SingularAttribute<Materialorder, Integer> cost;
    public static volatile SingularAttribute<Materialorder, Integer> quantity;
    public static volatile SingularAttribute<Materialorder, String> name;
    public static volatile SingularAttribute<Materialorder, Integer> idMaterial;
    public static volatile CollectionAttribute<Materialorder, Orders> ordersCollection;

}