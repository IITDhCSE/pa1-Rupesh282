Filegiven:
	given.		[property file]
	notgiven.	[single][property notfile]				

Filetype:
		TextFile.					[if file][property textfile]
		NontextFile.				[if file][error]

File:
	empty.		[if textfile][property empty]			
	nonempty.	[if textfile][property goodfile]

FeaturesOfFile:
	Sentences:	
		NoSentence.		[if textfile][if empty][property nosentence]
		OneSentence.	[if textfile][if goodfile][property sentence]
		Sentence<10.[if textfile][if goodfile][property sentence]
		Sentence>10.[if textfile][if goodfile][property sentence]
			Words:
				NoWord			[if textfile][if empty][if !sentence]
				Singleword.		[if textfile][if goodfile][if sentence]
				EverywordLen<MinWordLength. [if textfile][if goodfile][if sentence]
				EverywordLen>MinWordLength.[if textfile][if goodfile][if sentence]
	SentenceProp:
		AtEndContains=DelimeterProvided. [if textfile][if goodfile][if sentence]
		AtEndContains!=DelimeterProvided. [if textfile][if goodfile][if sentence]
		AtEndNewLine.		[if textfile][if goodfile][if sentence]
		AtEndTab.			[if textfile][if goodfile][if sentence]