/*
* min.c -- a minimal Lua interpreter
* loads stdin only with minimal error handling.
* no interaction, and no standard library, only a "print" function.
*/

#include <stdio.h>

#include "lauxlib.h"
#include "lualib.h"

int main(void)
{
  lua_State *L = lua_open();
  luaL_openlibs(L);
  luaL_dofile(L, "init.lua");
  lua_close(L);
  return 0;
}
