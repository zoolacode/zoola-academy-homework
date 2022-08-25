# Homework 2 (part 1)

- Investigate engine_game_example by running `yarn engine_game_example` and opening `localhost` in browser
- Read `engine.md` documentation and `game.js` sources (pay attention to comments)
- Play around, try adding new functionality (the crazier the better) - to understand how side-effects and reducers work together.

# Homework 2 (part 2)

## Game of Snake

### Rules

- Game must be created using `engine.js` (use `yarn dev` command, it's all there already)
- Size of game area is 25x25 squares
- Snake starts of size 5 squares
- Snake starts at position [10, 10]
- Snake starting direction is [1, 0]
- Snake can eat food and grow by one square
- One piece of food appears whenever snake eats
- One piece of food appears on the board when game starts
- One piece of food appears on the board every 15 seconds even if snake didn't eat the previous one
- Food always appears in places where there is no snake body or other food
- Game ends when snake hits its body, or game board edge, or when 120 seconds elapse
- Game should have visible timer
- Snake moves by one square in one second
- Keyboard arrows can be used to change snake direction
- Spacebar can be used to pause/play the game at any point. When game is on pause 120 seconds timer should also be stopped
- When snake eats food, score is incremented by one
- The current score is displayed somewhere on the user interface
- Snake itself can be designed in a free manner - but it is important that it is clearly visible.

### Details

### Board size

The size of the game board should be:

```
width: 100vh;
height: 100vh;
```

It also should be centered.
Use CSS calc() to calculate width/height of squares based on 100vh divided by number of squares in a row.

#### Location

All coordinates that are mentioned in format [number, number] mean ["x", "y"] where "x" is horizontal and "y" is vertical axis.
For example, initial snake coordinates can be displayed like an array:

```
const snake = [
  [10, 10],
  [10, 11],
  [10, 12],
  [10, 13],
  [10, 14],
]
```

This would mean that the snake tail starts at [10, 10] and its head is at [10, 14] (so it is fully vertical).

#### Direction

In terms of direction, it can be displayed like this:

```
const direction = [0, 1]
```

This would mean that current snake moving direction is vertical (because "x" equals 0 and "y" equals 1).
`[-1, 0]` would mean that snake is moving to the left. `[1, 0]` - to the right.

### Hints

- Use HTML/CSS to display game board and snake. Use `document.createElement` and `classList`.
- Use `display: grid` (ideally) to display squares correctly. `display: flex` should work, too.
- When updating snake location you need to consider current direction
- When changing snake location try deleting from its tail and adding to its head
