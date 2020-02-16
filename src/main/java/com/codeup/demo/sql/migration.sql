drop database road_watch;

show databases;
use road_watch;
show tables;

describe users;
select * from users;

DELETE FROM users WHERE id = 2;
select * from posts;
select * from comments;

describe posts;


SELECT * FROM road_watch.reports;

SELECT * FROM road_watch.reports;
select * from categories;
truncate table categories;


insert into categories (name)
values ('Flooding'),
       ('Construction'),
       ('Debris'),
       ('Animals'),
       ('Downtown'),
       ('Highway'),
       ('Residential'),
       ('Rural');

select * from categories;
describe reports;

select * from report_category;
select * from reports;

##----