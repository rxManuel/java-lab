# Paradigms for interview problems
## About
This repository offers examples of how to solve common programming challenges using different **programming paradigms** and **problem-solving strategies**.  
The primary language used is **Java**, with a focus on writing clear and idiomatic code.

Each problem is solved in multiple ways to highlight:

- The differences between **imperative** (_procedural_) and **declarative** (_functional_) programming styles
- The use of strategies such as **dynamic programming**, **concurrency**, and the more traditional _iterative_ approach.

While many of the problems are similar to those found in coding interviews, the goal of this project is broader:  
to teach effective programming techniques, paradigms, and structured problem solving.

### Goals

- Serve as a practical resource for learning **Java**
- Introduce and compare **programming paradigms**
- Explore common **problem-solving strategies**
- Help developers prepare for **technical interviews** through deeper understanding
- Encourage writing clean, maintainable, and well-structured code

---

This repository is ideal for:

- Students and self-learners looking to improve their Java skills
- Developers interested in exploring different paradigms
- Anyone preparing for interviews

## How It's Organized
Each code file is organized following a consistent structure:
-  **Package**: `problem` Each Java package represents a specific exercise (e.g. _primeNumber_).
   - **Subpackage**:  `paradigm` Inside each problem package, a subpackage defines the programming paradigm used (e.g., imperative or declarative).
        - **Classical**: A verbose and highly commented solution that illustrates the basic, straightforward way to solve the problem.
        - **Dynamic**: A version using dynamic programming techniques, memoization or caching.
        - **Concurrent / Parallel**: A version that introduces concurrency or parallelism, often using threads or parallel streams.

## Path to follow
### Students / novice
1. [`Classical Imperative prime number`](./src/main/java/primenumber/imperative/Classical.java)
2. [`Dynamic Imperative prime number`](./src/main/java/primenumber/imperative/Dynamic.java)
3. [`Classical Declarative prime number`](./src/main/java/primenumber/declarative/Classical.java)
4. [`Classical Imperative perfect number`](./src/main/java/perfectnumber/imperative/Classical.java)
5. [`Parallel prime number`](./src/main/java/primenumber/declarative/Parallel.java)
6. [`Classical Declarative perfect number`](./src/main/java/perfectnumber/declarative/Classical.java)
7. [`Concurrent prime number`](./src/main/java/primenumber/imperative/Concurrent.java)

### Curious about Java Streams and Functional Java Programming 
1. [`Classical Imperative perfect number`](./src/main/java/perfectnumber/imperative/Classical.java)
2. [`Classical Declarative prime number`](./src/main/java/primenumber/declarative/Classical.java)
3. [`Parallel prime number`](./src/main/java/primenumber/declarative/Parallel.java)
4. [`Classical Declarative perfect number`](./src/main/java/perfectnumber/declarative/Classical.java)
   


