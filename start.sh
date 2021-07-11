jjtree -OUTPUT_DIRECTORY=out src/com/doka/doka.jjt &&
javacc -STATIC=true -OUTPUT_DIRECTORY=out out/doka.jj &&

cd out &&
javac *.java &&
java Doka "$@"
