# mallijib

## Usage

1. Ensure Leiningen is installed and Docker is running locally.
1. Install [jib](https://github.com/GoogleContainerTools/jib).
1. Run Docker Registry:
    ```shell
    $ docker run -d -p 5550:5000 --restart=always --name registry registry:2
    ```
1. Use this function to iterate quickly:
    ```bash
    $ rejib() {
    rm -rf target && lein uberjar &&
    jib jar target/uberjar/mallijib-0.1.0-SNAPSHOT-standalone.jar --target=localhost:5550/mallijib:latest --allow-insecure-registries &&
    docker run --pull "always" --rm localhost:5550/mallijib:latest
    }

    $ rejib
    ```
1. After image is built, pushed to the registry, and ran, you'll see this:
    ```plain
    Exception in thread "main" java.lang.ExceptionInInitializerError
    Caused by: Syntax error macroexpanding at (spec.clj:13:7).
    :malli.core/invalid-schema {:schema #object[clojure.core$int_QMARK_ 0x673218b2 "clojure.core$int_QMARK_@673218b2"]}
    ```


## Full stacktrace
```clojure
Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: Syntax error macroexpanding at (spec.clj:13:7).
:malli.core/invalid-schema {:schema #object[clojure.core$int_QMARK_ 0x673218b2 "clojure.core$int_QMARK_@673218b2"]}
	at clojure.lang.Compiler$InvokeExpr.eval(Compiler.java:3707)
	at clojure.lang.Compiler$MapExpr.eval(Compiler.java:3054)
	at clojure.lang.Compiler$DefExpr.eval(Compiler.java:457)
	at clojure.lang.Compiler.eval(Compiler.java:7182)
	at clojure.lang.Compiler.load(Compiler.java:7636)
	at clojure.lang.RT.loadResourceScript(RT.java:381)
	at clojure.lang.RT.loadResourceScript(RT.java:372)
	at clojure.lang.RT.load(RT.java:459)
	at clojure.lang.RT.load(RT.java:424)
	at clojure.core$load$fn__1738.invoke(core.clj:6126)
	at clojure.core$load.invokeStatic(core.clj:6125)
	at clojure.core$load.doInvoke(core.clj:6109)
	at clojure.lang.RestFn.invoke(RestFn.java:408)
	at clojure.core$load_one.invokeStatic(core.clj:5908)
	at clojure.core$load_one.invoke(core.clj:5903)
	at clojure.core$load_lib$fn__1679.invoke(core.clj:5948)
	at clojure.core$load_lib.invokeStatic(core.clj:5947)
	at clojure.core$load_lib.doInvoke(core.clj:5928)
	at clojure.lang.RestFn.applyTo(RestFn.java:142)
	at clojure.core$apply.invokeStatic(core.clj:667)
	at clojure.core$apply.invoke(core.clj:660)
	at clojure.core$load_libs.invokeStatic(core.clj:5986)
	at clojure.core$load_libs.doInvoke(core.clj:5969)
	at clojure.lang.RestFn.applyTo(RestFn.java:137)
	at clojure.core$apply.invokeStatic(core.clj:667)
	at clojure.core$apply.invoke(core.clj:660)
	at clojure.core$require.invokeStatic(core.clj:6071)
	at clojure.core$require.doInvoke(core.clj:6007)
	at clojure.lang.RestFn.invoke(RestFn.java:408)
	at mallijib.core$eval6747$loading__1604__auto____6748.invoke(core.clj:1)
	at mallijib.core$eval6747.invokeStatic(core.clj:1)
	at mallijib.core$eval6747.invoke(core.clj:1)
	at clojure.lang.Compiler.eval(Compiler.java:7177)
	at clojure.lang.Compiler.eval(Compiler.java:7166)
	at clojure.lang.Compiler.load(Compiler.java:7636)
	at clojure.lang.RT.loadResourceScript(RT.java:381)
	at clojure.lang.RT.loadResourceScript(RT.java:372)
	at clojure.lang.RT.load(RT.java:459)
	at clojure.lang.RT.load(RT.java:424)
	at clojure.core$load$fn__1738.invoke(core.clj:6126)
	at clojure.core$load.invokeStatic(core.clj:6125)
	at clojure.core$load.doInvoke(core.clj:6109)
	at clojure.lang.RestFn.invoke(RestFn.java:408)
	at clojure.lang.Var.invoke(Var.java:384)
	at clojure.lang.Util.loadWithClass(Util.java:251)
	at mallijib.core.<clinit>(Unknown Source)
Caused by: clojure.lang.ExceptionInfo: :malli.core/invalid-schema {:schema #object[clojure.core$int_QMARK_ 0x673218b2 "clojure.core$int_QMARK_@673218b2"]} {:type :malli.core/invalid-schema, :message :malli.core/invalid-schema, :data {:schema #object[clojure.core$int_QMARK_ 0x673218b2 "clojure.core$int_QMARK_@673218b2"]}}
	at malli.core$_fail_BANG_.invokeStatic(core.cljc:119)
	at malli.core$_fail_BANG_.invoke(core.cljc:117)
	at malli.core$_schema.invokeStatic(core.cljc:265)
	at malli.core$_schema.invoke(core.cljc:262)
	at malli.core$schema.invokeStatic(core.cljc:1631)
	at malli.core$schema.invoke(core.cljc:1614)
	at malli.core$_or_schema$reify__9325$fn__9326.invoke(core.cljc:469)
	at clojure.core$mapv$fn__14217.invoke(core.clj:6912)
	at clojure.lang.ArrayChunk.reduce(ArrayChunk.java:58)
	at clojure.core.protocols$eval13800$fn__13801.invoke(protocols.clj:136)
	at clojure.core.protocols$eval13734$fn__13735$G__13725__13744.invoke(protocols.clj:19)
	at clojure.core.protocols$seq_reduce.invokeStatic(protocols.clj:31)
	at clojure.core.protocols$seq_reduce.invoke(protocols.clj:24)
	at clojure.core.protocols$eval13780$fn__13781.invoke(protocols.clj:95)
	at clojure.core.protocols$eval13698$fn__13699$G__13689__13712.invoke(protocols.clj:13)
	at clojure.core$reduce.invokeStatic(core.clj:6828)
	at clojure.core$reduce.invoke(core.clj:6810)
	at clojure.core$mapv.invokeStatic(core.clj:6912)
	at clojure.core$mapv.invoke(core.clj:6903)
	at malli.core$_or_schema$reify__9325._into_schema(core.cljc:469)
	at malli.core$into_schema.invokeStatic(core.cljc:1572)
	at malli.core$into_schema.invoke(core.cljc:1566)
	at malli.core$schema.invokeStatic(core.cljc:1628)
	at malli.core$schema.invoke(core.cljc:1614)
	at malli.core$_parse_entries$_parse__9134$fn__9144.invoke(core.cljc:215)
	at malli.core$_comp$fn__9062.invoke(core.cljc:155)
	at malli.core$_update.invokeStatic(core.cljc:171)
	at malli.core$_update.invoke(core.cljc:171)
	at malli.core$_parse_entries$_parse__9134.invoke(core.cljc:215)
	at clojure.core$mapv$fn__14217.invoke(core.clj:6912)
	at clojure.lang.ArrayChunk.reduce(ArrayChunk.java:58)
	at clojure.core.protocols$eval13800$fn__13801.invoke(protocols.clj:136)
	at clojure.core.protocols$eval13734$fn__13735$G__13725__13744.invoke(protocols.clj:19)
	at clojure.core.protocols$seq_reduce.invokeStatic(protocols.clj:31)
	at clojure.core.protocols$seq_reduce.invoke(protocols.clj:24)
	at clojure.core.protocols$eval13780$fn__13781.invoke(protocols.clj:95)
	at clojure.core.protocols$eval13698$fn__13699$G__13689__13712.invoke(protocols.clj:13)
	at clojure.core$reduce.invokeStatic(core.clj:6828)
	at clojure.core$reduce.invoke(core.clj:6810)
	at clojure.core$mapv.invokeStatic(core.clj:6912)
	at clojure.core$mapv.invoke(core.clj:6903)
	at malli.core$_parse_entries.invokeStatic(core.cljc:222)
	at malli.core$_parse_entries.invoke(core.cljc:210)
	at malli.core$_map_schema$reify__9456._into_schema(core.cljc:681)
	at malli.core$into_schema.invokeStatic(core.cljc:1572)
	at malli.core$into_schema.invoke(core.cljc:1566)
	at malli.core$schema.invokeStatic(core.cljc:1628)
	at malli.core$schema.invoke(core.cljc:1614)
	at malli.core$walk.invokeStatic(core.cljc:1678)
	at malli.core$walk.invoke(core.cljc:1670)
	at malli.util$closed_schema.invokeStatic(util.cljc:131)
	at malli.util$closed_schema.invoke(util.cljc:125)
	at malli.util$closed_schema.invokeStatic(util.cljc:129)
	at malli.util$closed_schema.invoke(util.cljc:125)
	at clojure.lang.AFn.applyToHelper(AFn.java:154)
	at clojure.lang.AFn.applyTo(AFn.java:144)
	at clojure.lang.Compiler$InvokeExpr.eval(Compiler.java:3702)
	... 45 more
```