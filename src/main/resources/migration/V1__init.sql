CREATE TABLE IF NOT EXISTS person (
    id uuid PRIMARY KEY,
    name text NOT NULL,
    patronymic text NOT NULL,
    surname text NOT NULL,
    birthday date NOT NULL,
    deathday date,
    father_id uuid,
    mother_id uuid,
    about text,
    update_timestamp timestamptz NOT NULL DEFAULT now()
);