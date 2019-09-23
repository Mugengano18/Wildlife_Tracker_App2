SET MODE PostgreSQL;

CREATE TABLE IF NT EXISTS animals(
id int PRIMARY KEY auto_increment,
name VARCHAR,
health VARCHAR,
endanger BOOLEAN
);

CREATE TABLE IF NT EXISTS sighting(
id int PRIMARY KEY auto_increment,
name VARCHAR;
location VARCHAR;
animalid INTEGER;
);