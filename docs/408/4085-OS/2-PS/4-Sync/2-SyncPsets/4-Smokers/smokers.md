
# Cigarette Smoker's Problem

- [https://www.cs.umd.edu/~hollings/cs412/s96/synch/smokers.html](https://www.cs.umd.edu/~hollings/cs412/s96/synch/smokers.html)

## sol

```
semaphore agent = 1, mutex = 1;
semaphore smoker_tobacco = smoker_match = smoker_paper = 0;
```

### agent

```c
while (1) {
	P(agent);
	P(mutex);
	int randNum = rand(1, 3); // pick a random number from 1-3
	if (randNum = 1) {
		// put tobacco on table
		// put paper on table
		V(smoker_match); // wake up smoker with match
	} else if ( randNum = 2) {
		// put tobacco on table
		// put match on table
		V(smoker_paper); // wake up smoker with paper
	} else {
		// put match on table
		// put paper on table
		V(smoker_tobacco); // wake up smoker with tobacco
	}
	V(mutex);
}
```

### smoker

```c
while (1) {
	P(smoker_tobacco);
	P(mutex);
	// pick up match
	// pick up paper
	V(mutex);
	// smoke
	V(agent);
}
```

```c
while (1) {
	P(smoker_match);
	P(mutex);
	// pick up tobacco
	// pick up paper
	V(mutex);
	// smoke
	V(agent);
}
```

```c
while (1) {
	P(smoker_paper);
	P(mutex);
	// pick up match
	// pick up tobacco
	V(mutex);
	// smoke
	V(agent);
}
```