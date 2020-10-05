# card-game

I'm going to explain by backtracking my steps from the main method.
In the main method, I use a conditional for if the argument is classify or simulate

1. Classify mode
The classify mode is entered by running the program with the argument "classify". In my classify method using a while 
loop (that is exited by pressing enter) the user is prompted to enter the 5 numbers(seperated by spaces) and then it is read 
into the code and passed into a method toArray() that makes the string into a sorted array.Now that the array is sorted, 
I first put it through a method called countOcc() which keeps track of the occurence of 1-6 in the array and stores this occurence
in another array called occurence. Notice the largest number in occurence will correspond to the number that appears the most in the array. 
I call this max and pass it into another method called whatOfaKind(). In whatOfaKind, I implement switch cases for 3-5 and this is where I 
set the string,score and start to keep track of the total scores and frequency of each case.The default of the switch sets the score to 0 
which leads us back to the conditional in classify() that puts the list through a method called straightCheck() if the score remians 0 still. 
In straightCheck(), I use a while loop to check how many numbers in the array are consecutive and label and score them accordingly if they fit 
smallstraight or largestraight.Back in classify(), if the score is still 0 after these two, it puts the list into a method called maxsum(). 
maxSum() sums 1-6 consecutively in the array, figures out which sum is the highest and labels it accordingly. Back at classify now that every 
possibility is accounted for, the numbers rolled, best outcome and score is printed out and the user is prompted to quit or continue!!

2. Simulate mode
The simulate mode is entered with 2 arguments.The first is "simulate" the second is a number string that represents the number of rolls you want simulated. 
I parse this stirng and make it an integer. In my simulate() method I also use a while loop that runs the number of rolls. There is a method randArray() that
produces a random sorted array of n numbers (in this case 5). I repeat what I did in classify (putting the array into countOcc(), straightCheck() and maxSum() 
accordingly. Additionaly, I put the stirng through a method called checkFreq(), checkFreq() accumulates the frequency and total score of the sumofno's labels
i.e notice for the other labels the methods do this. After this happens for the number of rolls, I have a couple of print statements ( I tried to think of a way
to make it a loop but couldn't) that prints out the table of
i. best outcome
ii. frequency - which i get by dividing the individual frequencies by runs and multiplying by 100
iii. and average score of each outcome - which i calculate by dividing the total score of each outcome by their respectful frequency.
