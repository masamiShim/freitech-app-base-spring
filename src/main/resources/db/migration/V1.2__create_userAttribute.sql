DROP TABLE IF EXISTS UserAttribute;

CREATE TABLE UserAttribute (
  version mediumint not null,
  id mediumint not null auto_increment,
  userId varchar (255) not null,
  firstName varchar (255),
  lastName varchar (255),
  createdBy varchar (255) not null,
  created timestamp not null,
  modifiedBy varchar (255),
  modified timestamp default current_timestamp,
  deletedBy varchar (255),
  primary key (id)
);