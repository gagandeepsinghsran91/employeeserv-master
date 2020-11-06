DROP TABLE IF EXISTS EMPLOYEES;
DROP TABLE IF EXISTS ADDRESS;

CREATE TABLE EMPLOYEES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  date_of_birth DATE NOT NULL
);

CREATE TABLE ADDRESS (
  id INT   PRIMARY KEY,
  line1 VARCHAR(250) NOT NULL,
  line2 VARCHAR(250) DEFAULT NULL,
  city  VARCHAR(250),
  state VARCHAR(250),
  country VARCHAR(250),
  zip_code VARCHAR(20),
   FOREIGN KEY (id) REFERENCES EMPLOYEES(id)
);