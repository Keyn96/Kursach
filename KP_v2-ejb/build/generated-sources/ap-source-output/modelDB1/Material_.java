package modelDB1;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelDB1.Operation;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-07T22:27:09")
@StaticMetamodel(Material.class)
public class Material_ { 

    public static volatile SingularAttribute<Material, Integer> cost;
    public static volatile SingularAttribute<Material, Integer> quantity;
    public static volatile CollectionAttribute<Material, Operation> operationCollection;
    public static volatile SingularAttribute<Material, String> name;
    public static volatile SingularAttribute<Material, Integer> weight;
    public static volatile SingularAttribute<Material, Integer> idMaterial;
    public static volatile SingularAttribute<Material, String> manufacturer;

}