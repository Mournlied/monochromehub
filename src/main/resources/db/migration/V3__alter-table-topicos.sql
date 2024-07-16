ALTER TABLE topicos
    ALTER COLUMN user_id TYPE INTEGER USING (user_id::integer),
    ALTER COLUMN curso_id TYPE INTEGER USING (curso_id::integer);