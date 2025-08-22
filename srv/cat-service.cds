using managedreport from '../db/schema';

service CatalogService {

    @readonly
    entity AllEntities    as projection on managedreport.AllEntities;

    @readonly
    entity Books          as projection on managedreport.Books;

    @readonly
    @title: 'Authors'
    entity Authors        as projection on managedreport.Authors;

    @readonly
    @title: 'Orders'
    entity Orders         as projection on managedreport.Orders;

    @readonly
    @title: 'Order Items'
    entity OrderItems     as projection on managedreport.OrderItems;

    @readonly
    entity OrderUnmanaged as projection on managedreport.OrderUnmanaged;

}
