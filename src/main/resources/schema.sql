
DROP TABLE IF EXISTS LEVEL;

CREATE TABLE LEVEL (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(2500),
  imageUrl VARCHAR(2500),
  defaultQuestionCount INT
);