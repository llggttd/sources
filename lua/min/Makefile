# makefile for Lua etc

LIB= ./
INC= ./include

CC= gcc
CFLAGS= -O2 -Wall -Wno-unused-value -I$(INC) $(MYCFLAGS)
MYCFLAGS= 
MYLIBS= -lm
RM= rm -f

EXE= main.exe
ALL_O= main.o

default: $(ALL_O)
	$(CC) -o $(EXE) $(ALL_O) -L$(LIB) -llua $(MYLIBS)

main.o:	main.c

clean:
	$(RM) $(ALL_O) $(EXE)

.PHONY: clean