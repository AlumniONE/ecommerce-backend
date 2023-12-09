alter table users
    add cart_id bigint null after id_user;

alter table users
    add constraint users_carts_id_cart_fk
        foreign key (cart_id) references carts (id_cart);

