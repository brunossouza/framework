
-- CREATE ALBUM TABLE
CREATE TABLE album(
    id bigserial primary key,
    created timestamp with time zone,
    altered timestamp with time zone,
    title character varying (150) NOT NULL

);


-- CREATE PICTURES TABLE
CREATE TABLE picture(
    id bigserial primary key,
    created timestamp with time zone,
    altered timestamp with time zone,
    path character varying (150) NOT NULL ,
    extension character varying (20),
    size bigint,
    album_id bigint NOT NULL ,
    CONSTRAINT picture_fk FOREIGN KEY (album_id) REFERENCES album (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE
);