CREATE TABLE IF NOT EXISTS "config"
(
    "id"           INTEGER   NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name"         TEXT(64)  NOT NULL DEFAULT '',
    "value"        TEXT(256) NOT NULL DEFAULT '',
    "type"         TEXT(32)  NOT NULL DEFAULT '',
    "enable"       INTEGER   NOT NULL DEFAULT 0,
    "time_created" DATETIME  NOT NULL,
    "time_updated" DATETIME  NOT NULL
);


CREATE TABLE IF NOT EXISTS "user"
(
    "id"           INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
    "username"     TEXT(64) NOT NULL DEFAULT '',
    "password"     TEXT(64) NOT NULL DEFAULT '',
    "mobile"       TEXT(32) NOT NULL DEFAULT '',
    "status"       INTEGER  NOT NULL DEFAULT 0,
    "time_created" DATETIME NOT NULL,
    "time_updated" DATETIME NOT NULL
);


CREATE TABLE IF NOT EXISTS "user_role"
(
    "id"           INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
    "user_id"      INTEGER  NOT NULL DEFAULT '',
    "role_id"      INTEGER  NOT NULL DEFAULT '',
    "status"       INTEGER  NOT NULL DEFAULT 0,
    "time_created" DATETIME NOT NULL,
    "time_updated" DATETIME NOT NULL
);

CREATE TABLE IF NOT EXISTS "role"
(
    "id"           INTEGER   NOT NULL PRIMARY KEY AUTOINCREMENT,
    "role_name"    TEXT(128) NOT NULL DEFAULT '',
    "role_sign"    TEXT(128) NOT NULL DEFAULT '',
    "description"  TEXT(256) NOT NULL DEFAULT '',
    "status"       INTEGER   NOT NULL DEFAULT 0,
    "time_created" DATETIME  NOT NULL,
    "time_updated" DATETIME  NOT NULL
);


CREATE TABLE IF NOT EXISTS "role_resource"
(
    "id"           INTEGER  NOT NULL PRIMARY KEY AUTOINCREMENT,
    "role_id"      INTEGER  NOT NULL DEFAULT '',
    "resource_id"  INTEGER  NOT NULL DEFAULT '',
    "status"       INTEGER  NOT NULL DEFAULT 0,
    "time_created" DATETIME NOT NULL,
    "time_updated" DATETIME NOT NULL
);


CREATE TABLE IF NOT EXISTS "resource"
(
    "id"             INTEGER   NOT NULL PRIMARY KEY AUTOINCREMENT,
    "resource_name"  TEXT(128) NOT NULL DEFAULT '',
    "resource_type"  TEXT(128) NOT NULL DEFAULT '',
    "resource_order" INTEGER   NOT NULL DEFAULT 0,
    "resource_icon"  TEXT(128) NOT NULL DEFAULT '',
    "resource_sign"  TEXT(128) NOT NULL DEFAULT '',
    "resource_uri"   TEXT(256) NOT NULL DEFAULT '',
    "parent_id"      INTEGER   NOT NULL DEFAULT 0,
    "status"         INTEGER   NOT NULL DEFAULT 0,
    "time_created"   DATETIME  NOT NULL,
    "time_updated"   DATETIME  NOT NULL
);