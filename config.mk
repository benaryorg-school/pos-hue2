GCJ:=gcj

CLASSPATH:=src/
RESPATH:=res/
MAINCLASS:=org.benary.java.school.Main

SRCS=$(shell find $(CLASSPATH) -iname '*.java')
CLSS=$(addprefix build/,$(addsuffix .class,$(basename $(SRCS:$(CLASSPATH)%=%))))
OBJS=$(addprefix build/,$(addsuffix .o,$(basename $(SRCS:$(CLASSPATH)%=%))))
JARS=$(shell find $(RESPATH) -iname '*.jar')

JFLAGS:=$(addprefix -I,$(CLASSPATH)) $(addprefix -I,$(JARS))

