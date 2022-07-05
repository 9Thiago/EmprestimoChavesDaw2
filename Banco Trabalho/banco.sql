begin;


CREATE TABLE public.users
(
    id SERIAL,
    username varchar(255),
    email varchar(255),
    password varchar(255),
    enabled varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.roles
(   
    id int NOT NULL,
    name varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.user_role
(   
    user_id int,
    role_id int
);

CREATE TABLE public.chaves
(   
    chave_id SERIAL,
    nomechave varchar(255),
    situacao varchar(255)    
);

CREATE TABLE public.emprestimo
(   
    id_emp SERIAL,
	alugada varchar(255),
	servidor varchar(255),
    hora varchar(255),
	acao varchar(255),
    PRIMARY KEY (id_emp)
);

ALTER TABLE public.user_role
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;

ALTER TABLE public.user_role
    ADD FOREIGN KEY (role_id)
    REFERENCES public.roles (id)
    NOT VALID;



insert into users (id,username,email,password,enabled)values('100','Thiago','admin@user','{noop}12345','true');
	
	    
insert into roles (id,name)values(1,'ROLE_ADMIN'),
    (2,'ROLE_USER');
	
insert into user_role(user_id,role_id)VALUES(100,1),(100,2);

end;
