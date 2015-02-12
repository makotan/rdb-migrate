package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 14:15
 */
public class TableColumnModel {
    public String tableCatalog;
    public String tableSchema;
    public String tableName;
    public String columnName;
    public Integer sqlType;
    public String typeName;
    public Integer columnSize;
    public Integer decimalDigits;
    public Integer numPrecRadix;
    public Integer nullable;
    public String comment;
    public String columnDefault;
    public Integer charOctetLength;
    public Integer ordinalPosition;
    public String isNullable;
    public String scopeCatalog;
    public String scopeSchema;
    public String scopeTable;
    public Short sourceDataType;
    public String isAutoincrement;
    public String isGeneratedColumn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TableColumnModel that = (TableColumnModel) o;

        if (charOctetLength != null ? !charOctetLength.equals(that.charOctetLength) : that.charOctetLength != null)
            return false;
        if (columnDefault != null ? !columnDefault.equals(that.columnDefault) : that.columnDefault != null)
            return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (columnSize != null ? !columnSize.equals(that.columnSize) : that.columnSize != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (decimalDigits != null ? !decimalDigits.equals(that.decimalDigits) : that.decimalDigits != null)
            return false;
        if (isAutoincrement != null ? !isAutoincrement.equals(that.isAutoincrement) : that.isAutoincrement != null)
            return false;
        if (isGeneratedColumn != null ? !isGeneratedColumn.equals(that.isGeneratedColumn) : that.isGeneratedColumn != null)
            return false;
        if (isNullable != null ? !isNullable.equals(that.isNullable) : that.isNullable != null) return false;
        if (nullable != null ? !nullable.equals(that.nullable) : that.nullable != null) return false;
        if (numPrecRadix != null ? !numPrecRadix.equals(that.numPrecRadix) : that.numPrecRadix != null) return false;
        if (ordinalPosition != null ? !ordinalPosition.equals(that.ordinalPosition) : that.ordinalPosition != null)
            return false;
        if (scopeCatalog != null ? !scopeCatalog.equals(that.scopeCatalog) : that.scopeCatalog != null) return false;
        if (scopeSchema != null ? !scopeSchema.equals(that.scopeSchema) : that.scopeSchema != null) return false;
        if (scopeTable != null ? !scopeTable.equals(that.scopeTable) : that.scopeTable != null) return false;
        if (sourceDataType != null ? !sourceDataType.equals(that.sourceDataType) : that.sourceDataType != null)
            return false;
        if (sqlType != null ? !sqlType.equals(that.sqlType) : that.sqlType != null) return false;
        if (tableCatalog != null ? !tableCatalog.equals(that.tableCatalog) : that.tableCatalog != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableCatalog != null ? tableCatalog.hashCode() : 0;
        result = 31 * result + (tableSchema != null ? tableSchema.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (sqlType != null ? sqlType.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (columnSize != null ? columnSize.hashCode() : 0);
        result = 31 * result + (decimalDigits != null ? decimalDigits.hashCode() : 0);
        result = 31 * result + (numPrecRadix != null ? numPrecRadix.hashCode() : 0);
        result = 31 * result + (nullable != null ? nullable.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (columnDefault != null ? columnDefault.hashCode() : 0);
        result = 31 * result + (charOctetLength != null ? charOctetLength.hashCode() : 0);
        result = 31 * result + (ordinalPosition != null ? ordinalPosition.hashCode() : 0);
        result = 31 * result + (isNullable != null ? isNullable.hashCode() : 0);
        result = 31 * result + (scopeCatalog != null ? scopeCatalog.hashCode() : 0);
        result = 31 * result + (scopeSchema != null ? scopeSchema.hashCode() : 0);
        result = 31 * result + (scopeTable != null ? scopeTable.hashCode() : 0);
        result = 31 * result + (sourceDataType != null ? sourceDataType.hashCode() : 0);
        result = 31 * result + (isAutoincrement != null ? isAutoincrement.hashCode() : 0);
        result = 31 * result + (isGeneratedColumn != null ? isGeneratedColumn.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\t\t\tTableColumnModel{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", sqlType=" + sqlType +
                ", typeName='" + typeName + '\'' +
                ", columnSize=" + columnSize +
                ", decimalDigits=" + decimalDigits +
                ", numPrecRadix=" + numPrecRadix +
                ", nullable=" + nullable +
                ", comment='" + comment + '\'' +
                ", columnDefault='" + columnDefault + '\'' +
                ", charOctetLength=" + charOctetLength +
                ", ordinalPosition=" + ordinalPosition +
                ", isNullable='" + isNullable + '\'' +
                ", scopeCatalog='" + scopeCatalog + '\'' +
                ", scopeSchema='" + scopeSchema + '\'' +
                ", scopeTable='" + scopeTable + '\'' +
                ", sourceDataType=" + sourceDataType +
                ", isAutoincrement='" + isAutoincrement + '\'' +
                ", isGeneratedColumn='" + isGeneratedColumn + '\'' +
                '}';
    }
}
