CREATE DATABASE `Друзья человека`;
USE `Друзья человека`;

DROP TABLE IF EXISTS main_classes;
CREATE TABLE main_classes (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(120) NOT NULL UNIQUE
    ) COMMENT "основные классы животных";
    
INSERT INTO `main_classes` (name) VALUES ("Домашние животные");
INSERT INTO `main_classes` (name) VALUES ("Вьючные животные");


DROP TABLE IF EXISTS animals_classes;
CREATE TABLE animals_classes (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    main_id INT UNSIGNED NOT NULL,
    name_class VARCHAR(120) NOT NULL UNIQUE,
    
    FOREIGN KEY(main_id) REFERENCES main_classes(id)
    ) COMMENT "подклассы животных";

INSERT INTO `animals_classes` (main_id, name_class) VALUES (1, "Собака");
INSERT INTO `animals_classes` (main_id, name_class) VALUES (1, "Кошка");
INSERT INTO `animals_classes` (main_id, name_class) VALUES (1, "Хомяк");
INSERT INTO `animals_classes` (main_id, name_class) VALUES (2, "Лошадь");
INSERT INTO `animals_classes` (main_id, name_class) VALUES (2, "Верблюд");
INSERT INTO `animals_classes` (main_id, name_class) VALUES (2, "Осел");

Select * FROM animals_classes;
DROP TABLE IF EXISTS animals_list;
CREATE TABLE animals_list (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animal_class_id INT UNSIGNED NOT NULL,
    name VARCHAR(120) NOT NULL,
    birthday DATE,
    
    FOREIGN KEY(animal_class_id) REFERENCES animals_classes(id)
) COMMENT "список животных";

INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (1, "Гера", "2019-03-27");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (1, "Нора", "2015-05-17");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (2, "Алиса", "2020-10-02");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (2, "Пушок", "2010-11-18");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (4, "Пуля", "2010-03-13");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (3, "Мышь", "2021-10-11");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (5, "Двугорбый", "2012-08-12");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (3, "Беляш", "2022-01-03");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (4, "Звездочка", "2015-07-04");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (5, "Плевун", "2022-01-03");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (6, "Иа", "2022-01-03");
INSERT INTO `animals_list` (animal_class_id, name, birthday) VALUES (5, "Тормоз", "2022-01-03");

Select * from animals_list;
DROP TABLE IF EXISTS skills_list;
CREATE TABLE skills_list (
	id INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    skill_name VARCHAR(120) NOT NULL
);
INSERT INTO `skills_list` (skill_name) VALUES ("Бегать");
INSERT INTO `skills_list` (skill_name) VALUES ("Сидеть");
INSERT INTO `skills_list` (skill_name) VALUES ("Лежать");
INSERT INTO `skills_list` (skill_name) VALUES ("Рычать");
INSERT INTO `skills_list` (skill_name) VALUES ("Катать верхом");
INSERT INTO `skills_list` (skill_name) VALUES ("Голос");
INSERT INTO `skills_list` (skill_name) VALUES ("Приносить тапки");
INSERT INTO `skills_list` (skill_name) VALUES ("Вертеться");
INSERT INTO `skills_list` (skill_name) VALUES ("Ходить по кругу");
INSERT INTO `skills_list` (skill_name) VALUES ("Перепрыгивать препятствия");
INSERT INTO `skills_list` (skill_name) VALUES ("Ползать");

DROP TABLE IF EXISTS animal_skills;
CREATE TABLE animal_skills (
	animal_id INT UNSIGNED NOT NULL,
    skill_id INT UNSIGNED NOT NULL,
    
    FOREIGN KEY(animal_id) REFERENCES animals_list(id),
    FOREIGN KEY(skill_id) REFERENCES skills_list(id)
);

INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (1, 1);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (1, 4);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (1, 10);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (2, 5);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (2, 1);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (2, 8);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (3, 2);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (3, 9);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (4, 3);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (4, 4);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (4, 7);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (5, 1);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (5, 3);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (5, 7);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (6, 8);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (6, 3);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (7, 6);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (7, 11);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (7, 7);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (8, 1);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (8, 10);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (9, 5);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (9, 6);
INSERT INTO `animal_skills` (animal_id, skill_id) VALUES (9, 1);

DROP FUNCTION IF EXISTS delete_animal;
DELIMITER //
CREATE FUNCTION `delete_animal` (delete_animal_class INT UNSIGNED)
RETURNS INT reads sql data
BEGIN
	DELETE animal_skills
    FROM animal_skills
    JOIN animals_list ON animals_list.id = animal_id
    WHERE animals_list.animal_class_id = delete_animal_class;
    
    DELETE
	FROM animals_list
    WHERE animal_class_id = delete_animal_class;
	    
RETURN delete_animal_class;
END//
DELIMITER ;

SELECT delete_animal(5) AS delete_animal;

SELECT * 
FROM animals_list 
ORDER BY id;


SELECT 
	animals_list.id as ID, 
	animals_classes.name_class as 'Подкласс животного', 
    animals_list.name as 'Имя', 
    animals_list.birthday as 'Дата рождения' 
FROM animals_list
JOIN animals_classes
	on (animal_class_id = animals_classes.id)
WHERE animal_class_id = 4 or animal_class_id = 6;

DROP TABLE IF EXISTS `Молодые животные`;
CREATE TABLE `Молодые животные` (
	Select *, TIMESTAMPDIFF(month, animals_list.birthday, CURRENT_DATE()) as `month`
    from animals_list
    WHERE TIMESTAMPDIFF(month, animals_list.birthday, CURRENT_DATE()) >= 12 and TIMESTAMPDIFF(month, animals_list.birthday, CURRENT_DATE()) < 36
);

SELECT *
FROM `Молодые животные`;

Select *
FROM animals_list
JOIN animals_classes
	on animals_classes.id = animals_list.animal_class_id
JOIN main_classes
	on animals_classes.main_id = main_classes.id
JOIN animal_skills
	on animal_id = animals_list.id
JOIN skills_list
	on skills_list.id = animal_skills.skill_id;