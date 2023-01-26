INSERT INTO person (id, name, patronymic, surname, last_surname, birthday, deathday, gender)
VALUES (gen_random_uuid(), 'Петя', 'Петрович', 'Петров', null, '2000-01-01', null, 1),
    (gen_random_uuid(), 'Анна', 'Анатольевна', 'Петрова', 'Иванова', '2002-01-01', null, 2),
    (gen_random_uuid(), 'Анатолий', 'Семенович', 'Иванов', null, '1920-01-01', '2000-01-01', 1);