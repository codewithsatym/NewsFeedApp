DO $$
DECLARE
    -- do not change the tablespace name ----
    --v_tablespace_dts varchar(20) := '{ph_schema}_dts';
    --v_tablespace_mtd varchar(20) := '{ph_schema}_mtd';
    --v_tablespace_ind varchar(20) := '{ph_schema}_ind';

    -- do not change the schema name ----
    v_schema_name_var varchar(50) := 'news';
    --- you can changes the file name ----
    v_filename varchar(100) := 'V202405121318__CREATE_KEYS_ENTITY.sql';
    --- you can changes the file name ----
    c record;

    v_state text;
    v_msg text;
    v_detail text;
    v_hint text;
    v_context text;
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.schemata WHERE schema_name = v_schema_name_var) THEN
        EXECUTE 'CREATE SCHEMA ' || v_schema_name_var;
    END IF;

    EXECUTE 'CREATE TABLE ' || v_schema_name_var || '.keys (
        id SERIAL PRIMARY KEY,
        created_date TIMESTAMP WITH TIME ZONE,
        key_value VARCHAR(255) UNIQUE
    )';
END $$;
