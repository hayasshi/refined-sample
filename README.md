## Refined sample

### Run benchmark

```
sbt "jmh:run -i 20 -wi 10 -f1 -t1"
```

### Project structure

```
├── README.md
├── build.sbt
├── project
│   ├── Dependencies.scala
│   ├── build.properties
│   └── plugins.sbt
└── src
    ├── main
    │   └── scala
    │       └── com
    │           └── github
    │               └── hayasshi
    │                   ├── RefinedSampleMain.scala
    │                   ├── assertion
    │                   │   └── AssertionUser.scala
    │                   └── refined
    │                       └── RefinedUser.scala
    └── test
        └── scala
```
