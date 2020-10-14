import os

print("-------------------------------")
file = "TestFiles/English.txt"
os.system("java -jar jars/avglength.jar " + file + " . 3 ")
print("-------------------------------")
file = "TestFiles/Empty.txt"
os.system("java -jar jars/avglength.jar " + file + " . 3 ")
print("-------------------------------")
file = "TestFiles/Chinese.txt"
os.system("java -jar jars/avglength.jar " + file + " . 3 ")
print("-------------------------------")
file = "TestFiles/Image.jpg"
os.system("java -jar jars/avglength.jar " + file + " . 3 ")
print("-------------------------------")

