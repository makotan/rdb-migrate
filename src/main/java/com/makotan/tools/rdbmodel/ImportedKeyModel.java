package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:06
 */
public class ImportedKeyModel {
    public String pkTableCatalog;
    public String pkTableSchema;
    public String pkTableName;
    public String pkColumnName;

    public String fkTableCatalog;
    public String fkTableSchema;
    public String fkTableName;
    public String fkColumnName;

    public Short keySeq;

    public Short updateRule;
    public Short deleteRule;

    public String fkName;
    public String pkName;
    public Short deferrability;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImportedKeyModel that = (ImportedKeyModel) o;

        if (deferrability != null ? !deferrability.equals(that.deferrability) : that.deferrability != null)
            return false;
        if (deleteRule != null ? !deleteRule.equals(that.deleteRule) : that.deleteRule != null) return false;
        if (fkColumnName != null ? !fkColumnName.equals(that.fkColumnName) : that.fkColumnName != null) return false;
        if (fkName != null ? !fkName.equals(that.fkName) : that.fkName != null) return false;
        if (fkTableCatalog != null ? !fkTableCatalog.equals(that.fkTableCatalog) : that.fkTableCatalog != null)
            return false;
        if (fkTableName != null ? !fkTableName.equals(that.fkTableName) : that.fkTableName != null) return false;
        if (fkTableSchema != null ? !fkTableSchema.equals(that.fkTableSchema) : that.fkTableSchema != null)
            return false;
        if (keySeq != null ? !keySeq.equals(that.keySeq) : that.keySeq != null) return false;
        if (pkColumnName != null ? !pkColumnName.equals(that.pkColumnName) : that.pkColumnName != null) return false;
        if (pkName != null ? !pkName.equals(that.pkName) : that.pkName != null) return false;
        if (pkTableCatalog != null ? !pkTableCatalog.equals(that.pkTableCatalog) : that.pkTableCatalog != null)
            return false;
        if (pkTableName != null ? !pkTableName.equals(that.pkTableName) : that.pkTableName != null) return false;
        if (pkTableSchema != null ? !pkTableSchema.equals(that.pkTableSchema) : that.pkTableSchema != null)
            return false;
        if (updateRule != null ? !updateRule.equals(that.updateRule) : that.updateRule != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pkTableCatalog != null ? pkTableCatalog.hashCode() : 0;
        result = 31 * result + (pkTableSchema != null ? pkTableSchema.hashCode() : 0);
        result = 31 * result + (pkTableName != null ? pkTableName.hashCode() : 0);
        result = 31 * result + (pkColumnName != null ? pkColumnName.hashCode() : 0);
        result = 31 * result + (fkTableCatalog != null ? fkTableCatalog.hashCode() : 0);
        result = 31 * result + (fkTableSchema != null ? fkTableSchema.hashCode() : 0);
        result = 31 * result + (fkTableName != null ? fkTableName.hashCode() : 0);
        result = 31 * result + (fkColumnName != null ? fkColumnName.hashCode() : 0);
        result = 31 * result + (keySeq != null ? keySeq.hashCode() : 0);
        result = 31 * result + (updateRule != null ? updateRule.hashCode() : 0);
        result = 31 * result + (deleteRule != null ? deleteRule.hashCode() : 0);
        result = 31 * result + (fkName != null ? fkName.hashCode() : 0);
        result = 31 * result + (pkName != null ? pkName.hashCode() : 0);
        result = 31 * result + (deferrability != null ? deferrability.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ImportedKeyModel{" +
                "pkTableCatalog='" + pkTableCatalog + '\'' +
                ", pkTableSchema='" + pkTableSchema + '\'' +
                ", pkTableName='" + pkTableName + '\'' +
                ", pkColumnName='" + pkColumnName + '\'' +
                ", fkTableCatalog='" + fkTableCatalog + '\'' +
                ", fkTableSchema='" + fkTableSchema + '\'' +
                ", fkTableName='" + fkTableName + '\'' +
                ", fkColumnName='" + fkColumnName + '\'' +
                ", keySeq=" + keySeq +
                ", updateRule=" + updateRule +
                ", deleteRule=" + deleteRule +
                ", fkName='" + fkName + '\'' +
                ", pkName='" + pkName + '\'' +
                ", deferrability=" + deferrability +
                '}';
    }
}
