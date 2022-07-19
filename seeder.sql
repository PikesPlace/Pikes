use pikes_db;

insert into users (admin, email, password, prof_pic, username) values (false, 'email@email.com', 'pass', null, 'user1');

insert into businesses (name) VALUES ('applebees');
insert into businesses (name) VALUES ('longhorn');

insert into locations (city, email, name, phone, poc, state, street, zip, business_id) VALUES ('perry', 'appleperry.com', 'perry applebees', 4234348973, 'Amy', 'GA', '123 main st', 31069, 1);
insert into locations (city, email, name, phone, poc, state, street, zip, business_id) VALUES ('warner robins', 'watlong.com', 'Watson longhorn', 5677895648, 'Craig', 'GA', '678 street', 31030, 2);


insert into job_types (name) values ('warranty');
insert into job_types (name) values ('Contract');
insert into job_types (name) values ('Normal');


insert into tickets (date, date_ordered, date_scheduled, phone_num, ticket_num, business_id, location_id) VALUES ('04/02/20', '04/01/20', '04/03/20', 4567654645, 1, 1, 1);

