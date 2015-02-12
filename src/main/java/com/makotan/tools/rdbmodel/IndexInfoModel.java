package com.makotan.tools.rdbmodel;

/**
 * User: makotan
 * Date: 15/02/07
 * Time: 19:32
 */
public class IndexInfoModel {
    public String tableCatalog;
    public String tableSchema;
    public String tableName;
    public Boolean nonUnique;
    public String indexQualifier;
    public String indexName;
    public Short type;
    public Short ordinalPosition;
    public String columnName;
    public String ascOrDesc;
    public Long cardinality;
    public Long pages;
    public String fileterCondition;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IndexInfoModel that = (IndexInfoModel) o;

        if (ascOrDesc != null ? !ascOrDesc.equals(that.ascOrDesc) : that.ascOrDesc != null) return false;
        if (cardinality != null ? !cardinality.equals(that.cardinality) : that.cardinality != null) return false;
        if (columnName != null ? !columnName.equals(that.columnName) : that.columnName != null) return false;
        if (fileterCondition != null ? !fileterCondition.equals(that.fileterCondition) : that.fileterCondition != null)
            return false;
        if (indexName != null ? !indexName.equals(that.indexName) : that.indexName != null) return false;
        if (indexQualifier != null ? !indexQualifier.equals(that.indexQualifier) : that.indexQualifier != null)
            return false;
        if (nonUnique != null ? !nonUnique.equals(that.nonUnique) : that.nonUnique != null) return false;
        if (ordinalPosition != null ? !ordinalPosition.equals(that.ordinalPosition) : that.ordinalPosition != null)
            return false;
        if (pages != null ? !pages.equals(that.pages) : that.pages != null) return false;
        if (tableCatalog != null ? !tableCatalog.equals(that.tableCatalog) : that.tableCatalog != null) return false;
        if (tableName != null ? !tableName.equals(that.tableName) : that.tableName != null) return false;
        if (tableSchema != null ? !tableSchema.equals(that.tableSchema) : that.tableSchema != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tableCatalog != null ? tableCatalog.hashCode() : 0;
        result = 31 * result + (tableSchema != null ? tableSchema.hashCode() : 0);
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (nonUnique != null ? nonUnique.hashCode() : 0);
        result = 31 * result + (indexQualifier != null ? indexQualifier.hashCode() : 0);
        result = 31 * result + (indexName != null ? indexName.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (ordinalPosition != null ? ordinalPosition.hashCode() : 0);
        result = 31 * result + (columnName != null ? columnName.hashCode() : 0);
        result = 31 * result + (ascOrDesc != null ? ascOrDesc.hashCode() : 0);
        result = 31 * result + (cardinality != null ? cardinality.hashCode() : 0);
        result = 31 * result + (pages != null ? pages.hashCode() : 0);
        result = 31 * result + (fileterCondition != null ? fileterCondition.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "\n\t\t\tIndexInfoModel{" +
                "tableCatalog='" + tableCatalog + '\'' +
                ", tableSchema='" + tableSchema + '\'' +
                ", tableName='" + tableName + '\'' +
                ", nonUnique=" + nonUnique +
                ", indexQualifier='" + indexQualifier + '\'' +
                ", indexName='" + indexName + '\'' +
                ", type=" + type +
                ", ordinalPosition=" + ordinalPosition +
                ", columnName='" + columnName + '\'' +
                ", ascOrDesc='" + ascOrDesc + '\'' +
                ", cardinality=" + cardinality +
                ", pages=" + pages +
                ", fileterCondition='" + fileterCondition + '\'' +
                '}';
    }
}
