CREATE TABLE IF NOT EXISTS person (
    id uuid PRIMARY KEY,
    name text NOT NULL,
    patronymic text NOT NULL,
    surname text NOT NULL,
    last_surname text,
    birthday date NOT NULL,
    gender int NOT NULL,
    deathday date,
    father_id uuid,
    mother_id uuid,
    about text,
    update_timestamp timestamptz NOT NULL DEFAULT now()
);

COMMENT ON TABLE person IS 'Таблица с людьми';
COMMENT ON COLUMN person.id IS 'Уникальный идентификатор человека';
COMMENT ON COLUMN person.name IS 'Имя';
COMMENT ON COLUMN person.patronymic IS 'Отчество';
COMMENT ON COLUMN person.surname IS 'Фамилия';
COMMENT ON COLUMN person.last_surname IS 'Прошлая фамилия (если менялась после свадьбы)';
COMMENT ON COLUMN person.birthday IS 'Дата рождения человека';
COMMENT ON COLUMN person.deathday IS 'Дата смерти человека';
COMMENT ON COLUMN person.gender IS 'Гендер человека (мальчик/девочка)';
COMMENT ON COLUMN person.father_id IS 'Ссылка на ID папы';
COMMENT ON COLUMN person.mother_id IS 'Ссылка на ID мамы';
COMMENT ON COLUMN person.about IS 'О человеке';
COMMENT ON COLUMN person.update_timestamp IS 'Дата и время последнего редактирования';