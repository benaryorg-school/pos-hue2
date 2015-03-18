GCJ:=gcj

CLASSPATH:=src/
MAINCLASS:=org.benary.java.school.wow.what.is.that.strange.name.of.that.pkg.why.am.i.doing.those.horrible.things.like.writing.my.code.in.such.a.pkg.declaration.VeryPrivateAndEncapsulatedWindowClassWhichDoesOnlyContainAMainMethodBecauseIAmProgrammingCStyle

JFLAGS:=--classpath=$(CLASSPATH)

SRCS=$(shell find $(CLASSPATH) -iname '*.java')
CLSS=$(addprefix build/,$(addsuffix .class,$(basename $(SRCS:$(CLASSPATH)%=%))))
OBJS=$(addprefix build/,$(addsuffix .o,$(basename $(SRCS:$(CLASSPATH)%=%))))

