package customer.managedreportcap.utils;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.CompareToBuilder;

import com.sap.cds.ql.cqn.CqnElementRef;
import com.sap.cds.ql.cqn.CqnSelect;
import com.sap.cds.ql.cqn.CqnSortSpecification;
import com.sap.cds.ql.cqn.transformation.CqnAggregateTransformation;

public class UnmanagedReportUtils {

    public static void sort(List<CqnSortSpecification> sortSpecificationList,
            List<? extends Map<String, ?>> entities) {

        // sort methods
        entities.sort((entity1, entity2) -> {
            // compare builder
            CompareToBuilder compareToBuilder = new CompareToBuilder();
            // loop cds sort specification
            for (CqnSortSpecification sort : sortSpecificationList) {

                // get element name
                CqnElementRef elementRef = (CqnElementRef) sort.value();
                // get sort key
                String sortKey = elementRef.displayName();
                String order = sort.order().sort;

                Object lhs, rhs;
                switch (order) {
                    case "asc":
                        lhs = entity1.get(sortKey); // get element in Map with sort key
                        rhs = entity2.get(sortKey);
                        break;
                    case "desc":
                        lhs = entity2.get(sortKey);
                        rhs = entity1.get(sortKey);
                        break;
                    default:
                        lhs = entity1.get(sortKey);
                        rhs = entity2.get(sortKey);
                        break;
                }
                // compare
                compareToBuilder.append(lhs, rhs);
            }
            // compare result
            return compareToBuilder.toComparison();
        });
    }

    ;

    public static List<? extends Map<String, ?>> getTopSkip(long top, long skip,
            List<? extends Map<String, ?>> entities) {
        int topInt = (int) top;
        int skipInt = (int) skip;

        if (topInt == 0) {
            return entities;
        } else {
            if (topInt + skipInt > entities.size()) {
                topInt = entities.size();
            } else {
                topInt = topInt + skipInt;
            }

            return entities.subList(skipInt, topInt);
        }

    }

    public static List<? extends Map<String, ?>> aggregate(CqnSelect cqnSelect,
            List<? extends Map<String, ?>> entities) {

        // entities.stream().collect()
        // CqnAggregateTransformation cqnSelect.groupBy().;
        return entities;

    }

}
