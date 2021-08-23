CREATE TABLE users(
    id bigserial NOT NULL PRIMARY KEY,
    altered timestamp without time zone,
    created timestamp without time zone NOT NULL,
    name character varying(200) NOT NULL,
    password character varying(300) NOT NULL,
    username character varying(100) UNIQUE
);

CREATE TABLE album(
    id bigserial NOT NULL PRIMARY KEY,
    altered timestamp without time zone,
    created timestamp without time zone NOT NULL,
    title character varying(300) NOT NULL,
    user_id bigint,
    CONSTRAINT user_album_fk FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE picture(
    id bigserial NOT NULL PRIMARY KEY,
    altered timestamp without time zone,
    created timestamp without time zone NOT NULL,
    extension character varying(20),
    path character varying(400) NOT NULL,
    size bigint,
    user_id bigint,
    CONSTRAINT user_picture_fk FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE album_pictures(
    album_id bigint NOT NULL,
    pictures_id bigint NOT NULL,
    CONSTRAINT picture_id_unique UNIQUE (pictures_id),
    CONSTRAINT picture_fk FOREIGN KEY (pictures_id)
        REFERENCES picture (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT album_fk FOREIGN KEY (album_id)
        REFERENCES album (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE post(
    id bigserial NOT NULL PRIMARY KEY,
    altered timestamp without time zone,
    created timestamp without time zone NOT NULL,
    message text NOT NULL,
    title character varying(255) NOT NULL,
    user_id bigint,
    CONSTRAINT user_post_fk FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);

CREATE TABLE comment(
    id bigserial NOT NULL PRIMARY KEY,
    altered timestamp without time zone,
    created timestamp without time zone NOT NULL,
    message character varying(500) NOT NULL ,
    post_id bigint,
    user_id bigint,
    CONSTRAINT user_comment_fk FOREIGN KEY (user_id)
        REFERENCES users (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT post_comment_fk FOREIGN KEY (post_id)
        REFERENCES post (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
);