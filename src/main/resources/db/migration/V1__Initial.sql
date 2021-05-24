create table club
(
    id      bigserial not null
        constraint club_pk
            primary key,
    name    varchar,
    address varchar
);

alter table club
    owner to n_admin;

create unique index club_id_uindex
    on club (id);

create table guest
(
    id    bigserial not null
        constraint guest_pk
            primary key,
    name  varchar,
    phone varchar
);

alter table guest
    owner to n_admin;

create unique index guest_id_uindex
    on guest (id);

create table history
(
    id       bigserial not null
        constraint history_pk
            primary key,
    club_id  bigint
        constraint history_club_id_fk
            references club,
    guest_id bigint
        constraint history_guest_id_fk
            references guest,
    date     timestamp
);

alter table history
    owner to n_admin;

create unique index history_id_uindex
    on history (id);

INSERT INTO public.guest (id, name, phone)
VALUES (1, 'Person Personovich', '7777123321'),
       (2, 'Ivan Ivan', '77771123456'),
       (3, 'Aibek Aibek', '777777777')
       ;
INSERT INTO public.club (id, name, address)
VALUES (1, 'CLUB NUMBER 1', 'ClubStr street 123'),
(2, 'CLUB NUMBER 2', 'ClubStr street 34'),
(3, 'CLUB NUMBER 3', 'ClubStr street 56')
       ;

INSERT INTO public.history (id, club_id, guest_id, date)
VALUES (DEFAULT, 1, 1, '2021-05-19 18:14:08.000000'),
       (DEFAULT, 2, 1, '2021-05-18 18:14:08.000000'),
       (DEFAULT, 1, 3, '2021-05-17 18:14:08.000000');



