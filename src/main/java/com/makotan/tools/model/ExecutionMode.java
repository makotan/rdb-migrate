package com.makotan.tools.model;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 14:07
 */
public class ExecutionMode {
    public static enum ExecuteMode {
        copy,
        diff
    }

    public final InputType currentType;
    public final String current;
    public final String currentCatalog;
    public final String currentSchema;
    public final String currentUser;
    public final String currentPassword;

    public final InputType nextType;
    public final String next;
    public final String nextCatalog;
    public final String nextSchema;
    public final String nextUser;
    public final String nextPassword;

    public final OutputType outputType;
    public final String output;
    public final String outputMode;
    public final String outputCatalog;
    public final String outputSchema;
    public final String outputUser;
    public final String outputPassword;
    public final boolean detailMode;

    public final ExecuteMode executeMode;

    public ExecutionMode(
            InputType currentType,
            String current,
            String currentCatalog,
            String currentSchema,
            String currentUser,
            String currentPassword,

            InputType nextType,
            String next,
            String nextCatalog,
            String nextSchema,
            String nextUser,
            String nextPassword,

            OutputType outputType,
            String output,
            String outputMode,
            String outputCatalog,
            String outputSchema,
            String outputUser,
            String outputPassword,

            boolean detailMode,

            ExecuteMode executeMode
    ) {
        this.currentType = currentType;
        this.current = current;
        this.currentCatalog = currentCatalog;
        this.currentSchema = currentSchema;
        this.currentUser = currentUser;
        this.currentPassword = currentPassword;

        this.nextType = nextType;
        this.next = next;
        this.nextCatalog = nextCatalog;
        this.nextSchema = nextSchema;
        this.nextUser = nextUser;
        this.nextPassword = nextPassword;

        this.outputType = outputType;
        this.output = output;
        this.outputMode = outputMode;
        this.outputCatalog = outputCatalog;
        this.outputSchema = outputSchema;
        this.outputUser = outputUser;
        this.outputPassword = outputPassword;

        this.detailMode = detailMode;

        this.executeMode = executeMode;
    }
}
