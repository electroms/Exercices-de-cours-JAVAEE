create table Classe (
  id bigint(20) Auto_increment NOT NULL,
  nom varchar(255),
  primary key(id)
) engine=InnoDB;

create table Peage (
  id bigint(20) Auto_increment NOT NULL,
  nom varchar(255),
  primary key(id)
) engine=InnoDB;

create table Tarif (
  id bigint(20) Auto_increment NOT NULL,
  montant float,
  dateEffet date,
  classe_id bigint(20),
  peage_entree_id bigint(20),
  peage_sortie_id bigint(20),
  primary key(id),
  foreign key(classe_id) references Classe(id),
  foreign key(peage_entree_id) references Peage(id),
  foreign key(peage_sortie_id) references Peage(id)
) engine=InnoDB;