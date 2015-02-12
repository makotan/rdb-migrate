package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:38
 */
public class FunctionColumnModel {
    public String functionCatalog;
    public String functionSchema;
    public String functionName;
    public String columnName;
    public Short columnType;
    public Integer dataType;
    public String typeName;
    public Integer precision;
    public Integer length;
    public Short scale;
    public Short radix;
    public Short nullable;
    public String comment;
    public Integer charOctetLength;
    public Integer ordinalPosition;
    public String isNullable;
    public String specificName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FunctionColumnModel that = (FunctionColumnModel) o;

        if (charOctetLength != null ? !charOctetLength.equals(that.charOctetLength) : that.charOctetLength != null)
            return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (columnType != null ? !columnType.equals(that.columnType) : that.columnType != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (dataType != null ? !dataType.equals(that.dataType) : that.dataType != null) return false;
        if (functionCatalog != null ? !functionCatalog.equals(that.functionCatalog) : that.functionCatalog != null)
            return false;
        if (functionName != null ? !functionName.equals(that.functionName) : that.functionName != null) return false;
        if (functionSchema != null ? !functionSchema.equals(that.functionSchema) : that.functionSchema != null)
            return false;
        if (isNullable != null ? !isNullable.equals(that.isNullable) : that.isNullable != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (nullable != null ? !nullable.equals(that.nullable) : that.nullable != null) return false;
        if (ordinalPosition != null ? !ordinalPosition.equals(that.ordinalPosition) : that.ordinalPosition != null)
            return false;
        if (precision != null ? !precision.equals(that.precision) : that.precision != null) return false;
        if (radix != null ? !radix.equals(that.radix) : that.radix != null) return false;
        if (scale != null ? !scale.equals(that.scale) : that.scale != null) return false;
        if (specificName != null ? !specificName.equals(that.specificName) : that.specificName != null) return false;
        if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = functionCatalog != null ? functionCatalog.hashCode() : 0;
        result = 31 * result + (functionSchema != null ? functionSchema.hashCode() : 0);
        result = 31 * result + (functionName != null ? functionName.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (columnType != null ? columnType.hashCode() : 0);
        result = 31 * result + (dataType != null ? dataType.hashCode() : 0);
        result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
        result = 31 * result + (precision != null ? precision.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (scale != null ? scale.hashCode() : 0);
        result = 31 * result + (radix != null ? radix.hashCode() : 0);
        result = 31 * result + (nullable != null ? nullable.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (charOctetLength != null ? charOctetLength.hashCode() : 0);
        result = 31 * result + (ordinalPosition != null ? ordinalPosition.hashCode() : 0);
        result = 31 * result + (isNullable != null ? isNullable.hashCode() : 0);
        result = 31 * result + (specificName != null ? specificName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FunctionColumnModel{" +
                "functionCatalog='" + functionCatalog + '\'' +
                ", functionSchema='" + functionSchema + '\'' +
                ", functionName='" + functionName + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnType=" + columnType +
                ", dataType=" + dataType +
                ", typeName='" + typeName + '\'' +
                ", precision=" + precision +
                ", length=" + length +
                ", scale=" + scale +
                ", radix=" + radix +
                ", nullable=" + nullable +
                ", comment='" + comment + '\'' +
                ", charOctetLength=" + charOctetLength +
                ", ordinalPosition=" + ordinalPosition +
                ", isNullable='" + isNullable + '\'' +
                ", specificName='" + specificName + '\'' +
                '}';
    }
}
