JFLAGS = -g
JC = javac
JUNIT = /usr/share/java/junit4.jar:.
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $.java

CLASSES = \
	LLNode.java \
	NumArrayList.java \
	NumLinkedList.java \
	NumList.java \
	NumSet.java

TESTS = \
	NumArrayListFundTest.java \
	NumLinkedListFundTest.java \
	NumSetTest.java

default:classes

classes:$(CLASSES:.java=.class)

test:
	$(JC) -cp $(JUNIT) $(TESTS)
	java -cp /usr/share/java/junit4.jar:. org.junit.runner.JUnitCore $(TESTS:.java=)

clear:
	$(RM) *.class
	$(RM) *.java~
