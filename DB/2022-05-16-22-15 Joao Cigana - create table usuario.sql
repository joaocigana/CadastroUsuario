CREATE TABLE IF NOT EXISTS public.usuario
(
    id integer NOT NULL DEFAULT nextval('usuario_id_seq'::regclass),
    username character varying(70) COLLATE pg_catalog."default",
    email character varying(70) COLLATE pg_catalog."default",
    senha character varying(70) COLLATE pg_catalog."default",
    pessoa_id integer,
    CONSTRAINT usuario_pkey PRIMARY KEY (id),
    CONSTRAINT usuario_pessoa_id_fkey FOREIGN KEY (pessoa_id)
        REFERENCES public.pessoa (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.usuario
    OWNER to postgres;