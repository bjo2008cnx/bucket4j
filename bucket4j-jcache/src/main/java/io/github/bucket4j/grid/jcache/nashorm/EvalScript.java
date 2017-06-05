package io.github.bucket4j.grid.jcache.nashorm;

import javax.script.*;

public class EvalScript {

    public static void main(String[] args) throws Exception {
        // create a script engine manager
        ScriptEngineManager factoryManager = new ScriptEngineManager();

        // create a Nashorn script engine
        ScriptEngine engine = factoryManager.getEngineByName("nashorn");
        engine.put("name", "vladimir");


        CompiledScript compiledScript = ((Compilable) engine).compile("print('Hello ' + name + '!');");
        compiledScript.eval();
    }

}
