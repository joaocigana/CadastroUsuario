CREATE TABLE IF NOT EXISTS public.pessoa
(
    id integer NOT NULL DEFAULT nextval('users_id_seq'::regclass),
    firstname character varying(40) COLLATE pg_catalog."default",
    lastname character varying(40) COLLATE pg_catalog."default",
    document_type character varying(15) COLLATE pg_catalog."default",
    document character varying(40) COLLATE pg_catalog."default",
    birth_date date,
    phone character varying(20) COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.pessoa
    OWNER to postgres;