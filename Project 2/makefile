JFLAGS = -g
JC = javac
JUNIT = /usr/share/java/junit4.jar:.
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	AVLTree.java \
	ByteCounter.java \
	HuffmanNode.java \
	HuffmanList.java \
	HuffmanCode.java \
	HuffmanCoder.java

TESTS = \
	AVLTreeTest.java \
	ByteCounterTest.java \
	HuffmanCodeTest.java \
	ByteCounterFundTest.java \
	HuffmanCodeFundTest.java \
	HuffmanCoderFundTest.java \
	HuffmanListFundTest.java \
	HuffmanNodeFundTest.java

default:classes

classes:$(CLASSES:.java=.class)

test:
	$(JC) -cp $(JUNIT) $(TESTS)
	java -cp $(JUNIT) org.junit.runner.JUnitCore $(TESTS:.java=)

clear:
	$(RM) *.class
	$(RM) *.java~
