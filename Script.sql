--<ScriptOptions statementTerminator=";"/>

ALTER TABLE flyway_schema_history DROP INDEX flyway_schema_history_s_idx;

ALTER TABLE flyway_schema_history DROP INDEX PRIMARY;

DROP TABLE flyway_schema_history;

