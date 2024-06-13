CREATE TABLE IF NOT EXISTS visit (
  id VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  "date" TIMESTAMP NOT NULL,
  aproved BOOLEAN NOT NULL,
  elderly_id VARCHAR(255) NOT NULL,
  responsable_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE visit
  ADD CONSTRAINT FK_elderly_id
  FOREIGN KEY (elderly_id)
  REFERENCES person (id);
  
ALTER TABLE visit
  ADD CONSTRAINT FK_responsable_id
  FOREIGN KEY (responsable_id)
  REFERENCES person (id);