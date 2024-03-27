insert into users(username,password, enable) VALUES
                        ('admin','123',true),
                        ('user','123',true);
insert into authorities(username,authority) VALUES
                        ('admin','admin'),
                        ('user','user');