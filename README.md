devfest2014
===========

for Devfest hackathon

(NOTE THAT TO RUN IT IN ECLIPSE AND PROBABLY ELSEWHERE ALSO YOU HAVE TO ADJUST THE MEMORY B/C ECLIPSE ALLOCATES 256MB memory BY DEFAULT... NEED TO ADD -Xmx2048m  under VM arguments)

This project is a way to see how likely it is that a sentence translated through Google translate or Bing's translating tools is actually a gramatically correct sentence. By first identifying the nouns in the Google or Bing translated sentence, and then looking up that phrase/sentence on Google, it shows the user how frequently used that sentence structure has been used online by giving the user the number of search results. 

To use this project, the following JAR files are necessary: gtranslateapi-1.0.jar, json-simple-1.1.1.jar, stanford-postagger.jar, microsoft-translator-java-api-0.6.2-jar-with-dependencies.jar, gson-2.2.4-sources.har, gson-2.2.4-javadoc.jar, gson-2.2.4.jar.

Also note that the tagger file is filled with french and german taggers that are given from the Stanford postagger API.

Running the program launches a GUI, in which you enter the sentence on the left side, and click the button that corresponds to the language you want the sentence translated into. WE DID NOT DO BASICALLY ANY ERROR CHECKING. IT IS REALLY LATE/EARLY.




