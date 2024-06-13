CREATE TABLE IF NOT EXISTS person (
	id VARCHAR(255) NOT NULL,
	name VARCHAR(255),
	age INTEGER,
	gender VARCHAR(1),
	address VARCHAR(255),
	"type" VARCHAR(255),
	PRIMARY KEY (id)
);

ALTER TABLE "user"
  ADD COLUMN person_id VARCHAR(255);

ALTER TABLE "user"
  ADD CONSTRAINT FK_person_id
  FOREIGN KEY (person_id)
  REFERENCES person (id);