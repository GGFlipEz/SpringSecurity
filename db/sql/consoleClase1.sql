select * from authorities;

select * from users;

insert into users(username,password, enabled) VALUES
                        ('admin','123',true),
                        ('user','123',true);
insert into authorities(username,authority) VALUES
                        ('admin','admin'),
                        ('user','user');