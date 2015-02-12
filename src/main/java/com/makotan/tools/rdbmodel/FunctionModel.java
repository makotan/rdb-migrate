package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:36
 */
public class FunctionModel {
    public String functionCatalog;
    public String functionSchema;
    public String functionName;
    public String functionComment;
    public Short functionType;
    public String specificName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionModel that = (FunctionModel) o;

        if (functionType != that.functionType) return false;
        if (functionCatalog != null ? !functionCatalog.equals(that.functionCatalog) : that.functionCatalog != null)
            return false;
        if (functionComment != null ? !functionComment.equals(that.functionComment) : that.functionComment != null)
            return false;
        if (functionName != null ? !functionName.equals(that.functionName) : that.functionName != null) return false;
        if (functionSchema != null ? !functionSchema.equals(that.functionSchema) : that.functionSchema != null)
            return false;
        if (specificName != null ? !specificName.equals(that.specificName) : that.specificName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = functionCatalog != null ? functionCatalog.hashCode() : 0;
        result = 31 * result + (functionSchema != null ? functionSchema.hashCode() : 0);
        result = 31 * result + (functionName != null ? functionName.hashCode() : 0);
        result = 31 * result + (functionComment != null ? functionComment.hashCode() : 0);
        result = 31 * result + (int) functionType;
        result = 31 * result + (specificName != null ? specificName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FunctionModel{" +
                "functionCatalog='" + functionCatalog + '\'' +
                ", functionSchema='" + functionSchema + '\'' +
                ", functionName='" + functionName + '\'' +
                ", functionComment='" + functionComment + '\'' +
                ", functionType=" + functionType +
                ", specificName='" + specificName + '\'' +
                '}';
    }
}
