DROP TABLE IF EXISTS UserRole;

CREATE TABLE UserRole (
  id mediumint not null auto_increment,
  userId varchar (255) not null,
  roleId mediumint not null,
  version mediumint not null,
  createdBy varchar (255) not null,
  created timestamp not null,
  modifiedBy varchar (255),
  modified timestamp default current_timestamp,
  deletedBy varchar (255),
  primary key (id)
);

DROP TABLE IF EXISTS Role;

CREATE TABLE Role (
  id mediumint not null auto_increment,
  name varchar (255) not null,
  version mediumint not null,
  createdBy varchar (255) not null,
  created timestamp not null,
  modifiedBy varchar (255),
  modified timestamp default current_timestamp,
  deletedBy varchar (255),
  primary key (id)
);

DROP TABLE IF EXISTS Authority;

CREATE TABLE Authority (
  id mediumint not null auto_increment,
  name varchar (255) not null,
  roleId mediumint not null,
  version mediumint not null,
  createdBy varchar (255) not null,
  created timestamp not null,
  modifiedBy varchar (255),
  modified timestamp default current_timestamp,
  deletedBy varchar (255),
  primary key (id)
);
