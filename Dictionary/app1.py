import json

data=json.load(open("data.json"))

def translate(w):
    w=w.lower()
    if w in data:
        return data[w]
    else:
        return "the word u entered does not exist."
word=input("enter what u want : ")

output=translate(word)

if type(output)==list:

    for item in output:
        print(item)
else:
    print(output)