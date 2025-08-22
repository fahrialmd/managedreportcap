using CatalogService as service from '../../srv/cat-service';

annotate service.OrderUnmanaged with @(
    UI.LineItem       : [
        {
            $Type: 'UI.DataField',
            Value: OrderNo,
        },
        {
            $Type: 'UI.DataField',
            Value: buyer,
        },
        {
            $Type: 'UI.DataField',
            Value: total,
            Label: 'total',
        },
    ],
    UI.SelectionFields: [
        OrderNo,
        buyer,
    ],
    Aggregation       : {
        ApplySupported        : {
            $Type              : 'Aggregation.ApplySupportedType',
            GroupableProperties: [
                buyer,
                OrderNo,
            ]
        },
        CustomAggregate #total: 'Edm.Decimal'
    }
);

annotate CatalogService.OrderUnmanaged with {
    total  @Analytics.Measure  @Aggregation.default: #SUM
};
