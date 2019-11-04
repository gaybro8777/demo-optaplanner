# Demo OptaPlanner

<img src="README.png" alt="Objective" style="width: 100%;"/>

* [Documentation](doc/)
  * [Setup](doc/setup.md)
  * [Wordbooks](doc/wordbooks/README.md)
  * [Plans](doc/plans/)
    * [Bootstrapping - WIP](doc/plans/bootstrapping.md)
    * [Objects UML diagram - WIP](doc/plans/objects.png)

## Example

When the app runs, it creates a demo constraint satisfaction problem, then solves it.

The constraint satisfaction problem is how to match makers (a.k.a. producers) with takers (a.k.a. consumers). 


### Initialization

Initialization of facts:

  * Create 10 makers. These are named 0 to 9.

  * Create 10 takers. These are named 0 to 9.

Initialization of planning entities:

  * Create 10 matchers. Each matcher can associate a maker and taker.

  * Each matcher is loaded with a corresponding maker, because this represents the facts i.e. we want to match all the makers.
  
  * Each matcher has null for the taker, because this is the planning variable i.e. we want to try to match on various takers.


### Running

Scorer pseudocode:

  * Score each matcher by comparing its maker and taker.
  
  * When the maker name and taker name are equal, then score +1 soft, else score -1 soft.

  * The scorer will maximize matchers that associate a maker and taker with the same name.

Solution pseudocode:

  * Create an OptaPlanner solver, and load it with the makers, takers, matchers, etc.

  * Create a timeout of 1 minute. This is fine for the demo small scale.

  * The solver will try associating the matchers with various takers, then report results.


### Run

Run the app:

```sh
java \
    -classpath "$CLASSPATH:./target/demo_optaplanner-1.0-SNAPSHOT.jar" \
    -Dorg.slf4j.simpleLogger.defaultLogLevel=warn  \
    com.joelparkerhenderson.demo.optaplanner.App
```

### Output

The output shows the solution successfully associates all makers and takers.

The score `0hard` means the hard constraint score is 0, which is correct because the scorer had no hard contraints.

The score `10soft` means the soft constraint score is 10, which is correct because the solver matched all 10 makers and takers.

Output with log level info:

```sh
Demo OptaPlanner version 1.0.0

Initialize...
    name:Demo Solution,
    score:(0hard/0soft),
    matchers:[
        matcher:{name:0,maker:{name:0},taker:{null}},
        matcher:{name:1,maker:{name:1},taker:{null}},
        matcher:{name:2,maker:{name:2},taker:{null}},
        matcher:{name:3,maker:{name:3},taker:{null}},
        matcher:{name:4,maker:{name:4},taker:{null}},
        matcher:{name:5,maker:{name:5},taker:{null}},
        matcher:{name:6,maker:{name:6},taker:{null}},
        matcher:{name:7,maker:{name:7},taker:{null}},
        matcher:{name:8,maker:{name:8},taker:{null}},
        matcher:{name:9,maker:{name:9},taker:{null}}]
Solved...
    name:Demo Solution,
    score:(0hard/10soft),
    matchers:[
        matcher:{name:0,maker:{name:0},taker:{name:0}},
        matcher:{name:1,maker:{name:1},taker:{name:1}},
        matcher:{name:2,maker:{name:2},taker:{name:2}},
        matcher:{name:3,maker:{name:3},taker:{name:3}},
        matcher:{name:4,maker:{name:4},taker:{name:4}},
        matcher:{name:5,maker:{name:5},taker:{name:5}},
        matcher:{name:6,maker:{name:6},taker:{name:6}},
        matcher:{name:7,maker:{name:7},taker:{name:7}},
        matcher:{name:8,maker:{name:8},taker:{name:8}},
        matcher:{name:9,maker:{name:9},taker:{name:9}}]
```

## Integration

Integration via XML is work in progress.

Example:

```xml
<maker>
  <name>x</name>
</maker>

<makerSet>
  <name>x</name>
</makerSet>

<taker>
  <name>x</name>
</taker>

<takerSet>
  <name>x</name>
</takerSet>

<matcher>
  <name>Foo</name>
</matcher>

<solution>
  <name>Foo</name>
  <score>
    <initScore>0</initScore>
    <hardScore>0</hardScore>
    <softScore>0</softScore>
  </score>
</solution>
