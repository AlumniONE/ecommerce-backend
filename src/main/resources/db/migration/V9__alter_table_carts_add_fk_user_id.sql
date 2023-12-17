alter table carts
               add user_id bigint not null;
alter table carts
               add constraint carts_users_id_fk
                   foreign key (user_id) references users (id);