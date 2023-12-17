alter table orders
    add invoice_id bigint null after user_id;

alter table orders
    add constraint orders_invoice_id_invoice_fk
        foreign key (invoice_id) references invoices (id);