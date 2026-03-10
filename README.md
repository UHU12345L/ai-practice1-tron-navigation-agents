# Practice 1 - Intelligent Agents in "The Grid" (Tron)

**Course:** Artificial Intelligence (Inteligencia Artificial)  
**Practice:** Practice 1 - Agent Navigation in Tron  
**University:** Universidad de Huelva  
**Year:** 2025-2026  

## 📄 Description
Agent-based simulation inspired by the Tron universe. A "Light Cycle" must navigate a grid from its starting position to the exit portal (S). Every move leaves a trail (.) that becomes a permanent wall, so the agent cannot backtrack. Hitting a wall or trail ends the game.

## 🎯 Learning Objectives
- Understanding intelligent agent architecture (perception → thinking → action)
- Implementing reactive agents with random decision-making among valid moves
- Implementing greedy agents using Manhattan distance heuristic
- Working with grid-based environments and dynamic obstacles
- Comparing behaviour between random reactive and heuristic-driven agents

## 🗺️ Maps Available
- **MAPA_CALLEJON:** Small trap map with a dead-end corridor
- **MAPA_GRANDE:** Large maze requiring careful navigation

## 🤖 Agents Implemented
- **AgenteInteractivo:** Manual agent controlled via keyboard (N/S/E/O)
- **AgenteReactivo:** Checks all 4 neighbours, collects valid moves, picks one randomly
- **AgenteGreedy:** Picks the valid neighbour with minimum Manhattan distance to the goal

## 💻 Technologies Used
- **Language:** Java
- **IDE:** Eclipse / IntelliJ
- **Package:** P0

## 🚀 How to Run
1. Clone the repository
2. Open the project in Eclipse or IntelliJ
3. Run `Tron.java`
4. Select the desired map and agent in `main()`
5. Input directions via console (interactive agent): `N` (North), `S` (South), `E` (East), `O` (West)

## 📁 Project Structure
```
src/
└── P0/
    ├── Tron.java                  # Main simulation loop
    ├── Entorno.java               # Game engine (grid, rules, physics)
    ├── AgenteInteractivo.java     # Interactive keyboard-controlled agent
    ├── AgenteReactivo.java        # Reactive agent with random valid moves
    ├── AgenteGreedy.java          # Greedy agent using Manhattan distance
    └── package-info.java
```

## 🧠 What I Learned
- Agent perception-action cycle design
- Validating moves against dynamic environment state using `esTransitable()`
- Random selection among valid actions with fixed-size arrays
- Manhattan distance heuristic for goal-directed navigation
- Why greedy agents can get trapped without backtracking
- Structuring a Java project with packages
