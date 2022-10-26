# Data Structures and Algorithms

## Agenda
* Hash table
* Trees
	* Terminologies
	* BST implementation

## Interview Questions
* Count occurrences of each word in the file.
	* Input
		```
		red green blue
		red red green
		red green blue
		```
	* Output
		```
		red=4
		green=3
		blue=2
		```
* HashTable
	* red = 4
	* green = 3
	* blue = 2
```Java
HashMap<String,Integer> map = new HashMap<>();
File file = new File(filePath);
Scanner sc = new Scanner(file);
while(sc.hasNext()) {
	String word = sc.next();
	Integer count = map.get(word);
	if(count == null)
		map.put(word, 1);
	else
		map.put(word, count + 1);
}
System.out.println(map);
```

