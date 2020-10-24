rm -rf out/*;
echo "Compiling Matrix...\n";
javac -d out $(find src -name '*.java');
# javac -d out src/com/step/matrix/Matrix.java;

echo "Compiling MatrixTest...\n";
javac -d out -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar:. $(find test -name '*Test.java');
# javac -d out -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar:. test/com/step/matrix/MatrixTest.java;

CLASSES=$(find test -name '*Test.java' | sed "s/test\///" | sed "s/.java//" | tr "/" ".")

echo "Executing MatrixTest...\n";
java -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar:. org.junit.runner.JUnitCore $CLASSES;
