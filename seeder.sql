use pikes_db;

insert into users (admin, email, password, prof_pic, username) values (false, 'email@email.com', 'pass', null, 'user1');

insert into businesses (name) VALUES ('applebees');

insert into locations (city, email, name, phone, poc, state, street, zip) VALUES ('perry', 'appleperry.com', 'perry applebees', 4566576475, 'Amy', 'GA', '123 main st', 31069);

insert into job_types (name) values ('warranty');

insert into tickets (date, date_ordered, date_scheduled, phone_num, ticket_num, business_id, location_id) VALUES ('04/02/20', '04/01/20', '04/03/20', 4567654645, 1, 1, 1);

insert into ticket_type (ticket_id, job_type_id) VALUES (1, 1);