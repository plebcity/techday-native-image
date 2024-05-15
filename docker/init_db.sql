SET client_encoding TO 'UTF8';

\set ON_ERROR_STOP ON

CREATE SCHEMA techday_owner;

SET search_path = techday_owner, pg_catalog;

CREATE USER techday_owner PASSWORD 'techday_owner';

GRANT USAGE ON SCHEMA techday_owner TO techday_owner;
ALTER SCHEMA techday_owner
    OWNER TO techday_owner;

SET search_path = techday_owner, pg_catalog;
