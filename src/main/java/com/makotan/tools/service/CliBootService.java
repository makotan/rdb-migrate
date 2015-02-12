package com.makotan.tools.service;

import com.makotan.tools.loader.ModelYamlLoader;
import com.makotan.tools.model.ExecutionMode;
import com.makotan.tools.model.InputType;
import com.makotan.tools.model.OutputType;
import com.makotan.tools.rdbmodel.RdbModel;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import static org.kohsuke.args4j.ExampleMode.ALL;

/**
 * User: makotan
 * Date: 15/02/06
 * Time: 21:24
 */
@Component
public class CliBootService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ModelLoadService modelLoadService;

    @Autowired
    ModelDumpService modelDumpService;

    public static class CliArgs {
        @Option(name="-f" , aliases = {"-config"} , usage = "config file :config.yaml")
        public String configFile;

        @Option(name="-c" , aliases = {"-current"} , usage = "current input :table(jdbc url),current.yaml")
        public String current;

        @Option(name="-cc" , aliases = {"-currentCatalog"} , usage = "current database Catalog")
        public String currentCatalog;

        @Option(name="-cs" , aliases = {"-currentSchema"} , usage = "current database Schema")
        public String currentSchema;

        @Option(name="-n" , aliases = {"-next"} , usage = "next input :table(jdbc url),next.yaml")
        public String next = null;

        @Option(name="-nc" , aliases = {"-nextCatalog"} , usage = "next database Catalog")
        public String nextCatalog;

        @Option(name="-ns" , aliases = {"-nextSchema"} , usage = "next database Schema")
        public String nextSchema;

        @Option(name="-o" , aliases = {"-output"} , usage = "output :table(jdbc url), output.yaml, output.sql")
        public String output;

        @Option(name="-oc" , aliases = {"-outputCatalog"} , usage = "output database Catalog")
        public String outputCatalog;

        @Option(name="-os" , aliases = {"-outputSchema"} , usage = "output database Schema")
        public String outputSchema;

        @Option(name="-m" , aliases = {"-outputmode"} , usage = "output mode flyway(sql)/detail(yaml)")
        public String outputMode = null;

        @Override
        public String toString() {
            return "CliArgs{" +
                    "current='" + current + '\'' +
                    ", currentCatalog='" + currentCatalog + '\'' +
                    ", currentSchema='" + currentSchema + '\'' +
                    ", next='" + next + '\'' +
                    ", nextCatalog='" + nextCatalog + '\'' +
                    ", nextSchema='" + nextSchema + '\'' +
                    ", output='" + output + '\'' +
                    ", outputCatalog='" + outputCatalog + '\'' +
                    ", outputSchema='" + outputSchema + '\'' +
                    ", outputMode='" + outputMode + '\'' +
                    '}';
        }
    }


    public void start(String args[]) {
        CliArgs cliArgs = new CliArgs();
        CmdLineParser parser = new CmdLineParser(cliArgs);

        // if you have a wider console, you could increase the value;
        // here 80 is also the default
        parser.setUsageWidth(120);

        try {
            // parse the arguments.
            parser.parseArgument(args);

            ExecutionMode em = getExecutionMode(cliArgs , parser);

            // you can parse additional arguments if you want.
            // parser.parseArgument("more","args");

            // after parsing arguments, you should check
            // if enough arguments are given.
            //if( arguments.isEmpty() )
                //throw new CmdLineException(parser,"No argument is given");

            RdbModel rdbModel = modelLoadService.loadModel(em.currentType, em.current);

            if (em.executeMode == ExecutionMode.ExecuteMode.copy) {
                modelDumpService.dumpModel(em.outputType , rdbModel , em.output);
            }

            ModelYamlLoader loader = new ModelYamlLoader();
            RdbModel load = loader.load(em.output);
            if (load == null) {
                System.err.println("load error");
            } if (rdbModel.equals(load)) {
                System.out.println("success");
            } else {
                System.err.println("load comp error");
            }

        } catch( CmdLineException e ) {
            // if there's a problem in the command line,
            // you'll get this exception. this will report
            // an error message.
            System.err.println(e.getMessage());
            System.err.println("java com.makotan.tools.App [options...] arguments...");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();

            // print option sample. This is useful some time
            System.err.println("  Example: java com.makotan.tools.App"+parser.printExample(ALL));

        }
    }

    ExecutionMode getExecutionMode(CliArgs cliArgs , CmdLineParser parser) throws CmdLineException{

        logger.info("=========================================");
        logger.info("config:    {}" , cliArgs.configFile);
        logger.info("current:   {}" , cliArgs.current);
        logger.info("  catalog: {}" , cliArgs.currentCatalog);
        logger.info("  schema:  {}" , cliArgs.currentSchema);
        logger.info("next:      {}" , cliArgs.next);
        logger.info("  catalog: {}" , cliArgs.nextCatalog);
        logger.info("  schema:  {}" , cliArgs.nextSchema);
        logger.info("output:    {}" , cliArgs.output);
        logger.info("  catalog: {}" , cliArgs.outputCatalog);
        logger.info("  schema:  {}" , cliArgs.outputSchema);
        logger.info("  mode:    {}" , cliArgs.outputMode);

        ExecutionMode.ExecuteMode executeMode;
        if (cliArgs.next == null || cliArgs.next.isEmpty()) {
            logger.info("execute:   copy mode");
            executeMode = ExecutionMode.ExecuteMode.copy;
        } else {
            logger.info("execute:   diff mode");
            executeMode = ExecutionMode.ExecuteMode.diff;
        }
        logger.info("=========================================");

        InputType currentType = getInputTypeName(cliArgs.current);
        InputType nextType = getInputTypeName(cliArgs.next);
        OutputType outputType = getOutputTypeName(cliArgs.output);

        if (currentType == null) {
            throw new CmdLineException(parser,"unknown current type");
        }

        if (executeMode == ExecutionMode.ExecuteMode.diff && nextType == null) {
            throw new CmdLineException(parser,"unknown next type");
        }

        if (outputType == null) {
            throw new CmdLineException(parser,"unknown output type");
        }

        ExecutionMode em = new ExecutionMode(
                currentType,
                cliArgs.current,
                cliArgs.currentCatalog,
                cliArgs.currentSchema,
                null,
                null,

                nextType,
                cliArgs.next,
                cliArgs.nextCatalog,
                cliArgs.nextSchema,
                null,
                null,

                outputType,
                cliArgs.output,
                cliArgs.outputMode,
                cliArgs.outputCatalog,
                cliArgs.outputSchema,
                null,
                null,

                (cliArgs.outputMode == null || cliArgs.outputMode.equalsIgnoreCase("detail")) ? false : true ,

                executeMode

        );
        return em;
    }

    InputType getInputTypeName(String name) {
        if (name == null) {
            return null;
        }

        if (name.startsWith("jdbc")) {
            return InputType.jdbc;
        } else if (name.endsWith(".yaml")) {
            return InputType.yaml;
        } else {
            return null;
        }
    }

    OutputType getOutputTypeName(String name) {
        if (name == null) {
            return null;
        }

        if (name.startsWith("jdbc")) {
            return OutputType.jdbc;
        } else if (name.endsWith(".yaml")) {
            return OutputType.yaml;
        } else if (name.endsWith(".sql")) {
            return OutputType.sql;
        } else {
            return null;
        }
    }

}
