ALTER TABLE topicos
    ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES usuarios (user_id);