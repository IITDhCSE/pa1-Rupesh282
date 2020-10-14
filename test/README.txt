----------------------------------------------------------------------------


	Testing the program by generating test cases using TSL generator on category parition method

	Team -: Software Fighters


----------------------------------------------------------------------------


To get all the test case by using file pc.spec-:
Run this command and it will produce pc.spec.tsl where all test cases written:
	./TSLgenerator-linux -c pc.spec



We have to test our program using each cases one by one by diffrentiating on these features as we get test cases=>Words-:


1.Filegiven-: It specifies whether file given or not.

2.Filetype-: By differentiating several file types probability of error increases.

3.File-: It specifies whether the file is empty or not.

4.Sentences-: It species some boundary conditions on Sentences.

5.Words-: It species some boundary conditions on Words.

7.Delimeter-:For special character.

8.Minimum Word lenth-: For not counting the words which is below this number.

For testing the test cases which are most required for functional requirements we have to run file 'tester.py' by using command-:

$python3 tester.py

So in this file 