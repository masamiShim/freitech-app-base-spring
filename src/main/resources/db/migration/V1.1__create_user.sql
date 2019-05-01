DROP TABLE IF EXISTS User;

CREATE TABLE User (
  version mediumint not null,
  userId varchar (255) not null,
  email varchar (255) not null,
  password varchar (255) not null,
  enabled bit,
  locked bit,
  expired bit,
  createdBy varchar (255) not null,
  created timestamp not null,
  modifiedBy varchar (255),
  modified timestamp default current_timestamp ,
  deletedBy varchar (255),
  primary key (userId)
);