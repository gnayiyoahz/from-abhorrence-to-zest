
import random

def vocab():
    print ('This program helps you expand your vocabulary. ')
    file = open('vocabtest.txt')
    myvocab = []
    for line in file.readlines():
        myvocab.append(line.split())
    l = len(myvocab)
#    print (myvocab)

    while l != 0:
        m = random.randint(0,l-1)
        word = myvocab[m]
        print (word[0])
        
        vocab = input()
        if vocab == 'yes':
            print ('Good job! :) ')
            myvocab.pop(m)
            l = len(myvocab)
#            print (mylist)
        if vocab == 'no':
            print ('Try again later :( ')
        if vocab != 'yes' and vocab !='no':
            print('Please input \'yes\' or \'no\'. ')
    if l == 0:
        print ('Well done!')

vocab ()
