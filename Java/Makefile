all:
	javac *.java
	jar cvfm Game.jar MANIFEST.MF *.class
#	jar umf MANIFEST.MF Game.jar
	java -jar Game.jar

clean:
	rm *.class *.jar

doc: *.java
	rm doc/* -rf
	javadoc  -encoding UTF-8 -charset UTF-8 -author *.java
	mv *.html *.css package-list resources doc/
	xdg-open doc/index.html
