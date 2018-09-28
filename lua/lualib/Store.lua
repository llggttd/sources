local SQLite3 = require('lsqlite3')
local _M = {}
local mt = { __index = _M }

local path = 'D:\\WWW\\lua\\config.sqlite'
local db = nil

function init()
    db = SQLite3.open(path)
    db:exec('CREATE TABLE IF NOT EXISTS store ( "id" integer NOT NULL PRIMARY KEY AUTOINCREMENT, "key" text(64) NOT NULL, "value" text(1024) NOT NULL, "date_create" integer, "date_modify" integer )')
end

function _M.set(self, key, value)
    local stmt = db:prepare("SELECT COUNT(1) FROM store WHERE key = ?")
    stmt:bind_values(key)
    stmt:step()
    local r = stmt:get_uvalues()
    if r <= 0 then
        stmt = db:prepare('INSERT INTO store VALUES (NULL, ?, ?, ?, ?)')
        stmt:bind_values(key, value, os.time(), os.time())
        stmt:step()
    else
        stmt = db:prepare('UPDATE store SET value = ?, date_modify = ? WHERE key = ?')
        stmt:bind_values(value, os.time(), key)
        stmt:step()
    end
end

function _M.get(self, key, defaultValue)
    local stmt = db:prepare("SELECT * FROM store WHERE key = ?")
    stmt:bind_values(key)
    if stmt:step() == SQLite3.DONE then
        if defaultValue then
            return defaultValue
        end
        return nil
    end
    return stmt:get_named_values()
end

function _M.create(self, name)
    local object = {}
    setmetatable(object, mt)
    init()
    return object
end

return _M