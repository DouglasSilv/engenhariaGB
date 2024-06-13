CREATE TABLE IF NOT EXISTS activity (
  id VARCHAR(255) NOT NULL,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  "date" TIMESTAMP NOT NULL,
  finished BOOLEAN NOT NULL,
  elderly_id VARCHAR(255) NOT NULL,
  nurse_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

ALTER TABLE activity
  ADD CONSTRAINT FK_elderly_id
  FOREIGN KEY (elderly_id)
  REFERENCES person (id);
  
ALTER TABLE activity
  ADD CONSTRAINT FK_nurse_id
  FOREIGN KEY (nurse_id)
  REFERENCES person (id);