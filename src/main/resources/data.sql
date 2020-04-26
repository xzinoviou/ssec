INSERT INTO users(username,password,enabled) values('user','user',true);
INSERT INTO authorities(username,authority) values('user','ROLE_USER');

INSERT INTO users(username,password,enabled) values('admin','admin',true);
INSERT INTO authorities(username,authority) values('admin','ROLE_ADMIN');

insert into role(id,role_type) values(1,'ADMIN'),(2,'USER'),(3,'MANAGER'),(4,'DEV')