# TestTask from p.7 till p.9

CREATE TABLE students (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  score INT NOT NULL,
  emotion VARCHAR(50),
  created TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
);

INSERT INTO students (name, score, emotion)
VALUES
  ('Kevin', 80, 'happy'),
  ('Josh', 90, 'sad'),
  ('Kevin', 85, 'happy'),
  ('Kevin', 75, 'sad'),
  ('Josh', 65, 'angry'),
  ('David', 85, 'happy'),
  ('Josh', 90, 'sad'),
  ('David', 75, 'sad'),
  ('Josh', 85, 'sad'),
  ('Josh', 90, 'happy'),
  ('Kevin', 70, 'sad'),
  ('Kevin', 80, 'sad'),
  ('Kevin', 73, 'angry'),
  ('David', 75, 'sad'),
  ('David', 65, 'sad');

7. Create a Query to find the average score of the data based on each name:

SELECT name, AVG(score) AS avg_score
FROM students
GROUP BY name;

8. Using the data table in question no 7, make a query to find the emotion mode value of
each name:

SELECT name, MODE() WITHIN GROUP (ORDER BY emotion) AS mode_enam
FROM students
GROUP BY name;

9. Using the data table in question no 7, make a query to find the average score and mode
emotion of each name and the same date:

SELECT name, created, AVG(score) AS avg_score, MODE() WITHIN GROUP (ORDER BY emotion) AS mode_enam
FROM students
GROUP BY name, created;
