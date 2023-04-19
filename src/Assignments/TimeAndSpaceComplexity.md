# Question 1 :- Analyze the time complexity of the given code and suggest a way to imporve it 
```bash 
int sum = 0;
for(int i = 1; i <= n; i++) {
for(int j = 1; j <= i; j++) {
sum++;
}
}
```
**Answer** :- The Time Complexity of the given code is O(n^2) and we can improve it by using the formula (n*(n+1))/2 

