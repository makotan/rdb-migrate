package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:05
 */
public class PrimaryKeyModel {
    public String tableCatalog;
    public String tableSchema;
    public String tableName;
    public String columnName;
    public Short keySeq;
    public String pkName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimaryKeyModel that = (PrimaryKeyModel) o;

        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (keySeq != null ? !keySeq.equals(that.keySeq) : that.keySeq != null) return false;
        if (pkName != null ? !pkName.equals(that.pkName) : that.pkName != null) return false;
        if (tableCatalog != null ? !tableCatalog.equals(that.tableCatalog) : that.tableCatalog != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableCatalog != null ? tableCatalog.hashCode() : 0;
        result = 31 * result + (tableSchema != null ? tableSchema.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (keySeq != null ? keySeq.hashCode() : 0);
        result = 31 * result + (pkName != null ? pkName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\tPrimaryKeyModel{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", keySeq=" + keySeq +
                ", pkName='" + pkName + '\'' +
                '}';
    }
}
