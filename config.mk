GCJ:=gcj

CLASSPATH:=src/
MAINCLASS:=org.benary.java.school.Main

JFLAGS:=--classpath=$(CLASSPATH)

SRCS=$(shell find $(CLASSPATH) -iname '*.java')
CLSS=$(addprefix build/,$(addsuffix .class,$(basename $(SRCS:$(CLASSPATH)%=%))))
OBJS=$(addprefix build/,$(addsuffix .o,$(basename $(SRCS:$(CLASSPATH)%=%))))

