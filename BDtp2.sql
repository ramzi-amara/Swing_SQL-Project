use master
drop database GestionLivre
go
create database GestionLivre
go
use GestionLivre
go
create table Livre 
(id_livre   int identity primary key,
 no_livre   int,
 isbn       char(17) unique not null,
 titre      varchar(25) not null,
 no_edition int not null,
 prix       money not null)
go

insert into Livre values
(1, '978-0-7334-2609-1', 'Naruto', 1, 5),
(2, '978-0-7334-2609-2', 'DBZ', 1, 10),
(3, '978-0-7334-2609-3', 'One piece', 1, 7),
(4, '978-0-7334-2609-4', 'Bleach', 1, 8),
(4, '978-0-7334-2609-5', 'Bleach', 2, 9),
(1, '978-0-7334-2609-6', 'Naruto', 2, 11),
(1, '978-0-7334-2609-7', 'Naruto', 3, 13)
go

-------------------------------------------------
create table Auteur 
(id_auteur     int identity(100,1) primary key,
 nom_auteur    varchar(25) not null, 
 niveau_auteur int not null check (niveau_auteur in (1,2)))
go

insert into Auteur values
('Ramzi', 1),
('Hamza', 1),
('Karim', 2),
('John', 2)
go
----------------------------------------------------

create table AuteurLivre
(id_livre int not null,
 id_auteur int not null,
 constraint pk_AuteurLivre primary key (id_livre, id_auteur))
go


insert into AuteurLivre values 
(1, 100),
(2, 101),
(3, 102), (3, 103),
(4, 102), (4, 103),
(5, 102), (5, 103),
(6, 100),
(7, 100)
go

-----------------------------------------------------

create table Edition 
(id_edition int identity(20,1) primary key,
 no_edition        int not null, 
 nombre_exemplaire int not null,
 date_edition      date not null)
go

insert into Edition values
(1, 25, '2010-01-01'),
(1, 15, '2010-02-02'),
(1, 10, '2010-03-03'),
(1, 13, '2010-04-04'),
(2, 20, '2010-05-05'),
(2, 21, '2010-06-07'),
(3, 22, '2010-07-07')
go

--------------------------------------------------------

create table LivreEdition 
(id_livre int not null,
 id_edition int not null,
 constraint pk_LivreEdition primary key (id_livre, id_edition))
go

insert into LivreEdition values
(1, 20), (6, 25), (7, 26), --Édition pour Naruto
(2, 21), --Édition pour DBZ
(3, 22), --Édition pour One piece
(4, 23), (5, 24) --Édition pour Bleach
go

-----------------------------------------------------------

create table Librairie 
(id_librairie int not null identity (50,1) primary key,
 nom_librairie varchar(25) not null,
 adresse_librairie varchar(40) not null)
go

insert into Librairie values
('LeBonCoin', '2125 rue Laconcorde'),
('CraigsList', '1521 rue Toupin'),
('Kijiji', '1015 rue Amherst')
go

-----------------------------------------------------------

Create table Commande 
(id_commande int identity(70,1) primary key,
 id_librairie int foreign key references Librairie(id_librairie),)
go

insert into Commande values
(50), --70
(50), --71
(51), --72
(52), --73
(52)  --74
go

create table CommandeLivre
(id_commande int not null,
 id_livre int not null,
 quantite int not null,
 constraint pk_CommandeLivre primary key (id_commande, id_livre),)
go

insert into CommandeLivre values
(70, 1, 5), (71, 2, 3),
(72, 3, 7),
(73, 4, 4), (74, 6, 8)
go

select * from Auteur
select * from Commande
select * from CommandeLivre

select t1.titre, t1.no_edition, t2.quantite, t3.id_librairie
from Livre t1 inner join CommandeLivre t2 on t1.id_livre = t2.id_livre
			  inner join Commande t3 on t3.id_commande = t2.id_commande
			  where t3.id_librairie = 50
go

select t1.titre, t1.no_edition, t2.quantite, t3.id_librairie
from Livre t1 inner join CommandeLivre t2 on t1.id_livre = t2.id_livre
			  inner join Commande t3 on t3.id_commande = t2.id_commande
			  where t3.id_librairie = 51
go

select t1.titre, t1.no_edition, t2.quantite, t3.id_librairie
from Livre t1 inner join CommandeLivre t2 on t1.id_livre = t2.id_livre
			  inner join Commande t3 on t3.id_commande = t2.id_commande
			  where t3.id_librairie = 52
go
			  

/*select t1.titre, t1.no_edition
from Livre t1 inner join AuteurLivre t2 on t1.id_livre = t2.id_livre
              inner join Auteur t3 on t3.id_auteur = t2.id_auteur
			  where t2.id_auteur = 100*/

--Part 1
select t1.no_livre, count(t3.nombre_exemplaire) as 'Nombre d exemplaire'
from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre
              inner join Edition t3 on t3.id_edition = t2.id_edition
			  where t1.no_livre = 1
group by t1.no_livre

--Part 2
select count(no_edition) 
from livre 
where no_livre = 1

--Part 3
select t1.no_livre, sum(t3.nombre_exemplaire) as 'Nombre d exemplaire'
from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre
              inner join Edition t3 on t3.id_edition = t2.id_edition
			  where t1.no_livre = 1
group by t1.no_livre

select titre 
from Livre 
where no_livre = 1
group by titre

	select  e.no_edition,e.nombre_exemplaire from Edition e
	inner join Livre l on l.no_edition=e.no_edition
	where l.no_livre=1
	group by e.no_edition,e.nombre_exemplaire
select count(distinct no_edition) from Livre where no_livre=1
select * from livre
select * from Edition
select t1.titre, t3.nombre_exemplaire 
from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre inner join 
Edition t3 on t3.id_edition = t2.id_edition
 where t2.id_edition = 20

 select * from Commandes

 select count(t3.no_edition) as 'Nombre d edition'
from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre
              inner join Edition t3 on t3.id_edition = t2.id_edition
			  where t1.no_livre = 1

select t3.no_edition,t3.nombre_exemplaire
from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre
              inner join Edition t3 on t3.id_edition = t2.id_edition
			  where t1.no_livre = 1

	select distinct count(no_edition) from Edition where
	no_edition in(select no_edition from Livre where no_livre=1)

	select * from Livre where no_livre=1
	select count(t3.no_edition),sum (t3.nombre_exemplaire)
	from Livre t1 inner join LivreEdition t2 on t1.id_livre = t2.id_livre
              inner join Edition t3 on t3.id_edition = t2.id_edition
			  where t1.no_livre = 1
