drop database road_watch;

show databases;
use road_watch;
show tables;

describe users;
select * from users;

select * from posts;
select * from comments;

describe posts;

SELECT * FROM roadwatch_db.reports;

insert into categories (name)
values ('Flooding'),
       ('Construction'),
       ('Debris'),
       ('Animals'),
       ('Downtown'),
       ('Highway'),
       ('Residential'),
       ('Rural');

##----Chris' database (I know it's wrong but whatevs)
drop database spring_blog;

use spring_blog;
show tables;

select * from users;

describe categories;
insert into categories (name)
values
       ('Construction'),('Animals'), ('Highway'), ('Residential');


select * from categories;
describe reports;
select * from reports;

##----