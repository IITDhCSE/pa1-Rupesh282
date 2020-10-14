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



To test all cases we used 'tester.py' file 

run tester.py file with $ python3 tester.py


Explanation of all corresponing files & commands in tester.py :

1.  Case 1  : Empty file
2.  Case 2  : non-text file
3.  Case 3  : non-English text file (just adds Warning about lang. used other than English AND runs as usual)
4.  Case 4  : multiple langs. in text file (just adds Warning about langs used other than English AND runs as usual)
5.  Case 5  : Normal text file
6.  Case 6  : Normal text file with empty delimiter (incorrect argument)
7.  Case 7  : Normal text file with delimiter 
8.  Case 8  : Normal text file with multicharacter delimiter
9.  Case 9  : Normal text file with empty min. word length (incorrect argument)
10. Case 10 : Normal text file with word length
11. Case 11 : Normal text file with -ve word length
12. Case 12 : Normal text file with non-interger word length
13. Case 13 : Normal text file with empty delimiter & empty word length
14. Case 14 : Normal text file with empty word length & empty delimiter
15. Case 15 : Normal text file with delimiter & word length 
16. Case 16 : Normal text file with Word length & delimiter





