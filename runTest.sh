echo "Compiling Matrix...\n";
javac -d out src/com/step/matrix/Matrix.java;

echo "Compiling MatrixTest...\n";
javac -d out -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar:. test/com/step/matrix/MatrixTest.java;

echo "Executing MatrixTest...\n";
java -cp out:lib/hamcrest-core-1.3.jar:lib/junit-4.13.1.jar:. org.junit.runner.JUnitCore com.step.matrix.MatrixTest;
